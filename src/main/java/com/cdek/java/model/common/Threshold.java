package com.cdek.java.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Дополнительный сбор за доставку в зависимости от стоимости товара.
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Threshold {

  @NotNull
  private Integer threshold;

  @NotNull
  private BigDecimal sum;
  private BigDecimal vatSum;
  private Integer vatRate;

}
