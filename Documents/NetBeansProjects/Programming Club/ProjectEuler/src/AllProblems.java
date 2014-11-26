/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(sumOfMult3and5());
    }
}
