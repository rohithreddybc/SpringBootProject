package com.example.SpringBootProject.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
//		super();
		this.studentRepository = studentRepository;
	}

	@GetMapping
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void setStudents(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);

		System.out.print(student + " saved yayy ");

	}

	public void deleteStudent(Long studentId) {
		Boolean idExists = studentRepository.existsById(studentId);
		if (!idExists) {
			throw new IllegalStateException("Student with ID: " + studentId + " does not exists");
		}
		studentRepository.deleteById(studentId);

	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("Student with ID: " + studentId + " does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			
			student.setEmail(email);

		}

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
