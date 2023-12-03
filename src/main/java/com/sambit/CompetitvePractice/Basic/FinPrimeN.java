package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 30-Nov-2023 : 2:56 PM
 */

public class FinPrimeN {
    static void primeN(int N) {
        int x, y, flg;

        System.out.println(
                "All the Prime numbers within 1 and " + N
                        + " are:");

        for (x = 1; x <= N; x++) {

            if (x == 1 || x == 0)
                continue;

            flg = 1;

            for (y = 2; y <= x / 2; ++y) {
                if (x % y == 0) {
                    flg = 0;
                    break;
                }
            }

            if (flg == 1)
                System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int N = 45;
        primeN(N);
    }
}
