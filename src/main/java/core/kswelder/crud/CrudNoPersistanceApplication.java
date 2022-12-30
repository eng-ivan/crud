package core.kswelder.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CrudNoPersistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudNoPersistanceApplication.class, args);
		System.out.println("System App de pé [Tomcat Ativo]");
	}

}
