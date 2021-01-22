package com.example.demo.controls;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entity.Assignment;
import com.example.demo.exception.NotFoundException;
import com.example.demo.reposDev.AssignmentRepository;
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
public class AssignmentController {
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
    @GetMapping("/students/{studentId}/assignments")
    public List<Assignment> getContactByStudentId(@PathVariable Long studentId) {
    	
        if(!studentRepository.existsById(studentId)) {
            throw new NotFoundException("Student not found!");
        }
    	
    	return assignmentRepository.findByStudentId(studentId);
    }
    
    @PostMapping("/students/{studentId}/assignments")
    public Assignment addAssignment(@PathVariable Long studentId,
                            @Valid @RequestBody Assignment assignment) {
        return studentRepository.findById(studentId)
                .map(student -> {
                    assignment.setStudent(student);
                    return assignmentRepository.save(assignment);
                }).orElseThrow(() -> new NotFoundException("Student not found!"));
    }
    
    @PutMapping("/students/{studentId}/assignments/{assignmentId}")
    public Assignment updateAssignment(@PathVariable Long studentId,
    								@PathVariable Long assignmentId,
    								@Valid @RequestBody Assignment assignmentUpdated) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return assignmentRepository.findById(assignmentId)
                .map(assignment -> {
                    assignment.setName(assignmentUpdated.getName());
                    assignment.setGrade(assignmentUpdated.getGrade());
                    return assignmentRepository.save(assignment);
                }).orElseThrow(() -> new NotFoundException("Assignment not found!"));
    }
    
    @DeleteMapping("/students/{studentId}/assignments/{assignmentId}")
    public String deleteAssignment(@PathVariable Long studentId,
    							   @PathVariable Long assignmentId) {
    	
    	if(!studentRepository.existsById(studentId)) {
    		throw new NotFoundException("Student not found!");
    	}
    	
        return assignmentRepository.findById(assignmentId)
                .map(assignment -> {
                    assignmentRepository.delete(assignment);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
