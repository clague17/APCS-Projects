import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dailyCalories
{
    public static String calorieCount[][] = new String [7][3];
    public final static String [] daysOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    public static int max = 0;
    public static int maxNumColOne = 0;
    public static int maxNumColTwo = 0;
    public static int maxNumColThree = 0;
    public static int min = Integer.MAX_VALUE;
    public static void main (String [] args) throws FileNotFoundException
    {
        Scanner keyboardInput = new Scanner (System.in);
        
        System.out.println ("Enter the name of the file you want to import: ");
        String fileString = keyboardInput.nextLine ();
  
        PrintWriter output = new PrintWriter ("outputFile.txt");
            
        try 
        {
            String [][] inputArray = averageCalories (fileString,output);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(dailyCalories.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            String [][] inputArray = maxCalPerDay (fileString,output);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(dailyCalories.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            String [][] inputArray = maxMinSum (fileString,output);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(dailyCalories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public static String[][] averageCalories (String fileString, PrintWriter output) throws FileNotFoundException, IOException
        {
            File file = new File (fileString);
            FileReader reader = new FileReader (file);
            BufferedReader br = new BufferedReader (reader);
            String [][] calorieCount = null;
            
            while (br.ready())
            {
                int sum = 0;
                String currentLine = br.readLine();
                String [] numbers = currentLine.split ("\t");
            
                for (int i = 0; i < numbers.length; i++)
                {
                    int num = Integer.parseInt (numbers[i]);
                    sum+=num;
                }
            
                int average = (sum/(numbers.length));
                output.println (average);
            }
            output.println();
            
            return calorieCount;
        }
        
        public static String[][] maxCalPerDay (String fileString, PrintWriter output) throws FileNotFoundException, IOException
        {
            File file = new File (fileString);
            FileReader reader = new FileReader (file);
            BufferedReader br = new BufferedReader (reader);
            String [][] calorieCount = null;
        
            while (br.ready())
            {
                String read = br.readLine();
                String breakfast [] = read.split ("\t");
            
                for (int i = 0; i < breakfast.length; i++)
                {
                    int numColOne = Integer.parseInt (breakfast[0]);
                    int numColTwo = Integer.parseInt (breakfast[1]);
                    int numColThree = Integer.parseInt (breakfast[2]);
                
                    if (numColOne > maxNumColOne)
                    {
                        maxNumColOne = numColOne;
                    }
                    else if (numColTwo > maxNumColTwo )
                    {
                        maxNumColTwo = numColTwo;
                    }
                    else if (numColThree > maxNumColThree)
                    {
                        maxNumColThree = numColThree;
                    }   
                }
            }
            br.close();
            
            output.println ("Largest Breakfast: " +maxNumColOne);
            output.println ("Largest Lunch: " +maxNumColTwo);
            output.println ("Largest Dinner: " +maxNumColThree);
            output.println();
            
            return calorieCount;
        }
        
        public static String[][] maxMinSum (String fileString, PrintWriter output) throws FileNotFoundException, IOException
        {
            File file = new File (fileString);
            FileReader reader = new FileReader (file);
            BufferedReader br = new BufferedReader (reader);
            String [][] calorieCount = null;
            
            while (br.ready())
            {
                int sumMax = 0;
                int sumMin = 0;
            
                String currentNumber = br.readLine();
                String [] numbers = currentNumber.split ("\t");
            
                for (int i = 0; i < numbers.length; i++)
                {
                    int num = Integer.parseInt (numbers[i]);
                    sumMax+=num;
                    sumMin+=num;
                
                    if (sumMax > max)
                    {
                        max = sumMax;
                    }
                }
                for (int j = 0; j < numbers.length; j++)
                {   
                    if (sumMin < min)
                    {
                        min = sumMin;
                    }
                } 
            }
            br.close();
            
            output.println (max);
            output.println (min);
            output.close();
            
            return calorieCount;
    }
}
