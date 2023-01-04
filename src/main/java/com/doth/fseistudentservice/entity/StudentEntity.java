package com.doth.fseistudentservice.entity;

import com.doth.fseistudentservice.utils.studies_level;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class StudentEntity {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long student_id;

    @Column(name = "student_registration_number")
    private long student_registration_number;

    @Column(name = "student_level")
    private @Enumerated(EnumType.STRING) studies_level student_level; //enum licence1 -> doctorate

    @Column(name = "studies_field")
    private String studies_field;

    @Column(name = "student_firstname")

    private String student_firstname;

    @Column(name = "student_lastname")
    private String student_lastname;

    @Column(name = "student_phone")
    private String student_phone;

    @Column(name = "student_email")
    private String student_email;

    @Column(name = "student_password")
    private String student_password;

    @Column(name = "student_birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date student_birth_date;

}
