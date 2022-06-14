package br.com.msofertaemprestimo;

import br.com.msofertaemprestimo.integration.core.OfertaCoreIntegration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackageClasses = {OfertaCoreIntegration.class, MsOfertaEmprestimoApplication.class})
@SpringBootApplication
public class MsOfertaEmprestimoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOfertaEmprestimoApplication.class, args);
	}

}
