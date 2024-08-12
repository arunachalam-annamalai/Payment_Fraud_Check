package com.payment.util;

import java.util.Arrays;
import java.util.List;

public class ValidationUtil {

    private static final List<String> BLACKLISTED_NAMES = Arrays.asList(
            "Mark Imaginary", "Govind Real", "Shakil Maybe", "Chang Imagine"
    );

    private static final List<String> BLACKLISTED_COUNTRIES = Arrays.asList(
            "CUB", "IRQ", "IRN", "PRK", "SDN", "SYR"
    );

    private static final List<String> BLACKLISTED_BANKS = Arrays.asList(
            "BANK OF KUNLUN", "KARAMAY CITY COMMERCIAL BANK"
    );

    private static final List<String> BLACKLISTED_INSTRUCTIONS = Arrays.asList(
            "Artillery Procurement", "Lethal Chemicals payment"
    );

    public static boolean isBlacklistedName(String name) {
        return BLACKLISTED_NAMES.contains(name);
    }

    public static boolean isBlacklistedCountry(String country) {
        return BLACKLISTED_COUNTRIES.contains(country);
    }

    public static boolean isBlacklistedBank(String bank) {
        return BLACKLISTED_BANKS.contains(bank);
    }

    public static boolean isBlacklistedInstruction(String instruction) {
        return BLACKLISTED_INSTRUCTIONS.contains(instruction);
    }
}
