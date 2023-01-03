package com.doth.fseistudentservice.controllers;

import com.doth.fseistudentservice.dataTransfer.StudentDTO;
import com.doth.fseistudentservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
        // make use of StudentService.getAll
        return null;
    }

    @GetMapping("/all-students/level={studiesLevel}")
    public List<StudentDTO> getByStudentLevel(@PathVariable String studiesLevel) {
        // make use of StudentService.getByStudentLevel
        System.out.println("All students");

        return null;
    }

    @GetMapping("/student-infos/{student_id}")
    public StudentDTO getStudent(@PathVariable String student_id) {
        // make use of StudentService.getStudent
        System.out.println("student with id" + student_id);

        return null;
    }


    @PostMapping("/create-student")
    public void createStudent(@RequestBody String student) {

        System.out.println(student);
    }

    @PutMapping("/update-student/{student_id}")
    public void updateStudent(@PathVariable String student_id, @RequestBody String data){

        System.out.println("Student updated, ID:" + student_id);
    }

    @DeleteMapping("/delete-student/{student_id}")
    public void deleteStudent(@PathVariable String student_id, @RequestBody String data){

        System.out.println("student deleted ID:" + student_id);
    }



}
