package com.bank.data;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public abstract class User {
	@NonNull
	private Integer id;

	private String firstName;

	private String LastName;

	private LocalDate birthDate;
}
