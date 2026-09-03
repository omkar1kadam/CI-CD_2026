package com.omkar1kadam.primes;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        PrimeNumberGenerator.first(1000).forEach(System.out::println);
    }
}