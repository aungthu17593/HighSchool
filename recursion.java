import java.util.Scanner;
public class recursion
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println(perm("ABC"));
}

public static String hanoi(int n, char A, char B, char C)
{
  if (n==1) return(A+"-"+B);
  else
  { return(hanoi(n-1,A,C,B)+" "+A+"-"+B+" "+hanoi(n-1,C,B,A));
  }}

public static int sumdigits (int n)
{
  if (n<10) return(n);
  else
  {
  return((n%10)+sumdigits(n/10));
  }
 } 
public static boolean palindrome (String word)
{
  int n= word.length();
  if (n<=1) return(true);
  else if (word.charAt(0)!=word.charAt(n-1))
  {
    return(false);
  }
  else
  {
  return (palindrome(word.substring(1,n-1)));
  }}

public static String permutation(String prefix, String word){
    String restr="";
    int n=word.length();
    if(n==0) return(prefix);
    else{
      for (int i=0; i<n; i++){
        restr+=permutation(prefix+word.charAt(i), word.substring(0,i)+word.substring(i+1));  
      }
    return(restr);
    }
}

public static String combination(String prefix, String word, int r){
  return(word);
}

public static String perm(String word)
{
  String restr="";
  String temp=word;
  if (word.length()==1) return(word);
  else
  {
    for(int i=0;i<word.length();i++)
    {
     word=swap(word,i);
     restr += word.charAt(0)+perm(word.substring(1))+" ";
     } 
   return (restr);
  }
}

public static String swap(String word, int a)
{
  return(word.charAt(a)+word.substring(0,a)+word.substring(a+1));
}

public static double[][] deleterow(double[][] x, int n){
  double[][] duplicate = new double[x.length-1][];
  for(int i=0; i<n; i++){
    duplicate[i]=x[i].clone();
  }

  for(int i=n; i<x.length-1; i++){
    duplicate[i]=x[i+1].clone();
  }
  return(duplicate);
}
  
public static double[][] deletecolumn(double[][] x, int n){
  double[][] duplicate = new double[x.length][x[0].length-1];
  for(int i=0; i<x.length; i++){
  
    for (int j=0; j<n; j++){
      duplicate[i][j]=x[i][j];
    }

    for (int j=n; j<x[0].length-1; j++){
      duplicate[i][j]=x[i][j+1];
    }}
  return(duplicate);
}

public static double determinant(double[][] m){
  int k=1;
  double re=0;
 if (m.length==1) return(m[0][0]);
 else{
 
  for (int i=0; i<m.length; i++){
    re+=k*m[i][0]*recursion.determinant(recursion.minor(m,i,0));
    k*=-1;
  }
  return(re);
 } 
}

public static double[][] minor(double[][] m, int r, int c){
  double[][] minor = recursion.deleterow(m, r);
  minor= recursion.deletecolumn(minor,c);
  return(minor);
}
}

