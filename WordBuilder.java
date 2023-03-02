/**
 * WordBuilder
 */
public class WordBuilder extends Def
{
    protected static final int[][] verb_pattern = 
    {
        {MOODVOWEL, MIDDLE, TENSEVOWEL},
        {ONSET, MOODVOWEL, MIDDLE, TENSEVOWEL},
        {VOWEL, MIDDLE, MOODVOWEL, MIDDLE, TENSEVOWEL},
        {ONSET, VOWEL, MIDDLE, MOODVOWEL, MIDDLE, TENSEVOWEL}
    };
    protected static final int[][] noun_pattern = 
    {
        {KEYVOWEL, CODA},
        {ONSET, KEYVOWEL, CODA},
        {VOWEL, MIDDLE, KEYVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, KEYVOWEL, CODA},
        {VOWEL, MIDDLE, VOWEL, MIDDLE, KEYVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, VOWEL, MIDDLE, KEYVOWEL, CODA}
    };
    protected static final int[][] adverb_pattern = 
    {
        {VOWEL, MIDDLE, ADVOWEL},
        {ONSET, VOWEL, MIDDLE, ADVOWEL},
        {VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL},
        {ONSET, VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL}
    };
    protected static final int[][] adjective_pattern = 
    {
        {ADVOWEL, CODA},
        {ONSET, ADVOWEL, CODA},
        {VOWEL, MIDDLE, ADVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, ADVOWEL, CODA},
        {VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL, CODA}
    };

    protected static final int[][] adhesive_pattern = 
    {
        {VOWEL},
        {ONSET, VOWEL},
        {ADVOWEL, CODA},
        {ONSET, ADVOWEL, CODA},
        {VOWEL, MIDDLE, ADVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, ADVOWEL, CODA},
        {VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL, CODA},
        {ONSET, VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL, CODA},
        {VOWEL, MIDDLE, ADVOWEL},
        {ONSET, VOWEL, MIDDLE, ADVOWEL},
        {VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL},
        {ONSET, VOWEL, MIDDLE, VOWEL, MIDDLE, ADVOWEL}
    };



    
}