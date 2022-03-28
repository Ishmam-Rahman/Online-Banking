package com.onlinebanking.onlinebanking.Dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanAccountDto {

  private Long id;

  private Long customerId;

  private Long loanProductId;

  private LocalDate disbursementDate;

  private Long disbursedAmount;

  private Long installmentAmount;

  private Long outstandingAmount;

  private LocalDate closingDate;
}
