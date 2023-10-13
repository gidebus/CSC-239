public class largestDivisibleNumber {
  public static void main(String[] args) {
    int i = 100000;
    while(i > 0) {
      if((i % 7 == 0) && (i % 11 == 0) && (i % 13 == 0) && (i % 17 == 0)) {
        System.out.println(i + " is the largest number divisible by 7, 11, 13, and 17");
        break;
      }
      --i;
    }
  }

}
