package com.doth.fseistudentservice.services;

import com.doth.fseistudentservice.dataTransfer.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<StudentDTO> getAllStudents() {
        return null;
    }

    public List<StudentDTO> getByStudentLevel(String studiesLevel) {
        System.out.println("All students");

        return null;
    }

    public StudentDTO getStudent(String student_id) {
        System.out.println("student with id" + student_id);

        return null;
    }

    public void createStudent(StudentDTO student) {

        System.out.println(student.toString());
    }

    public void updateStudent(String student_id,String data) {

        System.out.println("Student updated, ID:" + student_id);
    }

    public void deleteStudent( String student_id, String data) {

        System.out.println("student deleted ID:" + student_id);
    }

}
