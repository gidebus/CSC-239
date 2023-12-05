//HomeWork   Here is that you need to do with the program below!

Add 3 more fields
Add 2 methods that return something.  These methods cannot be void
Add all fields to the toString() method in the class

Extra credit:
Add the methods to the class's toString()
Format the data as I demonstrated in class.
// ****You may make your own class if you really want to practice.

import java.io.*;


class Emprec {
  String name;
  // DECLARE THE NEW FIELD     STEP 1
 





Emprec (String name)   
//STEP 2 ADD IT TO THE PARAMETER LIST
{

try{
this.name=name;



// Step 3 ASSIGN IT TO THE OBJECT 
} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
    

}//catch

}//Emprec constructor !!!!



// Step 4 ASSIGN IT TO THE toString() 
public  String toString()
{

return  ("\n your name is " + name);



}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class ParseEmpSolFilesHW
{
  
public static void main(String args[]) 
    throws IOException
 
 {

     BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));



// create strings for the input data for the Emprec object

    String str_name;
     //Step 5 make a stunt double !!!!!	
	
	
	
	
    

   for(;;){  

//READ THE FILE !!!!

 str_name     =  inData.readLine();

 if (str_name.equalsIgnoreCase("exit")) System.exit(0);



Emprec employee=new Emprec(str_name);  
//Step 7 pass the new field to the constructor !!!  V.O.
System.out.println(employee);


     
    }//for

 
   }//main

}//ParseEmpSol



// you may try this method     System.exit(0);
// to exit from the program.




