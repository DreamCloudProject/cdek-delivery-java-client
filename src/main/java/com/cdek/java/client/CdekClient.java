package com.cdek.java.client;

import com.cdek.java.client.auth.CdekAuthentication;
import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.response.AuthResponse;
import com.cdek.java.model.barcode.request.BarcodeRequest;
import com.cdek.java.model.barcode.response.BarcodeResponse;
import com.cdek.java.model.calculator.request.CalculatorRequest;
import com.cdek.java.model.calculator.response.Calculator;
import com.cdek.java.model.calculator.response.Tariffs;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.city.response.CityResponse;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.courier.response.CourierResponse;
import com.cdek.java.model.deliverypoint.request.DeliveryPointRequest;
import com.cdek.java.model.deliverypoint.response.DeliveryPointResponse;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.invoice.response.InvoiceResponse;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.model.order.response.OrderResponse;
import com.cdek.java.model.region.request.RegionRequest;
import com.cdek.java.model.region.response.Region;
import com.cdek.java.model.webhook.request.WebhookRequest;
import com.cdek.java.model.webhook.response.OrderStatusWebhook;
import com.cdek.java.model.webhook.response.WebhookResponse;

import java.util.List;
import java.util.UUID;

public interface CdekClient {

  AuthResponse authenticate(AuthRequest authRequest);

  /**
   * Запрос на регистрацию заказа
   * @param orderRequest - описание заказа
   * @return при успешно принятом запросе возвращается объект с информацией по заказу, значением
   * идентификатора uuid и статусом заказа в системе СДЭК. В случае возникновения ошибки в теле
   * ответа будет возвращено описание ошибки в формате error и HTTP-статус будет установлен в
   * соответствии с состоянием ошибки.
   */
  OrderResponse orderRegistration(OrderRequest orderRequest, CdekAuthentication authentication);

  /**
   * Запрос на получение информации о заказе
   * @param uuid - идентификатор заказа в ИС СДЭК, по которому необходима информация
   * @return объект с информацией по заказу
   */
  OrderResponse getOrderInfo(UUID uuid, CdekAuthentication authentication);

  /**
   * Запрос на получение информации о сумме доставки
   * @param calcRequest - объект содержащий информацию о габаритах, адресе доставки и весе заказа
   * @return объект с информацией по рассчитанной сумме доставки
   */
  Calculator calculateDelivery(CalculatorRequest calcRequest, CdekAuthentication authentication);

  /**
   * Запрос на удаление заказа
   * @param uuid - идентификатор заказа в ИС СДЭК, который необходимо удалить
   * @return объект с информацией по удаленному заказу
   */
  OrderResponse deleteOrder(UUID uuid, CdekAuthentication authentication);

  /**
   * Регистрация заявки на вызов курьера
   * Метод позволяет осуществить вызов курьера для забора груза со склада ИМ с последующей доставкой до склада СДЭК.
   * <p>
   * Условия формирования заявки:
   * - забор консолидированного груза в один день с одного адреса возможен только единожды;
   * - количество выездов курьера на один адрес в один день для штучного забора не ограничен;
   * - рекомендуемый минимальный диапазон времени для приезда курьера не менее 3х часов.
   * @param courierRequest
   * @return
   */
  CourierResponse createCourierDeliveryRequest(CourierRequest courierRequest, CdekAuthentication authentication);

  /**
   * Информация о заявке
   * Метод предназначен для получения информации по заданной заявке.
   * @param uuid - идентификатор заявки в ИС СДЭК, по которому необходима информация
   * @return
   */
  CourierResponse getCourierRequestInfo(UUID uuid, CdekAuthentication authentication);

  /**
   * Удаление заявки
   * Метод предназначен для отмены заявки на вызов курьера.
   * @param uuid - идентификатор заявки в ИС СДЭК, которую необходимо отменить
   * @return
   */
  CourierResponse deleteCourierRequest(UUID uuid, CdekAuthentication authentication);

