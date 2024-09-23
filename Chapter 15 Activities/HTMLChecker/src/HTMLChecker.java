import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";
        Stack<String> htmls = new Stack<>();
        boolean good = true;

        try (Scanner in = new Scanner(new File(filename)))
        {
            String nextTag = in.next();
            htmls.push(nextTag);
            while (in.hasNext())
            {
                nextTag = in.next();
                if (nextTag.substring(1, 2).equals("/"))
                {
                    String prevTag = htmls.pop();
                    if (!(prevTag.substring(1, prevTag.length() - 1).equals(nextTag.substring(2, nextTag.length() - 1))))
                    {
                        good = false;
                        break;
                    }
                }
                else
                    htmls.push(nextTag);
            }
            if (good == true)
                System.out.println("Good HTML");
            else
                System.out.println("Bad HTML");

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
