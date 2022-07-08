package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.Dto.SavingsProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface SavingsProductService {
  SavingsProductDto create(SavingsProductDto savingsProductDto);

  SavingsProductDto getById(Long id);

  SavingsProductDto update(SavingsProductDto savingsProductDto);

  List<SavingsProductDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
