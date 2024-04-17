package com.uri.testeEstrutural.controllers;

import com.uri.testeEstrutural.dto.PaymentDto;
import com.uri.testeEstrutural.dto.PaymentResponse;
import com.uri.testeEstrutural.services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<PaymentResponse> pay(@RequestBody @Valid PaymentDto paymentDto) {
        Integer discount = paymentService.pay(paymentDto);
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .message("Você recebeu um desconto de " + discount + "%!")
                .discount(discount).build();
        return ResponseEntity.ok(paymentResponse);
    }


}
