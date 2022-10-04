package tech.julkrolon.SpringBootAngular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.julkrolon.SpringBootAngular.entities.Users;
import tech.julkrolon.SpringBootAngular.repositories.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			Stream.of("Juan", "Julia", "Helena", "Raquel")
					.forEach(name->{
						Users user = Users.builder()
								.name(name)
								.email(name.toLowerCase()+"@julkrolon.tech")
								.build();
						userRepository.save(user);
					});
					userRepository.findAll().forEach(System.out::println);
		};
	}
}
