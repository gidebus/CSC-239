//HomeWork
// Here is what you need to do with the program below!
// Add 3 more fields
// Add 2 methods that return something. These methods cannot be void
// Add all fields to the toString() method in the class
// ******IT WILL HELP TO LOOK AT  Assignment21A.java

// Extra credit:
// Add the methods to the class's toString()
// Format the data as I demonstrated in class.
// ****You may make your own class if you really want to practice.

import java.io.*;


class Emprec {
  String name;
  String address;
  String socsec;
  // Added 
  String phone;
  String email;
  String employeeID;
  // ---->
  int age;
  double gpa;
  char sex;
  
	// DECLARE THE NEW FIELD STEP 1
  Emprec (String name, String address, String socsec, String age, String gpa, String sex, String phone, String email, String employeeID) {  
		//STEP 2 ADD IT TO THE PARAMETER LIST
    try{
      this.name = name;
      this.address = address;
      this.socsec = socsec;
      this.age = Integer.parseInt(age);
      this.gpa = Double.parseDouble(gpa);
      this.sex = sex.charAt(0);
      // Added
      this.phone = phone;
      this.email = email;
      this.employeeID = employeeID;
      // ---->
    } catch(NumberFormatException errmsg) { // Step 3 ASSIGN IT TO THE OBJECT
      System.out.println("Invalid format"+ errmsg);   
      this.name = "";  
      this.address = ""; 
      this.socsec = ""; 
      this.age = -1;
      this.gpa = 0.0;
      this.sex = '\0';
      // Added
      this.phone = "";
      this.email = "";
      this.employeeID = "";
      // ---->
    }
  }  

  public String getLastFourOfSocial() {
    return socsec.substring(socsec.length() - 4);
  }

  public String setTemporaryPassword() {
    return name.split(" ")[0] + 123;
  }
  // Step 4 ASSIGN IT TO THE toString() 
  public  String toString() {
    return  (
      "\n your name is " + this.name
      + "\n your address is " + this.address
      + "\n your socsec last four digits are " + getLastFourOfSocial()
      + "\n your age is " + this.age
      + "\n your gpa is " + this.gpa
      + "\n your gender is " + this.sex
      // Added
      + "\n your phone number is " + this.phone
      + "\n your employee ID is " + this.employeeID
      + "\n your email is " + this.email
      + "\n your temporary email password is " + setTemporaryPassword()
      // ---->
    );
  }
  // see if you can get the boolean to load from a text file.
  // what's missing ????
}

class ParseEmpSolFilesHW
{
  public static void main(String args[]) throws IOException
  {
    BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader inData = new BufferedReader(new FileReader("ParseEmpSolFilesHW.txt"));

    // create strings for the input data for the Emprec object
    String str_name;
    String str_address;
    String str_socsec;
    String str_age;
    String str_gpa;
    String str_sex;
    String str_phone;
    String str_email;
    String str_employeeID;
    //Step 5 make a stunt double !!!!!	
    for(;;) {  //STEP 6 READ THE FILE !!!!
      str_name = inData.readLine();
      if (str_name.equalsIgnoreCase("exit")) System.exit(0); //sentinel value
      str_address = inData.readLine();
      str_socsec = inData.readLine();
      str_age = inData.readLine();
      str_gpa = inData.readLine();
      str_sex = inData.readLine();
      str_phone = inData.readLine();
      str_email = inData.readLine();
      str_employeeID = inData.readLine();

      //if (str_name.equalsIgnoreCase("exit")) System.exit(0); //sentinel value

      Emprec employee = new Emprec(str_name, str_address, str_socsec, str_age, str_gpa, str_sex, str_phone, str_email, str_employeeID);  
      //Step 7 pass the new field to the constructor !!! 
      System.out.println(employee);
    }
  }
}

// you may try this method System.exit(0);
// to exit from the program.
