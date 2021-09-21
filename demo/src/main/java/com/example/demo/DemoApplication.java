package com.example.demo;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/ok")
	public String ok() {
		Random random = new Random();
		Integer jsonAge = random.nextInt(70) + 10;
		Integer jsonSalary = random.nextInt(10000) + 5000;
		Integer jsonId = random.nextInt(10000000);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "foo");
		jsonObject.put("age", jsonAge);
		jsonObject.put("salary", jsonSalary);
		jsonObject.put("id", jsonId);
		Integer age = (Integer) jsonObject.get("age");
		Integer salary = (Integer) jsonObject.get("salary");
		JSONObject jsonAnswer = new JSONObject();
		jsonAnswer.put("id", jsonObject.get("id"));
		if (age>20 && age<50 && salary>10000) {
			jsonAnswer.put("solve", "yes");
		} else {
			jsonAnswer.put("solve", "no");
		}
		return String.valueOf(jsonAnswer);
	}
}