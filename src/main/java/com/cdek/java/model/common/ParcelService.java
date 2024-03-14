package com.cdek.java.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

/**
 * Данные о дополнительных услугах
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParcelService {

  private String code;
  private Float sum;
  private String parameter;
  private Float totalSum;
  private Integer discountPercent;
  private Float discountSum;
}
