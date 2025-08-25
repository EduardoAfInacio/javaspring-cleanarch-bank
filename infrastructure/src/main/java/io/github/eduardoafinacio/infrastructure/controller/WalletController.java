package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.infrastructure.dto.request.TransferRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ConsultBalanceResponse;
import io.github.eduardoafinacio.usecase.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    private ConsultBalanceUseCase consultBalanceUseCase;
    private TransferUseCase transferUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase, CreateTransactionUseCase createTransactionUseCase, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws TaxNumberException, NotFoundException {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest request) throws TransferException, TaxNumberException, NotificationException, NotFoundException, InternalServerErrorException, TransactionPinException {

        var from = findWalletByTaxNumberUseCase.findByTaxNumber(request.fromTaxNumber());

        transactionPinValidateUseCase.validate(from.getTransactionPin(), request.pin());

        var to = findWalletByTaxNumberUseCase.findByTaxNumber(request.toTaxNumber());

        var transaction = createTransactionUseCase.create(from, to, request.value());

        transactionValidateUseCase.validate(transaction);

        transferUseCase.transfer(transaction);
        return BaseResponse.<String>builder().success(true).message("Transferred successfully").build();
    }
}
