package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.CustomerDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface LoanProductService {
  LoanProductDto create(LoanProductDto loanProductDto);

  LoanProductDto getById(Long id);

  LoanProductDto update(LoanProductDto loanProductDto);

  List<LoanProductDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
