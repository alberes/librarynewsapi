package io.github.alberes.librarynewsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibrarynewsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarynewsapiApplication.class, args);
	}

}
