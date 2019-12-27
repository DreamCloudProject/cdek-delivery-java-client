package com.cdek.java;

import com.cdek.java.client.CdekClient;
import com.cdek.java.client.reactive.ReactiveCdekClient;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.handbook.Country;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("all")
public class NoAuthNeedMethodsTest extends AbstractCdekClientTest {

  @Autowired
  private CdekClient cdekClient;

  @Autowired
  private ReactiveCdekClient reactiveCdekClient;


  // Sync client test

  @Test
  public void getRegionListSyncTest() {

  }

  @Test
  public void getCitiesListSyncTest() {

    var cityRequest = new CityRequest();
    var countryCodes = Lists.list(Country.RUSSIA);
    cityRequest.setCountryCodes(countryCodes);
    cityRequest.setSize(3);
    cityRequest.setRegionCode("23");

    var cities = cdekClient.getCitiesList(cityRequest);

    System.out.println(cities);

  }

  // Reactive client test

  @Test
  public void getRegionListReactiveTest() {

  }

  @Test
  public void getCitiesListReactiveTest() {

  }

}
