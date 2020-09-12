package com.pfe.RCV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@CrossOrigin(origins = "*", maxAge = 3600)
@SpringBootApplication
public class RcvApplication {

	public static void main(String[] args) {
		String path = "C:\Users\Admin\Desktop\pythoncodetest/script.py";
		ProcessBuilder pb = new ProcessBuilder("python","C:\Users\Admin\Desktop\pythoncodetest/script.py").inheritIO();
		Process p = pb.start();
		p.waitFor();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while ((line = bfr.readLine()) != null) {
			System.out.println(line);
		}

		SpringApplication.run(RcvApplication.class, args);
	}

}
