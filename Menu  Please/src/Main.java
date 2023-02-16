import java.util.Random;
import java.util.Scanner;
import com.sun.security.jgss.GSSUtil;
import javax.print.DocFlavor;
import java.util.Arrays;



public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of rows: ");
            int numRows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row: ");
            int seatsInRow = scanner.nextInt();
            char[][] charArray = new char[numRows][seatsInRow];
            int ticketCounter = 0;
            int ticketPrice = 0;
            int totalSeatsNumber = numRows * seatsInRow;
            int currentIncome = 0;
            int totalIncome = 0;
            char chosenSeat;
            int rowNumber;
            int seatNumber;
            boolean isInvalid;


            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length; j++) {
                    charArray[i][j] = 'S';
            }
            }

            //total income
            if (numRows * seatsInRow <= 60) {
                totalIncome = numRows * seatsInRow * 10;
            } else {
                totalIncome = (numRows / 2) * seatsInRow * 10 + ((numRows - numRows / 2) * seatsInRow * 8);
            }//end of counting total income


            int menu;
            do {
                System.out.println();
                System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
                System.out.println();
                switch (menu = scanner.nextInt()) {
                    case 2:

                        do{
                            isInvalid = false;

                        try{
                           do {
                                   System.out.println("Enter a row number: ");
                                   rowNumber = scanner.nextInt();
                                   System.out.println("Enter a seat number in that row: ");
                                   seatNumber = scanner.nextInt();
                                   chosenSeat = charArray[rowNumber - 1][seatNumber - 1];
                                   charArray[rowNumber - 1][seatNumber - 1] = 'B';
                                   if (charArray[rowNumber - 1][seatNumber - 1] == 'B') {
                                       ticketCounter++;
                                   }

                               for (int i = 0; i < charArray.length; i++) {
                                   for (int j = 0; j < charArray[i].length; j++) {
                                       if (charArray[i][j] == charArray[rowNumber - 1][seatNumber - 1]) {
                                           charArray[i][j] = 'B';
                                       } else {
                                           charArray[i][j] = 'S';
                                       }
                                   }
                               }

                               //counting ticket price
                               int frontRow = (int) Math.ceil(charArray.length / 2);
                               if (totalSeatsNumber <= 60) {
                                   ticketPrice = 10;

                               } else if (totalSeatsNumber > 60) {
                                   if (rowNumber <= frontRow) {
                                       ticketPrice = 10;
                                   } else {
                                       ticketPrice = 8;
                                   }
                               }

                               System.out.println("Ticket price: " + "$" + ticketPrice);
                               currentIncome += ticketPrice; //end of counting ticket price


                               //ticket already purchased
                               if (chosenSeat == charArray[rowNumber - 1][seatNumber - 1]) {
                                   System.out.println("That ticket has already been purchased!");
                               } //ticket already purchased


                           }while(chosenSeat == 'B');

                        }catch (ArrayIndexOutOfBoundsException e) {
                            isInvalid = true;
                           System.out.println("Wrong input!");
                        }

                        }while(isInvalid);

                        break;
                    case 1:
                        System.out.println("Cinema:");
                        System.out.print(" ");
                        for (int i = 1; i <= charArray.length+1; i++) {
                            System.out.print(" " + i);
                        }
                        System.out.println();
                        int count4 = 0;
                        for (int i = 0; i < charArray.length; i++) {
                            count4++;
                            System.out.print(count4);
                            for (int j = 0; j < charArray[i].length; j++) {
                                System.out.print(" " + charArray[i][j]);
                            }
                            System.out.println();
                        }

                        break;
                    case 3:
                        //the number of purchased tickets
                        System.out.println("Number of purchased tickets: " + ticketCounter);
                        //percentage
                        float percentage = (float)(ticketCounter*100)/(float)totalSeatsNumber;
                        char percentSign = '%';
                        String details = String.format("Percentage: %.2f%c",percentage, percentSign);
                        System.out.println(details);
                        //current income
                        System.out.println("Current income: $" + currentIncome);
                        System.out.println("Total income: $" + totalIncome);

                        break;

                    case 0:

                        break;
                }
                }while (menu != 0) ;

            } //main method

    }// main class




