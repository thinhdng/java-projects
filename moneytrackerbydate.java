import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;
/*
 * takes in a number which is the current balance
 * output a file with the current date and the current balance
*/
public class moneytrackerbydate{

    public static String returnFileName(){
        Locale loc = new Locale("en", "US");
        DateFormat formattedDate = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        String todayDate = formattedDate.format(new Date());
        String fileTitle = todayDate + " balance.txt";
        return fileTitle;
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
        }while(balance <= 0.0);
        
        x.close();
        String formattedBalance = "Today's balance: " + Double.toString(balance) + "$";
        return formattedBalance;
    }

    public static void writeToFile(String fileName, String content){
        try{
        FileWriter myWriter = new FileWriter(fileName);
        myWriter.write(content);
        myWriter.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }


    public static void main(String[] args){
        writeToFile(returnFileName(), balanceInput());
    }
} 