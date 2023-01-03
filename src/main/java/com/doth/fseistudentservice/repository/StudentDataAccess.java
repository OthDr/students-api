package com.doth.fseistudentservice.repository;

import com.doth.fseistudentservice.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataAccess extends JpaRepository<StudentEntity, Long> {
}
