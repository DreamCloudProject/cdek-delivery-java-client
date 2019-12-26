package com.cdek.java.model.request;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {

  @Size(max = 255)
  private String number;
  @Size(max = 255)
  private String additional;

}
