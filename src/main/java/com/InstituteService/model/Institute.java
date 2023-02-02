package com.InstituteService.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "institute")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institute_id")
    private Integer instituteId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "institute_address")
    private String instituteAddress;

    @Column(name = "institute_contact")
    private String instituteContact;

}
