import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /*
     * First refers to the first Node in the list
     * If the list is empty, first will be null
     */
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst(){
        if (this.first == null){
            throw new NoSuchElementException();
        }
        return this.first.data;
    }




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if (this.first == null){
            throw new NoSuchElementException();
        }

        Object element = this.first.data;
        this.first = this.first.next;
        return element;
    }





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element){
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = this.first;
        this.first = newNode;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    /**
    * Checks if the element is contained in the linked list
    * @param element the element to be checked
    */
    public boolean contains(Object obj)
    {
        Node n = first;
        while (n != null)
        {
            if (n.data.equals(obj))
                return true;
            n = n.next;
        }
        return false;
    }

    /**
     * Checks if the element is contained in the linked list
     * @param start the starting node to check from
     * @param obj the element to be checked
     */
    private static boolean contains(Node start, Object obj)
    {
        if (start == null)
            return false;

        if (start.data.equals(obj))
            return true;
        
        return contains(start.next, obj);
    }

    /**
     * Returns the size of the linked list
     */
    public int size()
    {
        Node n = first;
        int sum = 0;
        while (n != null)
        {
            sum++;
            n = n.next;
        }
        return sum;
    }


    public String toString()
    {
        String data = "[";
        ListIterator iter = this.listIterator();
        while (iter.hasNext())
            data = data + iter.next() + ", ";
        data = data.substring(0, data.length() - 2);
        return data + "]";
    }


    //Class Node
    // Node is static because it does NOT need access to anything in LinkedList
    static class Node{
        public Node next;
        public Object data;
    }


    class LinkedListIterator implements ListIterator
    {
      //private data 
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            previous = position;

            if (position == null){
                position = first;
            }
            else{
                position = position.next;
            }

            isAfterNext = true;
            return position.data;
        }





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            // Check if the list is empty
            if  (position == null)// The iterator hasn't moved
            {
                return first != null;
            }

            // The iterator has moved
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element)
        {
            //Check if the iterator is at the beginning
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else{
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                // Set the next element of the CURRENT position to point to our new node
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(){
            if (!isAfterNext)
                throw new IllegalStateException();

            // Check if the iterator is at the beginning
            if (position == first)
            {
                removeFirst();
                position = null;
            }
            else{
                previous.next = position.next;
                position = previous;
            }

            isAfterNext = false;
        }







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element)
        {
            if (!isAfterNext)
            {
                throw new IllegalStateException();
            }

            position.data = element;
        }


    }//LinkedListIterator
}//LinkedList
