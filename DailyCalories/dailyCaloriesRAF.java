/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dailyCaloriesRAF
{


public static void main(String[] args) throws FileNotFoundException {
                
        
            int totalCalories = 0;
            long pointerLocation=0;
            String line = "";
            //BufferedReader br = null; //instantiating all the variables
            //PrintWriter pw = null; // importing printwriter and bufferedreadwr
            RandomAccessFile raf = null;
            Scanner reader = null;
            int [][] calorieArray = new int [7][3];
            int sumCals = 0; // instantiating variable for aid in the calculations of the average. 
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the file path of the file that you'd like to analyze: ");
            System.out.print(">");      
            String fileString = input.nextLine();
            try {
                raf = new RandomAccessFile(fileString, "rw");
                //pw = new PrintWriter("file.txt");
                //br = new BufferedReader(new FileReader(raf));
               
                calorieArray = new int [7][3]; // instantiates a calorie array from the file read, allowing us to manipulate the values as integers instead of Strings.
                for (int i = 0; i<7; i++){
                    line = raf.readLine();
                    reader = new Scanner(line);
                    for (int k = 0; k<3; k++){
                        calorieArray[i][k] = reader.nextInt(); // runs the file through the array to take those values   
                    }
                    pointerLocation=raf.getFilePointer();
                    
            } 
           System.out.println(pointerLocation);//prints the pointerlocation to the console for easier troubleshooting
            } catch (Exception ex) {
                    Logger.getLogger(DailyCalories.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Invalid file location"); //in case the bufferedreader can't find the FilePath it will print out...
                    
            }
            
           int[] breakfast = new int[7];
           for (int i = 0;  i<7; i++){
                breakfast [i] = calorieArray[i][0];  // runs the first column of caloriearray through the breakfast array to get all the breakfast values
                }
          int[] lunch = new int[7]; // runs the second column of caloriearray through the lunch array to get all the lunch values.
            for (int i = 0; i<7; i++){
                lunch[i] = calorieArray[i][1];
            }
          int[] dinner = new int[7]; // runs the third column of caloriearray through the dinner array to get all the lunch values.
            for (int i = 0; i<7; i++){
                dinner[i] = calorieArray[i][2];
            }
           int[] sum = new int[7];
                
            for (int i = 0; i<7; i++){
                int toAdd = 0;
                    for (int k = 0; k<3;k++){
                        toAdd += calorieArray[i][k];        
                    }
                sum[i] = toAdd;
            }
            //C:\Users\LuisC\Downloads\dailyCalories.txt
            try{
                raf.seek(pointerLocation);
                raf.writeBytes("\n\n\n");
                raf.writeBytes("The average calories per day from Monday to Sunday are: ");
                for (int i = 0; i<7; i++){
                    raf.writeBytes("\n"+ (sum[i]/3)+"\n");// prints to the new file that's created in printwriter
                }
              
            int dayBreakfast = 0;
            int max = getMax(breakfast);
            for (int i = 0; i<breakfast.length;i++){ // loop that goes through array breakfast
                if (max==breakfast[i]){// checks where the max value of breakfast equals the element in breakfast[i]
                    dayBreakfast = i+1;               // i is the index. Index starts at 0 and goes to 6 in this case. However in this case you add one for the day of the week.
                }
            }
            int dayLunch = 0 ; // runs through the lunch array to compare and see which is the biggest value
            max = getMax(lunch);
            for (int i = 0; i<lunch.length; i++){
                if (max ==lunch[i]){
                    dayLunch = i+1;
                }
            }
            int dayDinner = 0; // runs through the dinner array to compare and see which is the largest value, running it through the getmax method. 
            max = getMax(dinner);
            for(int i = 0; i<dinner.length; i++){
                if(max == dinner[i]){
                    dayDinner = i+1;
                }
            }
            raf.writeBytes("\n The largest breakfast had " + breakfast[dayBreakfast-1] + " calories on day " + dayBreakfast );
            raf.writeBytes("\n The largest lunch had " + lunch[dayLunch-1] + " calories on day " + dayLunch);
            raf.writeBytes("\n The largest dinner had " + dinner[dayDinner-1] + " calories on day " + dayDinner);

            //calculates the largest amount of calories in one day
            int largeCalories = getMax(sum);
            int dayLarge = 0;
            for (int i = 0; i<7;i++){
                if(largeCalories == sum[i]){//goes through the array and compares the sum to an element within that array
                    dayLarge = i;
                }
            }
            int lowCalories = getMin(sum);
            int dayLow = 0;
            for(int i = 0; i<7; i++){
                if(lowCalories == sum[i]){
                    dayLow = i;
                }
            }

            raf.writeBytes("\n The highest amount of calories were consumed on day "+(dayLarge+1));
            raf.writeBytes("\n The lowest amount of calories were consumed on day " + (dayLow + 1));
            raf.close();
           }catch (Exception e){}
}
             
    public static int getMax(int[] inputArray){ //passes the array that's instantiated
        int maxValue = inputArray[0]; 
        for(int i=1;i < inputArray.length;i++){ 
            if(inputArray[i] > maxValue){ 
            maxValue = inputArray[i]; 
            } 
    } 
    return maxValue; 
  }
    
    public static int getMin(int[] inputArray){ //passes the array that's instantiated to get the minimum method. 
        int minValue = inputArray[0]; 
        for(int i=1;i < inputArray.length;i++){ 
            if(inputArray[i] <minValue){ 
            minValue = inputArray[i]; 
            } 
    } 
    return minValue; 
  }
    
}