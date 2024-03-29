package com.doth.fseistudentservice.service;

import com.doth.fseistudentservice.dataTransfer.StudentDTO;
import com.doth.fseistudentservice.entity.StudentEntity;
import com.doth.fseistudentservice.repository.StudentDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentDataAccess studentDAO;


    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> entities = studentDAO.findAll();
        //                new StudentDTO(
//                        studentEntity.getStudent_id(),
//                        studentEntity.getStudent_registration_number(),
//                        studentEntity.getStudent_level(),
//                        studentEntity.getStudies_field(),
//                        studentEntity.getStudent_firstname(),
//                        studentEntity.getStudent_lastname(),
//                        studentEntity.getStudent_phone(),
//                        studentEntity.getStudent_email(),
//                        studentEntity.getStudent_birth_date()
//                )).toList();
        return entities.stream().map(studentEntity -> StudentDTO.toDTO(studentEntity)).toList();
    }

    public List<StudentDTO> getByStudentLevel(String studiesLevel) {
        System.out.println("All students where level = " + studiesLevel);
        List<StudentEntity> entities = studentDAO.getAllStudentsByStudiesLevel(studiesLevel);

        return entities.stream().map(StudentDTO::toDTO).toList();
    }

    public List<StudentDTO> getByStudentField(String studiesField) {
        System.out.println("All students where field = " + studiesField);
        List<StudentEntity> entities = studentDAO.getAllStudentsByStudiesField(studiesField);
        return entities.stream().map(StudentDTO::toDTO).toList();
    }

    public StudentDTO getStudent(String student_id) {
        System.out.println("student with id" + student_id);

        Optional<StudentEntity> studentEntity = studentDAO.findById(Long.parseLong(student_id));
        if (studentEntity.isPresent()) {
            return StudentDTO.toDTO(studentEntity.get());
        } else {
            return null;
        }
    }

    public boolean createStudent(StudentDTO student) {
        System.out.println("creating student : " + student.toString());

        if (studentDAO.findStudentEntityByStudent_registration_number(student.getStudent_registration_number()) == null) {
            studentDAO.save(StudentDTO.toEntity(student));
            return true;
        } else {
            return false;
        }
    }

    public boolean checkStudent(String email, String password) {
        return studentDAO.findStudentEntityByStudent_emailAndAndStudent_password(email, password) != null;
    }

    public void updateStudent(StudentDTO studentDTO) {

        studentDAO.save(StudentDTO.toEntity(studentDTO));
        System.out.println("Student updated");
    }

    public boolean deleteStudent(StudentDTO student) {
        if (studentDAO.findStudentEntityByStudent_registration_number(student.getStudent_registration_number()) != null) {
            studentDAO.deleteById(student.getStudent_id());
            System.out.println("student deleted ID:" + student.getStudent_id());
            return true;
        } else {
            return false;
        }
    }

    public void updateStudentLevel(String level) {

    }
}
