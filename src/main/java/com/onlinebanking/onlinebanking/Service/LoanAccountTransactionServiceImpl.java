package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountDto;
import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Repository.LoanAccountTransactionRepository;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.LoanAccountTransactionEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanAccountTransactionServiceImpl
    implements LoanAccountTransactionService {
  private final LoanAccountTransactionRepository loanAccountTransactionRepository;
  private final LoanAccountService loanAccountService;
  ModelMapper modelMapper = new ModelMapper();

  public LoanAccountTransactionServiceImpl(
      LoanAccountTransactionRepository loanAccountTransactionRepository,
      LoanAccountService loanAccountService) {
    this.loanAccountTransactionRepository = loanAccountTransactionRepository;
    this.loanAccountService = loanAccountService;
  }

  @Override
  @Transactional
  public LoanAccountTransactionDto create(LoanAccountTransactionDto transactionDto) {
    LoanAccountTransactionEntity loanAccountTransactionEntity =
        modelMapper.map(transactionDto, LoanAccountTransactionEntity.class);

    LoanAccountEntity loanAccount = loanAccountService.getEntityById(
        transactionDto.getLoanAccountId());


    //TODO need to save the loan account also
    loanAccount.setOutstandingAmount(loanAccount.getOutstandingAmount()-
        transactionDto.getRealizedAmount());

    loanAccountTransactionEntity.setLoanAccount(loanAccount);
    loanAccountTransactionEntity.setOutstandingAfterCollection(loanAccount.getOutstandingAmount());
    return modelMapper.map(loanAccountTransactionRepository.save(loanAccountTransactionEntity),
        LoanAccountTransactionDto.class);
  }

  @Override
  public LoanAccountTransactionDto getById(Long id) {
    return modelMapper.map(loanAccountTransactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found!!")),
        LoanAccountTransactionDto.class);
  }

  @Override
  public LoanAccountTransactionDto update(LoanAccountTransactionDto loanProductDto) {
    LoanAccountTransactionEntity loanAccountTransactionEntity =
        modelMapper.map(loanProductDto, LoanAccountTransactionEntity.class);

    loanAccountTransactionEntity.setLoanAccount(modelMapper.map(loanAccountService.getById(
        loanProductDto.getLoanAccountId()), LoanAccountEntity.class));

    return modelMapper.map(loanAccountTransactionRepository.save(loanAccountTransactionEntity),
        LoanAccountTransactionDto.class);
  }

  @Override
  public List<LoanAccountTransactionDto> getAll(Pageable pageable) {
    return loanAccountTransactionRepository.findAll().stream()
        .map(i -> modelMapper.map(i, LoanAccountTransactionDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    loanAccountTransactionRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
