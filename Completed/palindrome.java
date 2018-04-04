import java.util.Scanner;

public class palindrome
{
public static void main(String[]args)
{
  Scanner kbd = new Scanner (System.in);
  System.out.println("Enter a word");
  String x = kbd.next();
  String y = x;
  x =  x.toLowerCase();
  int n = x.length();
  char a, b;
  boolean w=false;
  
  while (n>1)
  {
  a = x.charAt(n-1);
  b = x.charAt(0);
  w = a==b;
 
  if (w==false)
  {
  break;
  }
  else 
  {
  x = x.substring (1,n-1);
  n = x.length();
  }
  }
  
  
  if (w==true || n<=1)
  {
  System.out.println(y+ " is a palindrome");
  }
  else
  {
  System.out.println(y+" is not a palindrome.");
  }
  
  
  return;
  }}
  
 