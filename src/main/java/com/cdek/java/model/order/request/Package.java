package com.cdek.java.model.order.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Информация о местах заказа
 */
@Getter
@Setter
public class Package {

  /**
   * Номер упаковки (можно использовать порядковый номер упаковки заказа или номер заказа),
   * уникален в пределах заказа. Идентификатор заказа в ИС Клиента.
   */
  @NotNull
  @Size(max = 255)
  private String number;

  @NotNull
  private Integer weight;
  private Integer length;
  private Integer width;
  private Integer height;
  private String comment;

  /**
   * Позиции товаров в упаковке. Только для заказов "интернет-магазин"
   */
  private List<Item> items;

}
