
import java.util.ArrayList;
import java.util.HashSet;

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
    
    public static int problem3()
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
        System.out.println(problem3());
    }
}
