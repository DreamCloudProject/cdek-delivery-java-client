package com.cdek.java.model.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Threshold {

  private Integer threshold;
  private BigDecimal sum;
  private BigDecimal vatSum;
  private Integer vatRate;

}
