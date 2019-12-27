package com.cdek.java.client.reactive;

import com.cdek.java.client.AbstractCdekClient;
import com.cdek.java.client.auth.CdekAuthService;
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
import com.cdek.java.service.validation.ValidationService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactiveCdekClientImp extends AbstractCdekClient implements ReactiveCdekClient {

  private final ValidationService validationService;
  private final CdekAuthService cdekAuthService;
  private final WebClient reactiveWebClient;

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<OrderResponse> orderRegistration(OrderRequest orderRequest) {
    return Mono.just(orderRequest)
        .flatMap(order -> {
          validationService.validateOrderRequest(order);
          return reactiveWebClient
              .post()
              .uri(ordersUrl)
              .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
              .body(Mono.just(order), OrderRequest.class)
              .retrieve()
              .bodyToMono(OrderResponse.class);
        });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<OrderResponse> getOrderInfo(UUID uuid) {
    return reactiveWebClient
        .get()
        .uri(ordersUrl + "/" + uuid)
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .retrieve()
        .bodyToMono(OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<OrderResponse> deleteOrder(UUID uuid) {
    return reactiveWebClient
        .delete()
        .uri(ordersUrl + "/" + uuid)
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .retrieve()
        .bodyToMono(OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<CourierResponse> createCourierDeliveryRequest(CourierRequest courierRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<CourierResponse> getCourierRequestInfo(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<CourierResponse> deleteCourierRequest(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<InvoiceResponse> formOrderInvoice(InvoiceRequest invoiceRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<InvoiceResponse> getInvoiceForOrder(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<BarcodeResponse> formBarcodePlaceForOrder(BarcodeRequest barcodeRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<BarcodeResponse> getBarcodePlaceForOrder(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Flux<Region> getRegionsList(RegionRequest regionRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Flux<City> getCitiesList(CityRequest cityRequest) {
    return null;
  }
}
