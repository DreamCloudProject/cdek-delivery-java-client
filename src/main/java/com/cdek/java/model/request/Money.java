package com.cdek.java.model.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Стоимость услуги/товара с учетом налогообложения
 */
@Getter
@Setter
public class Money {

  private BigDecimal value;
  private BigDecimal vatSum;
  private Integer vatRate;

}
