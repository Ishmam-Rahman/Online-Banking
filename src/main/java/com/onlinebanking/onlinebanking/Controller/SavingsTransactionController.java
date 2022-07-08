package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Dto.SavingsTransactionDto;
import com.onlinebanking.onlinebanking.Service.LoanAccountTransactionService;
import com.onlinebanking.onlinebanking.Service.SavingsAccountTransactionService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavingsTransactionController {

  private final SavingsAccountTransactionService savingsAccountTransactionService;

  public SavingsTransactionController(SavingsAccountTransactionService savingsAccountTransactionService) {
    this.savingsAccountTransactionService = savingsAccountTransactionService;
  }

  @GetMapping( "/all-savings-account-transaction")
  public List<SavingsTransactionDto> getAllSavingsAccountTransaction(Pageable pageable) {
    return savingsAccountTransactionService.getAll(pageable);
  }

  @GetMapping( "/savings-account-transaction/{id}")
  public SavingsTransactionDto getSavingsAccountTransaction(@PathVariable Long id) {
    return savingsAccountTransactionService.getById(id);
  }

  @PostMapping( "/create-savings-account-transaction")
  public SavingsTransactionDto createSavingsAccountTransaction(@RequestBody SavingsTransactionDto savingsTransactionDto) {
    return savingsAccountTransactionService.create(savingsTransactionDto);
  }

  @PutMapping( "/update-savings-account-transaction")
  public SavingsTransactionDto updateSavingsAccountTransaction(@RequestBody SavingsTransactionDto savingsTransactionDto) {
    return savingsAccountTransactionService.update(savingsTransactionDto);
  }

  @DeleteMapping( "/delete-savings-account-transaction/{id}")
  public HttpStatus updateSavingsAccount(@PathVariable Long id) {
    return savingsAccountTransactionService.delete(id);
  }
}
