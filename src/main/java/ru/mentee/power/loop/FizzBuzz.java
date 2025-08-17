package ru.mentee.power.loop;

public class FizzBuzz {
    public String[] generateFizzBuzz(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = String.valueOf(i);
            }
        }
        return result;
    }

    public void printFizzBuzz(int n) {
        String[] results = generateFizzBuzz(n);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println("FizzBuzz для чисел от 1 до 30:");
        fizzBuzz.printFizzBuzz(30);
    }
}