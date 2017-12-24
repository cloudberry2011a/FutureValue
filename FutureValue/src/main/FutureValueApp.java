package main;

import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp 
{
    public static void main(String[] args) 
    {
        System.out.println("The Future Value Calculator\n");
        
        Scanner scanner = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) 
        {
        		System.out.println("Data Entry");
        		
        		double monthlyInvestment = getDoubleWithinRange(scanner, "Enter monthly investment:   ", 0, 1000);
            double interestRate = getDoubleWithinRange(scanner, "Enter yearly interest rate:   ", 0, 30);
            int years = getIntWithinRange(scanner, "Enter number of years:   "	, 0, 100);

            // convert yearly values to monthly values
            double monthlyInterestRate = interestRate / 12 / 100;
            int months = years * 12;

            double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

            // format the result and display it to the user
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);
            
            System.out.println("Monthly investment:         " + currency.format(monthlyInvestment));
            System.out.println("Yearly interest rate:       " + percent.format(interestRate / 100));
            System.out.println("Number of years:            " + years);
            System.out.println("Future value:               " + currency.format(futureValue));
            
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = scanner.next();
            System.out.println();
        }
        System.out.println("Bye!");
    }

    private static int getInt(Scanner scanner, String prompt)
    {
    		int result = 0;
    		boolean isValid = false;
    		while(!isValid)
    		{
    			System.out.print(prompt);
    			if(scanner.hasNextInt())
    			{
    				result = scanner.nextInt();
    				isValid = true;
    			}
    			else
    			{
    				System.out.println("Error: Entry is invalid. Try again.");
    			}
    		}
    		return result;
    }
    
    private static int getIntWithinRange(Scanner scanner, String prompt, double min, double max)
    {
    		int result = 0;
    		boolean isValid = false;
    		while(!isValid)
    		{
    			result = getInt(scanner, prompt);
    			if (result <= min)
    			{
    				System.out.println("Error: Entry must be greater than " + min + ".");
    			}
    			else if (result >= max)
    			{
    				System.out.println("Error: Entry must be less than " + max + ".");
    			}
    			else
    			{
    				isValid = true;
    			}
    		}
    		return result;
    }
    
    private static double getDouble(Scanner scanner, String prompt) 
	{
		double result = 0.0;
		boolean isValid = false;
		while(!isValid)
		{
			System.out.print(prompt);
			if (scanner.hasNextDouble())
			{
				result = scanner.nextDouble();
				isValid = true;
			}
			else
			{
				System.out.println("Error: Entry is invalid. Try again.");
			}
			scanner.nextLine(); //Discard any other data on the line.
		}
		return result;
	}
    
	private static double getDoubleWithinRange(Scanner scanner, String prompt, double min, double max) 
	{
		double result = 0.0;
		boolean isValid = false;
		while(!isValid)
		{
			result = getDouble(scanner, prompt);
			if (result <= min)
			{
				System.out.println("Error: Entry must be greater than " + min + "." );
			}
			else if (result >= max)
			{
				System.out.println("Error: Entry must be less than " + max + ".");
			}
			else
			{
				isValid = true;
			}
		}
		return result;
	}
	
	private static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) 
	{
		double futureValue = 0.0;
		for (int i = 1; i <= months; i++) 
		{
		    futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
		}
		return futureValue;
	}
}

