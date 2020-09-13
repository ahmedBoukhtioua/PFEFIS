package com.pfe.RCV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@SpringBootApplication
public class RcvApplication {

	public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {

	}
	public static void main(String[] args) {
		SpringApplication.run(RcvApplication.class, args);

	}



}
