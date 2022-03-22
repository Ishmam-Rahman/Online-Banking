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
public class SavingsProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String productName;

  private Long maxSavingsAmount;

  private Long minSavingsAmount;

  private Long savingsDuration;

  private Long interestRate;

}
