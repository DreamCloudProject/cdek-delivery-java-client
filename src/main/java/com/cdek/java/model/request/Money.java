package com.cdek.java.model.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Money {

  private BigDecimal value;
  private BigDecimal vatSum;
  private Integer vatRate;

}
