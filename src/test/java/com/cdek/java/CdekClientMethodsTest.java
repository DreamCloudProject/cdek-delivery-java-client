package com.cdek.java;

import com.cdek.java.client.CdekClient;
import com.cdek.java.client.CdekClientImpl;
import com.cdek.java.client.reactive.ReactiveCdekClient;
import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.request.GrantType;
import com.cdek.java.model.calculator.request.CalculatorRequest;
import com.cdek.java.model.calculator.response.Calculator;
import com.cdek.java.model.city.request.CityRequest;
import com.cdek.java.model.common.*;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.courier.response.CourierResponse;
import com.cdek.java.model.deliverypoint.request.DeliveryPointRequest;
import com.cdek.java.model.handbook.Country;
import com.cdek.java.model.order.request.Item;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.model.order.request.Package;
import com.cdek.java.model.order.response.OrderResponse;
import com.cdek.java.model.region.request.RegionRequest;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
      Assert.assertEquals("v2_internal_error",res.getErrors().get(0).getCode());
    } else {
      Assert.assertEquals(expected, res.getTotalSum());
    }

  }

  @Test
  public void getTariffListSyncTest() {
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
    calcRequest.setFromLocation(from);
    calcRequest.setToLocation(to);
    calcRequest.setServices(services);
    calcRequest.setPackages(packages);

    var res = cdekClient.getTariffsList(calcRequest, authResponse);//it's working only with production keys

    int expected = 48;
    if(Objects.nonNull(res.getErrors()) && res.getErrors().size() > 0) {
      //Test environment
      Assert.assertEquals("v2_internal_error",res.getErrors().get(0).getCode());
    } else {
      Assert.assertEquals(expected, res.getTariffCodes().size());
    }
  }

  @Test
  public void getDeliveryPointsTest() {
    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var deliveryPointRequest = new DeliveryPointRequest();
    deliveryPointRequest.setWeightMax(50);
    deliveryPointRequest.setCityCode("270");
    deliveryPointRequest.setAllowedCod(true);

    var res = cdekClient.getDeliveryPointsList(deliveryPointRequest,authResponse);

    Assert.assertTrue(res.size() > 0);

  }

  @Test
  public void createOrder() {
    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    var recipientCost = new Money();
    recipientCost.setValue(BigDecimal.valueOf(50));

    var from = new Location();
    from.setCode("44");
    from.setCity("Москва");
    from.setAddress("пр. Ленинградский, д.4");

    var to = new Location();
    to.setCode("270");
    to.setCity("Новосибирск");
    to.setAddress("ул. Блюхера, 32");

    var itemPrice = new Money();
    itemPrice.setValue(BigDecimal.valueOf(3000));

    var item = new Item();
    item.setWareKey("00055");
    item.setPayment(itemPrice);
    item.setName("Товар");
    item.setCost(BigDecimal.valueOf(300));
    item.setAmount(2);
    item.setWeight(700);
    item.setUrl("www.item.ru");

    List<Item> items = new ArrayList<>();
    items.add(item);

    var parcel = new Package();
    parcel.setNumber("bar-001");
    parcel.setComment("Упаковка");
    parcel.setHeight(10);
    parcel.setLength(10);
    parcel.setWeight(4000);
    parcel.setWidth(10);
    parcel.setItems(items);

    List<Package> packages = new ArrayList<>();
    packages.add(parcel);

    List<Phone> phones = new ArrayList<>();
    Phone mobile = new Phone();
    mobile.setNumber("+79134637228");
    phones.add(mobile);

    var recipient = new Contact();
    recipient.setName("Иванов Иван");
    recipient.setPhones(phones);

    var sender = new Contact();
    sender.setName("Петров Петр");

    var service = new ParcelService();
    service.setCode("SECURE_PACKAGE_A2");

    List<ParcelService> services = new ArrayList<>();
    services.add(service);

    var orderTarif = 139;

    var orderRequest = new OrderRequest();
    orderRequest.setNumber("ORD123");
    orderRequest.setComment("Новый заказ");
    orderRequest.setDeliveryRecipientCost(recipientCost);
    orderRequest.setRecipient(recipient);
    orderRequest.setSender(sender);
    orderRequest.setFromLocation(from);
    orderRequest.setToLocation(to);
    orderRequest.setPackages(packages);
    orderRequest.setServices(services);
    orderRequest.setTariffCode(orderTarif);

    OrderResponse res = cdekClient.orderRegistration(orderRequest,authResponse);

    Assert.assertEquals(res.getRequests().size(),1);
    Assert.assertEquals(res.getRequests().get(0).getState(),"ACCEPTED");

  }

  @Test
  public void createCourierRequest() {
    var authRequest = new AuthRequest();
    authRequest.setClientId(clientId);
    authRequest.setClientSecret(clientSecret);
    authRequest.setGrantType(GrantType.CLIENT_CREDENTIALS);

    var authResponse = cdekClient.authenticate(authRequest);

    List<Phone> phones = new ArrayList<>();
    Phone mobile = new Phone();
    mobile.setNumber("+79589441654");
    phones.add(mobile);

    var sender = new Contact();
    sender.setName("Иванов Петр");
    sender.setCompany("Компания");
    sender.setPhones(phones);

    var from = new Location();
    from.setCode("44");
    from.setCity("Москва");
    from.setPostalCode("109004");
    from.setAddress("ул. Блюхера, 32");

    LocalDateTime intakeDateTime = LocalDateTime.now();
    DateTimeFormatter intakeDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String intakeDateString = intakeDateFormatter.format(intakeDateTime);

    LocalDateTime intakeDateTimeFrom = LocalDateTime.now().plus(3,ChronoUnit.HOURS);
    DateTimeFormatter intakeDateFromFormatter = DateTimeFormatter.ofPattern("HH:mm");
    String intakeDateFromString = intakeDateFromFormatter.format(intakeDateTimeFrom);

    LocalDateTime intakeDateTimeTo = LocalDateTime.now().plus(7,ChronoUnit.HOURS);
    DateTimeFormatter intakeDateToFormatter = DateTimeFormatter.ofPattern("HH:mm");
    String intakeDateToString = intakeDateToFormatter.format(intakeDateTimeTo);

    var courierRequest = new CourierRequest();
    courierRequest.setIntakeDate(intakeDateString);
    courierRequest.setIntakeTimeFrom(intakeDateFromString);
    courierRequest.setIntakeTimeTo(intakeDateToString);
    courierRequest.setComment("Важный груз");
    courierRequest.setSender(sender);
    courierRequest.setFromLocation(from);
    courierRequest.setNeedCall(false);
    courierRequest.setName("Консолидированный груз");
    courierRequest.setHeight(10);
    courierRequest.setLength(10);
    courierRequest.setWeight(1000);
    courierRequest.setWidth(10);

    CourierResponse res = cdekClient.createCourierDeliveryRequest(courierRequest,authResponse);

    Assert.assertEquals(res.getRequests().size(),1);
    Assert.assertEquals(res.getRequests().get(0).getState(),"ACCEPTED");

  }


}
