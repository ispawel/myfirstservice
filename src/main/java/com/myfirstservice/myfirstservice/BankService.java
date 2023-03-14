package com.myfirstservice.myfirstservice;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.myfirstservice.myfirstservice.model.TransferBalance;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankService {
    
    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId){
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null){
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal accountId){
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance){
    }
}
