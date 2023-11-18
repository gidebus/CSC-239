package ThreeD;
// CHANGE THE OUTPUT DISPLAY TO DISPLAY THE CONTENTS OF EACH MAILBOX IN THE INDIVIDUAL BUILDINGS.

// BUILDING 1
//  0 1 2
//  3 4 5 
//  6 7 8


// BUILDING 2
//  9 10 11
//  12 13 14 
//  15 16 17

class ThreeD {
  public static void main(String args[]) {
    int list[][][] = new int[3][3][2];
    // what we have are mailboxes 3 rows by 3 columns
    // they are found in 2 apartment buildings

    int i, j, k;// to address the row, column and apartment bldg
                // of all the mailboxes !!!!

   // load by row, column and apartment bldg.
  
    for(k=0; k<2; k++)//apartment bldg.
     for(i=0; i<3; i++) //row
      for(j=0; j<3; j++)//column
     
        {
          System.out.println(" now loading row " + i + " column  " + j + " of building  " + k); 

         list[i][j][k] = i;// set all the values i
        }
     for(k=0; k<2; k++)
      for(i=0; i<3; i++) 
         for(j=0; j<3; j++) 
   

        {
          System.out.print(" row " + i + " column " + j + " of building " + k); 
        
          System.out.println(" has the value  "+ list[i][j][k]);

        }


  }

}
