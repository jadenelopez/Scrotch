/**
 *  Programmer: Jaden Lopez
 *  Date: 08.05.2022
 *  Purpose: This is a game that I made for my DND Campaign and I thought it would be fun to program it
 */

import java.util.Random;
public class test
{
    public static void main(String[] args)
    {


        //"Rolls 3 random numbers" Player numbers
        int[] playerRoll = randomNum();
        boolean scrotch = isScrotch(playerRoll);
        if(isScrotch(playerRoll))//Is all the numbers the same? If so we call this Scrotch
        {
            System.out.println("SCROTCH");
        }
        //Prints all numbers out for player to see
       for(int i = 0; i< playerRoll.length;i++)
       {
           System.out.println(playerRoll[i]);
           if(scrotch)// If Scrotch then change the number rolled to maximum number
           {
               playerRoll[i] = 6;
           }
       }

       // Add all numbers together to calc sum and then report score
       int sum = calculate(playerRoll);
       System.out.println("Your Score is: " + sum);

        System.out.println();
       // Generates Comp Numbers
        int[] compRoll = randomNum();
        boolean compScrotch = isScrotch(compRoll);
        if(isScrotch(compRoll))//Is all the numbers the same? If so we call this Scrotch
        {
            System.out.println("SCROTCH");

        }
        //Prints all numbers out for player to see
        for(int i = 0; i< compRoll.length;i++)
        {
            System.out.println(compRoll[i]);
            if(compScrotch)//If Scrotch then change the number rolled to maximum number
            {
                compRoll[i] = 6;
            }

        }

        // Add all numbers together to calc sum and then report score
        int sum2 = calculate(compRoll);
        System.out.println("Comp Score is: " + sum2);

        System.out.println();

        //Calculate Winnings
        if(sum > sum2)//Players sum bigger then comp sum
        {
            System.out.println("You WIN!");
            moneyCalc(sum);
        }
        else if(sum<sum2)//Comp sum bigger then player sum
        {
            System.out.println("You Lost!");
            moneyCalc(sum2);
        }
        else// When tie happens. Still need to add some more to this
        {
            System.out.println("TIE");
        }

    }

    /**
     * Name: randomNum
     * Purpose: This class is used to generate an array of random numbers. This simulates rolling 3 dice.
     * @return 3 random numbers
     */
    public static int[] randomNum ()
    {
        // Creating an array the holds 3 random numbers
        Random rand = new Random();
        int[] dice = new int[3];

        for(int i=0;i<dice.length;i++)
        {
            int randRoll = rand.nextInt(6);//generating random numbers between 0-6
            if(randRoll == 0)//if 0 then add 1 because 0 cant be rolled on a dice
            {
                randRoll =1;
            }
            dice[i]=randRoll;//adding random numbers to array
        }

        return dice;//returning array
    }

    /**
     * Name: Calculate
     * Purpose: This class is used to calculate the sum of an array
     * @param numsRolled needs an array of 3 random numbers
     * @return the int sum of all 3 numbers
     */
    public static int calculate(int[] numsRolled)
    {
        int sum = 0;

        //going through array and adding all numbers together
        for (int j : numsRolled) {
            sum += j;// using addition but multiplication could work here
        }

        //returning the sum of all values
        return sum;
    }

    /**
     * Name: isScrotch
     * Purpose: This class is made to determine if a group of numbers rolled are all the same number.
     * @param numsRolled an array of 3 random numbers
     * @return true or false if all numbers in array are the same
     */
    public static boolean isScrotch(int[] numsRolled)
    {
        int temp = numsRolled[0];//Creating a base number to compare all other numbers too
        for (int j : numsRolled) {
            if (j == temp)//if all numbers are the same then just continue
            {
                continue;
            } else {
                return false;// if numbers arnt the same return false
            }
        }

        return true;
    }

    /**
     * Name: MoneyCalc
     * Purpose: This class is made to calculate if you lost Copper, Gold, Silver, or Platinum
     * @param sum needs the sum of players or comps roll
     */
    public static void moneyCalc(int sum)
    {
        //"rolling" for a random number between 1-4
        Random rand = new Random();
        int diceRoll = rand.nextInt(5);
        if(diceRoll == 0)
        {
            diceRoll =1;
        }


        //Checking to see what number is rolled because the number is how much money is owed
        switch (diceRoll) {
            case 1 ->//if 1 is rolled
                    System.out.println(sum + " Copper");
            case 2 ->//if 2 is rolled
                    System.out.println(sum + " Silver");
            case 3 ->//if 3 is rolled
                    System.out.println(sum + " Gold");
            case 4 ->// if 4 is rolled
                    System.out.println(sum + " Platinum");
        }

    }









}
