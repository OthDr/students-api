package com.doth.fseistudentservice.repository;

import com.doth.fseistudentservice.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDataAccess extends JpaRepository<StudentEntity, Long> {
    @Query(value = "SELECT * FROM students WHERE `student_level`= :student_level", nativeQuery = true)
    List<StudentEntity> getAllStudentsByStudiesLevel(@Param("student_level") String student_level);

    @Query(value = "SELECT * FROM students WHERE `studies_field`= :studies_field", nativeQuery = true)
    List<StudentEntity> getAllStudentsByStudiesField(@Param("studies_field") String studies_field);
}
