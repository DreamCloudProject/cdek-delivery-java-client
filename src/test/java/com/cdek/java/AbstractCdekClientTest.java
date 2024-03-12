package com.cdek.java;

import com.cdek.java.config.CdekClientConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@Import(CdekClientConfiguration.class)
public abstract class AbstractCdekClientTest {

  @Value("${client.id:EMscd6r9JnFiQ3bLoyjJY6eM78JrJceI}")
  protected String clientId;
  @Value("${client.secret:PjLZkKBHEiLK3YsjtNrt3TGNG0ahs3kG}")
  protected String clientSecret;

}
