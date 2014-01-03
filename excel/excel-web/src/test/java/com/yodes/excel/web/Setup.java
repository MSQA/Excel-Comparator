package com.yodes.excel.web;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"classpath:services-context.xml", "classpath:mongo-context.xml", "classpath:jms-context.xml",
		"classpath:test-dao-context.xml", "classpath:test-jms-connection-context.xml", "classpath:excel-servlet.xml"
})
public abstract class Setup {

}
