package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface LoanAccountService {
  LoanAccountDto create(LoanAccountDto loanAccountDto);

  LoanAccountDto getById(Long id);

  LoanAccountEntity getEntityById(Long id);

  LoanAccountDto update(LoanAccountDto loanAccountDto);

  List<LoanAccountDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
