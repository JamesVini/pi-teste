package com.senac.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.senac.projeto.entities.Order;
import com.senac.projeto.entities.User;
import com.senac.projeto.entities.enums.OrderStatus;
import com.senac.projeto.repositories.OrderRepository;
import com.senac.projeto.repositories.UserRepository;

@Configuration    /*Sinalizar que é uma classe de especifica de configuração*/
@Profile("test")  /*Sinalizar que é uma Configuração especifica para teste.
				    palavra entre parenteses tem que ser igual a que esta no arquivo application.properties e em spring.profiles.active*/

public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}

/*Essa classe será utilizada para fazer o database seeding, ou seja popular o banco de dados com alguns ojetos.
  Para popular o banco de dados sera necessário acessar o banco de dados, salvar os dados no banco 
  e para salvar os dados usamos a classe repository então teremos nossa primeira injeção de dependencia.
  Essa classe terá que ter uma dependencia do UserRepository, quando um serviço depende do outro ela tem q ser FRACA e desacoplada */
 