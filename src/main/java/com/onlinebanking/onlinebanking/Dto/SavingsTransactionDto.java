package com.onlinebanking.onlinebanking.Dto;

import com.onlinebanking.onlinebanking.entity.SavingsAccountEntity;
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
public class SavingsTransactionDto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long customerId;

  private Long toCustomerId;

  private LocalDate transferDate;

  private Long transferredAmount;

  private Long savingsAccountId;

  private Boolean isDeposit = Boolean.FALSE;

  private Boolean isWithdrawal = Boolean.FALSE;
}
