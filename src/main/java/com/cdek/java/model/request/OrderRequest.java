package com.cdek.java.model.request;

import com.cdek.java.OrderTariff;
import com.cdek.java.OrderType;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
  private LocalDate dateInvoice;
  private String shipperName;
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
