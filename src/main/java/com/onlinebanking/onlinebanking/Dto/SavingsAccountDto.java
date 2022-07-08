package com.onlinebanking.onlinebanking.Dto;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SavingsAccountDto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long customerId;

  private Long savingsProductId;

  private LocalDate openingDate;

  private LocalDate closingDate;

  private Long currentAmount;

  private Long targetAmount;
}
