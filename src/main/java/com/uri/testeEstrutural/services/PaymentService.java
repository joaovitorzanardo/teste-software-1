package com.uri.testeEstrutural.services;

import com.uri.testeEstrutural.database.InMemoryDatabase;
import com.uri.testeEstrutural.dto.PaymentDto;
import com.uri.testeEstrutural.dto.UserDto;
import com.uri.testeEstrutural.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    ProcessDiscount processDiscount;

    public Integer pay(PaymentDto paymentDto) {
        List<UserDto> users = InMemoryDatabase.getRegistratedUsersList();

        boolean foundUser = false;

        for (UserDto user : users) {
            if (user.getUsername().equals(paymentDto.getUsername())){
                foundUser = true;
                break;
            }
        }

        if (!foundUser) {
            throw new UserNotFoundException(paymentDto.getUsername());
        }

        return processDiscount.process(paymentDto.isFirstPurchase(), paymentDto.getTotalPrice());
    }


}

