package com.derroth.studentservice.entity;

import com.derroth.studentservice.utils.studies_level;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class StudentModel {

    private long student_id;
    private @Enumerated(EnumType.STRING) studies_level student_level; //enum licence1 -> doctorate
    private String student_firstname;
    private String student_lastname;
    private String student_phone;
    private String email;
    private Date student_birth_date;

}
