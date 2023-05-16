package com.bank.data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
	
	@Getter @NonNull
	private Integer id;

	@Getter @NonNull
	private ZonedDateTime dateTime;

	@Getter @NonNull
	private BigDecimal amount;
	
}