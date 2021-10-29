public class Main
{
	public static void main(String[] args){
            //Scanner sc = new Scanner(System.in);
            String str = "madam";
            //String str = sc.next();
            String strRev = "";
            for (int i = str.length() -1 ; i >= 0; i--) {
                strRev += str.charAt(i);
            }
            if(str.equalsIgnoreCase(strRev))
                System.out.println("Palindrome");
            else
                System.out.println("Not Palindrome");
        }
}
