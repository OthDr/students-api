package com.derroth.studentservice.controllers;

import com.derroth.studentservice.entity.StudentModel;
import com.derroth.studentservice.services.StudentService;
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
    public List<StudentModel> getAllStudents() {
        // make use of StudentService.getAll
        return null;
    }

    @GetMapping("/all-students/level={studiesLevel}")
    public List<StudentModel> getByStudentLevel(@PathVariable String studiesLevel) {
        // make use of StudentService.getByStudentLevel
        System.out.println("All students");

        return null;
    }

    @GetMapping("/student-infos/{student_id}")
    public StudentModel getStudent(@PathVariable String student_id) {
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
