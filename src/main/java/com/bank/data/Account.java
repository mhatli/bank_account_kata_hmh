package com.bank.data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Account {

	@NonNull
	private Integer id;

	@NonNull
	private BigDecimal balance;

	@NonNull
	private Client owner;

	private List<Operation> operations = new LinkedList<>();

}