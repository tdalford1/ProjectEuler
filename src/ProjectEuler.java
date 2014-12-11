
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manu Singhal
 */
public class ProjectEuler 
{
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
    
    public static void main(String[] args)
    {
        System.out.println(factorMe(76576500));
    }
}
