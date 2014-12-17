
import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simon Alford
 */
 import java.math.*;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/*
 * Howdy y'all. Here's most of the project euler code I've written.
 * Not all of these methods still work, and some never worked in the first place.
 * I started commenting but you get the idea:
 * -I write the solution to each problem in a static method called problemX()
 * -This way I can have a clumped up solution to each problem in the history that can be rerun any time
 * 		simply by inserting that method into the main method.
 * 		I've found this quite effective.
 * These are all of my methods. Sorry if there are duplicates with Manu's.
 * --Simon
 */	
public class Euler2 
{
	
	//Still working on this one, it's not quite working yet.
	public static void problem30()
	{
		ArrayList<Integer> coins = new ArrayList(Arrays.asList(8,5,1));
		System.out.println(waysToMake(14, coins));
	}
	
	//A useful testing method for printing an arraylist
	static void printAL(ArrayList<Integer> list)
	{
		System.out.print("[");
		for(int i = 0 ; i < list.size(); i++)
		{
			System.out.print(list.get(i) + ", ");
		}
		System.out.println("]");
	}
	
	//for problem 30. again, not quite working yet. 
	public static int waysToMake(int c, ArrayList<Integer> listOfCoins)
	{
		int cents = c;
		ArrayList<Integer> coins = listOfCoins;
		
		if(coins.size() < 2 || cents == 0)
		{
			System.out.println("!");
			return 1;
		}
		
		int coin, temp, size = coins.size(), num = 0;
		
		for(int j = 0; j < size - 1; j++)
		{
			System.out.println("j=" + j + ", size = " + size);
			temp = coins.remove(0);
			System.out.println("temp=" + temp + ", cents = " + cents);
			if(size == 0)
			{
				System.out.println("?");
				num++;
			}else{
				
				for(int i = 1; temp*i <= cents; i++)
				{
					num+= waysToMake(cents - temp*i, coins); 
					//14c with 8,5,1
					//6c with 5,1
					//6c with 1
				}
			}	
		}
		
		return num;
	}
	
	//Generates an array with all of the prime numbers under n. Any non-primes are simply filled with 0's.
	public static int[] generateSieve(int n)
	{
		int[] numbers = new int[n];
		for(int i = 1; i < numbers.length; i++)
		{
			numbers[i] = i+1;
		}
		int count = 2;
		int multiple = 2;
		while(count <= Math.sqrt(n))
		{
			while(count*multiple <= n)
			{
				numbers[count*multiple - 1] = 0;
				multiple++;
			}
			count++;
			multiple = 2;
		}
		return numbers;
	}
	//another testing method which prints an array
	public static void print(int[] array)
	{
		System.out.print("[");
		for(Object temp: array)
		{
			System.out.print(temp + ", ");
		}
		System.out.println("]");

	}
	
	//not sure what this is. Still working on it.
	static void problem31()
	{
		ArrayList<Integer> coins = new ArrayList<Integer>(Arrays.asList(1,2,5,10,20,50,100));
		
		int numOfWays = 1 + numOfWays(coins, 100); //auto count in the number of ways with the 2 pound coin;
	}
	//not sure what this is. Still working on it.
	static int numOfWays(ArrayList<Integer> coins, int sum)
	{
		int numOfWays = 0;
		ArrayList<Integer> temp = coins;
		int i;
		for(Integer temp: coins)
		{
			i = 1;
			while(temp*i < sum)
			{
				numOfWays += numOfWays(temp, sum - temp*i);
				i++;
			}
		}
		
		return numOfWays;
	}
	
	static void problem28()
	{
		int sum = 1;
		for(int i = 3; i <= 1001; i+=2)
		{
			sum+=4*i*i - 6*(i-1);
		}
		System.out.println(sum);
	}
	
	static void problem30v2()
	{
		long i = 2, k, sum, totalSum = 0;
		int j;
		long[] digits = new long[10];
		
		while(i++ < 1000000000)
		{
			k = i;
			j = 0;
			sum = 0;
			
			while(k!= 0)
			{
				sum += Math.pow(k % 10, 5);
				k/= 10;
			}
			if(sum == i)
			{
				totalSum+=i;
				System.out.println(i + "\t" + totalSum);
			}
		}
	}
	
