package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.Service.LoanAccountService;
import com.onlinebanking.onlinebanking.Service.LoanProductService;
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
public class LoanAccountController {

  private final LoanAccountService loanAccountService;

  public LoanAccountController(LoanAccountService loanProductService) {
    this.loanAccountService = loanProductService;
  }

  @GetMapping( "/all-lona-account")
  public List<LoanAccountDto> getAllLoanAccount(Pageable pageable) {
    return loanAccountService.getAll(pageable);
  }

  @GetMapping( "/loan-account/{id}")
  public LoanAccountDto getLoanAccount(@PathVariable Long id) {
    return loanAccountService.getById(id);
  }

  @PostMapping( "/create-loan-account")
  public LoanAccountDto createLoanAccount(@RequestBody LoanAccountDto loanAccountDto) {
    return loanAccountService.create(loanAccountDto);
  }

  @PutMapping( "/update-loan-account")
  public LoanAccountDto updateLoanAccount(@RequestBody LoanAccountDto loanAccountDto) {
    return loanAccountService.update(loanAccountDto);
  }

  @DeleteMapping( "/delete-loan-account/{id}")
  public HttpStatus updateLoanAccount(@PathVariable Long id) {
    return loanAccountService.delete(id);
  }
}
