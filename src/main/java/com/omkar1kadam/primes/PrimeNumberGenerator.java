package com.omkar1kadam.primes;

import java.util.ArrayList;
import java.util.List;

public final class PrimeNumberGenerator {

    private PrimeNumberGenerator() {
    }

    public static List<Integer> first(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must not be negative");
        }

        List<Integer> primes = new ArrayList<>(count);
        int candidate = 2;
        while (primes.size() < count) {
            if (isPrime(candidate, primes)) {
                primes.add(candidate);
            }
            candidate++;
        }
        return List.copyOf(primes);
    }

    private static boolean isPrime(int candidate, List<Integer> knownPrimes) {
        for (int prime : knownPrimes) {
            if ((long) prime * prime > candidate) {
                break;
            }
            if (candidate % prime == 0) {
                return false;
            }
        }
        return true;
    }
}