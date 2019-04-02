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
            tempList = makeList(n-1);
            tempList.add(n);
            return tempList;
        }
        //return tempList;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList); 
        if (list.isEmpty())
        {
            return list;
        }
        else
        {
            list.remove(0);
            list = reverseList(tList);
            list.add(tList.get(0));
            return list;
        }
    }
}