	static void problem29()
	{
		BigInteger answer;
		ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
		for(int i = 2; i < 101; i++)
		{
			for(int j = 2; j < 101; j++)
			{
				answer = BigInteger.valueOf(i).pow(j);
				if(!numbers.contains(answer))
				{
					numbers.add(answer);
				}
			}
		}
		System.out.println(numbers.size());
	}
	
	static void problem27()
	{
		int[] primes = eSieve(10000000);
		int maxA = 0, maxB = 0, maxConsec = 1, consec;
		
		for(int a = -999; a < 1000; a++)
		{
			System.out.println(a);
			for(int b = 0; primes[b] < 1000; b++)
			{
				consec = 0;
				while(isPrime((consec*consec + a*consec + primes[b]), primes))
				{
					consec++;
				}
				if(consec > maxConsec)
				{
					maxA = a;
					maxB = primes[b];
					maxConsec = consec;
					System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
				}
				consec = 0;
				while(isPrime((consec*consec + a*consec - primes[b]), primes))
				{
					consec++;
				}
				if(consec > maxConsec)
				{
					maxA = a;
					maxB = -primes[b];
					maxConsec = consec;
					System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
				}
			}
			System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
		}
	}
	
	static boolean isPrime(int n, int[] sieve)
	{
		n = Math.abs(n);
		for(int temp: sieve)
		{
			if(n == temp)
			{
				return true;
			}
			if(n < temp)
			{
				return false;
			}
		}
		return false;
	}
	
	static void problem28v2()
	{
		int n = 3, counter = 1, increment = 2;
		long sum = 1;
		while(n + increment <= (int) Math.pow(1001, 2))
		{
			n+=increment;
			sum += n;
			
			if(++counter % 4 == 0)
			{
				increment +=2;
			}
		}
		System.out.println(sum);
	}
	
	static void problem26()
	{
		final long startTime = System.currentTimeMillis();
		String answer;
		int maxLength = 0, maxNum = 0, length;
		
		for(int number = 999; number > 1; number--)
		{
			if(number < maxLength)
			{
				break;
			}
			length = 1;
			answer = BigDecimal.ONE.divide(BigDecimal.valueOf(number),5000,RoundingMode.HALF_UP).toString();
			while(!answer.substring(100, 100 + length).equals(answer.substring(length + 100, 2*length + 100))) 
			{	
				length++;
			}
			if(length > maxLength)
			{
				maxNum = number;
				maxLength = length;
			}
		}
		final long endTime = System.currentTimeMillis();
		
		System.out.println(String.format("Value of D = %d", maxNum));
		System.out.println(String.format("Cycle = %d digits", maxLength));
		System.out.println(String.format("Time elapsed: %d ms", endTime - startTime));
		
	}
	
	static int perm(int num)
	{
		return 0;
	}
	
	public static void problem23()
	{
		 ArrayList<Integer> abundants = new ArrayList<Integer>();
		 int[] primesList = eSieve(28123);
		 int[] nums = new int[28123];
		
		 for(int i = 1; i < 28123; i++)
		 {
			 nums[i-1] = i;
			 if(sumOfProperDivisors(i, primesList) > i)
				 abundants.add(i);
		 }
		 int a,b;
		 for(int i = 0; i < abundants.size(); i++)
		 {
			 a = abundants.get(i);
			 for(int j = i; j < abundants.size(); j++)
			 {
				b = abundants.get(j);
				if(a+b < 28124)
					nums[a + b - 1] = 0;
			 }
		 }
		 int sum = 0;
		 for(int temp: nums)
		 {
			 sum+= temp;
		 }
		 System.out.println(sum);
		 
	}

	public static int[] eSieve(int n) 
	{
			int[] eSieve = new int[(int)(n/2)];
			
	        // initially assume all integers are prime
	        boolean[] isntPrime = new boolean[n +1];

	        // mark non-primes <= N using Sieve of Eratosthenes
	        for (int i = 2; i*i <= n; i++) {

	            // if i is prime, then mark multiples of i as nonprime
	            // suffices to consider multiples i, i+1, ..., N/i
	            if (!isntPrime[i]) {
	                for (int j = i; i*j <= n; j++) {
	                    isntPrime[i*j] = true;
	                }
	            }
	        }
	        int count = 0;
	        for(int i = 2; i < isntPrime.length; i++)
	        {
	        	if(!isntPrime[i])
	        	{
	        		eSieve[count++] = i;
	        	}	
	        }
	        return eSieve;
	}
	
