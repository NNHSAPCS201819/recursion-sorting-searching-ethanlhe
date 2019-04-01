import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
    public static void main (String[] args)
    {
        String str, another = "y";
        int left, right;
        Scanner s = new Scanner(System.in);

        do
        {
            System.out.println ("Enter a potential palindrome:");
            str = s.nextLine();

            if (isPalindrome(str))
            {
                System.out.println("That string IS a palindrome.");

            }
            else
            {
                System.out.println ("That string is NOT a palindrome");
            }
            System.out.println();
            System.out.print ("Test another palindrome (y/n)? ");
            another = s.nextLine();
        }
        while (another.equalsIgnoreCase("y")); // allows y or Y
    }

    public static boolean isPalindrome(String str)
    {
        if(str.length() <= 1)
        {
            return true;
        }
        String firstChar = str.substring(0,1);
        String lastChar = str.substring(str.length()-1);
        if(firstChar.equals(lastChar))
        {
            return isPalindrome(str.substring(1, str.length()-1));
        }
        else
        {
            return false;
        }
    }

}

