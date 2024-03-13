package com.cdek.java.client;

import com.cdek.java.commons.Api;

public abstract class AbstractCdekClient {

  private static final String versionedUrl = Api.version;
  protected static final String authUrl = Api.version + "/oauth/token";
  protected static final String ordersUrl = versionedUrl + "/orders";
  protected static final String courierUrl = versionedUrl + "/intakes";
  protected static final String invoiceUrl = versionedUrl + "/print/orders";
  protected static final String barcodeUrl = versionedUrl + "/print/barcodes";
  protected static final String calculatorUrl = versionedUrl + "/calculator/tariff";
  protected static final String tariffsUrl = versionedUrl + "/calculator/tarifflist";
  protected static final String webhooksUrl = versionedUrl + "/webhooks";
  protected static final String regionListUrl = versionedUrl + "/location/regions";
  protected static final String citiesListUrl = versionedUrl + "/location/cities";

}
