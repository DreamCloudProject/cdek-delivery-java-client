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

  @Value("${client.id:z9GRRu7FxmO53CQ9cFfI6qiy32wpfTkd}")
  protected String clientId;
  @Value("${client.secret:w24JTCv4MnAcuRTx0oHjHLDtyt3I6IBq}")
  protected String clientSecret;

}
