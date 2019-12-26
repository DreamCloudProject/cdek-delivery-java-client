package com.cdek.java.client;

import com.cdek.java.client.auth.CdekAuthService;
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
import com.cdek.java.model.region.response.RegionResponse;
import com.cdek.java.service.validation.ValidationService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
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

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse orderRegistration(OrderRequest orderRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse getOrderInfo(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderResponse deleteOrder(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse createCourierDeliveryRequest(CourierRequest courierRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse getCourierRequestInfo(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CourierResponse deleteCourierRequest(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse formOrderInvoice(InvoiceRequest invoiceRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InvoiceResponse getInvoiceForOrder(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse formBarcodePlaceForOrder(BarcodeRequest barcodeRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BarcodeResponse getBarcodePlaceForOrder(UUID uuid) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RegionResponse getRegionsList(RegionRequest regionRequest) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CityResponse getCitiesList(CityRequest cityRequest) {
    return null;
  }
}
