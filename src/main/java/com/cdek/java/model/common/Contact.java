package com.cdek.java.model.common;

import com.cdek.java.commons.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Данные контрагента (отправителя, получателя)
 */
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

  @JsonFormat(pattern = Pattern.DATE)
  private Instant passportDateOfIssue;

  @Size(max = 255)
  private String passportOrganization;

  @Size(max = 255)
  private String tin;

  @JsonFormat(pattern = Pattern.DATE)
  private Instant passportDateOfBirth;

  @Email
  @Size(max = 255)
  private String email;

  private List<Phone> phones;

}
