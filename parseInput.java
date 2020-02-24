import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class parseInput
{
    public static void main(String[] args)
    {   BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(args[0]));
        
        
        String[] description = in.readLine().split(" ");
            
        int numBooks = Integer.parseInt(description[0]);
        int numLibrary = Integer.parseInt(description[1]);
        int days = Integer.parseInt(description[2]);
        //in.readLine();
        String[] bookScoreArray = in.readLine().split(" ");
        

        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < numBooks; i++)
            bookList.add(new Book(i, Integer.parseInt(bookScoreArray[i])));
        
        List<Library> libraries = new ArrayList<Library>();
        for (int i = 0; i < numLibrary; i++)
        {
          //  in.readLine();
            String[] newLine = in.readLine().split(" ");
            int books = Integer.parseInt(newLine[0]);
            int signup = Integer.parseInt(newLine[1]);
            int scan = Integer.parseInt(newLine[2]);

            Library newLibrary = new Library(i, signup, scan);
           // in.readLine();
            String[] rawlist = in.readLine().split(" ");
         //   System.out.println(signup);
            for (int j = 0; j < books; j++)
            {
                int book = Integer.parseInt(rawlist[j]);
                newLibrary.books.add(bookList.get(book));
                newLibrary.numBooks++;

            }
            
          //  System.out.println("Library " + i + ", signup " + newLibrary.signUp + ", shiprate " + newLibrary.scanRate);
            newLibrary.calcMax(days);
            libraries.add(newLibrary);
        }

        Collections.sort(libraries, Collections.reverseOrder());

        System.out.println((int)libraries.size());
        for (int i = 0; i < numLibrary; i++)
        {
            Library outputLibrary = libraries.get(i);
            Collections.sort(outputLibrary.books, Collections.reverseOrder());
            days = outputLibrary.scan(days);
            //System.out.println("score: " + outputLibrary.maxScore);
            if (days < 0)
                break;
            System.out.print(outputLibrary.id + " ");
            System.out.println(outputLibrary.scanned.size());
            for (int j = 0; j < outputLibrary.scanned.size(); j++)
            {
                System.out.print(outputLibrary.scanned.get(j).id + " ");
            
            }
            System.out.println();
        }
        in.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e);
        }

    }
}