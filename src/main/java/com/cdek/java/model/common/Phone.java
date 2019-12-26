package com.cdek.java.model.common;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Номер телефона (мобильный/городской)
 */
@Getter
@Setter
public class Phone {

  @NotNull
  @Size(max = 255)
  private String number;
  @Size(max = 255)
  private String additional;

}
