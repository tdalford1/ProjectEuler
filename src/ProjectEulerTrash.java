import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Here are all of the Project Euler methods which have been attempted but have not
 * quite been perfected yet. Feel free to look through the rubble, and even try to
 * fix broken problems if you want.
 */
public class ProjectEulerTrash 
{
    
    /**
     * @author Manu S.
     * 
     * Find the largest ratio of an integer n to the
     * number of relatively prime numbers that are less than
     * n, where n has a maximum value of 1000000.
     * 
     * Easy problem to write, but a pain to wait for.
     */
    public static void problem69()
    {
        int biggestN = 6;
        double smallestValue = 3;
        for(int i = 2; i <= 1000000; i ++)
        {
            System.out.println(i);
            double value = (double) i / totient(i);
            if(value > smallestValue)
                biggestN = i;
        }
        
        System.out.println(biggestN);
    }
    
    public static int lcm(int a, int b)
    {
        int lcm = a * b;
        for(int m = 1; m < b; m ++)
        {
            int product = a * m;
            if(product % b == 0 && product < lcm)
                lcm = product;
        }
        
        return lcm;
    }
    
    public static int totient(int n)
    {
        int relativePrime = 1;
        for(int i = 2; i < n; i ++)
        {
            if(lcm(i, n) <= i * n)
                relativePrime ++;
        }
        
        return relativePrime;
    }
    
    /**
     * Method for problem 4. Self explanatory.
     * @author Simon Alford
     */
    public static boolean isPalindrome(long n)
    {
    	ArrayList digits = new ArrayList((int)Math.log(n) + 1);
	int i = 0;
	while(n!= 0)
	{
            digits.add(n%10);
            n/= 10;
	}
	while(digits.size() > 1)
	{
            if(digits.remove(0) != digits.remove(digits.size() - 1))
		return false;
	}
        
	return true;
    }
    
    /**
     * DARN IT!!! This should work, but the numbers are too big...
     */
    public static void problem55()
    {
        int count = 0;
        for(int i = 1; i < 10000; i ++)
        {
            if(isLychrel(i))
                count ++;
        }
        
        System.out.println(count);
    }
    
    public static boolean isLychrel(long number)
    {
        int iteration = 0;
        while(iteration <= 50)
        {
            if(isPalindrome(number) && number != 196)
                return false;
            
            if(number != 196)
                number = reverseThis(number) + number;
            
            iteration ++;
        }
        return true;
    }
    
    public static long reverseThis(long number)
    {
        int indexE;        
        String stringNumber = number + "";        
        String reverse = "";
        int length = (number + "").length();
        
        if(stringNumber.contains("E"))
            indexE = stringNumber.indexOf("E");
        else
            indexE = length - 1;
        
        for(int i = indexE; i >= 0; i --)
        {
            reverse += stringNumber.charAt(i);
        }
        
        System.out.println(stringNumber);
        long reversed = Long.parseLong(reverse);
        
        return reversed;
    }
    
    /**
    * I think this should work but it's too slow. I should do it faster�maybe even mathematically.
    * @author Simon Alford
    */
    public static void problem40()
    {
    	System.out.println("starting");
    	String num = "0.";
    	for(Integer i = 0; i < 1000000; i++)
    	{
    		num+=String.valueOf(i);
    	}
    	int j = 1;
    	int val = 1;//hi
    	while(j <= 100000)
    	{
    		j = j*10;
    		System.out.println(Integer.parseInt(num.substring(j+1, j + 2)));
    		val = val*Integer.parseInt(num.substring(j+1, j + 2));
    	}
    	System.out.println(val);
    }
    
	/**
     * @author Manu Singhal
     * ARGHHH THIS IS WRONG
     * I'LL FIX THIS LATER
     */
    public static void problem5()
    {
        System.out.println((int) (Math.pow(2, 10) * Math.pow(3, 6) * Math.pow(4, 5) * Math.pow(5, 4) * Math.pow(6, 3)
        		* Math.pow(7, 2) * Math.pow(8, 2) * Math.pow(9, 2) * 100 * 11 * 12 * 13 *14 * 15 * 16 * 17 * 18 * 19 * 20));
    }
    
	/**
	 * @author Simon Alford
	 * Still working on this.
	 */
	public static void problem31()
	{
		ArrayList<Integer> coins = new ArrayList<Integer>(Arrays.asList(1,2,5,10,20,50,100));
		
		int numOfWays = 1 + numOfWays(coins, 100); //auto count in the number of ways with the 2 pound coin;
	}
	
	/**
	 * Recursive method I'm working on for problem 30. It doesn't work yet.
	 * @author Simon Alford
	 * @param coins
	 * @param sum
	 * @return number of ways to make the sum with the arraylist of coins.
	 */
	public static int numOfWays(ArrayList<Integer> coins, int sum)
	{
		int numOfWays = 0;
		ArrayList<Integer> hi = coins;
		int i;
		for(Integer temp: coins)
		{
			i = 1;
			while(temp*i < sum)
			{
				numOfWays += numOfWays(hi, sum - temp*i);
				i++;
			}
		}
		
		return numOfWays;
	}	
	
