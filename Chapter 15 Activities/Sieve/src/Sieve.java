import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Iterator<Integer> iterator;
        Set<Integer> sieve = new HashSet<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> values = new HashSet<>();
        for (int i = 2; i <= n; i++)
            values.add(i);

        while (!(values.isEmpty()))
        {
            iterator = values.iterator();
            int prime = iterator.next();
            iterator.remove();
            sieve.add(prime);
            while (iterator.hasNext())
                if (iterator.next() % prime == 0)
                    iterator.remove();

        }
        System.out.println(sieve);
    }
}
