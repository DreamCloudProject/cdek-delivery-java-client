package com.cdek.java.model.city.request;

import com.cdek.java.model.handbook.Country;
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
public class CityRequest {

  /**
   * Массив кодов стран
   */
  private List<Country> countryCodes;

  /**
   * Код региона СДЭК
   */
  private String regionCode;

  /**
   * Код КЛАДР региона
   */
  private String kladrRegionCode;

  /**
   * Уникальный идентификатор ФИАС региона
   */
  private UUID fiasRegionGuid;

  /**
   * Код КЛАДР населенного пункта
   */
  private String kladrCode;

  /**
   * Уникальный идентификатор ФИАС населенного пункта
   */
  private UUID fiasGuid;

  /**
   * Почтовый индекс
   */
  private String postalCode;

  /**
   * Код населенного пункта СДЭК
   */
  private String code;

  /**
   * Название населенного пункта. Должно соответствовать полностью
   */
  private String city;

  /**
   * Ограничение выборки результата. По умолчанию 1000.
   * Обязателен, если указан page
   */
  private Integer size;

  /**
   * Номер страницы выборки результата. По умолчанию 0
   */
  private Integer page;

  /**
   * Локализация. По умолчанию "rus"
   */
  private String lang;

  /**
   * Ограничение на сумму наложенного платежа:
   * -1 - ограничения нет;
   * 0 - наложенный платеж не принимается;
   * положительное значение - сумма наложенного платежа не более данного значения.
   */
  private BigDecimal paymentLimit;

}
