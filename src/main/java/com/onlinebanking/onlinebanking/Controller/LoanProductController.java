package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.CustomerDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.Service.CustomerService;
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
public class LoanProductController {

  private final LoanProductService loanProductService;

  public LoanProductController(LoanProductService loanProductService) {
    this.loanProductService = loanProductService;
  }

  @GetMapping( "/all-lona-product")
  public List<LoanProductDto> getAllLoanProduct(Pageable pageable) {
    return loanProductService.getAll(pageable);
  }

  @GetMapping( "/lona-product/{id}")
  public LoanProductDto getLoanProduct(@PathVariable Long id) {
    return loanProductService.getById(id);
  }

  @PostMapping( "/create-loan-product")
  public LoanProductDto createLoanProduct(@RequestBody LoanProductDto loanProductDto) {
    return loanProductService.create(loanProductDto);
  }

  @PutMapping( "/update-loan-product")
  public LoanProductDto updateLoanProduct(@RequestBody LoanProductDto loanProductDto) {
    return loanProductService.update(loanProductDto);
  }

  @DeleteMapping( "/delete-loan-product/{id}")
  public HttpStatus updateLoanProduct(@PathVariable Long id) {
    return loanProductService.delete(id);
  }
}
