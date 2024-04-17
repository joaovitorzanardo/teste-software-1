package com.uri.testeEstrutural.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDto {

    @NotNull
    private boolean isFirstPurchase;
    @NotNull
    private Float totalPrice;
    @NotEmpty
    private String username;

    private void setIsFirstPurchase(boolean isFirstPurchase) {
        this.isFirstPurchase = isFirstPurchase;
    }

}
