package com.cdek.java;

import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.handbook.Country;
import com.cdek.java.model.region.request.RegionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("all")
public class SerializationTest extends AbstractCdekClientTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void orderRequestSerializationTest() {

  }

  @Test
  public void courierRequestSerializationTest() {

  }

  @Test
  public void invoiceRequestSerializationTest() {

  }

  @Test
  public void regionRequestSerializationTest() throws JsonProcessingException {
    var regionRequest = new RegionRequest();
    var countryCodes = Lists.list(Country.RUSSIA, Country.KAZAKHSTAN);
    regionRequest.setCountryCodes(countryCodes);
    regionRequest.setSize(3);

    var actualJson = objectMapper.writeValueAsString(regionRequest);

    var expectedJson = "{\"country_codes\":[\"ru\",\"kz\"],\"size\":3}";

    Assert.assertEquals(expectedJson.trim(), actualJson);
  }

  @Test
  public void cityRequestSerializationTest() throws JsonProcessingException {
    var cityRequest = new CityRequest();
    var countryCodes = Lists.list(Country.RUSSIA);
    cityRequest.setCountryCodes(countryCodes);
    cityRequest.setRegionCode("23");
    cityRequest.setSize(3);

    var actualJson = objectMapper.writeValueAsString(cityRequest);

    var expectedJson = "{\"country_codes\":[\"ru\"],\"region_code\":\"23\",\"size\":3}";
    Assert.assertEquals(expectedJson.trim(), actualJson);
  }
}
