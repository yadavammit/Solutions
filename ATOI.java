
public class ATOI {
	public static void main(String[] args){
		ATOI at = new ATOI();
		at.myAtoi("42");
	}
	    public int myAtoi(String str) {
	        double number = 0d;
	        int negative = 1;
	        for(int i=0 ; i<str.length() ;i++){
	            
	            if(str.charAt(i) == ' ' && number == 0d){
	                continue;
	            }else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	                number = number * 10 + (int) (str.charAt(i) - '0');
	            } else if((str.charAt(i) == '-' || str.charAt(i) == '+') && number == 0){
	                if(str.charAt(i) == '-'){
	                negative = -1;
	            }
	            }else{
	                break;
	            }
	        }
	        
	       
	        if(number > 0){
	            number = number * negative;
	            if(number > Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            }else if(number < Integer.MIN_VALUE){
	                return Integer.MIN_VALUE;
	            }
	            return (int) number;
	        }else{
	            return 0;
	        }
	    }
	
}
