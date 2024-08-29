import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list. */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        System.out.println(staff);

        //The list is currently: TNPG
        /*
         * The listIterator method creates a new list iterator that is positioned at the head of the list.
         * The | is used to represent the iterator position.
         */
        ListIterator<String> iterator = staff.listIterator(); // |TNPG
        /* The next method advances the iterator over the next element in the list. */
        iterator.next(); //T|NPG
        
        /*The next method also returns the element that the iterator passes over. */
        String avenger = iterator.next(); //TN|PG
        System.out.println(avenger);// Should print Natasha

        /* The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the element that was added.
         */
        iterator.add("Captain America");// TNS|PG
        iterator.add("Clint");// TNSC|PG

        System.out.println(staff);

        /* The remove method removes the element returned by the lsat call to next or previous
         * The remove method can ONLY be called after calling next or previous.
         * The remove method CANNOT be called after calling add.
         */
        iterator.next();// TNSCP|G
        iterator.remove();// Peter is removed -> TNSC|G
        System.out.println(staff);

        /* The set method updates the element returned by the last call to next or previous. */
        iterator.previous();// TNS|CG
        iterator.set("T'Challa");//TNS|TG

        System.out.println(staff);
        
        /* The hasNext method is used to determine if there is a next node after the iterator. The hasNext method is often used in the condition of a while loop. */
        iterator = staff.listIterator();
        while (iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")){ //TN|STG
                iterator.remove(); //TSTG
            }
        }//TSTG|

        /* Enhanced for loops work with linked lists */

        for (String n: staff){
            System.out.print(n + " ");
        }

        System.out.println();

        /*
         * ConcurrentModificationException: CANNOT modify a linked list while using an iterator. UNLESS you use the iterator to do the modification.
         */

         iterator = staff.listIterator(); //|TSTG
         while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Tony")){
                //staff.remove("Tony"); ConcurrentModificationExample
            }
         }

         /* The enhanced for loop AUTOMATICALLY creates an iterator. */
         for (String p : staff){
            if (p.equals("Tony")){
                staff.add("Miles Morales");
            }
         }

         System.out.println(staff);
    }
}