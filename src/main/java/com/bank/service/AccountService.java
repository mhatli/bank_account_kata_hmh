package com.bank.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.data.Account;
import com.bank.data.Operation;

public class AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

	// replacement for id generated
	private final static AtomicInteger idGenerationStrategy = new AtomicInteger(100);

	/**
	 * 
	 * @return true if operation success
	 */
	public boolean depositOrWithdrawal(Account account, BigDecimal amount/* , Additional audit details parms ... */) {
		String methodName = "depositOrWithdrawal() -";

		boolean withdrawal = amount.signum() < 0;
		boolean deposit = amount.signum() > 0;

		LOGGER.debug("{} Account operation of type withdrawal={} or deposit={} on accountId={} with amountOf={} ",
				methodName, withdrawal, deposit, (account != null ? account.getId() : null), amount);

		if (withdrawal) {
			// handle insufficient balance, withdrawal limit with additional fee coasts ....
		}

		if (deposit || withdrawal) {
			account.setBalance(account.getBalance().add(amount));

			account.getOperations()
					.add(new Operation(idGenerationStrategy.getAndIncrement(), ZonedDateTime.now(), amount));

			LOGGER.debug("{} Account operation success on  accountId={}", methodName,
					(account != null ? account.getId() : null));
			
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @return unmodifiableList of account operation
	 */
	public List<Operation> getOperations(Account account) {
		return Collections.unmodifiableList(account.getOperations()); // based on usage it will better using deep clone
	}
}
