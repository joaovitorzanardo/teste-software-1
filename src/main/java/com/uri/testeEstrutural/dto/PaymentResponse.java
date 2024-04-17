package com.uri.testeEstrutural.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {

    private String message;
    private Integer discount;

}
