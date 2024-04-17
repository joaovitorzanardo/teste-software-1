package com.uri.testeEstrutural.services;

import org.springframework.stereotype.Service;

@Service
public class ProcessDiscount {

    public Integer process(boolean isFirstPurchase, Float totalPrice) {
        if (isFirstPurchase) {
            return 15;
        }

        if (totalPrice > 200 && totalPrice <= 500) {
            return 5;
        }

        if (totalPrice > 500) {
            return 10;
        }

        return 0;
    }

}
