// Student Name: Gilberto Del Busto
// Class: CSC-239
// Description: Added phone number, age, and gpa attributes to the Emprec class
// Added two getter methods that print out the name and phone number of the employee
// Added aforementioned attributes to the toString() method.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Emprec {
    String name;
    String address;
    String phoneNumber;
    int age;
    double gpa;


    Emprec (String name, String address, String phoneNumber, int age, double gpa) {

        try {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.age = age;
            this.gpa = gpa;


        } catch (NumberFormatException err) {
            System.out.println("Invalid format" + err);
            this.name = "";

        }
    }
    public String toString() {
        return ("\n your name is: " + name +
                "\n your address is: " + address +
                "\n your phone number is: " + phoneNumber +
                "\n your age is: " + age +
                "\n your gpa is: " + gpa
        );
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ParseEmpSolFilesHWHelp {
    public static void main(String args[]) throws IOException {
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));

        String str_name;
        String str_address;
        String str_phone_number;
        int int_age;
        double double_gpa;

        for (;;) {

            str_name = inData.readLine();

            if (str_name.equalsIgnoreCase("exit")) System.exit(0);

            str_address = inData.readLine();

            str_phone_number = inData.readLine();

            int_age = Integer.parseInt(inData.readLine());

            double_gpa = Double.parseDouble(inData.readLine());


            Emprec employee = new Emprec(str_name, str_address, str_phone_number, int_age, double_gpa);

            System.out.println(employee);

            // To run and print out added class methods
//            System.out.println(employee.getName());
//            System.out.println(employee.getPhoneNumber());
        }
    }
}