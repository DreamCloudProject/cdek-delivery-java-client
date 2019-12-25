package com.cdek.java;

import com.cdek.java.model.request.OrderRequest;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CdekClientImp implements CdekClient {

  @Value("${url}")
  private String url;

  private String ordersUrl;
  private String courierUrl;
  private String invoiceUrl;
  private String barcodeUrl;
  private String webhooksUrl;
  private String regionListUrl;
  private String citiesListUrl;

  @PostConstruct
  private void init() {
    var versionedUrl = url + "/v2";
    ordersUrl = versionedUrl + "/orders";
    courierUrl = versionedUrl + "/intakes";
    invoiceUrl = versionedUrl + "/print/orders";
    barcodeUrl = versionedUrl + "/print/barcodes";
    webhooksUrl = versionedUrl + "/webhooks";
    regionListUrl = versionedUrl + "/location/regions";
    citiesListUrl = versionedUrl + "/location/cities";
  }


  @Override
  public OrderInfo orderRegistration(OrderRequest orderRequest) {
    return null;
  }

  @Override
  public OrderInfo getOrderInfo(UUID uuid) {
    return null;
  }

  @Override
  public OrderInfo deleteOrder(UUID uuid) {
    return null;
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
