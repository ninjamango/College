package com.example.college.COLLEGE;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="colleges")
public class collegeEntity {

@Id
@GeneratedValue ( strategy = GenerationType.IDENTITY)
private long id;
private String collegeName;
private String country;


}
