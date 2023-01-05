package com.doth.fseistudentservice.controller;

import com.doth.fseistudentservice.dataTransfer.Credentials;
import com.doth.fseistudentservice.dataTransfer.StudentDTO;
import com.doth.fseistudentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin(allowedHeaders = "*", origins = "*")


public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all-students")
    public List<StudentDTO> getAllStudents() {
        System.out.println("All students");
        return studentService.getAllStudents();
    }

    @GetMapping("/all-students/level/{studiesLevel}")
    public List<StudentDTO> getByStudentLevel(@PathVariable String studiesLevel) {
        System.out.println("All students of :" + studiesLevel);
        return studentService.getByStudentLevel(studiesLevel);
    }

    @GetMapping("/all-students/field/{studiesField}")
    public List<StudentDTO> getByStudentField(@PathVariable String studiesField) {
        System.out.println("All students of :" + studiesField);

        return studentService.getByStudentField(studiesField);
    }

    @GetMapping("/student-infos/{student_id}")
    public StudentDTO getStudent(@PathVariable String student_id) {
        System.out.println("student with id" + student_id);
        return studentService.getStudent(student_id);
    }

    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO student) {
        System.out.println(student);
        if (studentService.createStudent(student)) {
            return ResponseEntity.ok().body("Student successfully created");
        } else {
            return ResponseEntity.badRequest().body("Error: student number already exists" + "student :" + student.getStudent_firstname() + " " + student.getStudent_lastname());
        }
    }

    @PostMapping("/profile")
    public ResponseEntity<?> signStudent(@RequestBody Credentials credentials) {
        System.out.println(credentials);
        if (studentService.checkStudent(credentials.getEmail(), credentials.getPassword())) {
            return ResponseEntity.ok().body("student signed in");
        } else {
            return ResponseEntity.badRequest().body("Error: wrong student information");
        }
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody StudentDTO student) {
        studentService.updateStudent(student);
        System.out.println("** PUT **");
    }

    @DeleteMapping("/delete-student/{student_id}")
    public ResponseEntity<?> deleteStudent(@RequestBody StudentDTO student) {
        try {
            if (studentService.deleteStudent(student)) {
                return ResponseEntity.ok().body("Deleted:" + student);
            } else {
                return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
