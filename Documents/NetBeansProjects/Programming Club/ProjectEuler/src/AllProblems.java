
import java.util.ArrayList;

/*
 * Imma make another change
 */

/**
 * This class holds all of the problems and their solutions 
 * in methods, which can be called in the main method.
 * @author Manu S.
 */
public class AllProblems 
{
    public static int sumOfMult3and5()
    {
        int sum = 0;
        for(int i = 0; i < 1000; i ++)
        {
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }
    
    /**
     * The method that actually figures out which
     * of the million Collatz sequences is the longest.
     * @return - the seed which gives the largest Collatz
     * sequence from 1 to 1000000
     */
    public static int largestCollatz()
    {
        int longestSeed = 1;
        int longestLength = 1;
        for(int i = 1; i < 1000000; i ++)
        {
            int length = newCollatz(new ArrayList<Integer>(), i);
            if(length > longestLength)
            {
                longestLength = length;
                longestSeed = i;
            }
        }
        
        return longestSeed;
    }
    
    /**
     * DEPRECATED
     * @param seed
     * @param length
     * @return 
     */
    public static int collatz(int seed, int length)
    {
        System.out.print(seed + " ");
        if(seed == 1)
        {
            length ++;
            System.out.println(length);
        }
        if(seed != 1)
        {
            if(seed % 2 == 0 && seed != 1)
            {
                seed /= 2;
                length ++;
                System.out.println(length);
                collatz(seed, length);
                return length;
            }
            else if(seed % 2 == 1 && seed != 1)
            {
                seed = 3*seed + 1;
                length ++;
                System.out.println(length);
                collatz(seed, length);
            }
        }
        
        return length;
    }
    
    /**
     * Recursive method that is used to find the length
     * of a Collatz sequence. Makes use of several advanced
     * programming topics, including recursion.
     * @param sequence - the ArrayList where the numbers are stored
     * @param seed - the original number
     * @return - the length of the sequence
     */
    public static int newCollatz(ArrayList<Integer> sequence, int seed)
    {
        sequence.add(seed);
        
        //System.out.println(seed + " " + sequence.size());
        if(seed == 1)
        {
            return sequence.size();
        }
        if(seed != 1)
        {
            if(seed % 2 == 0 && seed != 1)
            {
                seed /= 2;
                newCollatz(sequence, seed);
            }
            else if(seed % 2 == 1 && seed != 1)
            {
                seed = 3*seed + 1;
                newCollatz(sequence, seed);
            }
        }
        
        return sequence.size();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
//        int length = newCollatz(new ArrayList<Integer>(), 13);
//        System.out.println();
//        System.out.println(length);
        
        System.out.println(largestCollatz());
        System.out.println(newCollatz(new ArrayList<Integer>(), 910107));
    }
}
