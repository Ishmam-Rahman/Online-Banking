package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.Dto.SavingsAccountDto;
import com.onlinebanking.onlinebanking.Dto.SavingsProductDto;
import com.onlinebanking.onlinebanking.ExceptionHandle.ResourcesNotFound;
import com.onlinebanking.onlinebanking.Repository.SavingsProductRepository;
import com.onlinebanking.onlinebanking.entity.LoanProductEntity;
import com.onlinebanking.onlinebanking.entity.SavingsProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SavingsProductServiceImpl
    implements SavingsProductService {

  private final SavingsProductRepository savingsProductRepository;
  ModelMapper modelMapper = new ModelMapper();

  public SavingsProductServiceImpl(SavingsProductRepository savingsProductRepository) {
    this.savingsProductRepository = savingsProductRepository;
  }

  @Override
  public SavingsProductDto create(SavingsProductDto savingsProductDto) {
    return modelMapper.map(
        savingsProductRepository.save(
            modelMapper.map(savingsProductDto, SavingsProductEntity.class)),
        SavingsProductDto.class);
  }

  @Override
  public SavingsProductDto getById(Long id) {
    return modelMapper.map(savingsProductRepository.findById(id)
        .orElseThrow(() -> new ResourcesNotFound("Loan Product Not Found!!!")), SavingsProductDto.class);
  }

  @Override
  public SavingsProductDto update(SavingsProductDto savingsProductDto) {
    SavingsProductEntity savingsProduct = modelMapper.map(savingsProductDto, SavingsProductEntity.class);
    return modelMapper.map(savingsProductRepository.save(savingsProduct), SavingsProductDto.class);
  }

  @Override
  public List<SavingsProductDto> getAll(Pageable pageable) {
    return savingsProductRepository.findAll().stream().map(dto->modelMapper.map(dto, SavingsProductDto.class)).collect(
        Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    savingsProductRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
