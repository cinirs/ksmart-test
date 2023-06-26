package com.citizenportal.citizen.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "citizen")
public class CitizenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull(message = "name cannot be null.")
    private String name;

    @NotNull(message = "address cannot be null.")
    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dateofbirth")
    @Past(message = "Date input is invalid for a birth date.")
    private LocalDate dateOfBirth;

}
