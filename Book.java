public class Book implements Comparable<Book>
{
    public int id;
    public int score;

    public Book(int reqid, int reqscore)
    {
        this.id = reqid;
        this.score = reqscore;
    }

    @Override
    public int compareTo(Book bk)
    {
      return this.getScore().compareTo(bk.getScore());
    }
  
    public Integer getScore()
    {
      return this.score;
    }
}