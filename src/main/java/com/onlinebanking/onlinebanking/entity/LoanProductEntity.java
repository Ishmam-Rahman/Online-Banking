package com.onlinebanking.onlinebanking.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoanProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String productName;

  private Long maxLoanAmount;

  private Long minLoanAmount;

  private Long loanDuration;

  private Long interestRate;

}
