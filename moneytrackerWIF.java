/*
 * input the balance, and it's written into the same file
 * by current date
 * the file will store different dates' balance 
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class moneytrackerWIF{

    public static String returnDate(){
        Locale loc = new Locale("en", "US");
        DateFormat formattedDate = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        String todayDate = formattedDate.format(new Date());
        String currentDate = todayDate + " balance: ";
        return currentDate;
    }

    public static String balanceInput(){
        Scanner x = new Scanner(System.in);
        double balance = 0.0;
        System.out.print("Enter today's balance (just the number, no symbols or words.): ");


        do{
            try{
                balance = x.nextDouble();
            }catch(InputMismatchException e){
                System.out.print("Invalid input. Try again: ");
            }
            x.nextLine();
        }while(balance < 0.0);
        
        x.close();
        String formattedBalance = returnDate() + "$" + Double.toString(balance) + "\n";
        return formattedBalance;
    }

    public static void writeToFile(String content){
        try{
            //without true it will delete the existing data in the file
            //with true it will turn on append mode!
        FileWriter myWriter = new FileWriter("mtwritetestfile.txt", true);
        myWriter.write(content);
        myWriter.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void main(String[] args){
        writeToFile(balanceInput());
    }

}

