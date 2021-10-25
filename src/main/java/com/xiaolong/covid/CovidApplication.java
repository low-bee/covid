package com.xiaolong.covid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
public class CovidApplication {

	@ApiOperation("name")
	@PostMapping("/param")
	public String hello2(@ApiParam(name = "name") @RequestParam String name){
		return "hello " + name;
	}

	public static void main(String[] args) {

		SpringApplication.run(CovidApplication.class, args);
	}

}
