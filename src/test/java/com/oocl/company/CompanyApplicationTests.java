package com.oocl.company;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {


	@BeforeEach
	public void setup(){
		System.out.println("ddd");
	}

	@Test
	public void contextLoads() {
	}

}
