package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

public class DomainTest {
	
	
	void DomainNameTest() {
		assertEquals("Information about customers",Domain.CUSTOMER.getDescription());
	}
}
