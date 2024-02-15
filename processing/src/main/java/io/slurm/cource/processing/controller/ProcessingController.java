package io.slurm.cource.processing.controller;

import io.slurm.cource.processing.dto.ExchangeMoneyDTO;
import io.slurm.cource.processing.dto.NewAccountDTO;
import io.slurm.cource.processing.dto.PutAccountMoneyDTO;
import io.slurm.cource.processing.model.AccountEntity;
import io.slurm.cource.processing.model.Operation;
import io.slurm.cource.processing.service.AccountService;
import io.slurm.cource.processing.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("processing")
@RequiredArgsConstructor
public class ProcessingController {
    private final AccountService accountService;

    private final ExchangeService exchangeService;

    @PostMapping("/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account) {
        return accountService.createNewAccount(account);
    }

    @PutMapping("/account/{id}")
    public AccountEntity putMoney(@PathVariable("id") Long accountId, @RequestBody PutAccountMoneyDTO data) {
        return accountService.addMoneyToAccount(data.getUid(), accountId, null, Operation.PUT, data.getMoney());
    }

    @PutMapping("/exchange/{uid}")
    public BigDecimal exchange(@PathVariable("uid") String uid, @RequestBody ExchangeMoneyDTO data) {
        return exchangeService.exchangeCurrency(uid, data.getFromAccountId(), data.getToAccountId(), data.getMoney());
    }

    @GetMapping("/accounts")
    public List<AccountEntity> getAllAccount() {
        return accountService.getAllAccount();
    }
}
