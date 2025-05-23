package vn.edu.vlu.khoaluan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KhoaluanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhoaluanApplication.class, args);
	}

}
