package com.cdek.java.model.order.request;

import com.cdek.java.commons.Pattern;
import com.cdek.java.model.handbook.OrderTariff;
import com.cdek.java.model.common.OrderType;
import com.cdek.java.model.common.Contact;
import com.cdek.java.model.common.Location;
import com.cdek.java.model.common.Money;
import com.cdek.java.model.common.Service;
import com.cdek.java.model.common.Threshold;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderRequest {

  private OrderType type;

  private UUID number;

  @NotNull
  private OrderTariff tariffCode;

  @Size(max = 255, message = "Размер комментария к заказу не может быть больше 255 символов.")
  private String comment;

  @Size(max = 255, message = "Код ПВЗ СДЭК забора отправления не может быть больше 255 символов")
  private String shipmentPoint;

  @Size(max = 255)
  private String deliveryPoint;

  private String itemsCostCurrency;

  private String recipientCurrency;

  /**
   * Дата инвойса. Только для заказов "интернет-магазин"
   */
  @JsonFormat(pattern = Pattern.DATE)
  private Instant dateInvoice;

  @Size(max = 255)
  private String shipperName;

  @Size(max = 255)
  private String shipperAddress;
  private Money deliveryRecipientCost;
  private List<Threshold> deliveryRecipientCostAdv;
  private Contact sender;
  private Seller seller;
  private Contact recipient;
  private Location fromLocation;
  private Location toLocaton;
  private List<Service> services;
  private List<Package> packages;

}
