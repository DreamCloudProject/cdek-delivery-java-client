package com.cdek.java.client;

import com.cdek.java.client.auth.CdekAuthService;
import com.cdek.java.exception.CdekException;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CdekClientImp extends AbstractCdekClient implements CdekClient {

  @Value("${cdek.base.url}")
  private String baseUrl;

  private final ValidationService validationService;
  private final CdekAuthService cdekAuthService;
  private final OkHttpClient webClient;
  private final ObjectMapper objectMapper;

  /**
   * {@inheritDoc}
   */
  @Override
  @SneakyThrows
  public OrderResponse orderRegistration(@NotNull OrderRequest orderRequest) {
    Objects.requireNonNull(orderRequest);
    validationService.validateOrder(orderRequest);
    var json = objectMapper.writeValueAsBytes(orderRequest);
    var requestBody = RequestBody.create(json);
    var request = new Request.Builder()
        .url(baseUrl + ordersUrl)
        .header(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .post(requestBody)
        .build();
    var response = webClient.newCall(request).execute();
    var responseBody = response.body();
    Objects.requireNonNull(responseBody);
    return objectMapper.readValue(responseBody.string(), OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @SneakyThrows
  public OrderResponse getOrderInfo(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var request = new Request.Builder()
        .url(baseUrl + ordersUrl + "/" + uuid)
        .addHeader(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .build();
    var response = webClient.newCall(request).execute();
    var responseBody = response.body();
    Objects.requireNonNull(responseBody);
    return objectMapper.readValue(responseBody.string(), OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @SneakyThrows
  public OrderResponse deleteOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    var request = new Request.Builder()
        .url(baseUrl + ordersUrl + "/" + uuid)
        .addHeader(AUTH_HEADER, cdekAuthService.getFreshJWT())
        .delete()
        .build();
    var response = webClient.newCall(request).execute();
    var responseBody = response.body();
    Objects.requireNonNull(responseBody);
    return objectMapper.readValue(responseBody.string(), OrderResponse.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse createCourierDeliveryRequest(@NotNull CourierRequest courierRequest) {
    Objects.requireNonNull(courierRequest);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse getCourierRequestInfo(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse deleteCourierRequest(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse formOrderInvoice(@NotNull InvoiceRequest invoiceRequest) {
    Objects.requireNonNull(invoiceRequest);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse getInvoiceForOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse formBarcodePlaceForOrder(@NotNull BarcodeRequest barcodeRequest) {
    Objects.requireNonNull(barcodeRequest);
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse getBarcodePlaceForOrder(@NotNull UUID uuid) {
    Objects.requireNonNull(uuid);
    return null;
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

  private <T> List<T> getList(String url, Object requestEntity, Class<T> responseEntityClass) {
    try {
      var json = objectMapper.writeValueAsBytes(requestEntity);
      var requestBody = RequestBody.create(json);
      var request = new Request.Builder()
          .url(url)
          .method("GET", requestBody)
          .build();
      var response = webClient.newCall(request).execute();
      var responseBody = response.body();
      Objects.requireNonNull(responseBody);
      var listMapper = objectMapper
          .getTypeFactory()
          .constructCollectionType(List.class, responseEntityClass);
      return objectMapper.readValue(responseBody.string(), listMapper);
    } catch (JsonProcessingException ex) {
      log.info(ex.getMessage(), ex);
      throw new CdekProxyException(ex.getMessage(), ex);
    } catch (IOException ex) {
      log.info(ex.getMessage(), ex);
      throw new CdekException(ex.getMessage(), ex);
    }
  }
}
