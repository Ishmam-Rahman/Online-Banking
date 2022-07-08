package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.SavingsAccountDto;
import com.onlinebanking.onlinebanking.Service.LoanAccountService;
import com.onlinebanking.onlinebanking.Service.SavingsAccountService;
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
public class SavingsAccountController {

  private final SavingsAccountService savingsAccountService;

  public SavingsAccountController(SavingsAccountService savingsAccountService) {
    this.savingsAccountService = savingsAccountService;
  }

  @GetMapping( "/all-savings-account")
  public List<SavingsAccountDto> getAllSavingsAccount(Pageable pageable) {
    return savingsAccountService.getAll(pageable);
  }

  @GetMapping( "/savings-account/{id}")
  public SavingsAccountDto getSavingsAccount(@PathVariable Long id) {
    return savingsAccountService.getById(id);
  }

  @PostMapping( "/create-savings-account")
  public SavingsAccountDto createSavingsAccount(@RequestBody SavingsAccountDto savingsAccountDto) {
    return savingsAccountService.create(savingsAccountDto);
  }

  @PutMapping( "/update-savings-account")
  public SavingsAccountDto updateSavingsAccount(@RequestBody SavingsAccountDto savingsAccountDto) {
    return savingsAccountService.update(savingsAccountDto);
  }

  @DeleteMapping( "/delete-savings-account/{id}")
  public HttpStatus updateSavingsAccount(@PathVariable Long id) {
    return savingsAccountService.delete(id);
  }
}
