// Получение информции о балансе
// Полонение баланса

package com.myfirstservice.myfirstservice;

import org.springframework.web.bind.annotation.RestController;
import com.myfirstservice.myfirstservice.model.TransferBalance;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController("/balance")
@AllArgsConstructor
public class BalanceController {
    
    private final BankService bankService;


    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);
    }
    

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);
    }

}
