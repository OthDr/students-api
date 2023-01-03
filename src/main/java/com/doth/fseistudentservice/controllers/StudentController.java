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
    public void createStudent(@RequestBody StudentDTO student) {
        System.out.println(student);
        studentService.createStudent(student);

    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody StudentDTO student) {
        studentService.updateStudent(student);
        System.out.println("** PUT **");
    }

    @DeleteMapping("/delete-student/{student_id}")
    public void deleteStudent(@PathVariable String student_id, @RequestBody String data) {

        System.out.println("student deleted ID:" + student_id);
    }


}