    /**
     * @author Manu Singhal
     * Find the smallest triangular number
     * that has over 500 factors. 
     * 
     * Firstly, find a triangular number. I did
     * this using a while loop with a non-local 
     * iterator. After that I used factorMe (below)
     * to find the number of factors. Compare the 
     * number of factors to 500, and exit the loop.
     * 
     * This takes too long to give an answer in a reasonable amount of time.
     * Or maybe it's just broken. -Simon
     * 
     * @return highlyDivisble - the smallest triangular
     * number that has over 500 factors
     */
    public static int problem12()
    {
        boolean foundIt = false;
        int highlyDivisible = 0;
        int iteration = 500;
        while(!foundIt)
        {
            int triNum = iteration * (iteration + 1) / 2;
            
            if(factorMe(triNum) > 500)
            {
                highlyDivisible = triNum;
                foundIt = true;
            }
            iteration++;
        }
        return highlyDivisible;
    }
    
    /**
     * @author Manu Singhal
     * Used for problem 12 above.
     * @return numFactors - the number of factors
     * this thing has
     */
    public static int factorMe(int i)
    {
        int numFactors = 0;
        for(int j = 1; j <= i; j ++)
        {
            if(i % j == 0)
                numFactors++;
        }
        return numFactors;
    }
	
    /**
     * @author Simon Alford
     * This problem is so hard. I basically copied all this from a website and it still doesn't work.
     */
	public static void problem15v2()
	{
		System.out.println(recGrid(10,10));
	}
	
	/**
	 * This doesn't work but it's for problem 15.
	 * @author Simon Alford
	 * @param xDim
	 * @param yDim
	 * @return
	 */
	public static long recGrid(int xDim, int yDim)
	{
		if(xDim ==0 && yDim == 0)
		{
			return 1;
		}
		long paths = 0;
		if(xDim > 0)
			paths += recGrid(xDim - 1, yDim);
		if(yDim > 0)
			paths += recGrid(xDim, yDim - 1);
		return paths;
	}
	
	/**
	 * @author Simon Alford
	 * what a load of garbage. And to think I spent all that time filling in that multidimensional array.
	 */
	public static void problem18()
	{
		int[][] nums = { {00,00,00,00,00,00,00,00,00,00,00,00,00,00,75,00,00,00,00,00,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,00,00,00,00,00,95,00,64,00,00,00,00,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,00,00,00,00,17,00,47,00,82,00,00,00,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,00,00,00,18,00,35,00,87,00,10,00,00,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,00,00,20,00,04,00,82,00,47,00,65,00,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,00,19,00,01,00,23,00,75,00,03,00,34,00,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,00,88,00,02,00,77,00,73,00,07,00,63,00,67,00,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,00,99,00,65,00,04,00,28,00,06,00,16,00,70,00,92,00,00,00,00,00,00,00} ,
						 {00,00,00,00,00,00,41,00,41,00,26,00,56,00,83,00,40,00,80,00,70,00,33,00,00,00,00,00,00} ,
						 {00,00,00,00,00,41,00,48,00,72,00,33,00,47,00,32,00,37,00,16,00,94,00,29,00,00,00,00,00} ,
						 {00,00,00,00,53,00,71,00,44,00,65,00,25,00,43,00,91,00,52,00,97,00,51,00,14,00,00,00,00} ,
						 {00,00,00,70,00,11,00,33,00,28,00,77,00,73,00,17,00,78,00,39,00,68,00,17,00,57,00,00,00} ,
						 {00,00,91,00,71,00,52,00,38,00,17,00,14,00,91,00,43,00,58,00,50,00,27,00,29,00,48,00,00} ,
						 {00,63,00,66,00,04,00,68,00,89,00,53,00,67,00,30,00,73,00,16,00,69,00,87,00,40,00,31,00} ,
						 {04,00,62,00,98,00,27,00,23,00, 9,00,70,00,98,00,73,00,93,00,38,00,53,00,60,00,04,00,23} };
		//nums[y][x];
		//System.out.println(nums[3].length);
		//System.out.println(nums.length);
		
		int[] sums = new int[16384];
		boolean[] path = new boolean[14];
		boolean[] maxPath;
		int pos, sum, maxSum = 0;
		
		for(int i = 0; i < 16384; i++)
		{
			increment(path);
			pos = 14;
			sum = 0;
			for(int j = 0; j < 14; j++)
			{
				sum+=nums[j][pos];
				if(path[j])
				{
					pos++;
				}else{
					pos--;
				}
			}
			if(sum > maxSum)
				maxSum = sum;
		}
		System.out.println(maxSum);
	}
	
	/**
	 * This is for that load of garbage problem 18.
	 * @author Simon Alford
	 * @param array
	 */
	public static void increment(boolean[] array)
	{
		boolean flip = array[array.length -1];
		array[array.length - 1] = !array[array.length - 1];
		int i = array.length - 2;
		while(flip && i > -1)
		{
			flip = array[i];
			array[i] = !array[i];
			i--;
		}
	}
	
	public static void main(String[] args)
	{
            System.out.println(problem12());
	}
}
