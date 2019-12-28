package com.cdek.java.client;

import com.cdek.java.client.auth.service.CdekAuthService;
import com.cdek.java.exception.CdekProxyException;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CdekClientImp extends AbstractCdekClient implements CdekClient {

  @Value("${cdek.base.url}")
  private String baseUrl;

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  private final ValidationService validationService;
  private final CdekAuthService cdekAuthService;
  private final HttpClient httpClient;
  private final ObjectMapper objectMapper;

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse orderRegistration(@NotNull OrderRequest orderRequest) {
    Objects.requireNonNull(orderRequest);
    validationService.validateOrderRequest(orderRequest);
    var url = baseUrl + ordersUrl;
    return doRequestForObject(url, "POST", orderRequest, OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse getOrderInfo(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + ordersUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse deleteOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + ordersUrl + "/" + uuid;
    return doRequestForObject(url, "DELETE", null, OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse createCourierDeliveryRequest(@NotNull CourierRequest courierRequest) {
    Objects.requireNonNull(courierRequest);
    validationService.validateCourierRequest(courierRequest);
    var url = baseUrl + courierUrl;
    return doRequestForObject(url, "POST", courierRequest, CourierResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse getCourierRequestInfo(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + courierUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, CourierResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse deleteCourierRequest(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + courierUrl + "/" + uuid;
    return doRequestForObject(url, "DELETE", null, CourierResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse formOrderInvoice(@NotNull InvoiceRequest invoiceRequest) {
    Objects.requireNonNull(invoiceRequest);
    validationService.validateInvoiceRequest(invoiceRequest);
    var url = baseUrl + invoiceUrl;
    return doRequestForObject(url, "POST", invoiceRequest, InvoiceResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse getInvoiceForOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + invoiceUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, InvoiceResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse formBarcodePlaceForOrder(@NotNull BarcodeRequest barcodeRequest) {
    Objects.requireNonNull(barcodeRequest);
    validationService.validateBarcodeRequest(barcodeRequest);
    var url = baseUrl + barcodeUrl;
    return doRequestForObject(url, "POST", barcodeRequest, BarcodeResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse getBarcodePlaceForOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var url = baseUrl + barcodeUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, BarcodeResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Region> getRegionsList(@NotNull RegionRequest regionRequest) {
    Objects.requireNonNull(regionRequest);
    var url = baseUrl + regionListUrl;
    return getList(url, regionRequest, Region.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<City> getCitiesList(@NotNull CityRequest cityRequest) {
    Objects.requireNonNull(cityRequest);
    var url = baseUrl + citiesListUrl;
    return getList(url, cityRequest, City.class);
  }

  private <T> T doRequestForObject(String url, String method, @Nullable Object requestEntity,
      Class<T> responseEntityClass) {
    try {
      var response = doRequest(url, method, requestEntity);
      var responseBody = response.body();
      Objects.requireNonNull(responseBody);
      return objectMapper.readValue(responseBody, responseEntityClass);
    } catch (IOException | InterruptedException ex) {
      log.error(ex.getMessage(), ex);
      throw new CdekProxyException(ex.getMessage(), ex);
    }
  }

  private <T> List<T> getList(String url, @Nullable Object requestEntity,
      Class<T> responseEntityClass) {
    try {
      var response = doRequest(url, "GET", requestEntity);
      var responseBody = response.body();
      Objects.requireNonNull(responseBody);
      var listMapper = objectMapper
          .getTypeFactory()
          .constructCollectionType(List.class, responseEntityClass);
      return objectMapper.readValue(responseBody, listMapper);
    } catch (IOException | InterruptedException ex) {
      log.error(ex.getMessage(), ex);
      throw new CdekProxyException(ex.getMessage(), ex);
    }
  }

  private HttpResponse<String> doRequest(String url, String method, @Nullable Object requestEntity)
      throws IOException, InterruptedException {
    var bodyPublisher = BodyPublishers.noBody();
    if (requestEntity != null) {
      var json = objectMapper.writeValueAsBytes(requestEntity);
      bodyPublisher = BodyPublishers.ofByteArray(json);
    }
    var request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .method(method, bodyPublisher)
        .build();
    return httpClient.send(request, BodyHandlers.ofString());
  }
}
