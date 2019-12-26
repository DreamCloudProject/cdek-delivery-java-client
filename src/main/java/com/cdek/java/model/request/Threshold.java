package com.cdek.java.model.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Дополнительный сбор за доставку в зависимости от стоимости товара.
 */
@Getter
@Setter
public class Threshold {

  @NotNull
  private Integer threshold;

  @NotNull
  private BigDecimal sum;
  private BigDecimal vatSum;
  private Integer vatRate;

}
