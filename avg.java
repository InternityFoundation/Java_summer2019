import java.util.*00;
public class avg {

	/**
	 * @param args
	 */
	
		public static void average(String str,int ...a)
		{
			int s=0,j,k;
			j=a.length;
			for(int i=0;i<a.length;i++)
			{
		
				s=s+a[i];
				
			}
			k=s/j;
			System.out.println(k);
		}
		public static void main(String []args)
		{
			average("average is",1,2,3,4,5);
		}
		

	}

	


