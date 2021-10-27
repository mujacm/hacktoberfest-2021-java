
import java.util.Random;

public class PasswordGenerator 
{
    public static void main(String[] args)
    {
        int length = 10; // password length(can be changed)
        System.out.println(generatePswd(length));
    }
    static String generatePswd(int len)
    {
        System.out.println("Your Password:");
        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "!@#$%^&*_=+-/€.?<>)";

        String passSymbols = charsCaps + chars + nums + symbols;
        Random rnd = new Random();
        
        String password="";
       
        for (int i = 0; i < len; i++) 
        {
            password += String.valueOf(passSymbols.charAt(rnd.nextInt(passSymbols.length())));
            
        }
        return password;
    }
}
