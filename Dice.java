import java.util.Random;

public class Dice 
{
    private static Random random = new Random();

    public static int rand(int min, int max) 
    {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int rand(int[] range) 
    {
        return rand(range[0], range[1]);
    }

    public static int weight() 
    {
        return weight(0, 100);
    }

    public static int weight(int max) 
    {
        return weight(0, max);
    }


    public static boolean coinToss() 
    {
        return rand(0, 1) == 0;
    }

    public static boolean coinToss(int cutoff) 
    {
        return rand(0, 100) < cutoff;
    }

    public static boolean coinToss(int cutoff, int max) 
    {
        return rand(0, max) < cutoff;
    }
}
