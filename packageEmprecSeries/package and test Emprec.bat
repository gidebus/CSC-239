cls
cd \x1

REM TO CREATE THE PACKAGE 


javac   -d     c:\x1     Emprec_Iface.java
javac   -d     c:\x1     HoursRate.java
javac   -d     c:\x1     Emprec.java
REM PLEASE NOTE THAT Emprec needs to be packaged last!!!! 
REM WHAT IS THE REASON FOR THIS????
PAUSE
REM  TO TEST THE PACKAGE TYPE

javac MakePayrollFile.java
java MakePayrollFile

javac ReadPayrollFile.java
java ReadPayrollFile





