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

@Getter
@Setter
@Entity
public class LoanAccountTransactionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long customerId;

  @ManyToOne
  @JoinColumn(name = "loan_account_id")
  private LoanAccountEntity loanAccount;

  private LocalDate collectionDate;

  private Long realizedAmount;

  private Long outstandingAfterCollection;
}
