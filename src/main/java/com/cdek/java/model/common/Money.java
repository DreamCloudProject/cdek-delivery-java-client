package com.cdek.java.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Стоимость услуги/товара с учетом налогообложения
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Money {

  private BigDecimal value;
  private BigDecimal vatSum;
  private Integer vatRate;

}
