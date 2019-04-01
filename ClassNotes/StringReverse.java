/**
 * Write a description of class StringReverse here.
 *
 * @author mgbuescher
 * @version (a version number or a date)
 */
public class StringReverse
{
        public static int fun(int x)
        {    
            if (x < 1)
            {
            return 1;
        }
            else
            {
            return x +fun(x-5);
        }
    
    }
}