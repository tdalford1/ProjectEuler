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
    
    public static void main(String[] args)
    {
        System.out.println(problem6());
    }
}
