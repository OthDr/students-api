package com.doth.fseistudentservice.dataTransfer;

import com.doth.fseistudentservice.entity.StudentEntity;
import com.doth.fseistudentservice.utils.studies_level;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {

    private long student_id;
    private @Enumerated(EnumType.STRING) studies_level student_level;
    private String student_firstname;
    private String student_lastname;
    private String student_phone;
    private String student_email;
    private Date student_birth_date;

    public StudentDTO toDTO(StudentEntity entity){
        return StudentDTO.builder()
                .student_id(entity.getStudent_id())
                .student_level(entity.getStudent_level())
                .student_firstname(entity.getStudent_firstname())
                .student_lastname(entity.getStudent_lastname())
                .student_email(entity.getStudent_email())
                .student_birth_date(entity.getStudent_birth_date())
                .build();
    }
}
