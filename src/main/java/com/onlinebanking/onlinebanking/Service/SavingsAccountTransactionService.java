package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Dto.SavingsTransactionDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface SavingsAccountTransactionService {
  SavingsTransactionDto create(SavingsTransactionDto savingsTransactionDto);

  SavingsTransactionDto getById(Long id);

  SavingsTransactionDto update(SavingsTransactionDto savingsTransactionDto);

  List<SavingsTransactionDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
