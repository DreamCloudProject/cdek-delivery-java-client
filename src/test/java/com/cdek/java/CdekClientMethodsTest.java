package com.cdek.java;

import com.cdek.java.client.CdekClient;
import com.cdek.java.client.CdekClientImpl;
import com.cdek.java.client.reactive.ReactiveCdekClient;
import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.request.GrantType;
import com.cdek.java.model.calculator.request.CalculatorRequest;
import com.cdek.java.model.calculator.response.Calculator;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.common.Location;
import com.cdek.java.model.common.ParcelService;
import com.cdek.java.model.handbook.Country;
import com.cdek.java.model.order.request.Package;
import com.cdek.java.model.region.request.RegionRequest;
import javax.annotation.PostConstruct;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.*;

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

  @Test
  public void calculateDelivery() {
    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var from = new Location();
    from.setCode("270");

    var to = new Location();
    to.setCode("44");

    var parcel = new Package();
    parcel.setHeight(10);
    parcel.setLength(10);
    parcel.setWeight(4000);
    parcel.setWidth(10);

    List<Package> packages = new ArrayList<>();
    packages.add(parcel);

    var service = new ParcelService();
    service.setCode("INSURANCE");
    service.setParameter("100");

    List<ParcelService> services = new ArrayList<>();
    services.add(service);

    var calcRequest = new CalculatorRequest();
    calcRequest.setDate(Date.from(Instant.now()));
    calcRequest.setTariffCode(139);
    calcRequest.setFromLocation(from);
    calcRequest.setToLocation(to);
    calcRequest.setServices(services);
    calcRequest.setPackages(packages);

    Calculator res = cdekClient.calculateDelivery(calcRequest,authResponse);
    Float expected = 1100.75F;//it's working only with production keys
    if(Objects.nonNull(res.getErrors()) && res.getErrors().size() > 0) {
      //Test environment
      Assert.assertEquals("ve_contract_with_id_not_exists",res.getErrors().get(0).getCode());
    } else {
      Assert.assertEquals(expected, res.getTotalSum());
    }

  }

  @Test
  public void getTariffListSyncTest() {
    ((CdekClientImpl) cdekClient).setBaseUrl("https://api.cdek.ru");
    var authRequest = new AuthRequest();
    authRequest.setClientId("478Ju6OXLJUoJzLnfmHsQ3oIZj5yh5Oe");
    authRequest.setClientSecret("iJ7H5RHuPKG06zGFhvBOkYepobHwz0IW");
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var from = new Location();
    from.setCode("270");

    var to = new Location();
    to.setCode("44");

    var parcel = new Package();
    parcel.setHeight(10);
    parcel.setLength(10);
    parcel.setWeight(4000);
    parcel.setWidth(10);

    List<Package> packages = new ArrayList<>();
    packages.add(parcel);

    var service = new ParcelService();
    service.setCode("INSURANCE");
    service.setParameter("100");

    List<ParcelService> services = new ArrayList<>();
    services.add(service);

    var calcRequest = new CalculatorRequest();
    calcRequest.setDate(Date.from(Instant.now()));
    calcRequest.setFromLocation(from);
    calcRequest.setToLocation(to);
    calcRequest.setServices(services);
    calcRequest.setPackages(packages);

    var res = cdekClient.getTariffsList(calcRequest, authResponse);//it's working only with production keys

    int expected = 48;
    if(Objects.nonNull(res.getErrors()) && res.getErrors().size() > 0) {
      //Test environment
      Assert.assertEquals("ve_contract_with_id_not_exists",res.getErrors().get(0).getCode());
    } else {
      Assert.assertEquals(expected, res.getTariffCodes().size());
    }
  }

  // Reactive client test

  @Test
  public void getRegionListReactiveTest() {

  }

  @Test
  public void getCitiesListReactiveTest() {

  }

}
