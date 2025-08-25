package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.infrastructure.dto.request.TransferRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ConsultBalanceResponse;
import io.github.eduardoafinacio.usecase.ConsultBalanceUseCase;
import io.github.eduardoafinacio.usecase.TransferUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    private ConsultBalanceUseCase consultBalanceUseCase;
    private TransferUseCase transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws TaxNumberException, NotFoundException {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest request) throws TransferException, TaxNumberException, NotificationException, NotFoundException, InternalServerErrorException, TransactionPinException {
        transferUseCase.transfer(request.fromTaxNumber(), request.toTaxNumber(), request.value(), request.pin());
        return BaseResponse.<String>builder().success(true).message("Transferred successfully").build();
    }
}
