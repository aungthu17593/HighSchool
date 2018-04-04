public class test2D
  {
public static void main (String[]args)
  {  
	for(int i=6;i<6;i++){
		System.out.println(";)");
	}
    twoD P= new twoD(1,0);
    twoD Q=new twoD();
    twoD W= new twoD(1,2);
    twoD[] point = new twoD[2];
    twoD[] abc=new twoD[2];
    point[0]=new twoD(2,0);
    point[1]=new twoD(-2,0);
    abc=twoD.rotateline(point, Q, Math.PI);
    
    boolean test= P.equals(W);
    System.out.println(test);
    
    
    return;
    }}
 