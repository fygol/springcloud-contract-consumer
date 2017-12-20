package io.sample.spring.cloud.contract.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
		ids = {"io.sample:springcloud-contract-producer:+:stubs:8085"},
		workOffline = true
)
public class ConsumerApplicationTests {
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetUserById() {
		String response = restTemplate.getForObject("http://localhost:8085/user", String.class);
		System.out.println("response:" + response);
	}
}
