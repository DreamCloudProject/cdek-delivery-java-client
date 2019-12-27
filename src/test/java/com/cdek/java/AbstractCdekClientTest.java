package com.cdek.java;

import com.cdek.java.config.CdekClientConfiguration;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Import(CdekClientConfiguration.class)
public abstract class AbstractCdekClientTest {

}
