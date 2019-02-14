package infinity;

import java.util.Scanner;

public class PiCalculator_GregoryLeibniz {

	static Scanner sc = new Scanner(System.in);
	static int wantedTerms, i;
	static double denom, sum, piApprox;

	public static void main(String[] args) {

		System.out.println(
				"This infinite series is called the Gregory-Leibniz series. It is one of the many infinite series used to calculate pi."
						+ "\nThis series follows the sequence π = 4(1 - 1/3 + 1/5 - 1/7...)"
						+ "\nThis program calculates within the parentheses first, and then multiplies by four to get pi."
						+ "\nBy default, this series has one term: -1/3. The 1 is not counted as a term."
						+ "\nChoose how many terms you want in this series. Unfortunately, this series converges slowly. "
						+ "\nIt takes 300 terms to calculate pi to two decimal places, so pick a large number!");
		wantedTerms = sc.nextInt();
		sc.close();
		piCalc(wantedTerms);
	}

	public static void piCalc(int wantedTerms) {
		sum = 1;
		denom = 3;
		for (i = 1; i <= wantedTerms; i++) {
			if (i % 2 != 0) {
				sum = piCalcSubTerm(sum, denom);
			} else if (i % 2 == 0) {
				sum = piCalcAddTerm(sum, denom);
			} else {
				System.out.print("Something wierd happened.");
				main(new String[0]); // This actually isn't necessary, but it'll annoy Leone, so I'll let it stay
			}
			denom += 2;
		}
		piApprox = sum * 4;
		System.out.println(
				"The value of pi is calculated to be " + piApprox + " using " + wantedTerms + " terms of the series."
						+ "\nFor comparison, this is the value of pi typically used in Java: " + Math.PI + ".");
	}

	public static double piCalcSubTerm(double sum, double denom) {
		return sum = sum - (1 / denom);
	}

	public static double piCalcAddTerm(double sum, double denom) {
		return sum = sum + (1 / denom);
	}
}