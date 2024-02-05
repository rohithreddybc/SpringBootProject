package com.example.SpringBootProject.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	
	
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}




	@GetMapping
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}




	public void setStudents(Student student) {
		
		System.out.print(student);
		
	}
	
//	@GetMapping
//	public List<Student> getStudents() {
//		return List.of(
//					new Student(
//							1234L, //1234Long
//							"Rohith",
//							"rohithreddybcus@gmail.com",
//							LocalDate.of(1998, 3, 18),
//							25
//							
//							) 
//					);
//	}

}
