import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "Chapter 15 Activities/StringLengthMap/src/test2.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Integer, String> words = new HashMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                String x = words.get(len);
                if (x == null)
                    words.put(len, word);
                else
                    words.put(len, x + ", " + word);

            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            Set<Integer> keys = words.keySet();
            List<Integer> sortedList = new ArrayList<>(keys);
            Collections.sort(sortedList);
                for (Integer key : sortedList)
                    System.out.println(key + ": " + words.get(key));
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
