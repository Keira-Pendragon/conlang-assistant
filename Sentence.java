import java.util.ArrayList;

public class Sentence 
{
    private int word_count;
    private ArrayList<Word> words;

    public Sentence() 
    {
        word_count = 0;
        words = new ArrayList<Word>();
    }

    public void addWord(Word word) 
    {
        words.add(word);
        word_count++;
    }

    public Word WordAt(int index) 
    {
        if (index < 0 || index >= word_count) 
        {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return words.get(index);
    }
}