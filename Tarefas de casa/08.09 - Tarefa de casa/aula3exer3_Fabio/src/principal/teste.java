package principal;

	
	import java.util.Scanner;
	
	public class teste {


	     public static void main(String []args){

	    	 byte z=5; float y=2; double x=20; 
	    	  
	    	 x *= y+z; 
	    	  
	    	 boolean A, B, C, D;
	    	 
	    	 A = ((x>100) & (y<z));
	    	 B = ((z<y) && (x<100));
	    	 C = (y<z) | (x>100);
	    	 D = (x<100) || (z<y);
	    	 
	    	 System.out.println(A);
	    	 System.out.println(B);
	    	 System.out.println(C);
	    	 System.out.println(D);
	         
	         
	     }
	}
	
	     



