import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Hi! This is the file that contains the solutions
 * to a few of the Project Euler problems. The 
 * problems can be found at projecteuler.net/problems.
 *
 * Now this class could easily become a mess with so many methods,
 * so do be careful to include methods the correct way if you're adding anything.
 * 
 * Here's some tips:
 * 
 *  1. This class is only for solutions that have already been shown to work. If you
 *     have a solution that's still being made, or one that worked but now doesn't for
 *     some reason, put it in class ProjectEulerTrash.
 *  2. Each question gets its own method, labeled as
 *     problemX(), where X is the number id of the problem
 *     on the Project Euler website. All methods are 
 *     static, so that they can be accessed without making
 *     a ProjectEuler object. Inside each method, you will
 *     see how we decided to solve it, hopefully with comments
 *     explaining why we did what we and why we didn't do what 
 *     we didn't. Above each method, hopefully, you will find a 
 *     javadoc explain what the problem hopes to solve and how 
 *     we went around doing it.
 *  3. Often an effective solution of a problem will require outside helper methods
 *     outside of the problemX() method. This is fine, just try to make clear in
 *     comments what this outside method is used for and such.
 *  4. If a method for your problemX() already exists, you can name it problemXSimon()
 *     or whatever your name is. You can do this for helper methods too.
 *  5. For ease of use, keep the numerical order of problemX() methods, with smaller
 *     numbers at the top. Also, keep helper methods next to whichever problem they
 *     are used for.
 *     
 *     If you changed this file, add your name here.
 * @author Simon Alford, Manu Singhal
 *
 * Problems completed:
 *  1, 4, 6, 7, 8, 10, 13, 14, 16, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30
 *  
 *  As always, contact Manu S.
 * (singhalmanu9 on GitHub) or visit the GitHub repository
 * (www.github.com/DCHSProgrammingClub/ProjectEuler) if you have
 * any questions, comments, or concerns. Thanks!
 */
public class Euler3 {

	/**
     * Find the sum of all multiples of
     * 3 or 5.
     * I immediately thought of a for loop
     * for this problem. Pretty easy, took
     * about 5 minutes to write and test.
     * 
     * @author Manu Singhal
     */
    public static void problem1()
    {
        int sum = 0;
        for(int i = 0; i < 1000; i ++)
        {
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        System.out.println(sum);
    }
    
    /**
     * Problem 4. self explanatory, I think.
     * @author Simon Alford
     */
    public static void problem4()
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
    
	/**
	 * Method for problem 4. Self explanatory.
	 * @author Simon Alford
	 */
	public static boolean isPalindrome(int n)
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
   
    /**
     * @author Manu Singhal
     * Find the difference of the sum of the
     * squares of the first 100 integers and
     * the square of the sum of the first 100
     * integers.
     * 
     * Pretty straightforward. Use a for loop
     * to sum all of the squares and another
     * to sum the integers, then square it.
     * One elementary operation is all that is
     * needed to solve the problem.
     * 
     * @return difference - the difference
     * of the square of the sums and the sum
     * of the squares. 
     */
    public static void problem6()
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
        
        System.out.println(difference);
    }
    
    /**
     * @author Manu Singhal
     */
    public static void problem7()
    {
        int prime = 0;
        int currentNumber = 2;
        while(prime < 10001)
        {
            if(isPrime(currentNumber))
                prime ++;
            
            currentNumber++;
        }
        
       System.out.println(currentNumber);
    }
    
    /**
     * @author Simon Alford
     */
    public static void problem8()
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
    
