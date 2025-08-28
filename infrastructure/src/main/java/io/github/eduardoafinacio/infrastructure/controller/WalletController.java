package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.infrastructure.dto.request.TransferRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ConsultBalanceResponse;
import io.github.eduardoafinacio.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    final private ConsultBalanceUseCase consultBalanceUseCase;
    final private TransferUseCase transferUseCase;
    final private CreateTransactionUseCase createTransactionUseCase;
    final private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    final private TransactionValidateUseCase transactionValidateUseCase;
    final private TransactionPinValidateUseCase transactionPinValidateUseCase;
    final private UserNotificationUseCase userNotificationUseCase;


    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase, CreateTransactionUseCase createTransactionUseCase, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase, UserNotificationUseCase userNotificationUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public ResponseEntity<BaseResponse<ConsultBalanceResponse>> consultBalance(@PathVariable String taxNumber) throws TaxNumberException, NotFoundException {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return ResponseEntity.ok().body(BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build());
    }

    @PostMapping("/transfer")
    public ResponseEntity<BaseResponse<String>> transfer(@RequestBody TransferRequest request) throws TransferException, TaxNumberException, NotificationException, NotFoundException, InternalServerErrorException, TransactionPinException {

        var from = findWalletByTaxNumberUseCase.findByTaxNumber(request.fromTaxNumber());

        transactionPinValidateUseCase.validate(from.getTransactionPin(), request.pin());

        var to = findWalletByTaxNumberUseCase.findByTaxNumber(request.toTaxNumber());

        var transaction = createTransactionUseCase.create(from, to, request.value());

        transactionValidateUseCase.validate(transaction);

        transferUseCase.transfer(transaction);

        userNotificationUseCase.notificate(transaction, from.getUser().getEmail());
        return ResponseEntity.ok().body(BaseResponse.<String>builder().success(true).message("Transferred successfully").build());
    }
}