	public static int sumOfProperDivisors(int number, int[] primes)
	{
		int n = number;
		int sum = 1;
		int p = primes[0];
		int j;
		int i = 0;
		//see if it is a prime factor. if it is, then n = n/p ,and multiply it to the sum
		while(p*p <= n)
		{
			j = p = primes[i];
			i++;
			while(n % p == 0)
			{
				n = n / p;
				j = j*p;
			}
			sum *= (j-1)/(p-1);
		}
		if (n > 1) {
	        sum *= n + 1;
	    }
		
		return sum - number;
	}

	public static void problem25()
	{
		BigInteger first = BigInteger.ONE;
		BigInteger second = first;
		BigInteger temp;
		long count = 2;
		
		while(second.divide(BigInteger.TEN.pow(999)).equals(BigInteger.ZERO))
		{
			count++;
			temp = second;
			second = second.add(first);
			first = temp;
		}
		System.out.println(count);
	}
	
	public static void problem22() throws IOException
	{
		String nameFile = "p022_names.txt";
		String names = "";
		
		try{
			
			ReadFile file = new ReadFile(nameFile);
			names = file.openFile()[0];
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage() );
		}
		
		names = names + ",end";
		String[] seperatedNames = new String[5163];
		int count = 0;
			while(!names.equals("end"))
			{
				seperatedNames[count] = names.substring(1,names.indexOf('"',2)).toLowerCase();
				names = names.substring(seperatedNames[count].length() + 3);
				count++;
			}
			
			String temp;
			for(int i = 0; i < seperatedNames.length; i++)
			{
				for(int j = i + 1; j < seperatedNames.length; j++)
				{
					if(seperatedNames[i].compareTo(seperatedNames[j]) > 0)
					{
						temp = seperatedNames[i];
						seperatedNames[i] = seperatedNames[j];
						seperatedNames[j] = temp;
					}
				}
			}
			