    /**
     * @author Manu Singhal
     * Needed this for problem 10.
     */
    public static boolean isPrime(int num)
    {
        for(int i = 2; i <= (int)(Math.sqrt(num)); i ++)
        {
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    /**
     * @author Manu Singhal
     * Find the sum of the primes less than 
     * two million. 
     * 
     * Pretty easy, use a for loop to find the
     * primes less than 2,000,000 and sum them
     * up.
     * 
     * @return sum - the sum of the primes less
     * than two million
     */
    public static void problem10()
    {
        long sum = 0;
        for(int i = 2; i < 2000000; i ++)
        {
            if(isPrime(i))
                sum += i;
        }
        System.out.println(sum);
    }
    
    /**
     * @author Simon Alford
     */
    public static void problem13()
	{
		String[] nums = {"37107287533902102798797998220837590246510135740250",
					    "46376937677490009712648124896970078050417018260538","74324986199524741059474233309513058123726617309629",
						"91942213363574161572522430563301811072406154908250","23067588207539346171171980310421047513778063246676",
						"89261670696623633820136378418383684178734361726757","28112879812849979408065481931592621691275889832738",
						"44274228917432520321923589422876796487670272189318","47451445736001306439091167216856844588711603153276",
						"70386486105843025439939619828917593665686757934951","62176457141856560629502157223196586755079324193331",
						"64906352462741904929101432445813822663347944758178","92575867718337217661963751590579239728245598838407",
						"58203565325359399008402633568948830189458628227828","80181199384826282014278194139940567587151170094390",
						"35398664372827112653829987240784473053190104293586","86515506006295864861532075273371959191420517255829",
						"71693888707715466499115593487603532921714970056938","54370070576826684624621495650076471787294438377604",
						"53282654108756828443191190634694037855217779295145","36123272525000296071075082563815656710885258350721",
						"45876576172410976447339110607218265236877223636045","17423706905851860660448207621209813287860733969412",
						"81142660418086830619328460811191061556940512689692","51934325451728388641918047049293215058642563049483",
						"62467221648435076201727918039944693004732956340691","15732444386908125794514089057706229429197107928209",
						"55037687525678773091862540744969844508330393682126","18336384825330154686196124348767681297534375946515",
						"80386287592878490201521685554828717201219257766954","78182833757993103614740356856449095527097864797581",
						"16726320100436897842553539920931837441497806860984","48403098129077791799088218795327364475675590848030",
						"87086987551392711854517078544161852424320693150332","59959406895756536782107074926966537676326235447210",
						"69793950679652694742597709739166693763042633987085","41052684708299085211399427365734116182760315001271",
						"65378607361501080857009149939512557028198746004375","35829035317434717326932123578154982629742552737307",
						"94953759765105305946966067683156574377167401875275","88902802571733229619176668713819931811048770190271",
						"25267680276078003013678680992525463401061632866526","36270218540497705585629946580636237993140746255962",
						"24074486908231174977792365466257246923322810917141","91430288197103288597806669760892938638285025333403",
						"34413065578016127815921815005561868836468420090470","23053081172816430487623791969842487255036638784583",
						"11487696932154902810424020138335124462181441773470","63783299490636259666498587618221225225512486764533",
						"67720186971698544312419572409913959008952310058822","95548255300263520781532296796249481641953868218774",
						"76085327132285723110424803456124867697064507995236","37774242535411291684276865538926205024910326572967",
						"23701913275725675285653248258265463092207058596522","29798860272258331913126375147341994889534765745501",
						"18495701454879288984856827726077713721403798879715","38298203783031473527721580348144513491373226651381",
						"34829543829199918180278916522431027392251122869539","40957953066405232632538044100059654939159879593635",
						"29746152185502371307642255121183693803580388584903","41698116222072977186158236678424689157993532961922",
						"62467957194401269043877107275048102390895523597457","23189706772547915061505504953922979530901129967519",
						"86188088225875314529584099251203829009407770775672","11306739708304724483816533873502340845647058077308",
						"82959174767140363198008187129011875491310547126581","97623331044818386269515456334926366572897563400500",
						"42846280183517070527831839425882145521227251250327","55121603546981200581762165212827652751691296897789",
						"32238195734329339946437501907836945765883352399886","75506164965184775180738168837861091527357929701337",
						"62177842752192623401942399639168044983993173312731","32924185707147349566916674687634660915035914677504",
						"99518671430235219628894890102423325116913619626622","73267460800591547471830798392868535206946944540724",
						"76841822524674417161514036427982273348055556214818","97142617910342598647204516893989422179826088076852",
						"87783646182799346313767754307809363333018982642090","10848802521674670883215120185883543223812876952786",
						"71329612474782464538636993009049310363619763878039","62184073572399794223406235393808339651327408011116",
						"66627891981488087797941876876144230030984490851411","60661826293682836764744779239180335110989069790714",
						"85786944089552990653640447425576083659976645795096","66024396409905389607120198219976047599490197230297",
						"64913982680032973156037120041377903785566085089252","16730939319872750275468906903707539413042652315011",
						"94809377245048795150954100921645863754710598436791","78639167021187492431995700641917969777599028300699",
						"15368713711936614952811305876380278410754449733078","40789923115535562561142322423255033685442488917353",
						"44889911501440648020369068063960672322193204149535","41503128880339536053299340368006977710650566631954",
						"81234880673210146739058568557934581403627822703280","82616570773948327592232845941706525094512325230608",
						"22918802058777319719839450180888072429661980811197","77158542502016545090413245809786882778948721859617",
						"72107838435069186155435662884062257473692284509516","20849603980134001723930671666823555245252804609722",
						"53503534226472524250874054075591789781264330331690"};
		BigInteger[] numbers = new BigInteger[nums.length];
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < numbers.length; i++)
		{
			sum = sum.add(new BigInteger(nums[i]));
		}
		System.out.println(sum.toString().substring(0, 10));
	}
    
    /**
     * @author Simon Alford
     * I'm pretty sure this was just my brute force version of this problem. 
     * If anyone wants to replace it with a recursive/storing version, go ahead.
     * Because it's really a pretty neat problem.
     */
    public static void problem14()
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
	
	/**
	 * @author Simon Alford
	 * @param n
	 * @return the number of steps taken to reach 1 as defined by the Collatz sequence
	 */
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
	/**
	 * @author Simon Alford
	 * I like using BigInteger. it makes me feel powerful.
	 */
	public static void problem16()
	{
		String number = new BigInteger("2").pow(1000).toString();
		int sum = 0;
		for(int i = 0; i < number.length(); i++)
		{
			sum+=Integer.parseInt(number.substring(i,  i+1));
		}	
		System.out.println(sum);
	}
	
	/**
	 * @author Simon Alford
	 * I have a bunch of displaying going on to make it clearer for debugging
	 */
	public static void problem19()
	{
		int[] year = {2,5,5,1,3,6,1,4,7,2,5,7,1900}; // this is for 1900
		int endDate = 2000;
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
		
		System.out.println(numOfSundays);
	}
	
	/**
	 * @author Simon Alford
	 */
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
	
	/**
	 * Useful testing method which prints an int[]
	 * @author Simon Alford
	 * @param array
	 */
	public static void print(int[] array)
	{
		System.out.print("[");
		for(Object temp: array)
		{
			System.out.print(temp + ", ");
		}
		System.out.println("]");
	}
	
	/**
	 * @author Simon Alford
	 */
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
	/**
	 * Function defined from problem 21.
	 * Something like the sum of all of it's divisors < n.
	 * @author Simon Alford
	 **/
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
	
	/**
	 * @author Simon Alford
	 */
	public static void problem22()
	{
		//if you're going to run this, change it so that this is the correct path
		String nameFile = "/Users/Simon/Desktop/Fun/p022_names.txt";
		String names = "";
		
		try{
			
			BufferedReader bf = new BufferedReader(new FileReader(nameFile));
			String line;

			while((line = bf.readLine()) != null)
			{
				names+=line;
			}
			
			bf.close();
		
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
				
		}catch(IOException e)
		{
			System.out.println(e.getMessage() );
		}
	}
	/**
	 * This is for problem 22.
	 * @author Simon Alford
	 * @param name
	 * @return int, the worth of the string as defined by problem 22.
	 */
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
	
	/**
	 * @author Simon Alford
	 * Uses eSieve() method to make a list of primes useful for finding sumOfProperDivisors.
	 * uses sumOfProperDivisors() method also.
	 */
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
	
	/**
	 * Creates a Sieve of Erasthenos for problem 23 to help with speed
	 * in finding the sum of proper divisors.
	 * @author Simon Alford
	 * @param n
	 * @return a sieve of prime numbers under n, I believe.
	 */
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
	
	/**
	 * Method for problem 23. Returns the sum of the proper divisors of a number. 
	 * Uses an int[] with all of the needed primes in it for speed.
	 * @author Simon Alford
	 * @param number
	 * @param primes
	 * @return
	 */
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
	
	/**
	 * @author Simon Alford
	 */
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
	
	/**
	 * @author Simon Alford
	 */
	public static void problem26()
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
			//answer = 1/number to 5000 decimal places
			answer = BigDecimal.ONE.divide(BigDecimal.valueOf(number),5000,RoundingMode.HALF_UP).toString();
			//starts at 100 in case there's a number that goes .092345789999999999 and doesn't start repeating for a while
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
	
	/**
	 * @author Simon Alford
	 * uses the eSieve() method to main a list of primes under a million bajillion
	 */
	public static void problem27()
	{
		int[] primes = eSieve(10000000);
		int maxA = 0, maxB = 0, maxConsec = 1, consec;
		
		for(int a = -999; a < 1000; a++)
		{
			//System.out.println(a);
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
					//System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
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
					//System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
				}
			}
			//System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
		}
		System.out.println(maxA*maxB);
	}
	
	/**
	 * Method for problem 27.
	 * @author Simon Alford
	 * @param n
	 * @param sieve, an array filled with primes, at least up to n.
	 * @return true if the number is prime, false otherwise
	 */
	public static boolean isPrime(int n, int[] sieve)
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
	
	/**
	 * @author Simon Alford
	 * This one turned out to be a nice mathematical way to do it, so there you go.
	 */
	public static void problem28()
	{
		int sum = 1;
		for(int i = 3; i <= 1001; i+=2)
		{
			sum+=4*i*i - 6*(i-1);
		}
		System.out.println(sum);
	}
    
    /**
     * @author Manu Singhal
     * Find the amount of unique powers of
     * a^b, where a and b are between 1000.
     * 
     * This one was screaming Set. Used the set
     * and added the powers, no need to check
     * if the power was already there because the
     * HashSet already does that.
     * 
     * @return - the size of the Set of powers
     */
    public static void problem29()
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
        
        // Just for debugging
        //for(Object p : powers)
        //    System.out.println(p);
        
       System.out.println(powers.size());
    }
    
    /**
     * @author Simon Alford
     * I didn't really know when to stop, so I initially had it go to infinity,
     * but I changed that now that I know the answer.
     */
    public static void problem30()
	{
		long i = 2, k, sum, totalSum = 0;
		int j;
		long[] digits = new long[10];
		
		while(i++ < 1000000)
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
			}
		}
		System.out.println(totalSum);
	}
    
    
    public static void main(String[] args)
    {
        
    }    
}
