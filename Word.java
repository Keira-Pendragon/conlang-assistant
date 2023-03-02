/**
 * Word
 */
public class Word extends Def
{
    private int word_type;
    private boolean random_type;

    private int[] word_pattern;
    private boolean random_pattern;

    private int[] cluster_length;
    private boolean random_cluster_length;

    private int[] cluster_flavor;
    private boolean random_cluster_flavor;

    private int tense;
    private boolean random_tense;

    private int mood;
    private boolean random_mood;

    private int[] genus;
    private boolean random_genus;

    private int singularity;
    private boolean random_singularity;

    private int possessiveness;
    private boolean random_possessiveness;

    private int mention_order;
    private boolean random_mention_order;

    private int pronoun_role;
    private boolean random_pronoun_role;

    private String b12_digits;
    private String[] b12Mixed;
    private boolean random_b12_digits;

    private int digit_count;
    private boolean random_digit_count;

    private char delimiter;
    private boolean random_delimiter;

    private int delimiter_index;
    private boolean random_delimiter_index;

    private int is_negative;
    private boolean random_is_negative;

    private int degree;
    private boolean random_degree;

    private int is_doubt;
    private boolean random_is_doubt;


    /**
     * Random Constructor
     */
    public Word()
    {
        randomizeAll(true);
        RefreshRandoms();
    }

    /**
     * Verb Constructor
     * @param word_type
     * @param word_pattern
     * @param cluster_length
     * @param cluster_flavor
     * @param tense
     * @param mood
     */
    public Word(int word_type, int[] word_pattern, int[] cluster_length, int[] cluster_flavor, int mood, int tense)
    {
        randomizeAll(false);

        this.word_type = word_type;
        this.word_pattern = word_pattern;
        this.cluster_length = cluster_length;
        this.cluster_flavor = cluster_flavor;
        this.mood = mood;
        this.tense = tense;

        this.random_word_pattern = (word_pattern[0] == RANDOM);
        this.random_cluster_length = (cluster_length[0] == RANDOM);
        this.random_cluster_flavor = (cluster_flavor[0] == RANDOM);
        this.random_mood = (mood == RANDOM);
        this.random_tense = (tense == RANDOM);

        RefreshRandoms();
    }

    /**
     * Noun Constructor
     * @param word_type
     * @param word_pattern
     * @param cluster_length
     * @param cluster_flavor
     * @param genus
     */
    public Word(int word_type, int[] word_pattern, int[] cluster_length, int[] cluster_flavor, int[] genus, int singularity, int possessiveness)
    {
        randomizeAll(false);

        this.word_type = word_type;
        this.word_pattern = word_pattern;
        this.cluster_length = cluster_length;
        this.cluster_flavor = cluster_flavor;
        this.genus = genus;

        this.random_word_pattern = (word_pattern[0] == RANDOM);
        this.random_cluster_length = (cluster_length[0] == RANDOM);
        this.random_cluster_flavor = (cluster_flavor[0] == RANDOM);
        this.random_genus = (genus[0] == RANDOM);

        RefreshRandoms();
    }

    /**
     * Pronoun Constructor
     * @param word_type
     * @param genus
     * @param singularity
     * @param possessiveness
     * @param mention_order
     * @param pronoun_role
     */
    public Word(int word_type, int[] genus, int singularity, int possessiveness, int mention_order, int pronoun_role)
    {
        randomizeAll(false);

        this.word_type = word_type;
        this.genus = genus;
        this.singularity = singularity;
        this.possessiveness = possessiveness;
        this.mention_order = mention_order;
        this.pronoun_role = pronoun_role;

        this.random_genus = (genus[0] == RANDOM);
        this.random_singularity = (singularity == RANDOM);
        this.random_possessiveness = (possessiveness == RANDOM);
        this.random_mention_order = (mention_order == RANDOM);
        this.random_pronoun_role = (pronoun_role == RANDOM);

        RefreshRandoms();
    }

    /**
     * Adhesive, Adjective and Adverb Constructor
     * @param word_type
     * @param word_pattern
     * @param cluster_length
     * @param cluster_flavor
     */
    public Word(int word_type, int[] word_pattern, int[] cluster_length, int[] cluster_flavor)
    {
        randomizeAll(false);
        this.word_type = word_type;
        this.word_pattern = word_pattern;
        this.cluster_length = cluster_length;
        this.cluster_flavor = cluster_flavor;

        this.random_word_pattern = (word_pattern[0] == RANDOM);
        this.random_cluster_length = (cluster_length[0] == RANDOM);
        this.random_cluster_flavor = (cluster_flavor[0] == RANDOM);

        RefreshRandoms();
    }