  /**
   * Формирование квитанции к заказу
   * Метод используется для формирования квитанции в формате pdf к заказу/заказам.
   * Во избежание перегрузки платформы нельзя передавать более 100 номеров заказов в одном запросе.
   * @param invoiceRequest
   * @return
   */
  InvoiceResponse formOrderInvoice(InvoiceRequest invoiceRequest, CdekAuthentication authentication);

  /**
   * Получение квитанции к заказу
   * Метод используется для получения ссылки на квитанцию в формате pdf к заказу/заказам.
   * @param uuid - идентификатор квитанции, ссылку на которую необходимо получить
   * @return
   */
  InvoiceResponse getInvoiceForOrder(UUID uuid, CdekAuthentication authentication);

  /**
   * Формирование ШК-места к заказу
   * Метод используется для формирования ШК-места в формате pdf к заказу/заказам.
   * Во избежание перегрузки платформы нельзя передавать более 100 номеров заказов в одном запросе.
   * @param barcodeRequest
   * @return
   */
  BarcodeResponse formBarcodePlaceForOrder(BarcodeRequest barcodeRequest, CdekAuthentication authentication);

  /**
   * Получение ШК-места к заказу
   * Метод используется для получения ШК-места в формате pdf к заказу/заказам.
   * @param uuid - идентификатор ШК-места, ссылку на который необходимо получить
   * @return
   */
  BarcodeResponse getBarcodePlaceForOrder(UUID uuid, CdekAuthentication authentication);

  /**
   * Список регионов.
   * Метод предназначен для получения детальной информации о регионах.
   * Список регионов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param regionRequest - объект, содержащий
   * @return
   */
  List<Region> getRegionsList(RegionRequest regionRequest, CdekAuthentication authentication);

  /**
   * Список населенных пунктов.
   * Метод предназначен для получения детальной информации о населенных пунктах.
   * Список населенных пунктов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param cityRequest - объект содержащий информацию о запрашиваемых населенных пунктах.
   */
  List<CityResponse> getCitiesList(CityRequest cityRequest, CdekAuthentication authentication);

  /**
   * Список точек доставки по заданным параметрам.
   *
   * @param deliveryPointRequest объект с параметрами запроса точек доставки
   * @param authentication объект для аутентификации в сервисе
   * @return список объектов DeliveryPointResponse, содержащих информацию о точках доставки
   */
  List<DeliveryPointResponse> getDeliveryPointsList(DeliveryPointRequest deliveryPointRequest, CdekAuthentication authentication);

  /**
   * Список тарифов для расчета суммы доставки.
   * Метод предназначен для получения детальной информации о тарифах.
   * Список тарифов может быть ограничен характеристиками, задаваемыми пользователем.
   * @param calcRequest - объект содержащий информацию о запрашиваемых тарифах.
   * @param authentication объект для аутентификации в сервисе   */
  Tariffs getTariffsList(CalculatorRequest calcRequest, CdekAuthentication authentication);

  /**
   * Метод возвращает код тарифа в зависимости от веса груза.
   * @param weight вес груза
   * @return код тарифа
   */
  Integer getTariffCode(Integer weight);

  /**
   * Метод для создания вебхука на основе запроса.
   *
   * @param request объект запроса для создания вебхука
   * @param authentication объект для аутентификации в сервисе
   * @return объект ответа на запрос о создании вебхука
   */
  WebhookResponse createWebhook(WebhookRequest request, CdekAuthentication authentication);

  /**
   * Метод для получения информации о подписке
   *
   * @param uuid идентификатор подписки
   * @param authentication объект для аутентификации в сервисе
   * @return объект ответа на запрос об удалении вебхука
   */
  WebhookResponse getWebhookInfo(UUID uuid, CdekAuthentication authentication);

  /**
   * Метод для удаления вебхука
   *
   * @param uuid идентификатор подписки
   * @param authentication объект для аутентификации в сервисе
   * @return объект ответа на запрос об удалении вебхука
   */
  WebhookResponse deleteWebhook(UUID uuid, CdekAuthentication authentication);

  /**
   * Возвращает список вебхуков.
   * @param request объект запроса
   * @param authentication объект для аутентификации в сервисе
   * @return список вебхуков
   */
  List<OrderStatusWebhook> getWebhookList(WebhookRequest request, CdekAuthentication authentication);

}
