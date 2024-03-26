package com.cdek.java.model.order.request;

import com.cdek.java.model.handbook.Country;
import com.cdek.java.model.common.Money;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

/**
 * Информация о товарах места заказа (только для заказа типа "интернет-магазин")
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Item {

  /**
   * Наименование товара (может также содержать описание товара: размер, цвет)
   */
  @NotNull
  @Size(max = 255)
  private String name;

  /**
   * Идентификатор/артикул товара
   */
  @NotNull
  @Size(max = 20)
  private String wareKey;

  /**
   * Оплата за товар при получении (за единицу товара в указанной валюте, значение >=0) —
   * наложенный платеж, в случае предоплаты значение = 0
   */
  @NotNull
  private Money payment;

  /**
   * Объявленная стоимость товара (за единицу товара в указанной валюте, значение >=0).
   * С данного значения рассчитывается страховка
   */
  @NotNull
  private BigDecimal cost;

  /**
   * Вес (за единицу товара, в граммах)
   */
  @NotNull
  private Integer weight;

  /**
   * Вес брутто
   */
  private Integer weightGross;

  /**
   * Количество единиц товара (в штуках)
   */
  @NotNull
  private Integer amount;

  /**
   * Наименование на иностранном языке
   */
  @Size(max = 255)
  private String nameI18n;

  /**
   * Бренд на иностранном языке
   */
  @Size(max = 255)
  private String brand;

  /**
   * Код страны
   */
  private Country countryCode;

  /**
   * Код материала
   */
  @Size(max = 255)
  private String material;

  /**
   * Содержит wifi/gsm
   */
  private Boolean wifiGsm;

  /**
   * Ссылка на сайт интернет-магазина с описанием товара
   */
  @Size(max = 255)
  private String url;

}