			long sumOfScores = 0;
			for(int i = 0; i < seperatedNames.length; i++)
			{
				sumOfScores += (i+1)*worthOf(seperatedNames[i]);
			}
			System.out.println(sumOfScores);		
	}
	
	public static int worthOf(String name)
	{
		int worth = 0;
		String alphabet = " abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < name.length(); i++)
		{
			worth += alphabet.indexOf(name.charAt(i));
		}
		return worth;
	}
	
	public static void problem21()
	{
		int sum = 0;
		for(int i = 1; i < 10000; i++)
		{
			if(i == d(d(i)) && i != d(i))
			{	
				sum+=i;
			}
		}
		System.out.println(sum);
		
	}
	/*
	 * Function defined from problem 21.
	 * Something like the sum of all of it's divisors < n.
	 */
	public static int d(int n) 
	{
		int sum = 1;
		int i = 1;
		while(i < n/2)
		{
			if(n % ++i ==0)
			{
				sum+=i;
			}
		}
		return sum;
	}
	
	public static void problem20()
	{
		BigInteger answer = new BigInteger("100");
		BigInteger product = new BigInteger("99");
		while(!product.equals(BigInteger.ONE))
		{
			answer = answer.multiply(product);
			product = product.subtract(BigInteger.ONE);
		}
		BigInteger sum = BigInteger.ZERO;
		while(!answer.equals(BigInteger.ZERO))
		{
			sum = sum.add(answer.remainder(BigInteger.TEN));
			answer = answer.divide(BigInteger.TEN);
		}
		System.out.println(sum.toString());
	}
	
	public static void problem19()
	{
		System.out.println(numOfSundays(2000));
	}
	
	public static int numOfSundays(int endDate)
	{
		int[] year = {2,5,5,1,3,6,1,4,7,2,5,7,1900}; // this is for 1900
		int numOfSundays = 0;
		int add = 1;
		
		for(int i = 1901; i < endDate + 1; i++)
		{
			//the following code shifts forward one year, accounting for leap years:
				year[12]++; // this is the actual year.
				
				year[0] += add; //january gets forward one day.
				year[1] += add; // etc.
				if(add == 2)
				{
					add = 1;
				}else if( (year[12]) % 4 == 0 && (year[12] % 100 != 0 || year[12] == 2000))
				{
					System.out.println("LEAP!");
					add = 2;
				}	
				year[2] += add;
				year[3] += add;
				year[4] += add;
				year[5] += add;
				year[6] += add;
				year[7] += add;
				year[8] += add;
				year[9] += add;
				year[10] += add;
				year[11] += add;
				
				for(int j = 0; j < 12; j++)
				{
					if(year[j] == 8)
					{
						year[j] = 1;
					}else if(year[j] == 9)
					{
						year[j] = 2;
					}
					if(year[j] == 1)
					{
						numOfSundays++;
					}
				}
			
			print(year);
			System.out.println(numOfSundays);
		}
		
		return numOfSundays;
	}
	
	public static void next(int[] array, int add)
	{	
		array[12]++;
		array[0] += add;
		array[1] += add;
		array[2] += add;
		if(add == 2)
		{
			add = 1;
		}else if( (array[12]) % 4 == 0 && (array[12] % 100 != 0 || array[12] == 2000))
		{
			System.out.println("LEAP!");
			add = 2;
		}	
		array[3] += add;
		array[4] += add;
		array[5] += add;
		array[6] += add;
		array[7] += add;
		array[8] += add;
		array[9] += add;
		array[10] += add;
		array[11] += add;
	}
	
	public static void problem15v2()
	{
		System.out.println(recGrid(13,13));
	}
	
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
	
	public static void problem17()
	{
		int sum = 11+ 10*854 + 36*99 + 90*100;
		System.out.println(sum);
		String one = "onetwothreefourfivesixseveneightnine";
		System.out.println(one.length());
		String two = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
		System.out.println(two.length());
		//1-9 = 36;
		//10 - 19 = 70;
		//20 - 29 = 10*6 + 36
		/*6,6,5,5,5,7,6,6
		= 
		1-99 = 36 + 70 + 36*8 + 10*46; = 854;
		hundred = 7 + 3 + (3,3,5,4,4,3,5,5,4)
		100-199 = 854 + 3*99 + 10*100 = 2151
		200-299 = 854 + 3*99 + 10*100 = 
		3,4,5,6,7,8,9
		one thousand = 11;
		11+ 10*854 + 36*99 + 90*100*/
		
	}
	
	public static void problem16()
	{
		BigInteger two = new BigInteger("2");
		BigInteger num = new BigInteger("2");
		for(int i = 0; i < 1000; i++)
		{
			num = num.multiply(two);
			
		}
		int[] nums = new int[100];
		for(int i = 0; i < 1; i++)
		{
			nums[i] = num.intValue();
			System.out.println(nums[i]);
		}
			
	}	
	
	public static void problem15(int n)
	{
		int possiblePaths = 0;
		boolean[] path = new boolean[n+1];
		path[n] = true;
		while(!path[0])
		{
			increment(path);
			if(isValid(path))
			{
				possiblePaths++;
			}
		}
		System.out.println(possiblePaths);
	}
	
	public static boolean isValid(boolean[] array)
	{
		int trues = 0;
		for(Boolean temp: array)
		{
			if(temp)
				trues++;
		}
		return trues == 10;
	}
	

	
	public static void problem14v2()
	{
		int max = 1;
		int starter = 1;
		int k;
		for(int i = 2; i < 1000000; i++)
		{
			k = collatz(i);
			if(k > max)
			{
				max = k;
				starter = i;
			}
		}
		System.out.println(max);
		System.out.println(starter);
	}
	
	
	public static int collatz(long n)
	{
		int count = 0;
		while(n > 1)
		{
			count++;
			if(n%2 == 0)
			{
				n = n/2;
			}else{
				n = 3*n + 1;
			}
			
		}
		return count;
	}
	
	
	public static void problem14v3()
	{
		/*
		 * go through numbers 1-1000000
		 * go to next term in series.
		 * add this term to the list
		 * once you finally get to one, go through all of these numbers
		 * if they are less than 1 million, add them to length array
		 * for the first number, if it is greater than the max, make it the max
		 * 
		 * 
		 * 
		 * 
		 */
		long[] length = new long[1000000];
		length[0] = 1;
		
		ArrayList<Long> TO_ADD = new ArrayList<Long>(); //numbers who haven't been logged
		long count;
		long n;
		int p;
		long q;
		int newLength;
		int maxLength = 1;
		int maxNum = 1;
		for(long i = 2; i <= 1000000; i++)
		{
			n = i;
			count = 0; //count shows position in the array.
			TO_ADD.clear();
			while(n > 1000000 || 0 == length[(int)n-1])
			{
				TO_ADD.add(n);
				count++;
				if(0 == n%2)
				{
					n = n/2;
				}else
				{
					n = 3*n + 1;
				}			
			}
			// now n has been logged in length
			for(int j = 0; j < s; j++)
			{
				q = TO_ADD.get(j);
				if(q <= 1000000)
				{
					newLength = p + s - j;
					length[(int)q-1] = newLength;
					if(newLength > maxLength)
					{
						maxLength = newLength;
						maxNum = (int)i;
					}
				}
			}			
		}
		
		System.out.println(maxLength + " " + maxNum);
	}
	
	
	public static void problem14()
	{
		ArrayList<Long> logged = new ArrayList<Long>();
		ArrayList<Integer> iterations = new ArrayList<Integer>();

		logged.add(1L);
		logged.add(2L);
		iterations.add(1);
		iterations.add(2);
		long n;
		int initSize;
		
		ArrayList<Integer> chain = new ArrayList<Integer>(); //numbers who haven't been logged
		
		for(long i = 3; i <= 1000000; i++)
		{
			n = i;
			initSize = logged.size();
			
			while(!logged.contains(n))
			{
				while(n%2 == 0 && !logged.contains(n))
				{
					logged.add(n);
					n = n/2;
				}
				while(n% 2 == 1 && !logged.contains(n))
				{
					logged.add(n);
					n = 3*n + 1;
				}
			}
			
			for(int j = 0; j < logged.size() - initSize; j++)
			{
				iterations.add(logged.size() - initSize + iterations.get(logged.indexOf(n)) - j);
			}
			
		}
		
		int maxIndex = 1;
		
		for(int i = 0; i < logged.size(); i++)
		{
			if(logged.get(i) < 1000000 && iterations.get(i) > iterations.get(maxIndex))
				maxIndex = i;
		}
		
		System.out.println(maxIndex);
	}
	
	
	public static void problem13()

	{
		String[] nums = {"37107287533902102798797998220837590246510135740250","46376937677490009712648124896970078050417018260538",		"74324986199524741059474233309513058123726617309629",		"91942213363574161572522430563301811072406154908250",		"23067588207539346171171980310421047513778063246676",		"89261670696623633820136378418383684178734361726757",		"28112879812849979408065481931592621691275889832738",		"44274228917432520321923589422876796487670272189318",		"47451445736001306439091167216856844588711603153276",		"70386486105843025439939619828917593665686757934951",		"62176457141856560629502157223196586755079324193331",		"64906352462741904929101432445813822663347944758178",		"92575867718337217661963751590579239728245598838407",		"58203565325359399008402633568948830189458628227828",		"80181199384826282014278194139940567587151170094390",		"35398664372827112653829987240784473053190104293586",		"86515506006295864861532075273371959191420517255829",		"71693888707715466499115593487603532921714970056938",		"54370070576826684624621495650076471787294438377604",		"53282654108756828443191190634694037855217779295145",		"36123272525000296071075082563815656710885258350721",		"45876576172410976447339110607218265236877223636045",		"17423706905851860660448207621209813287860733969412",		"81142660418086830619328460811191061556940512689692",		"51934325451728388641918047049293215058642563049483",		"62467221648435076201727918039944693004732956340691",		"15732444386908125794514089057706229429197107928209",		"55037687525678773091862540744969844508330393682126",		"18336384825330154686196124348767681297534375946515",		"80386287592878490201521685554828717201219257766954",		"78182833757993103614740356856449095527097864797581",		"16726320100436897842553539920931837441497806860984",		"48403098129077791799088218795327364475675590848030",		"87086987551392711854517078544161852424320693150332",		"59959406895756536782107074926966537676326235447210",		"69793950679652694742597709739166693763042633987085",		"41052684708299085211399427365734116182760315001271",		"65378607361501080857009149939512557028198746004375",		"35829035317434717326932123578154982629742552737307",		"94953759765105305946966067683156574377167401875275",		"88902802571733229619176668713819931811048770190271",		"25267680276078003013678680992525463401061632866526",		"36270218540497705585629946580636237993140746255962",		"24074486908231174977792365466257246923322810917141",		"91430288197103288597806669760892938638285025333403",		"34413065578016127815921815005561868836468420090470",		"23053081172816430487623791969842487255036638784583",		"11487696932154902810424020138335124462181441773470",		"63783299490636259666498587618221225225512486764533",		"67720186971698544312419572409913959008952310058822",		"95548255300263520781532296796249481641953868218774",		"76085327132285723110424803456124867697064507995236",		"37774242535411291684276865538926205024910326572967",		"23701913275725675285653248258265463092207058596522",		"29798860272258331913126375147341994889534765745501",		"18495701454879288984856827726077713721403798879715",		"38298203783031473527721580348144513491373226651381",		"34829543829199918180278916522431027392251122869539",		"40957953066405232632538044100059654939159879593635",		"29746152185502371307642255121183693803580388584903",		"41698116222072977186158236678424689157993532961922",		"62467957194401269043877107275048102390895523597457",		"23189706772547915061505504953922979530901129967519",		"86188088225875314529584099251203829009407770775672",		"11306739708304724483816533873502340845647058077308",		"82959174767140363198008187129011875491310547126581",		"97623331044818386269515456334926366572897563400500",		"42846280183517070527831839425882145521227251250327",		"55121603546981200581762165212827652751691296897789",		"32238195734329339946437501907836945765883352399886",		"75506164965184775180738168837861091527357929701337",		"62177842752192623401942399639168044983993173312731",		"32924185707147349566916674687634660915035914677504",		"99518671430235219628894890102423325116913619626622",		"73267460800591547471830798392868535206946944540724",		"76841822524674417161514036427982273348055556214818",		"97142617910342598647204516893989422179826088076852",		"87783646182799346313767754307809363333018982642090",		"10848802521674670883215120185883543223812876952786",		"71329612474782464538636993009049310363619763878039",		"62184073572399794223406235393808339651327408011116",		"66627891981488087797941876876144230030984490851411",		"60661826293682836764744779239180335110989069790714",		"85786944089552990653640447425576083659976645795096",		"66024396409905389607120198219976047599490197230297",		"64913982680032973156037120041377903785566085089252",		"16730939319872750275468906903707539413042652315011",		"94809377245048795150954100921645863754710598436791",		"78639167021187492431995700641917969777599028300699",		"15368713711936614952811305876380278410754449733078",		"40789923115535562561142322423255033685442488917353",		"44889911501440648020369068063960672322193204149535",		"41503128880339536053299340368006977710650566631954",		"81234880673210146739058568557934581403627822703280",		"82616570773948327592232845941706525094512325230608",		"22918802058777319719839450180888072429661980811197",		"77158542502016545090413245809786882778948721859617",		"72107838435069186155435662884062257473692284509516",		"20849603980134001723930671666823555245252804609722",	"53503534226472524250874054075591789781264330331690"};
		BigInteger[] numbers = new BigInteger[nums.length];
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < numbers.length; i++)
		{
			sum = sum.add(new BigInteger(nums[i]));
		}
		System.out.println(sum.toString());
	}	

	static void problem8()
	{
		String number = "731671765313306249192251196744265747423553491949349698352"
				+ "0312774506326239578318016984801869478851843858615607891129494954"
				+ "5950173795833195285320880551112540698747158523863050715693290963"
				+ "29522744304355766896648950445244523161731856403098711121722383113"
				+ "6222989342338030813533627661428280644448664523874930358907296290491"
				+ "5604407723907138105158593079608667017242712188399879790879227492190"
				+ "1699720888093776657273330010533678812202354218097512545405947522435"
				+ "2584907711670556013604839586446706324415722155397536978179778461740"
				+ "6495514929086256932197846862248283972241375657056057490261407972968"
				+ "65241453510047482166370484403199890008895243450658541227588666881164"
				+ "27171479924442928230863465674813919123162824586178664583591245665294"
				+ "76545682848912883142607690042242190226710556263211111093705442175069"
				+ "41658960408071984038509624554443629812309878799272442849091888458015"
				+ "61660979191338754992005240636899125607176060588611646710940507754100"
				+ "225698315520005593572972571636269561882670428252483600823257530420752963450";
		long max = 0, n, product;
		
		for(int i = 0; i < number.length() - 14; i++)
		{
			product = 1;
			for(int j = 0; j < 13; j++)
			{
				product*=Long.parseLong(number.substring(i+j, i+j+1));
			}
			if(product > max)
				max = product;
		}
		System.out.println(max);
	}

	static void problem4()
	{
		int max = 0;
		for(int i = 100; i < 1000; i++)
		{
			for(int j = 100; j < 1000; j++)
			{
				if(isPalindrome(i*j) && i*j > max)
				{
					max = i*j;
				}
			}
		}
		System.out.println(max);
	}
	
	static boolean isPalindrome(int n)
	{
		ArrayList<Integer> digits = new ArrayList<Integer>((int)Math.log(n) + 1);
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
	
	public static int nthPrime(int n) 
	{
		int[] primes = new int[n-1];
		primes[0] = 3;
		
		for(int i = 4; i < n + 2; i++)
		{
			boolean isPrime = false;
			int j = primes[i-4];
			while(! isPrime)
			{
				j+=2;
				isPrime = true;
				for(int k = 0; primes[k] < Math.sqrt(j); k++)
				{
					if( j % primes[k] == 0)
					{
						isPrime = false;
						break;
					}
				}
				if(isPrime)
				{
					primes[i-3] = j;
				}
			}	
		}
		return primes[n-2];
	}
/*
* Here are where Manu's methods start!
*/
    public static int problem1()
    {
        int sum = 0;
        for(int i = 0; i < 1000; i ++)
        {
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }
    
    public static int problem5()
    {
        return (int) (Math.pow(2, 10) * Math.pow(3, 6) * Math.pow(4, 5) * Math.pow(5, 4) * Math.pow(6, 3) * Math.pow(7, 2) * Math.pow(8, 2) * Math.pow(9, 2) * 100 * 11 * 12 * 13 *14 * 15 * 16 * 17 * 18 * 19 * 20);
    }
    
    public static int problem6()
    {
        int sumSquares = 0;
        for(int i = 1; i < 101; i ++)
        {
            sumSquares += (i*i);
        }
        
        int squareSum = 0;
        for(int i = 1; i < 101; i ++)
        {
            squareSum += i;
        }
        squareSum = squareSum * squareSum;
        
        int difference = squareSum - sumSquares;
        
        return difference;
    }
    
    public static boolean isPrime(int num)
    {
        for(int i = 2; i <= (int)(Math.sqrt(num)); i ++)
        {
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    public static int problem10()
    {
        int sum = 0;
        for(int i = 2; i < 2000000; i ++)
        {
            if(isPrime(i))
                sum += i;
        }
        return sum;
    }
    
    public static int problem12()
    {
        boolean foundIt = false;
        int highlyDivisible = 0;
        int iteration = 1;
        while(!foundIt)
        {
            int triNum = 0;
            for(int i = 0; i <= iteration; i ++)
                triNum += i;
            
            if(factorMe(triNum) > 500)
            {
                highlyDivisible = triNum;
                foundIt = true;
            }
            iteration++;
        }
        return highlyDivisible;
    }
    
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
    
    public static int problem29()
    {
        HashSet powers = new HashSet();
        
        for(int a = 2; a <= 100; a ++)
        {
            for(int b = 2; b <= 100; b ++)
            {
                double power = Math.pow(a, b);
                powers.add(power);
            }
        }
        
        for(Object p : powers)
            System.out.println(p);
        
        return powers.size();
    }
    
    public static void main(String[] args)
    {
        System.out.println(problem5());
    }
}
