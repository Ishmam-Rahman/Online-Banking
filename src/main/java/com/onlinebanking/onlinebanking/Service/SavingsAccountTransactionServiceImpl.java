package com.onlinebanking.onlinebanking.Service;

import com.onlinebanking.onlinebanking.Dto.LoanAccountTransactionDto;
import com.onlinebanking.onlinebanking.Dto.SavingsTransactionDto;
import com.onlinebanking.onlinebanking.Repository.SavingsAccountRepository;
import com.onlinebanking.onlinebanking.Repository.SavingsTransactionRepository;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.LoanAccountTransactionEntity;
import com.onlinebanking.onlinebanking.entity.SavingsAccountEntity;
import com.onlinebanking.onlinebanking.entity.SavingsTransactionEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountTransactionServiceImpl
    implements SavingsAccountTransactionService {

  private final SavingsAccountRepository savingsAccountRepository;
  private final SavingsTransactionRepository savingsTransactionRepository;
  private final SavingsAccountService savingsAccountService;
  ModelMapper modelMapper = new ModelMapper();

  public SavingsAccountTransactionServiceImpl(SavingsAccountRepository savingsAccountRepository,
                                              SavingsTransactionRepository savingsTransactionRepository,
                                              SavingsAccountService savingsAccountService) {
    this.savingsAccountRepository = savingsAccountRepository;
    this.savingsTransactionRepository = savingsTransactionRepository;
    this.savingsAccountService = savingsAccountService;
  }

  @Override
  public SavingsTransactionDto create(SavingsTransactionDto savingsTransactionDto) {
    SavingsTransactionEntity savingsTransactionEntity =
        modelMapper.map(savingsTransactionDto, SavingsTransactionEntity.class);

    SavingsAccountEntity savingsAccount = savingsAccountService.getEntityById(
        savingsTransactionDto.getSavingsAccountId());


    savingsAccount.setCurrentAmount(savingsAccount.getCurrentAmount()+
        savingsTransactionDto.getTransferredAmount());
    savingsTransactionEntity.setSavingsAccountEntity(savingsAccount);

    return modelMapper.map(savingsTransactionRepository.save(savingsTransactionEntity),
        SavingsTransactionDto.class);
  }

  @Override
  public SavingsTransactionDto getById(Long id) {
    return modelMapper.map(savingsTransactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found!!")),
        SavingsTransactionDto.class);
  }

  @Override
  public SavingsTransactionDto update(SavingsTransactionDto savingsTransactionDto) {
    SavingsTransactionEntity savingsTransactionEntity =
        modelMapper.map(savingsTransactionDto, SavingsTransactionEntity.class);

    savingsTransactionEntity.setSavingsAccountEntity(modelMapper.map(savingsAccountService.getById(
        savingsTransactionDto.getSavingsAccountId()), SavingsAccountEntity.class));

    return modelMapper.map(savingsTransactionRepository.save(savingsTransactionEntity),
        SavingsTransactionDto.class);
  }

  @Override
  public List<SavingsTransactionDto> getAll(Pageable pageable) {
    return savingsTransactionRepository.findAll().stream()
        .map(i -> modelMapper.map(i, SavingsTransactionDto.class)).collect(
            Collectors.toList());
  }

  @Override
  public HttpStatus delete(Long id) {
    savingsTransactionRepository.deleteById(id);
    return HttpStatus.OK;
  }
}
