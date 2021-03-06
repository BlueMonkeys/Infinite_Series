package series.calculators.pifast;

import java.util.Scanner;

public class PiCalculator_PiFast {

    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "This is the fastest algorithm to calculate PI I found on the internet."
                        + "\nIt is one of the many infinite series used to calculate pi."
                        + "\nThis series follows the sequence who's terms are too long to list here."
                        + "\nChoose how many terms you want in this series. (But don't go too high because Java can't handle it)"
                        + "\nThis series is far superior than every other algorithm in this repo!");

        long iterations;
        while (true) {
            try {
                iterations = sc.nextLong();
                break;
            } catch (Exception fail) {
                System.out.println("You entered something stupid. Try again.");
                sc.nextLine();
            }
        }
        sc.close();

        double result = piCalc(iterations);
        System.out.println(
                "The value of pi is calculated to be " + result + " using " + iterations + " terms of the series."
                        + "\nFor comparison, this is the value of pi typically used in Java: " + Math.PI + "."
                        + "\nThis value is " + Math.abs(result - Math.PI) + " off from Java's PI");
    }

    public static double piCalc(long iterations) {
        FactorialPoorMans f = new FactorialPoorMans();
        double sum = 0;

        for (int i = 0; i < iterations; i++) {
            final double nFactorial = f.factorial(i);

            // saving time on repeat calculations
            final int n3 = i * 3;
            
            // because this is faster than Math.pow(n, 3)
            final double nFactorialCubed = nFactorial * nFactorial * nFactorial;

            sum += (
                (f.factorial(6 * i) * (545140134 * i + 13591409)) /
                (nFactorialCubed * f.factorial(n3) * Math.pow(-640320, n3))
            );
        }

        return (426880 * Math.sqrt(10005)) / sum;
    }
}
