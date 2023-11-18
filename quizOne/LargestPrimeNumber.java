

class LargestPrimeNumber {
  public static void main(String[] args) {
    int limit = 5000;

    for (int number = limit; number >= 2; number--) {
        if (isPrime(number)) {
            System.out.println("The largest prime number less than 5000 is: " + number);
            break; // Stop the loop once the largest prime is found
        }
    }
}

public static boolean isPrime(int num) {
    if (num <= 1) {
        return false;
    }
    if (num <= 3) {
        return true;
    }
    if (num % 2 == 0 || num % 3 == 0) {
        return false;
    }

    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}
}