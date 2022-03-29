package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.ExceptionHandle.ResourcesNotFound;
import com.onlinebanking.onlinebanking.Repository.LoanProductRepository;
import com.onlinebanking.onlinebanking.entity.LoanProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanProductServiceImpl
    implements LoanProductService {

  private final LoanProductRepository loanProductRepository;

  @Value("${environment.massage}")
  String massage;

  ModelMapper modelMapper = new ModelMapper();

  public LoanProductServiceImpl(
      LoanProductRepository loanProductRepository) {
    this.loanProductRepository = loanProductRepository;
  }


  @Override
  public LoanProductDto create(LoanProductDto loanProductDto) {
    return modelMapper.map(
        loanProductRepository.save(modelMapper.map(loanProductDto, LoanProductEntity.class)),
        LoanProductDto.class);
  }

  @Override
  public LoanProductDto getById(Long id) {
    return modelMapper.map(loanProductRepository.findById(id)
        .orElseThrow(() -> new ResourcesNotFound("Loan Product Not Found!!!")), LoanProductDto.class);
  }

  @Override
  public LoanProductDto update(LoanProductDto loanProductDto) {
    //if id does exist then it will update. Otherwise create new one.
    LoanProductEntity loanProduct = modelMapper.map(loanProductDto, LoanProductEntity.class);
    return modelMapper.map(loanProductRepository.save(loanProduct), LoanProductDto.class);
  }

  @Override
  public List<LoanProductDto> getAll(Pageable pageable) {
    log.info("Environment: "+massage);
    return loanProductRepository.findAll(pageable).stream()
        .map(i -> modelMapper.map(i, LoanProductDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    loanProductRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
