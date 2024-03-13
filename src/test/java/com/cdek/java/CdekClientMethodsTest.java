package com.cdek.java;

import com.cdek.java.client.CdekClient;
import com.cdek.java.client.CdekClientImpl;
import com.cdek.java.client.reactive.ReactiveCdekClient;
import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.request.GrantType;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.handbook.Country;
import com.cdek.java.model.region.request.RegionRequest;
import javax.annotation.PostConstruct;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("all")
public class CdekClientMethodsTest extends AbstractCdekClientTest {

  @Autowired
  private CdekClient cdekClient;

  @Autowired
  private ReactiveCdekClient reactiveCdekClient;

  @PostConstruct
  public void init() {
    ((CdekClientImpl) cdekClient).setBaseUrl("https://api.edu.cdek.ru");
  }


  // Sync client test

  @Test
  public void getRegionListSyncTest() {

    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var size = 3; // Ограничение выборки

    var regionRequest = new RegionRequest();
    var countryCodes = Lists.list(Country.RUSSIA, Country.KAZAKHSTAN);
    regionRequest.setCountryCodes(countryCodes);
    regionRequest.setSize(size);

    var regions = cdekClient.getRegionsList(regionRequest, authResponse);

    Assert.assertEquals(size, regions.size());

    regions.forEach(region -> {
      Assert.assertTrue("RU".equals(region.getCountryCode()) || "KZ".equals(region.getCountryCode()));
    });
  }

  @Test
  public void getCitiesListSyncTest() {

    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var size = 3; // Ограничение выборки

    var cityRequest = new CityRequest();
    var countryCodes = Lists.list(Country.RUSSIA);
    cityRequest.setCountryCodes(countryCodes);
    cityRequest.setSize(size);
    cityRequest.setRegionCode("23");

    var cities = cdekClient.getCitiesList(cityRequest, authResponse);

    Assert.assertEquals(size, cities.size());

    cities.forEach(city -> {
      Assert.assertTrue(city.getRegion().contains("Новосибирская"));
    });
  }

  // Reactive client test

  @Test
  public void getRegionListReactiveTest() {

  }

  @Test
  public void getCitiesListReactiveTest() {

  }

}
