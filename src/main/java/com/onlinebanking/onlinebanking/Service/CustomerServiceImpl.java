package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.CustomerDto;
import com.onlinebanking.onlinebanking.Repository.CustomerRepository;
import com.onlinebanking.onlinebanking.entity.CustomerEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl
    implements CustomerService {

  private final CustomerRepository customerRepository;
  ModelMapper modelMapper = new ModelMapper();


  public CustomerServiceImpl(
      CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public CustomerDto create(CustomerDto customerDto) {
    CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
    return modelMapper.map(customerRepository.save(customerEntity), CustomerDto.class);
  }

  @Override
  public CustomerDto getById(Long id) {
    return modelMapper.map(customerRepository.findById(id).orElse(null), CustomerDto.class);
  }

  @Override
  public CustomerDto update(CustomerDto customerDto) {
    return null;
  }

  @Override
  public List<CustomerDto> getAll(Pageable pageable) {
    return customerRepository.findAll(pageable).stream()
        .map(i -> modelMapper.map(i, CustomerDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {

    return null;
  }
}
