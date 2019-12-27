package com.cdek.java.client;

import com.cdek.java.model.barcode.request.BarcodeRequest;
import com.cdek.java.model.barcode.response.BarcodeResponse;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.city.response.CityResponse;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.courier.response.CourierResponse;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.invoice.response.InvoiceResponse;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.model.order.response.OrderResponse;
import com.cdek.java.model.region.request.RegionRequest;
import com.cdek.java.model.region.response.Region;
import com.cdek.java.model.region.response.RegionResponse;
import java.util.List;
import java.util.UUID;

public interface CdekClient {

  /**
   * Запрос на регистрацию заказа
   * @param orderRequest - описание заказа
   * @return при успешно принятом запросе возвращается объект с информацией по заказу, значением
   * идентификатора uuid и статусом заказа в системе СДЭК. В случае возникновения ошибки в теле
   * ответа будет возвращено описание ошибки в формате error и HTTP-статус будет установлен в
   * соответствии с состоянием ошибки.
   */
  OrderResponse orderRegistration(OrderRequest orderRequest);

  /**
   * Запрос на получение информации о заказе
   * @param uuid - идентификатор заказа в ИС СДЭК, по которому необходима информация
   * @return объект с информацией по заказу
   */
  OrderResponse getOrderInfo(UUID uuid);

  /**
   * Запрос на удаление заказа
   * @param uuid - идентификатор заказа в ИС СДЭК, который необходимо удалить
   * @return объект с информацией по удаленному заказу
   */
  OrderResponse deleteOrder(UUID uuid);

  CourierResponse createCourierDeliveryRequest(CourierRequest courierRequest);

  CourierResponse getCourierRequestInfo(UUID uuid);

  CourierResponse deleteCourierRequest(UUID uuid);

  InvoiceResponse formOrderInvoice(InvoiceRequest invoiceRequest);

  InvoiceResponse getInvoiceForOrder(UUID uuid);

  BarcodeResponse formBarcodePlaceForOrder(BarcodeRequest barcodeRequest);

  BarcodeResponse getBarcodePlaceForOrder(UUID uuid);

  /**
   * Список регионов.
   * Метод предназначен для получения детальной информации о регионах.
   * Список регионов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param regionRequest - объект, содержащий
   * @return
   */
  List<Region> getRegionsList(RegionRequest regionRequest);

  /**
   * Список населенных пунктов.
   * Метод предназначен для получения детальной информации о населенных пунктах.
   * Список населенных пунктов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param cityRequest - объект содержащий информацию о запрашиваемых населенных пунктах.
   */
  CityResponse getCitiesList(CityRequest cityRequest);

}
