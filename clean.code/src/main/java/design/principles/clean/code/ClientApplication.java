package design.principles.clean.code;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientApplication {
	private static final Logger log = LogManager.getLogger(ClientApplication.class);
public static void main (String args[])
{ 
	System.out.println("Enter option");
	Scanner sc = new Scanner(System.in);
	System.out.println("1)Simple Interest");
	System.out.println("2)Compound Interest");
	System.out.println("3)House Price estimation");
	int option = sc.nextInt();
	long principalAmount = 0;
	Double rateOfInterest = 0.0;
	int timePeriodInYears = 0;
	int noOfTimes = 0;
	switch(option)
	{
	case 1:
		
		SimpleInterest si = new SimpleInterest();
		System.out.println("enter principal amount");
		principalAmount = sc.nextLong();
		System.out.println("enter rate of interest");
		rateOfInterest = sc.nextDouble();
		System.out.println("enter time1 period in years");
		timePeriodInYears = sc.nextInt();
		log.info("for principal amount "+principalAmount+" rate of interest "+rateOfInterest+" amount is: "+si.calculate(principalAmount, rateOfInterest, timePeriodInYears));
		break;
	case 2:
		CompoundInterest ci = new CompoundInterest();
		System.out.println("enter principal amount");
		principalAmount = sc.nextLong();
		System.out.println("enter rate of interest");
		rateOfInterest = sc.nextDouble();
		System.out.println("enter time period in years");
		timePeriodInYears = sc.nextInt();
		System.out.println("enter no of times");
		noOfTimes = sc.nextInt();
		log.info("for principal amount "+principalAmount+" rate of interest "+rateOfInterest+" amount is: "+ci.calculate(principalAmount, rateOfInterest, timePeriodInYears,noOfTimes));
		break;
	case 3:
		String material;
		Double areaInSquareFeet;
		System.out.println("enter material");
		System.out.println("->High Standard");
		System.out.println("->above Standard");
		System.out.println("->Standard");
		material = sc.next()+sc.nextLine();
		System.out.println("enter area required");
		areaInSquareFeet = sc.nextDouble();
		House house = new House();
		if(material.compareTo("High Standard")==0)
		{  char choice = 'a';
			System.out.println("Do you want fully automated y/n");
			choice = sc.next().charAt(0);
			if(choice=='y')
			{
				log.info("for areainsquarefeet "+areaInSquareFeet+" high standard,automated "+"total price is "+house.estimatingPriceForHighStandard(material, areaInSquareFeet, true));
			}
			else
			{
				log.info("total price"+house.estimatingPriceForHighStandard(material, areaInSquareFeet, false));
			}
			
		}
		else
		{
			log.info("for material "+material+" and area "+areaInSquareFeet+" total price"+house.estimatingPriceForBelowHighStandard(material, areaInSquareFeet));	
		}
		break;
	default:
		System.out.println("please choose in the options given");
	}
	sc.close();
}
}
