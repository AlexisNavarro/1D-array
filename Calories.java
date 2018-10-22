//Author: Alexis Navarro
//Lab 1
//Last modification: 9/6/18

//PURPOSE OF THE PROGRAM:
//The purpose of this program is to demostrate my ability with using text files and being able to manipulate the contents of the file by using     //arrays to complete the tasks assigned.

import java.io.*;
import java.util.Scanner; //imports scanner

public class Calories{
    
    //SUM OF CALORIES IN A DAY METHOD, WHICH RETURNS THE SUM
	public static int[] dailyIntake(int[] a, int[] b, int[]c){
		int[] sum = new int[7];
			for(int i=0; i<a.length; i++){
				sum[i] = a[i]+b[i]+c[i];
			}//end for
		return sum;
	}//end dailyIntake
    
    
    //CHECKS WHICH DAY HAS AN EXCESS OF CALORIES AND PRINTS OUT THE DAY
    //TO DETERMINE WHICH EXCEEDED 2,250 
     public static void excessCalories(String[] a,int[] b){
        for(int i=0; i< a.length;i++){
          if(b[i]>2250){
             System.out.println("\n"+a[i]+" Excess in calories");
          } 
        }
    }//end excessCalories
    
    
    //AVERAGE CALORIES OF EACH MEAL METHOD, WHICH RETURNS THE AVERAGE
    public static double averageMeal(int[] b){
        double sumMeal=0;
        for(int i=0; i<b.length; i++){
            sumMeal=sumMeal+b[i];
        }
        double avg=0.0;
        avg =sumMeal/b.length;
        return avg;
    }//end averageMeals
    
   
	
    //PRINTS ARRAY TO CHECK IF THE ARRAY CREATED IS CORRECT.
    public static void printArray(int[]b){
        System.out.println("The Array is: ");
        for(int i=0; i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
    }//end printArray
    
    
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = null;	
			try{
                s = new Scanner(new File("input.txt")); 
                int i=0;
                int[] breakfast=new int[7];
                int[] lunch=new int[7];
                int[] dinner=new int[7];
                
                int l=0;
				while(s.hasNextLine()){	
					String line = s.nextLine(); 
                    //System.out.println(line);
					
					String[] aSplit= line.split(" ");
                    
					int[] a = new int[aSplit.length];
                    
                        breakfast[l] = Integer.parseInt(aSplit[0]);
                        lunch[l] = Integer.parseInt(aSplit[1]);
                        dinner[l] = Integer.parseInt(aSplit[2]); 
                        l++;
				}//end while
                
                //printArray(breakfast);//CHECKS THE ARRAY 
				//printArray(lunch);//CHECKS THE ARRAY
				//printArray(dinner);//CHECKS THE ARRAY
                
                String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};//CREATED A STRING ARRAY THAT CONTAINS THE                                                                                          //DAYS OF A WEEK
                
                int[] total = dailyIntake(breakfast, lunch, dinner);//DECLARES A NEW INTEGER ARRAY TO CONTAIN THE SUM OF MEALS EACH DAY
                 for(i=0; i<7; i++){
                    System.out.println(days[i]+" Calories: "+total[i]);
                }//end for
                
                //CALLS THE METHOD TO FIND THE DAY WITH MORE CALORIES CONSUMED THAN NEEDED
                excessCalories(days,total);
                
                //DECLARES A NEW VARIABLE THAT CALLS THE METHOD TO FIND THE AVERAGE OF EACH MEAL
                double breakfastAvg = averageMeal(breakfast);
                double lunchAvg = averageMeal(lunch);
                double dinnerAvg = averageMeal(dinner);
                System.out.println("\nBreakfast Calories: "+ breakfastAvg);
                System.out.println("lunch Calories: "+ lunchAvg);
                System.out.println("dinner Calories: "+ dinnerAvg);
                             
			}catch(Exception e){
				e.printStackTrace();//prints the exceptions found
			}//end catch
		}//end main
	}//end Calories
