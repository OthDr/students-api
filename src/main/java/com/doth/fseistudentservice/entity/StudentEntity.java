package com.doth.fseistudentservice.entity;

import com.doth.fseistudentservice.utils.studies_level;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Column(name = "student_level")
    private @Enumerated(EnumType.STRING) studies_level student_level; //enum licence1 -> doctorate

    @Column(name = "student_firstname")
    private String student_firstname;

    @Column(name = "student_lastname")
    private String student_lastname;

    @Column(name = "student_phone")
    private String student_phone;

    @Column(name = "student_email")
    private String student_email;

    @Column(name = "student_birth_date")
    private Date student_birth_date;

}
