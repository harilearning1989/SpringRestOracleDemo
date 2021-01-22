package com.example.demo.controls;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.entity.Student;
import com.example.demo.exception.NotFoundException;
import com.example.demo.reposDev.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	return studentRepository.findAll();
    }
    
    @GetMapping("/students/{id}")
    public Student getStudentByID(@PathVariable Long id) {
    	Optional<Student> optStudent = studentRepository.findById(id);
    	if(optStudent.isPresent()) {
    		return optStudent.get();
    	}else {
    		throw new NotFoundException("Student not found with id " + id);
    	}
    }
    
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }
    
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id,
                                   @Valid @RequestBody Student studentUpdated) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentUpdated.getName());
                    student.setAge(studentUpdated.getAge());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }
    
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }
}