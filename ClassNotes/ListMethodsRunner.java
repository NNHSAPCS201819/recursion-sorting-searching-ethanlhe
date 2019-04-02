import java.util.ArrayList;

public class ListMethodsRunner
{
    public static void main(String[] args)
    {
        ArrayList<Integer> tempList = ListMethods.makeList(10);
        if (tempList.size() == 0)
        {
            System.out.println("The list is empty");
        }
        else
        {
            for (Integer i : tempList)
            {
                System.out.println(i);
            }
        }
    }

    public static void reverseTest()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        ListMethods.reverseList(list);
        System.out.println(list);
    }
}