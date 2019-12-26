package com.cdek.java.model.request;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seller {

  @Size(max = 255)
  private String name;

  @Size(min = 20, max = 20)
  private String inn;

  @Size(max = 255)
  private String phone;

  private Integer ownershipForm;

  @Size(max = 255)
  private String address;

}
