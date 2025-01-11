package com.jsp.hibernate_one_to_one_unidirection.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adhar {

	@Id
	@Column(name = "adharno",length = 12,updatable = false)
	private long adharNumber;
	@Column(name = "fathername",length = 30)
	private String fatherName;
	private String address;
	private LocalDate dob;
}
