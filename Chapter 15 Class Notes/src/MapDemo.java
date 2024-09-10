import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*
         * The map interface is generic.
         * The first type given si the type of the key.
         * The second type given is the type of the value.
         */

         Map<String, Color> favColors = new HashMap<>();

         //Add elements to the map using the put method
         favColors.put("Henry", Color.BLUE);
         favColors.put("Jack", Color.RED);
         favColors.put("Priuya", Color.GREEN);
         
         // Two different elements with the same value
         favColors.put("Dr. Miller", Color.GREEN);

         //The same key CANNOT have two different values
         // Using put on a key that exisets, changes the value
         favColors.put("Jack", Color.MAGENTA);

         //Create a set of the keys in a map
         Set<String> keys = favColors.keySet();
         for (String key: keys)
         {
            System.out.println(key + " (" + key.hashCode() + "): " + favColors.get(key));
         }
    }
}
