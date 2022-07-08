package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.SavingsAccountDto;
import com.onlinebanking.onlinebanking.Dto.SavingsProductDto;
import com.onlinebanking.onlinebanking.Repository.SavingsAccountRepository;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.SavingsAccountEntity;
import com.onlinebanking.onlinebanking.entity.SavingsProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountServiceImpl
    implements SavingsAccountService {

  private final SavingsAccountRepository savingsAccountRepository;
  private final SavingsProductService savingsProductService;
  ModelMapper modelMapper = new ModelMapper();

  public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository,
                                   SavingsProductService savingsProductService) {
    this.savingsAccountRepository = savingsAccountRepository;
    this.savingsProductService = savingsProductService;
  }

  @Override
  public SavingsAccountDto create(SavingsAccountDto savingsAccountDto) {
    SavingsAccountEntity savingsAccount = modelMapper.map(savingsAccountDto, SavingsAccountEntity.class);
    SavingsProductDto savingsProductDto = savingsProductService.getById(savingsAccountDto.getSavingsProductId());
    savingsAccount.setSavingsProduct(modelMapper.map(savingsProductDto, SavingsProductEntity.class));

    return modelMapper.map(savingsAccountRepository.save(savingsAccount), SavingsAccountDto.class);
  }

  @Override
  public SavingsAccountDto getById(Long id) {
    return modelMapper.map(savingsAccountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Savings account not found!!")), SavingsAccountDto.class);
  }

  @Override
  public SavingsAccountDto update(SavingsAccountDto savingsAccountDto) {
    SavingsAccountEntity savingsAccount = modelMapper.map(savingsAccountDto, SavingsAccountEntity.class);
    savingsAccount.setSavingsProduct(
        modelMapper.map(savingsProductService.getById(savingsAccountDto.getSavingsProductId()),
            SavingsProductEntity.class));
    SavingsAccountEntity savingsAccount1 = savingsAccountRepository.save(savingsAccount);
    return modelMapper.map(savingsAccount1, SavingsAccountDto.class);
  }

  @Override
  public SavingsAccountEntity getEntityById(Long id) {
    return savingsAccountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Savings account not found!!"));
  }

  @Override
  public List<SavingsAccountDto> getAll(Pageable pageable) {
    return savingsAccountRepository.findAll(pageable).stream()
        .map(i -> modelMapper.map(i, SavingsAccountDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    savingsAccountRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
