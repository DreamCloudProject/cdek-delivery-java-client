package com.cdek.java.model.common;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * Адрес местоположения контрагента (отправителя, получателя), включая геолокационные данные
 */
@Getter
@Setter
public class Location {

  private String code;
  private UUID fiasGuid;
  private String postalCode;
  private BigDecimal longitude;
  private BigDecimal latitude;
  private String countryCode;
  private String region;
  private String subRegion;
  private String city;
  private String kladrCode;
  private String address;

}
