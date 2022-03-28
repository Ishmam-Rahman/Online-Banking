package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.LoanProductDto;
import com.onlinebanking.onlinebanking.Repository.LoanAccountRepository;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.LoanProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoanAccountServiceImpl
    implements LoanAccountService {

  private final LoanAccountRepository loanAccountRepository;
  private final LoanProductService loanProductService;
  ModelMapper modelMapper = new ModelMapper();

  public LoanAccountServiceImpl(
      LoanAccountRepository loanAccountRepository,
      LoanProductService loanProductService) {
    this.loanAccountRepository = loanAccountRepository;
    this.loanProductService = loanProductService;
  }

  @Override
  public LoanAccountDto create(LoanAccountDto loanAccountDto) {
    LoanAccountEntity loanAccount = modelMapper.map(loanAccountDto, LoanAccountEntity.class);
    LoanProductDto loanProductDto = loanProductService.getById(loanAccountDto.getLoanProductId());
    loanAccount.setLoanProductEntity(modelMapper.map(loanProductDto, LoanProductEntity.class));

    return modelMapper.map(loanAccountRepository.save(loanAccount), LoanAccountDto.class);
  }

  @Override
  public LoanAccountDto getById(Long id) {
    return modelMapper.map(loanAccountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Loan account not found!!")), LoanAccountDto.class);
  }

  @Override
  public LoanAccountEntity getEntityById(Long id) {
    return loanAccountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Loan account not found!!"));
  }

  @Override
  public LoanAccountDto update(LoanAccountDto loanAccountDto) {
    LoanAccountEntity loanAccount = modelMapper.map(loanAccountDto, LoanAccountEntity.class);
    loanAccount.setLoanProductEntity(
        modelMapper.map(loanProductService.getById(loanAccountDto.getLoanProductId()),
            LoanProductEntity.class));
    LoanAccountEntity loanAccount1 = loanAccountRepository.save(loanAccount);
    return modelMapper.map(loanAccount1, LoanAccountDto.class);
  }

  @Override
  public List<LoanAccountDto> getAll(Pageable pageable) {
    return loanAccountRepository.findAll(pageable).stream()
        .map(i -> modelMapper.map(i, LoanAccountDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    loanAccountRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
