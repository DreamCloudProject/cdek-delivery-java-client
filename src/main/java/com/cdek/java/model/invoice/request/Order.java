package com.cdek.java.model.invoice.request;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

  private UUID orderUuid;

  private Long cdekNumber;

}
