package com.cdek.java.model.invoice;

import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRequest {

  @NotNull
  private List<Order> orders;

  private Integer copyCount;

  private InvoiceType type;

}
