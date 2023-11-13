package com.mochimochi.backcrudmarketing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mochimochi.backcrudmarketing.model.Evento;
import com.mochimochi.backcrudmarketing.model.User;
import com.mochimochi.backcrudmarketing.repository.EventoRepository;
import com.mochimochi.backcrudmarketing.repository.UserRepository;

@SpringBootApplication
public class BackCrudMarketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackCrudMarketingApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(EventoRepository eventoRepository){
		return args -> {
			eventoRepository.deleteAll();
			
			Evento c = new Evento();
			c.setNome("Calourada Uniceplac");
			c.setDescricao("Evento destinado a jovens iniciando na universidade");
			c.setImg("dada");
			//c.setLike(true);
			c.setUrlEvento("aadsdadadasdsad");

			

			eventoRepository.save(c);
		};

	}

}
