package com.cdek.java.client;

import com.cdek.java.client.auth.CdekAuthentication;
import com.cdek.java.exception.CdekProxyException;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CdekClientImpl extends AbstractCdekClient implements CdekClient {

  private final HttpClient httpClient = HttpClient.newHttpClient();

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Setter
  @Value("${cdek.base.url}")
  private String baseUrl;

  /**
   * {@inheritDoc}
   */
  @Override
  public AuthResponse authenticate(AuthRequest authRequest) {

    var uri = UriComponentsBuilder.newInstance()
        .uri(URI.create(baseUrl + authUrl))
        .queryParam("grant_type", authRequest.getGrantType().name().toLowerCase())
        .queryParam("client_id", authRequest.getClientId())
        .queryParam("client_secret", authRequest.getClientSecret())
        .build()
        .toUriString();

    return doRequestForObject(
        uri,
        "POST",
        null,
        AuthResponse.class,
        null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse orderRegistration(
      @NotNull OrderRequest orderRequest,
      @NotNull CdekAuthentication authentication) {

    if (orderRequest == null) {
      throw new CdekProxyException("Поле orderRequest не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + ordersUrl;

    return doRequestForObject(url, "POST", orderRequest, OrderResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse getOrderInfo(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + ordersUrl + "/" + uuid;

    return doRequestForObject(url, "GET", null, OrderResponse.class, authentication);
  }

  @Override
  public Calculator calculateDelivery(
          @NotNull CalculatorRequest calcRequest,
          @NotNull CdekAuthentication authentication) {
    if (calcRequest == null) {
      throw new CdekProxyException("Поле calcRequest не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + calculatorUrl;

    return doRequestForObject(url, "POST", calcRequest, Calculator.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse deleteOrder(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + ordersUrl + "/" + uuid;

    return doRequestForObject(url, "DELETE", null, OrderResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse createCourierDeliveryRequest(
      @NotNull CourierRequest courierRequest,
      @NotNull CdekAuthentication authentication) {

    if (courierRequest == null) {
      throw new CdekProxyException("Поле courierRequest не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + courierUrl;

    return doRequestForObject(url, "POST", courierRequest, CourierResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse getCourierRequestInfo(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + courierUrl + "/" + uuid;

    return doRequestForObject(url, "GET", null, CourierResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse deleteCourierRequest(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + courierUrl + "/" + uuid;

    return doRequestForObject(url, "DELETE", null, CourierResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse formOrderInvoice(
      @NotNull InvoiceRequest invoiceRequest,
      @NotNull CdekAuthentication authentication) {

    if (invoiceRequest == null) {
      throw new CdekProxyException("Поле по invoiceRequest не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + invoiceUrl;

    return doRequestForObject(url, "POST", invoiceRequest, InvoiceResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse getInvoiceForOrder(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + invoiceUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, InvoiceResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse formBarcodePlaceForOrder(
      @NotNull BarcodeRequest barcodeRequest,
      @NotNull CdekAuthentication authentication) {

    if (barcodeRequest == null) {
      throw new CdekProxyException("Поле barcodeRequest не может null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + barcodeUrl;
    return doRequestForObject(url, "POST", barcodeRequest, BarcodeResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse getBarcodePlaceForOrder(
      @NotNull UUID uuid,
      @NotNull CdekAuthentication authentication) {

    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + barcodeUrl + "/" + uuid;
    return doRequestForObject(url, "GET", null, BarcodeResponse.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Region> getRegionsList(
      @NotNull RegionRequest regionRequest,
      @NotNull CdekAuthentication authentication) {

    if (regionRequest == null) {
      throw new CdekProxyException("Поле regionRequest не может быть null.");
    }
    var url = baseUrl + regionListUrl;
    requireNonNullAccessToken(authentication);

    return doGetRequestForList(url, regionRequest, Region.class, authentication);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CityResponse> getCitiesList(
      @NotNull CityRequest cityRequest,
      @NotNull CdekAuthentication authentication) {

    if (cityRequest == null) {
      throw new CdekProxyException("Поле cityRequest не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + citiesListUrl;
    return doGetRequestForList(url, cityRequest, CityResponse.class, authentication);
  }

  @Override
  public List<DeliveryPointResponse> getDeliveryPointsList(DeliveryPointRequest deliveryPointRequest, CdekAuthentication authentication) {
    if (deliveryPointRequest == null) {
      throw new CdekProxyException("Поле deliveryPointRequest не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + deliveryPointsUrl;
    return doGetRequestForList(url, deliveryPointRequest, DeliveryPointResponse.class, authentication);
  }

  @Override
  public Tariffs getTariffsList(
          @NotNull CalculatorRequest calcRequest,
          @NotNull CdekAuthentication authentication) {
    if (calcRequest == null) {
      throw new CdekProxyException("Поле calcRequest не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + tariffsUrl;

    return doRequestForObject(url, "POST", calcRequest, Tariffs.class, authentication);
  }

  @Override
  public Integer getTariffCode(Integer weight) {
    if(weight > 0 && weight <= 30){
      return 139;
    } else if(weight > 30 && weight <= 50){
      return 231;
    } else if(weight > 50 && weight <= 500){
      return 293;
    } else {
      return 293;
    }
  }

  @Override
  public WebhookResponse createWebhook(WebhookRequest request, CdekAuthentication authentication) {
    if (request == null) {
      throw new CdekProxyException("Поле request не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + webhooksUrl;

    return doRequestForObject(url, "POST", request, WebhookResponse.class, authentication);
  }

  @Override
  public WebhookResponse getWebhookInfo(
          @NotNull UUID uuid,
          @NotNull CdekAuthentication authentication) {
    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null.");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + webhooksUrl + "/" + uuid;

    return doRequestForObject(url, "GET", null, WebhookResponse.class, authentication);
  }

  @Override
  public WebhookResponse deleteWebhook(
          @NotNull UUID uuid,
          @NotNull CdekAuthentication authentication) {
    if (uuid == null) {
      throw new CdekProxyException("Поле uuid не может быть null");
    }
    requireNonNullAccessToken(authentication);
    var url = baseUrl + webhooksUrl + "/" + uuid;

    return doRequestForObject(url, "DELETE", null, WebhookResponse.class, authentication);
  }

  @Override
  public List<OrderStatusWebhook> getWebhookList(WebhookRequest webhookRequest, CdekAuthentication authentication) {
    if (webhookRequest == null) {
      throw new CdekProxyException("Поле webhookRequest не может быть null.");
    }
    var url = baseUrl + webhooksUrl;
    requireNonNullAccessToken(authentication);

    return doGetRequestForList(url, webhookRequest, OrderStatusWebhook.class, authentication);
  }

  private void requireNonNullAccessToken(CdekAuthentication authentication) {
    if (authentication == null) {
      throw new CdekProxyException("Поле authentication не может быть null.");
    }
    if (authentication.getAccessToken() == null) {
      throw new CdekProxyException("Токен доступа не может быть null.");
    }
  }

  private <T> T doRequestForObject(
      String url,
      String method,
      @Nullable Object requestEntity,
      Class<T> responseEntityClass,
      @Nullable CdekAuthentication authentication) {

    try {
      var response = doRequest(url, method, requestEntity, authentication);
      var responseBody = response.body();
      Objects.requireNonNull(responseBody);
      return objectMapper.readValue(responseBody, responseEntityClass);
    } catch (IOException | InterruptedException ex) {
      log.error(ex.getMessage(), ex);
      throw new CdekProxyException(ex.getMessage(), ex);
    }
  }

  private <T> List<T> doGetRequestForList(
      String url,
      @Nullable Object requestEntity,
      Class<T> responseEntityClass,
      CdekAuthentication authentication) {
    try {
      Map<String,Object> params = objectMapper.convertValue(requestEntity, new TypeReference<>() {});
      MultiValueMap<String,String> queryValueMap = new LinkedMultiValueMap<>();
      params.forEach((key, value) -> {
        Object val;
        if(value instanceof List){
          val = ((List<String>) value).stream().collect(Collectors.joining(","));
        } else {
          val = value;
        }
        if(Objects.nonNull(val)){
          queryValueMap.add(key, val.toString());
        }
      });
      UriComponents queryParams = UriComponentsBuilder.newInstance()
              .queryParams(queryValueMap).build();

      var response = doRequest(url + queryParams, "GET", requestEntity, authentication);
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

  private HttpResponse<String> doRequest(
      String url,
      String method,
      @Nullable Object requestEntity,
      CdekAuthentication authentication) throws IOException, InterruptedException {
    var bodyPublisher = BodyPublishers.noBody();
    if (requestEntity != null) {
      var json = objectMapper.writeValueAsBytes(requestEntity);
      bodyPublisher = BodyPublishers.ofByteArray(json);
    }
    var requestBuilder = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .method(method, bodyPublisher);
    if (authentication != null && authentication.getAccessToken() != null) {
      requestBuilder.header(HttpHeaders.AUTHORIZATION, "bearer " + authentication.getAccessToken());
    }
    var request = requestBuilder.build();
    return httpClient.send(request, BodyHandlers.ofString());
  }
}
