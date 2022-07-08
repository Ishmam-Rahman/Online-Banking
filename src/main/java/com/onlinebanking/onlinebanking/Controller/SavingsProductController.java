package com.onlinebanking.onlinebanking.Controller;

import com.onlinebanking.onlinebanking.Dto.SavingsProductDto;
import com.onlinebanking.onlinebanking.Service.SavingsProductService;
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
public class SavingsProductController {

  private final SavingsProductService savingsProductService;

  public SavingsProductController(SavingsProductService savingsProductService) {
    this.savingsProductService = savingsProductService;
  }

  @GetMapping( "/all-savings-product")
  public List<SavingsProductDto> getAllSavingsProductDto(Pageable pageable) {
    return savingsProductService.getAll(pageable);
  }

  @GetMapping( "/savings-product/{id}")
  public SavingsProductDto getSavingsProductDto(@PathVariable Long id) {
    return savingsProductService.getById(id);
  }

  @PostMapping( "/create-savings-product")
  public SavingsProductDto createSavingsProductDto(@RequestBody SavingsProductDto savingsProductDto) {
    return savingsProductService.create(savingsProductDto);
  }

  @PutMapping( "/update-savings-product")
  public SavingsProductDto updateSavingsProductDto(@RequestBody SavingsProductDto savingsProductDto) {
    return savingsProductService.update(savingsProductDto);
  }

  @DeleteMapping( "/delete-savings-product/{id}")
  public HttpStatus updateSavingsProductDto(@PathVariable Long id) {
    return savingsProductService.delete(id);
  }
}
