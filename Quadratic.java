// this is a quadratic equation calculator which produces the roots of the equation in exact and decimal form
// I made this during CSE 142, Introductory Programming.  It is quite out of date.

import java.util.*;

public class Quadratic {
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      boolean again = true;
      double[] nums = new double[4];
      writePrompt();
      while (again) {
         getNums(console, nums);
         String exp = getExpression(nums);
         System.out.println("Exact answer = " + exp);
         if (nums[2] > 0) {
            double ans1 = compute(exp, "+", nums);
            double ans2 = compute(exp, "-", nums);
            System.out.println("Decimal answers = " + ans1 + ", " + ans2);
         } else {
            System.out.println("Imaginary Decimal Answers! (Negative under square root)");
         }
         again = test(console);
      }
   }
   
   public static void writePrompt() {
      System.out.println("This is a simple quadratic equation calculator. Please input");
      System.out.println("the constants a, b, and c assuming the standard quadratic");
      System.out.println("form 'ax^2 + bx + c'. Exact and decimal answers will be");
      System.out.println("computed and displayed for your convenience.");
      System.out.println("Note: Expression not simplified if negative under square root.");
      System.out.println();
   }
   
   public static void getNums(Scanner console, double[] nums) {
      System.out.println("Enter constants:");
      System.out.print("a? ");
      double a = console.nextDouble();
      System.out.print("b? ");
      double b = console.nextDouble();
      System.out.print("c? ");
      double c = console.nextDouble();
      nums[0] = -b; 
      nums[2] = simplify(Math.pow(b, 2) - (4* a* c)); 
      nums[1] = Math.sqrt((Math.pow(b, 2) - (4* a* c)) / nums[2]);
      nums[3] = (2 * a);
      System.out.println();
   }
   
   public static String getExpression(double[] nums) {
      if (nums[1] == 1.0) {
         return ("(" + nums[0] + " +/ \u221a(" + nums[2] + ")) / " + nums[3]);
      } else if (nums[2] == 1.0) {
         return ("(" + nums[0] + " +/ " + nums[1] + ") / " + nums[3]);
      } else {
         return ("(" + nums[0] + " +/ " + nums[1] + "\u221a(" + nums[2] + ")) / " + nums[3]);
      }
   }
   
   public static double compute(String exp, String sign, double[] nums) {
      Scanner line = new Scanner(exp);
      if (sign.equals("+")) {
         return (nums[0] + nums[1] * Math.sqrt(nums[2])) / nums[3];
      } else {
         return (nums[0] - nums[1] * Math.sqrt(nums[2])) / nums[3];
      }
   }
   
   public static boolean test(Scanner console) {
      System.out.println();
      System.out.print("Another equation? (y for yes, n for no) ");
      String input = console.next().toLowerCase();
      System.out.println();
      if (input.startsWith("y")) {
         return true;
      } else if (!input.startsWith("n")) {
         System.out.println("Unable to process request. Please enter a word starting with either 'y' or 'n'.");
         return test(console);
      }
      return false;
   }
   
   public static double simplify(double n) {
      double undersq = n;
      for (int i = 2; (i * i) <= n; i++) {
         if (n / (i * i) == (int) n / (i * i)) {
            undersq = n / (i * i);
         }
      }
      return undersq;
   }
}   

