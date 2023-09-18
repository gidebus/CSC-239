//Promote.java

// call this Promote.java

class Promote {

  public static void main(String args[]) {

 int i=5;
 long l=8L;
 float f=3.2F;
 double d=6.7;


   System.out.println("i is "+i);

   System.out.println("l is "+l);

   System.out.println("f is "+f);

   System.out.println("d is "+d);


  // now let's try some conversions !!!

  i=i;
  l=i;
  d=l;
  f=i+l;
  // all of these conversions are fine because the
  // variable on the left of the = sign
  // is higher up on the promotion scale than the
  // largest variable on the right side of the = sign.


   System.out.println("i is "+i);

   System.out.println("l is "+l);

   System.out.println("f is "+f);

   System.out.println("d is "+d);

 // let's  see how to downsize

 i=(int)d;
 l=(long) f;
 f=(float)d;

   System.out.println("i is "+i);

   System.out.println("l is "+l);

   System.out.println("f is "+f);

   System.out.println("d is "+d);
 // by using a cast (int) etc. then the variable on the
 // right side of the equal sign is "cut down" to size and
 // will now fit the variable on the left of the = sign.

 // one final thought

 i=(int)( (i*l+d+f) );
 //this allows for the expression to be evaluated and then
 // assigned to the varible "i" on the right.
 // try some more for yourself !!!! add to this program !!!

  }//main


}//Promote
