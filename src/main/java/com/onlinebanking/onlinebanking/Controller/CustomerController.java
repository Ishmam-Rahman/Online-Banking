package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.CustomerDto;
import com.onlinebanking.onlinebanking.Service.CustomerService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping( "/all-customer")
  public List<CustomerDto> getAllCustomer(Pageable pageable) {
    return customerService.getAll(pageable);
  }

  @PostMapping( "/create-customer")
  public CustomerDto getAllCustomer(@RequestBody CustomerDto customerDto) {
    return customerService.create(customerDto);
  }
}
