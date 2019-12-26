package com.cdek.java.client;

import com.cdek.java.client.auth.CdekAuthService;
import com.cdek.java.model.OrderInfo;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.service.validation.ValidationService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CdekClientImp implements CdekClient {

  private final ValidationService validationService;
  private final CdekAuthService cdekAuthService;
  private final WebClient webClient;

  private static final String AUTH_HEADER = "Authorization";
  private static final String versionedUrl = "/v2";
  private static final String ordersUrl = versionedUrl + "/orders";
  private static final String courierUrl = versionedUrl + "/intakes";
  private static final String invoiceUrl = versionedUrl + "/print/orders";
  private static final String barcodeUrl = versionedUrl + "/print/barcodes";
  private static final String webhooksUrl = versionedUrl + "/webhooks";
  private static final String regionListUrl = versionedUrl + "/location/regions";
  private static final String citiesListUrl = versionedUrl + "/location/cities";

  @Override
  public Mono<OrderInfo> orderRegistration(OrderRequest orderRequest) {
//    return Mono.just(orderRequest)
//        .flatMap(order -> {
//          validationService.validateOrder(order);
//          return webClient
//              .post()
//              .uri(ordersUrl)
//              .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
//
//        });
    return null;
  }

  @Override
  public Mono<OrderInfo> getOrderInfo(UUID uuid) {
    return webClient
        .get()
        .uri(ordersUrl + "/" + uuid)
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .retrieve()
        .bodyToMono(OrderInfo.class);
  }

  @Override
  public Mono<OrderInfo> deleteOrder(UUID uuid) {
    return webClient
        .delete()
        .uri(ordersUrl + "/" + uuid)
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .retrieve()
        .bodyToMono(OrderInfo.class);
  }

  @Override
  public void createCourierDeliveryRequest() {

  }

  @Override
  public void formInvoice() {

  }

  @Override
  public void getInvoice() {

  }

  @Override
  public void getRegionList() {

  }
}
