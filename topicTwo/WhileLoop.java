public class WhileLoop {
  public static void main(String[] args) { // Define main function
    int sum = 0; // Define sum variable
    int counter = 1; // Define counter variable
    while(counter <= 100) { // Iterate until counter reaches 100
      sum += counter; // increment sum by counter
      counter++; // increment counter
    }
    System.out.println("The sum from 1 to 100 is: " + sum); // output result
  }
}
