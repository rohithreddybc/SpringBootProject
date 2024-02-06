package com.example.SpringBootProject.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "api/version1/student")
public class StudentController {
	
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

//	StudentService studentService = new StudentService();

	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.setStudents(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudentByID(@PathVariable Long studentId) {
//		id = (long) 16;
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
		
		studentService.updateStudent(studentId, name, email);
		
	}

//	@GetMapping()
//	public String hello() {
//		return "hello, This app is working. Enter URL to move to other page";
//	}

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
