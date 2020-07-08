
public class LongestPalindromicSubstring {
	public static void main(String[] args){
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("caba"));
	}
    public String longestPalindrome(String s) {
        
        int[][] p = new int[s.length()][s.length()];
        for(int i = 0 ; i < s.length(); i++){
            p[i][i] = 1;
        }
        int max = 1;
        for(int i = 0 ; i< s.length() - 1 ; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                max = 2;
                p[i][i+1] = 2;
            }
            else{
                p[i][i+1] = 0;
            }
        }
        
        int len = 2;
        while(len < s.length() ){
            for ( int i = 0 ; i< s.length() - len ; i++){
                if(s.charAt(i) == s.charAt(i+len)
                  && p[i+1][i+len-1] != 0
                  ){
                    p[i][i+len] = p[i+1][i+len-1] + 2;
                    max = p[i][i+len];
                }
            }
            len++;
        }
        
        for(int i=0;i< s.length(); i++){
            for (int j=i ; j< s.length() ; j++){
                if(p[i][j] == max){
                   return s.substring(i,j + 1); 
                }
            }
        }
        return "";
    }
}

