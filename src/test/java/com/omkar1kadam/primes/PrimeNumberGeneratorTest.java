package com.omkar1kadam.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class PrimeNumberGeneratorTest {

    @Test
    void computesTheFirstThousandPrimes() {
        List<Integer> primes = PrimeNumberGenerator.first(1000);

        assertEquals(1000, primes.size());
        assertEquals(List.of(2, 3, 5, 7, 11), primes.subList(0, 5));
        assertEquals(7919, primes.get(999));
    }

    @Test
    void supportsZeroAndRejectsNegativeCounts() {
        assertEquals(List.of(), PrimeNumberGenerator.first(0));
        assertThrows(IllegalArgumentException.class, () -> PrimeNumberGenerator.first(-1));
    }
}