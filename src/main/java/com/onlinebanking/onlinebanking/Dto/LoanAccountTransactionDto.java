package com.onlinebanking.onlinebanking.Dto;

import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanAccountTransactionDto {

  private Long id;

  private Long customerId;

  private Long loanAccountId;

  private LocalDate collectionDate;

  private Long realizedAmount;

  private Long outstandingAfterCollection;
}