    /**
     * Number Constructor
     * @param b12_digits
     */
    public Word(String b12_digits)
    {
        randomizeAll(false);
        this.b12_digits = b12_digits;
        this.random_b12_digits = b12_digits.contains("" + RANDOM);
        processNumber();
        RefreshRandoms();
    }

    /**
     * Negation Constructor
     * @param type
     * @param is_negative
     * @param degree
     */
    public Word(int type, int is_negative, int degree)
    {
        randomizeAll(false);

        this.word_type = type;
        this.is_negative = is_negative;
        this.degree = degree;

        this.random_is_negative = (is_negative == RANDOM);
        this.random_degree = (degree == RANDOM);

        RefreshRandoms();
    }

    /**
     * Questioning Constructor
     * @param type
     * @param query_or_doubt
     */
    public Word(int type, int query_or_doubt)
    {
        randomizeAll(false);

        this.word_type = type;
        this.is_doubt = query_or_doubt;

        this.random_is_doubt = (query_or_doubt == RANDOM);

        RefreshRandoms();
    }

    /**
     * Set everything to random - except random_type - set that as directed.
     * @param random_type
     */
    private void randomizeAll(boolean random_type)
    {
        this.random_type = random_type;
        this.random_pattern = true;
        this.random_cluster_length = true;
        this.random_cluster_flavor = true;
        this.random_tense = true;
        this.random_mood = true;
        this.random_genus = true;
        this.random_singularity = true;
        this.random_possessiveness = true;
        this.random_mention_order = true;
        this.random_pronoun_role = true;
        this.random_b12_digits = true;
        this.random_digit_count = true;
        this.random_delimiter_index = true;
        this.random_is_negative = true;
        this.random_degree = true;
        this.random_is_doubt = true;
        this.delimiter = '-';
    }

/***********************************************
 *                     Getters
 ***********************************************/

    public int Type()
    {
        return this.word_type;
    }

    public int[] Pattern()
    {
        return this.word_pattern;
    }

    public int[] ClusterLength()
    {
        return this.cluster_length;
    }

    public int[] ClusterFlavor()
    {
        return this.cluster_flavor;
    }

    public int Tense()
    {
        return this.tense;
    }

    public int Mood()
    {
        return this.mood;
    }

    public int[] Genus()
    {
        return this.genus;
    }

    public int Singularity()
    {
        return this.singularity;
    }

    public int Possessiveness()
    {
        return this.possessiveness;
    }

    public int MentionOrder()
    {
        return this.mention_order;
    }

    public int PronounRole()
    {
        return this.pronoun_role;
    }

    public String B12Digits()
    {
        return this.b12_digits;
    }

    public int DigitCount()
    {
        return this.digit_count;
    }

    public char Delimiter()
    {
        return this.delimiter;
    }

    public int DelimiterIndex()
    {
        return this.delimiter_index;
    }

    public int isNegative()
    {
        return this.is_negative;
    }

    public int Degree()
    {
        return this.degree;
    }

    public int isDoubt()
    {
        return this.is_doubt;
    }

/****************************************************************
 *                   Other Logic
 ****************************************************************/

    /**
     * Can be called to set a temporary value for anything that the user wants to be randomized.
     * Should Only be called ONCE per word assembly.
     */
    public void RefreshRandoms() 
    {
        this.word_type = this.random_type ? weightedRandomWordType() : this.word_type;
        this.word_pattern = this.random_pattern ? weightedRandomWordPattern() : this.word_pattern;
        this.cluster_length = this.random_cluster_length ? weightedRandomClusterLength() : this.cluster_length;
        this.cluster_flavor = this.random_cluster_flavor ? weightedRandomClusterFlavor() : this.cluster_flavor;
        this.mood = this.random_mood ? weightedRandomMood() : this.mood;
        this.tense = this.random_tense ? weightedRandomTense() : this.tense;
        this.genus = this.random_genus ? weightedRandomGenus() : this.genus;
        this.singularity = this.random_singularity ? weightedRandomSingularity() : this.singularity;
        this.possessiveness = this.random_possessiveness ? weightedRandomPossessiveness() : this.possessiveness;
        this.mention_order = this.random_mention_order ? weightedRandomMentionOrder() : this.mention_order;
        this.pronoun_role = this.random_pronoun_role ? weightedRandomPronounRole() : this.pronoun_role;
        this.digit_count = this.random_digit_count ? weightedRandomDigitCount() : this.digit_count;
        this.delimiter = this.random_delimiter ? weightedRandomDelimiter() : this.delimiter;
        this.delimiter_index = this.random_delimiter_index ? weightedRandomDelimiterIndex() : this.delimiter_index;
        this.b12_digits = this.random_b12_digits ? weightedRandomB12Digits() : this.b12_digits;
        this.b12Mixed = this.random_b12_digits ? weightedRandomB12Mixed() : this.b12Mixed;
        this.is_negative = this.random_is_negative ? weightedRandomIsNegative() : this.is_negative;
        this.degree = this.random_degree ? weightedRandomDegree() : this.degree;
        this.is_doubt = this.random_is_doubt ? weightedRandomIsDoubt() : this.is_doubt;
    }

/****************************************************************
 *                  Weighted Randomizers
 ****************************************************************/

