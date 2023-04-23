package com.doth.fseistudentservice.dataTransfer;

import com.doth.fseistudentservice.entity.StudentEntity;
import com.doth.fseistudentservice.utils.studies_level;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {

    @JsonProperty("student_id")
    private long student_id;

    @JsonProperty("student_registration_number")
    private long student_registration_number;

    @JsonProperty("student_level")
    private @Enumerated(EnumType.STRING) studies_level student_level;

    @JsonProperty("student_firstname")
    private String student_firstname;

    @JsonProperty("studies_field")
    private String studies_field;

    @JsonProperty("student_lastname")
    private String student_lastname;

    @JsonProperty("student_phone")
    private String student_phone;

    @JsonProperty("student_email")
    private String student_email;

    @JsonProperty("student_password")
    private String student_password;

    @JsonProperty("student_birth_date")
    private Date student_birth_date;

    public static StudentDTO toDTO(StudentEntity entity) {
        return StudentDTO.builder()
                .student_id(entity.getStudent_id())
                .student_registration_number(entity.getStudent_registration_number())
                .student_level(entity.getStudent_level())
                .studies_field(entity.getStudies_field())
                .student_firstname(entity.getStudent_firstname())
                .student_lastname(entity.getStudent_lastname())
                .student_phone(entity.getStudent_phone())
                .student_email(entity.getStudent_email())
                .student_birth_date(entity.getStudent_birth_date())
                .build();
    }

    public static StudentEntity toEntity(StudentDTO dto) {
        return StudentEntity.builder()
                .student_registration_number(dto.getStudent_registration_number())
                .student_level(dto.getStudent_level())
                .studies_field(dto.getStudies_field())
                .student_firstname(dto.getStudent_firstname())
                .student_lastname(dto.getStudent_lastname())
                .student_phone(dto.getStudent_phone())
                .student_email(dto.getStudent_email())
                .student_password(dto.getStudent_password())
                .student_birth_date(dto.getStudent_birth_date())
                .build();
    }
}
