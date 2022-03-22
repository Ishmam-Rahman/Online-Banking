package com.onlinebanking.onlinebanking.Dto;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;

  private String lastName;

  private String address;

  private LocalDate membershipDate;

  private String PhotoUrl;

  private String nidNumber;

  private Long designationId;

  private LocalDate joiningDate;
}
