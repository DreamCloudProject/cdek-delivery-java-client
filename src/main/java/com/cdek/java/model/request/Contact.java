package com.cdek.java.model.request;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {

  @Size(max = 255)
  private String company;

  @Size(max = 255)
  private String name;

  @Size(max = 255)
  private String passportSeries;

  @Size(max = 255)
  private String passportNumber;

  private LocalDate passportDateOfIssue;

  @Size(max = 255)
  private String passportOrganization;

  @Size(max = 255)
  private String tin;

  private LocalDate passportDateOfBirth;

  @Email
  @Size(max = 255)
  private String email;

  private List<Phone> phones;

}
