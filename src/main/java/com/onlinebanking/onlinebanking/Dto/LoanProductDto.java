package com.onlinebanking.onlinebanking.Dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanProductDto {

  private Long id;

  private String productName;

  private Long maxLoanAmount;

  private Long minLoanAmount;

  private Long loanDuration;

  private Long interestRate;

}
