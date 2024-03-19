package com.cdek.java.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * Адрес местоположения контрагента (отправителя, получателя), включая геолокационные данные
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Location {

  private String code;
  private UUID fiasGuid;
  private String postalCode;
  private BigDecimal longitude;
  private BigDecimal latitude;
  private String regionCode;
  private String countryCode;
  private String region;
  private String subRegion;
  private String city;
  private String cityCode;
  private String kladrCode;
  private String address;
  private String addressFull;

}
