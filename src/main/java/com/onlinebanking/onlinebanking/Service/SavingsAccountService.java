package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.SavingsAccountDto;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.SavingsAccountEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface SavingsAccountService {
  SavingsAccountDto create(SavingsAccountDto savingsAccountDto);

  SavingsAccountDto getById(Long id);


  SavingsAccountEntity getEntityById(Long id);

  SavingsAccountDto update(SavingsAccountDto savingsAccountDto);

  List<SavingsAccountDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
