import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        int l = strings.size();

        for (int i = 0; i < l/2; i++)//The idea is to swap the first and last elements, the second and second-to-last elements, etc.
            strings.set(i, strings.set(l - i - 1, iterator.next()));//Here, I iterate through the first half of the list and swap the ith element with the l-i-1th element, where it is when reversed.       
    }
}