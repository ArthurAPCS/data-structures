import java.util.*;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        String name, grade;
        Set<String> keys;
        Scanner in = new Scanner(System.in);

        Map<String, String> grades = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                name = in.next();
                grade = in.next();
                grades.put(name, grade);

            } else if (input.equals("R"))
            {
                name = in.next();
                grades.remove(name);
            } else if (input.equals("M"))
            {
                name = in.next();
                grade = in.next();
                grades.put(name, grade);
            } else if (input.equalsIgnoreCase("P"))
            {
                keys = grades.keySet();
                List<String> sortedList = new ArrayList<>(keys);
                Collections.sort(sortedList);
                for (String key : sortedList)
                    System.out.println(key + ": " + grades.get(key));
            } else
            {
                done = true;
            }
        }
    }
}
