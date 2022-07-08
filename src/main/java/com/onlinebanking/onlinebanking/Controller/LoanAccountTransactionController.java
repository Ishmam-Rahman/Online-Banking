package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Service.LoanAccountTransactionService;
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
public class LoanAccountTransactionController {

  private final LoanAccountTransactionService loanAccountTransactionService;

  public LoanAccountTransactionController(LoanAccountTransactionService loanAccountTransactionService) {
    this.loanAccountTransactionService = loanAccountTransactionService;
  }

  @GetMapping( "/all-lona-account-transaction")
  public List<LoanAccountTransactionDto> getAllLoanAccountTransaction(Pageable pageable) {
    return loanAccountTransactionService.getAll(pageable);
  }

  @GetMapping( "/loan-account-transaction/{id}")
  public LoanAccountTransactionDto getLoanAccountTransaction(@PathVariable Long id) {
    return loanAccountTransactionService.getById(id);
  }

  @PostMapping( "/create-loan-account-transaction")
  public LoanAccountTransactionDto createLoanAccountTransaction(@RequestBody LoanAccountTransactionDto loanAccountTransactionDto) {
    return loanAccountTransactionService.create(loanAccountTransactionDto);
  }

  @PutMapping( "/update-loan-account-transaction")
  public LoanAccountTransactionDto updateLoanAccountTransaction(@RequestBody LoanAccountTransactionDto loanAccountTransactionDto) {
    return loanAccountTransactionService.update(loanAccountTransactionDto);
  }

  @DeleteMapping( "/delete-loan-account-transaction/{id}")
  public HttpStatus updateLoanAccount(@PathVariable Long id) {
    return loanAccountTransactionService.delete(id);
  }
}
