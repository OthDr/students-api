package com.derroth.studentservice.services;

import com.derroth.studentservice.entity.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<StudentModel> getAllStudents() {
        return null;
    }

    public List<StudentModel> getByStudentLevel(String studiesLevel) {
        System.out.println("All students");

        return null;
    }

    public StudentModel getStudent(String student_id) {
        System.out.println("student with id" + student_id);

        return null;
    }

    public void createStudent(String student) {

        System.out.println(student);
    }

    public void updateStudent(String student_id,String data) {

        System.out.println("Student updated, ID:" + student_id);
    }

    public void deleteStudent( String student_id, String data) {

        System.out.println("student deleted ID:" + student_id);
    }

}
