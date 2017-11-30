package object.middle;

public class exception {
	public static void main(String args[]){
		try{
			System.out.println(3/0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("end");
		}
		
		StringBuffer sb =new StringBuffer();
        
		try{
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append('a');
        }
		}catch(OutOfMemoryError e){
			System.out.println("catch oom");
			e.printStackTrace();
		}
        System.out.println("end2");
	}
}
