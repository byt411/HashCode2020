import java.util.*;

public class Library implements Comparable<Library>{
  public int id;
  public int signUp;
  public int scanRate;
  public int numBooks;

  public ArrayList<Book> books;
  public ArrayList<Book> scanned;

  public int maxScore;
  public Library(int givenId, int givenSignUp, int givenScanRate){

                 this.id = givenId;
                 this.signUp = givenSignUp;
                 this.scanRate = givenScanRate;
                 this.numBooks = 0;
                 this.books = new ArrayList<Book>();
                 this.scanned = new ArrayList<Book>();
                 }
  
  public void calcMax (int days)
  {
    int scoreabledays = days - this.signUp;
    int maxScore = 0;
    int currentbook = 0;
    Collections.sort(this.books, Collections.reverseOrder());
    for (int i = 0; i < scoreabledays && currentbook < this.books.size(); i+= scanRate)
    {
     // System.out.println("added book " + currentbook + " with score " + scores[currentbook]);
      maxScore += this.books.get(currentbook).score;
      
      currentbook++;
    }
    this.maxScore = maxScore;

  }

  public int scan(int days)
  {
    days -= this.signUp;
    int booksScanned = 0;
    for (int i = 0; i < days && booksScanned < this.books.size(); i+=this.scanRate)
    {
      scanned.add(this.books.get(booksScanned));
      this.books.get(booksScanned).score = 0;
      booksScanned++;
    }
    return days;
  }

  @Override
  public int compareTo(Library lib)
  {
    return this.getScore().compareTo(lib.getScore());
  }

  public Integer getScore()
  {
    return this.maxScore;
  }
}
