public class ForLoop {
  public static void main(String[] args) {
    int sum = 0; // Define sum

    for (int i = 1; i <= 100; i++) { // specify break statement
      sum += i; // increment sum by index
    }

    System.out.println("The sum from 1 to 100 is: " + sum); // output result to the screen
  }
}