    /**
     * Tentative weighting for random word type
     * @return
     */
    private int weightedRandomWordType()
    {
        int w = Dice.weight();
        return (w < 5)? NUMBER : (w < 10)? PRONOUN : (w < 30)? NOUN : (w < 50)? ADJECTIVE : 
               (w < 70)? VERB : (w < 90)? ADVERB : (w < 95)? QUERY : NEGATION;
    }

    /**
     * 
     * @return
     */
    private int[] weightedRandomWordPattern()
    {
        int w = Dice.weight(130);
        int[] pattern;
        switch (this.word_type) 
        {
            case NOUN:
                pattern = (w < 20)? noun_pattern[0] : (w < 70)? noun_pattern[1] : (w < 80)? noun_pattern[2] :
                          (w < 110)? noun_pattern[3] : (w < 115)? noun_pattern[4] : noun_pattern[5];
                break;
            case ADJECTIVE:
                pattern = (w < 20)? adjective_pattern[0] : (w < 70)? adjective_pattern[1] : (w < 80)? adjective_pattern[2] :
                          (w < 110)? adjective_pattern[3] : (w < 115)? adjective_pattern[4] : adjective_pattern[5];
                break;
            case VERB:
                pattern = (w < 20)? verb_pattern[0] : (w < 90)? verb_pattern[1] : 
                          (w < 100)? verb_pattern[2] : verb_pattern[3];
                break;
            case ADVERB:
                pattern = (w < 10)? adverb_pattern[0] : (w < 20)? adverb_pattern[1] : 
                          (w < 30)? adverb_pattern[2] : adverb_pattern[3];
                break;
            case ADHESIVE:
                pattern = (w < 10)? adhesive_pattern[0] : (w < 20)? adhesive_pattern[1] : (w < 30)? adhesive_pattern[2] : 
                          (w < 40)? adhesive_pattern[3] : (w < 50)? adhesive_pattern[4] : (w < 60)? adhesive_pattern[5] :
                          (w < 70)? adhesive_pattern[6] : (w < 80)? adhesive_pattern[7] : (w < 90)? adhesive_pattern[8] :
                          (w < 100)? adhesive_pattern[9] : (w < 120)? adhesive_pattern[10] : adhesive_pattern[11];
                break;
            default:
                pattern = RANDOMINTARRAY;
                break;
        }
        return pattern;
    }

    /**
     * 
     * @return
     */
    private int[] weightedRandomClusterLength()
    {
        int w;
        int[] len;
        if(this.word_type >= NOUN && this.word_type <= ADHESIVE)
        {
            len = new int[this.word_pattern.length];
            for(int i = 0; i < this.word_pattern.length; i++)
            {
                w = Dice.weight();
                len[i] = (w < 60)? ONELETTER : (w < 90)? TWOLETTERS : THREELETTERS;
            }
        }
        else
        {
            len = RANDOMINTARRAY;
        }
        return len;
    }

    /**
     * 
     * @return
     */
    private int[] weightedRandomClusterFlavor()
    {
        int w;
        int[] len;
        if(this.word_type >= NOUN && this.word_type <= ADHESIVE)
        {
            len = new int[this.word_pattern.length];
            w = Dice.weight();
            int c_count = 0;
            for(int i = 0; i < this.word_pattern.length; i++)
            {
                len[i] = (this.word_pattern[i] == ONESET || this.word_pattern[i] == MIDDLE || this.word_pattern[i] == CODA)? 0 : RANDOM;
                c_count = c_count + ((len[i] == 0)? 1 : 0);
            }
            int [] consonants = new int[c_count];
            for(int j = 0; j < consonants.lenght; j++)
            {
                w = Dice.weight();
                consonants[j] = (j == 0)? ((w < 60)? VOICELESS : (w < 80)? NEUTRAL : VOICED) : 
                                ((w < 80)? consonants[0] : (w < 88)? VOICELESS : (w < 96)? NEUTRAL : VOICED);
            }
            int c = 0;
            for(int k = 0; k < len.lenght; k++)
            {
                if(len[j] == 0)
                {
                    len[j] = consonants[c];
                    c++;
                }
                if(c == consonants.length)
                {
                    break;
                }
            }
        }
        else
        {
            len = RANDOMINTARRAY;
        }

        return len;
    }

