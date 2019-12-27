package com.cdek.java.client.reactive;

import com.cdek.java.model.barcode.request.BarcodeRequest;
import com.cdek.java.model.barcode.response.BarcodeResponse;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.city.response.City;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.courier.response.CourierResponse;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.invoice.response.InvoiceResponse;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.model.order.response.OrderResponse;
import com.cdek.java.model.region.request.RegionRequest;
import com.cdek.java.model.region.response.Region;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveCdekClient {

  /**
   * Запрос на регистрацию заказа
   * @param orderRequest - описание заказа
   * @return при успешно принятом запросе возвращается объект с информацией по заказу, значением
   * идентификатора uuid и статусом заказа в системе СДЭК. В случае возникновения ошибки в теле
   * ответа будет возвращено описание ошибки в формате error и HTTP-статус будет установлен в
   * соответствии с состоянием ошибки.
   */
  Mono<OrderResponse> orderRegistration(OrderRequest orderRequest);

  /**
   * Запрос на получение информации о заказе
   * @param uuid - идентификатор заказа в ИС СДЭК, по которому необходима информация
   * @return объект с информацией по заказу
   */
  Mono<OrderResponse> getOrderInfo(UUID uuid);

  /**
   * Запрос на удаление заказа
   * @param uuid - идентификатор заказа в ИС СДЭК, который необходимо удалить
   * @return объект с информацией по удаленному заказу
   */
  Mono<OrderResponse> deleteOrder(UUID uuid);

  Mono<CourierResponse> createCourierDeliveryRequest(CourierRequest courierRequest);

  Mono<CourierResponse> getCourierRequestInfo(UUID uuid);

  Mono<CourierResponse> deleteCourierRequest(UUID uuid);

  Mono<InvoiceResponse> formOrderInvoice(InvoiceRequest invoiceRequest);

  Mono<InvoiceResponse> getInvoiceForOrder(UUID uuid);

  Mono<BarcodeResponse> formBarcodePlaceForOrder(BarcodeRequest barcodeRequest);

  Mono<BarcodeResponse> getBarcodePlaceForOrder(UUID uuid);

  /**
   * Список регионов.
   * Метод предназначен для получения детальной информации о регионах.
   * Список регионов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param regionRequest - объект, содержащий
   * @return
   */
  Flux<Region> getRegionsList(RegionRequest regionRequest);

  /**
   * Список населенных пунктов.
   * Метод предназначен для получения детальной информации о населенных пунктах.
   * Список населенных пунктов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param cityRequest - объект содержащий информацию о запрашиваемых населенных пунктах.
   */
  Flux<City> getCitiesList(CityRequest cityRequest);

}
