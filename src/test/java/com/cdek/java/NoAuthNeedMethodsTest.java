package com.cdek.java;

import com.cdek.java.client.CdekClient;
import com.cdek.java.client.reactive.ReactiveCdekClient;
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

  }

  // Reactive client test

  @Test
  public void getRegionListReactiveTest() {

  }

  @Test
  public void getCitiesListReactiveTest() {

  }

}
