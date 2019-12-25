package com.cdek.java;

import com.cdek.java.model.request.OrderRequest;
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
  OrderInfo orderRegistration(OrderRequest orderRequest);

  /**
   * Запрос на получение информации о заказе
   * @param uuid - идентификатор заказа в ИС СДЭК, по которому необходима информация
   * @return объект с информацией по заказу
   */
  OrderInfo getOrderInfo(UUID uuid);

  /**
   * Запрос на удаление заказа
   * @param uuid - идентификатор заказа в ИС СДЭК, который необходимо удалить
   * @return объект с информацией по удаленному заказу
   */
  OrderInfo deleteOrder(UUID uuid);

  void createCourierDeliveryRequest();

  void formInvoice();

  void getInvoice();

  void getRegionList();


}
