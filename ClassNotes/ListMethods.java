import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0) 
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            return list;

        }
        else        
        {
            
            makeList(n-1);
        
        }
        return tempList;
    }

}