package com.hcl.bank.ing.CustomerAccount;

import java.util.Random;

public class GeneratorUtils {

	public String generateCustomerId() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 7;
		Random random = new Random();

		String generatedCustomerId = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedCustomerId;

	}
}
