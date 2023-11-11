// CharEx.java

// save this file as CharEx.java

class CharEx {

  public static void main(String args[]) {

    char ch;
    // assign ch to capital "A"

    ch='A';
    // now display the value
    System.out.println("the value of  ch is  " + ch);

   // you can also display the value as an int
    System.out.println("the value of  ch is  " + (int)ch);
    // in this way you can do the following
    ++ch;

   // note what is displayed now

    System.out.println("the value of  ch is  " + ch);

    System.out.println("the value of  ch is  " + (int)ch);

   // what will be the output if I do this

   --ch;

    System.out.println("the value of  ch is  " + ch);

    System.out.println("the value of  ch is  " + (int)ch);


  }//main

}// CharEx
