package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.CustomerDto;
import com.onlinebanking.onlinebanking.entity.CustomerEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface CustomerService {
  CustomerDto create(CustomerDto customerDto);

  CustomerDto getById(Long id);

  CustomerDto update(CustomerDto customerDto);

  List<CustomerDto> getAll(Pageable pageable);

  HttpStatus delete(Long id);

}
