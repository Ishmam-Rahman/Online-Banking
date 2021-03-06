package com.onlinebanking.onlinebanking.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoanAccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long customerId;

  @ManyToOne
  @JoinColumn(name = "loan_product_id", nullable = false)
  private LoanProductEntity loanProductEntity;

  private LocalDate disbursementDate;

  private Long disbursedAmount;

  private Long realizableAmount;

  private Long outstandingAmount;

  private LocalDate closingDate;
}
