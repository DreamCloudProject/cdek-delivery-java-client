package com.cdek.java.model.city.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class City {

  /**
   * Код населенного пункта СДЭК
   */
  private String code;

  /**
   * Название населенного пункта.
   */
  private String city;

  /**
   * Уникальный идентификатор ФИАС населенного пункта
   */
  private UUID fiasGuid;

  /**
   * Код КЛАДР населенного пункта
   */
  private String kladrCode;

  /**
   * Код страны населенного пункта в формате  ISO_3166-1_alpha-2
   */
  private String country;

  /**
   * Название страны населенного пункта
   */
  private String region;

  /**
   * Код региона СДЭК
   */
  private String regionCode;

  /**
   * Уникальный идентификатор ФИАС региона населенного пункта
   */
  private UUID fiasRegionGuid;

  /**
   * Код КЛАДР региона населенного пункта
   */
  private String kladrRegionCode;

  /**
   * Название района региона населенного пункта
   */
  private String subRegion;

  /**
   * Массив почтовых индексов
   */
  private List<String> postalCodes;

  /**
   * Долгота центра населенного пункта
   */
  private BigDecimal longitude;

  /**
   * Широта центра населенного пункта
   */
  private BigDecimal latitude;

  /**
   * 	Часовой пояс населенного пункта
   */
  private String timeZone;

  /**
   * Ограничение на сумму наложенного платежа в населенном пункте
   */
  private BigDecimal paymentLimit;

  /**
   * Список ошибок
   */
  private List<Error> errors;

}