    /**
     * 
     * @return
     */
    private int weightedRandomTense()
    {
        int w = Dice.weight();
        return (w < 40)? TIMELESS : (w < 60)? PAST : (w < 80)? PRESENT : FUTURE;
    }

    /**
     * 
     * @return
     */
    private int weightedRandomMood()
    {
        int w = Dice.weight();
        return (w < 30)? WISH : (w < 50)? DIRECTIVE : (w < 70)? DELIBERATELY : (w < 85)? PASSIVELY : UNINTENTIONALLY;
    }

    /**
     * 
     * @return
     */
    private int[] weightedRandomGenus()
    {
        int w = Dice.weight();
        int mod = (w < 20)? CONCEPT : (w < 50)? THING : (w < 70)? ENTITY : (w < 85)? QUALITY : ACTION;
        int primary = (w < 20)? CONCEPT : (w < 50)? THING : (w < 70)? ENTITY : PLACE;
        return new int[] {mod, primary};
    }

    /**
     * 
     * @return
     */
    private int weightedRandomSingularity()
    {
        return Dice.coinToss(85);
    }

    /**
     * 
     * @return
     */
    private int weightedRandomPossessiveness()
    {
        int w = Dice.weight();
        return (w < 30)? NONPOSSESSIVE : (w < 40)? PARTOF : (w < 50)? CLOSETO : 
               (w < 60)? DOMINANTTO : (w < 70)? DIMINUATIVETO : TENUOUSLYLINKEDTO;
    }

    /**
     * 
     * @return
     */
    private int weightedRandomMentionOrder()
    {
        int w = Dice.weight();
        return (w < 90)? 1 : (w < 95)? Dice.rand(1, 3) : (w < 98)? Dice.rand(1, 8) : Dice.rand(1, 12);
    }

    /**
     * 
     * @return
     */
    private int weightedRandomPronounRole()
    {
        
        int role;
        if(genus[PRIMARY] != ENTITY)
        {
            role = Dice.coinToss()? ITHIS : THEYTHAT;
        }
        else
        {
            int w = Dice.weight();

            role = (w < 40)? ITHIS : (w < 60)? YOU : (w < 75)? WEBOTH : THEYTHAT;
        }
        return role;
    }

    /**
     * 
     * @return
     */
    private int weightedRandomIsNegative()
    {
        return Dice.coinToss(30);
    }

    /**
     * 
     * @return
     */
    private int weightedRandomDegree()
    {
        int w = Dice.weight();
        return (w < 20) ? 1 : (w < 40)? 5 : (w < 60)? 8 : (w < 80)? 11 : Dice.rand(1, 11);
    }

    /**
     * 
     * @return
     */
    private int weightedRandomIsDoubt()
    {
        return Dice.coinToss(20);
    }



    // TODO: NUMBER STUFFFFFFFF
    /**
     * 
     * @return
     */
    private int weightedRandomDigitCount()
    {
        int w = Dice.weight();
        return (w < 50)? Dice.rand(1, 6) : (w < 90)? Dice.rand(1, 15) : (w < 98) ? Dice.rand(1, 36) : Dice.rand(1, 72);
    }

    /**
     * 
     * @return
     */
    private char weightedRandomDelimiter()
    {
        char del = ' ';
        if(this.digit_count > 1)
        {
            int w = Dice.weight();
            del = (this.digit_count <= 36)?((w < 50)? ' ' : (w < 75)? '.' : '/') : (Dice.coinToss()? '.' : '/');
        }
        return del;
    }

    /**
     * 
     * @return
     */
    private int weightedRandomDelimiterIndex()
    {
        int maxOffset = Math.min(MAXDIGITS, this.digit_count - MAXDIGITS);
        int offset = Dice.rand(1, maxOffset);
        return (this.digit_count == 1)? RANDOM : MAXDIGITS + (dice.rand(0, 1) == 0 ? -offset : offset);
    }


    /**
     * 
     * @return
     */
    private String weightedRandomB12Digits()
    {
        // Make sure we Actually set up the digit count - can't have -1 digits after all!
        if(this.digit_count == RANDOM)
        {
            this.digit_count = weightedRandomDigitCount();
            this.delimiter_index = weightedRandomDelimiterIndex();
            this.delimiter = weightedRandomDelimiter();
        }
        String 
        for()
        {

        }



        return "";
    }

    private String[] weightedRandomB12Mixed()
    {
        return new String[] {"0" , "0"};
    }


    /******************************************
     *        Number handling Nonsense
     ******************************************/
    private void processNumber()
    {

    }
}