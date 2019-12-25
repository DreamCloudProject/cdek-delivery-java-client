package com.cdek.java.model.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

  private String name;
  private String wareKey;
  private BigDecimal payment;
  private BigDecimal value;
  private BigDecimal vatSum;
  private Integer vatRate;
  private BigDecimal cost;
  private Integer weight;
  private Integer weightGross;
  private Integer amount;
  private String nameI18n;
  private String brand;
  private String countryCode;
  private String material;
  private String wifiGsm;
  private String url;

}
