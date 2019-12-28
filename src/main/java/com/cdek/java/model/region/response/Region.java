package com.cdek.java.model.region.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Region {

  /**
   * Код страны в формате  ISO_3166-1_alpha-2
   */
  @Size(max = 2)
  private String countryCode;

  /**
   * Название страны региона
   */
  @Size(max = 255)
  private String country;

  /**
   * Название региона
   */
  @Size(max = 255)
  private String region;

  /**
   * Код региона СДЭК
   */
  @Size(max = 255)
  private String regionCode;

  /**
   * Код КЛАДР региона
   */
  @Size(max = 255)
  private String kladrRegionCode;

  /**
   * Уникальный идентификатор ФИАС региона
   */
  private UUID fiasRegionGuid;

  /**
   * Список ошибок
   */
  private List<Error> errors;

}
