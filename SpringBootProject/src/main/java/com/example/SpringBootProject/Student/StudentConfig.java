package com.example.SpringBootProject.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student Rohith = new Student(
					1234L, //1234Long
					"Rohith",
					"rohithreddybcus@gmail.com",
					LocalDate.of(1998, 3, 18),
					25
					);
			
			Student Reddy = new Student(
					12342L, //1234Long
					"Reddy",
					"rohithreddybc@gmail.com",
					LocalDate.of(1990, 3, 18),
					25
					);
		
		
		studentRepository.saveAll(
				List.of( Rohith, Reddy)
				);
		};
		
		
	}

}
