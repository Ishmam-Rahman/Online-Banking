package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface LoanAccountTransactionService {
  LoanAccountTransactionDto create(LoanAccountTransactionDto loanProductDto);

  LoanAccountTransactionDto getById(Long id);

  LoanAccountTransactionDto update(LoanAccountTransactionDto loanProductDto);

  List<LoanAccountTransactionDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
