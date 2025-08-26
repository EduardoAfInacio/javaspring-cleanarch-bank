package io.github.eduardoafinacio.infrastructure.client;

import io.github.eduardoafinacio.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidate", url = "${client.url}")
public interface ApiValidateClient {

    @GetMapping("/ApiValidate")
    ApiValidateResponse validate();
}
