package com.onlinebanking.onlinebanking.Dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
  private Long id;

  private String firstName;

  private String lastName;

  private String address;

  private Long age;

  private LocalDate membershipDate;

  private String PhotoUrl;
}
