/**
 * 
 */
package finalProject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Harah Bijukumar(C0)
 *Online Book Store 
 *This is the main class
 *it contains all the methods 
 */
public class Main {

	/**
	 * Online Book store
	 * this is the main method
	 * A menu is created using switch case statement
	 * every other function is called according to the user input
	 */
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> OrderedBooks = new ArrayList<String>();
	public static void main(String[] args) {
		// Online Book Store
		try {
			int opt;
			do{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("Choose Options: ");
				System.out.println("1.Show all available books(And Order Them)\n2.Search for a specific book \n3.Exit");
				opt = scanner.nextInt();//Printing options and taking input 
				switch (opt){
				case 1:
				{
					PrintBooks();
					opt = 0;
					break;
				}
				case 2:
					SearchBook();
					break;
				case 3: 
				{//case 3 terminates the program
					System.out.println("\n\n\n\n\n\n\n\n\nExiting.........");
						return;
				}
				case 404:
				{
					/*
					 * This option/case is only available for the administrator, password is hard coded and this leads to other options like add books and delete books.
					 */
					int password = 8520;
					int UserPassword;
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("Enter the password");
					UserPassword = scanner.nextInt();
					for(int i=3; i>0; i--)// gives the user four tries, if the password is wrong, the program is exited.
					{
						if(password != UserPassword)//checks if the user inputed password is same as the hard coded password
						{
							System.out.println("Incorrect Password! You Have "+i+" tries left.");
							System.out.println("Enter the password");
							UserPassword = scanner.nextInt();
						}
						else {
							DevOptions();// if the password is correct, DevOptions() is invoked
							i=0;
						}
					}
					break;
				}
				default:
				{
					System.out.println("Invalid Input! Try again.");
				}
				}
				
			}while(opt != 10); 
		}catch (InputMismatchException nfe) {
		    System.out.println("You have entered a non numeric field value"); // exception to catch if the user inputs a wrong value
		}
		catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
	}
	/**
	 * No parameters are passed, no return value.
	 * this method has options to add books, delete books and go back to main menu.
	 * uses if else statement to create menu
	 * asks user to choose from three options and go to other methods accordingly
	 * Adds book to the txt file,delete books from the txt file using BookID as the search value
	 */
	public static void DevOptions() {
		try {
			int opt = 0;
			do {
				System.out.println("\n\n\n\n\n\n\n\n\n");
				System.out.println("Choose Options:");
				System.out.println("1.Add Books\n2.Delete Books \n3.Go back to Main Menu");
				opt = scanner.nextInt();//Printing options and taking input 
				if(opt == 1)
				{
					try {
						AddBooks();
					} catch (IOException e) {
						// T// Catches error if the file is not found
						System.out.println("File Not Found");
					}
				}
				else if (opt == 2) {
					{
					System.out.println("\n\n\n\n");
						DeleteBooks();
					}
					
				}
				else if(opt == 3)
					break;
				else if(opt != 1 || opt != 2 || opt != 3)
					System.out.println("Inavlid input");
			}while(opt != 3);
		}catch (InputMismatchException e) {
		    System.out.println("You have entered a non numeric field value"); //If the user inputs string, this will be printed.
		}
	}
	
	
	
	/**
	 * Method to add books to the .txt file
	 * takes input like bookID, BookName, Author, and price of the book.
	 */
	public static void AddBooks() throws IOException {
		System.out.println("\n");
		String BookID, BookName, Author;
		double Price;
		int opt1 = 0;
		try {
			while(opt1 != 1 )
			{
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				scanner.nextLine();
				System.out.println("Enter the Book ID");
				BookID = scanner.nextLine();
				System.out.println("Enter the Name of Book:");
				BookName = scanner.nextLine();
				System.out.println("Enter the Name of Author:");
				Author = scanner.nextLine();
				System.out.println("Enter the price of book:");
				Price = scanner.nextDouble();
				Books book = new Books(BookID, BookName, Author, Price);// object of class Books is created.
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				book.OutPut();
				System.out.println("\nIf the entry is Wrong, press 2 to  re-enter,\nPress 1 to exit\nPress 3 to Add the data to the file");
				opt1 = scanner.nextInt();
				if(opt1 == 3) {
					File fbook = new File("BookInfo.txt");
					boolean exists = fbook.exists();//assigns true if the file exists, false if the file does not exists.
					if(exists == false)// if the file does not exit, an new file will be created 
					{
						System.out.println("File created: " + fbook.getName());
						try (PrintWriter bookwriter = new PrintWriter("BookInfo.txt")) {
							bookwriter.printf(" %s %s %s %f",BookID, BookName, Author, Price);
							break;
						}
						
					}
					else { //if the file exits, the data will be added to the existing file
						try (FileWriter bookWrite = new FileWriter("BookInfo.txt",true)) {
							bookWrite.write(BookID+" "+ BookName+" "+ Author+" "+ Price+"\n");
						} catch (IOException e) {
							// Catches error if the file is not found
							System.out.println("File Not Found");
						}
						break;
					}
				}
			
			}
		}catch(InputMismatchException nfe) {
		    System.out.println("You have entered a non numeric field value"); //If the user inputs string, this will be printed.
		}
	}
	
	
	/**
	 * DeletBook() method is used to delete book 
	 * using BookID to search through the txt file
	 * @throws IOException
	 */

	public static void DeleteBooks(){
		try {
			scanner.nextLine();
			System.out.println("Enter the Book's BookId which is to be deleted ");
			String UBookID = scanner.nextLine();// asks the user for BookID for the book that should be deleted.
			PrintWriter bookwriterTemp = new PrintWriter("BookInfoTemp.txt");// A new .txt file is created for temporarily copying data from the original txt except the file that should be deleted
			File BookINFO = new File("BookInfo.txt");//original .txt file is opened
			Scanner inputFile = new Scanner(BookINFO);
			while(inputFile.hasNext()){
			//Searching for the BookID that user inputed inside the file
				String CurrentLine = inputFile.nextLine();
				if(CurrentLine.contains(UBookID))
				{
					System.out.println(CurrentLine + " is deleted");
					continue;//If current line contains UBookInfo, it will skip part after the if loop
				}
				bookwriterTemp.write(CurrentLine+"\n");
				}
			System.out.println("Press any key and press enter to continue.");
			scanner.next();
			bookwriterTemp.flush();
			bookwriterTemp.close();
			inputFile.close();
			//inputFile.close(); //inputFile closes
			FileReader BookINFOTemp = new FileReader("BookInfoTemp.txt");
			BufferedReader  inputFileTemp = new BufferedReader (BookINFOTemp);
			PrintWriter bookwriterOLD = new PrintWriter("BookInfo.txt");
			String CurrentLineTemp;
			while((CurrentLineTemp = inputFileTemp.readLine()) != null)
			{
				bookwriterOLD.write(CurrentLineTemp+"\n");
			}
			inputFileTemp.close();//inputFileTemp is closed			
			bookwriterOLD.flush();
			bookwriterOLD.close();//bookwriterOLD is closed
			
		}catch(IOException e) {
			System.out.println("File not found! Sorry ");
		}
	}
	
	
	/**
	 * MEthod to print all the book from txt file a asks if the user needs to place order
	 */
	public static void PrintBooks(){
		try {
			System.out.println("\n\n\n\n\n\n\n\n\n");
			Scanner Bookout = new Scanner(new File("BookInfo.txt"));//file is opened
			String CurrentLine;
			String BookID, BookName, BookAuthor;
			Double Price;
			while(Bookout.hasNextLine())
			{
				CurrentLine = Bookout.nextLine();
				String[] token = CurrentLine.split(",");//splits all the files in the data into a string array where there is " , "
				//System.out.println(CurrentLine);
				BookID = token[0];// as we know that first part is BookID, it will in the 0th position and everything else follows
				Price = Double.parseDouble(token[3]);
				BookName = token[1];
				BookAuthor = token[2];
				Books bookOutPut = new Books(BookID, BookName, BookAuthor, Price);
				bookOutPut.OutPut();//object of class Books is created and method of class Books is invoked, which will print the data 
				System.out.println("\n-------------------------------\n");
			}
			Bookout.close();
			System.out.println("\nPress 1 to order books!\n Press any other key to exit");
			int opt = scanner.nextInt();
			if(opt == 1) {// if the user wants to order books, OrderBook() method is invoked
				OrderBooks();
			}
			
		}catch (FileNotFoundException e) {
			// exception to catch file not found error
			System.out.println("No data found! Sorry");
		} 
		catch (Exception e) {
			// to catch every other errors
			System.out.println("Something went wrong!");
		}
	}
	
	
	
	/**
	 * Method for ordering books
	 * Ask user for information about themselves
	 * Creates a .txt using the information 
	 * Asks the user for number of book to order and asks for BookID based on the number of books
	 * In the end, prints a receipt 
	 */
	public static void OrderBooks() {
		try {
			File UserINFO = new File("UserInfo.txt");//.txt file is opened
			String userID = "";
			if(UserINFO.exists() == true)// checks if the file exits
			{
				Scanner GetUserID = new Scanner(UserINFO);
				while(GetUserID.hasNext())
				{
					String CurrentLine = GetUserID.nextLine();
					String[] token = CurrentLine.split(",");
					//System.out.println(token[0]+"\n");
					token[0].replaceAll(" ", "");
					if(token[0] == null) {
						userID = "0";
					}
					else
						userID = token[0];//as userID is replaced every line, we can obtain the last userID and add 1 to it to get current userID
				}
				//System.out.println(userID+"\n");
				GetUserID.close();
				
			}
			else {
				System.out.println("Does not Exits");
				userID = "1"; // if the file does not exist, UserID is assigned as 1
			}
			System.out.println("\n\n\n\n\n\n\n\n\n");
			System.out.println("Your information is required to continue!(This will be used as your delivery information)");
			System.out.println("Enter the followinf informations: ");
			int input = 1;
			UserInfo userinfo;
			do {
				if(input != 1 )
				{
					System.out.println("Invalid input! Try again.");
				}
				scanner.nextLine();
				System.out.println("Name: ");
				String name = scanner.nextLine();
				System.out.println("Street: ");
				String street = scanner.nextLine();
				System.out.println("City: ");
				String city = scanner.nextLine();
				System.out.println("Province: ");
				String province = scanner.nextLine();
				System.out.println("Postal Code: ");
				String postalcode = scanner.nextLine();
				Address address = new Address(street, city, province, postalcode);
				System.out.println("Email: ");
				String email = scanner.nextLine();
				System.out.println("Phone.No: ");
				String PhoneNo = scanner.nextLine();
				System.out.println("\n\n\n\n\n\n\n\n\n");
				int USERID = Integer.parseInt(userID)+1;
				userinfo = new UserInfo(USERID, name, address, email, PhoneNo); // object of class userInfo is created
				System.out.println(userinfo.OutPut()+"\n");
				System.out.println("Is is information correct? If not, press 1 to re-enter.\nPress 2 to confirm\n");
				input = scanner.nextInt();
			}while(input != 2);
			FileWriter UserWrite = new FileWriter("UserInfo.txt",true);
			UserWrite.write("\n"+userinfo.toString());// data is written into the file(userinfo.toString() returns all the userinfo and is directly written into the file)
			UserWrite.flush();
			int BookOrderedCount = 0; // to keep track of no of books ordered
			boolean bookIDTorF = false;
			do {
				String CurrentLine;
				System.out.println("\n\n\n\n\n\n\n\n\n");
				System.out.println("\nEnter the number of books you want to order: ");
				int size = scanner.nextInt();
				if(size < (OrderedBooks.size()-size))
					size = (OrderedBooks.size()-size);
				else if(size > (OrderedBooks.size()-size))
					size = size - (OrderedBooks.size());
				
				String[] UserBookID = new String[size];//string for BookID is created with size(number of book to be ordered)
				scanner.nextLine();
				System.out.println("\n\n\n\n\n\n\n\n\n");
				for(int i = 0; i < size; i++)
				{
					System.out.printf("Enter the BookID(including '#') of book number%d%n(Entering the same bookID more than once means that the book will be delivered that many times) %n", i+1);
					UserBookID[i] = scanner.nextLine();//BookId is taken from user 
				}
				Scanner Bookout = new Scanner(new File("BookInfo.txt"));// .txt file is opened
				System.out.println("\n\n\n\n\n\n\n\n\n");
				double totalPrice = 0;
				while(Bookout.hasNextLine())
				{
					int choice = 0;
					CurrentLine = Bookout.nextLine();// books current line is stored in string CurrentLine
					for(int i = 0; i < size; i++) {
						if(CurrentLine.contains(UserBookID[i]))
						{
							choice = 1;
							for(int x = 0; x<OrderedBooks.size();x++)
							{
								if((OrderedBooks.get(x).contains(UserBookID[i])))// checks for duplicate input and asks user if this should be added to the cart
								{	
									while ((choice != 1)|| (choice != 2))
									{
										System.out.println("\n" + OrderedBooks.get(x));
										System.out.println("You already added this book to the cart, \nTo add it again press 1\nTo skip this one press 2");
										choice = scanner.nextInt();
										if((choice != 1) && (choice != 2))
										{
											System.out.println("Invalid Choice, Please enter Again");
										}
										else
										{
											break;
										}
									}
								}
							}
							if(choice == 1)
							{
								//System.out.print(OrderedBooks.get(0)+"\n");
								OrderedBooks.add(CurrentLine);
								BookOrderedCount++;
								UserWrite.write(" "+UserBookID[i]);//
							}
							else 
							{
								BookOrderedCount++;// book ordered count is still incremented so that later it can be compared with the number of book user wanted to order.
								continue;
							}
							bookIDTorF = true;
						}
					}
				}
				for(int i = 0;i<OrderedBooks.size();i++)
				{
					System.out.print(OrderedBooks.get(i)+"\n");
					System.out.println("\n-------------------------------\n");
					String[] token = OrderedBooks.get(i).split(",");
					totalPrice = Double.parseDouble(token[3])+totalPrice;
				}
				if(BookOrderedCount < size)//bookOrderedCount not equal to size mean that one or more BookID user inputed was wrong, so the loop will start again
				{
					bookIDTorF = false;
					System.out.println("Invalid BookID, Please enter Again");
				}
				else// else receipt is printed 
					System.out.println("Your total is : "+totalPrice + "\nand will be delivered to your address...\n");
				UserWrite.flush();
				UserWrite.close();
			}while(bookIDTorF == false);
			
		}catch (FileNotFoundException e) {
			System.out.println("File not found! Sorry ");
		}
		catch (Exception e) {
			// to catch every other errors
			System.out.println("Something went wrong!");
		}
	}
	
	
	
	/**
	 * SearchBook() method is used to search book using BookID, author name, book name or even using price
	 */
	static void SearchBook(){
		
		try
		{
			scanner.nextLine();
			Scanner Bookout = new Scanner(new File("BookInfo.txt"));
			System.out.println("\n\n\n\n\n\n\n\n\n");
			double totalPrice = 0;
			System.out.println("Enter the Book or Author you want to search");
			String UserInput = scanner.nextLine();
			OrderedBooks.clear();
			boolean flag = false;
			String CurrentLine = "";
			while(Bookout.hasNextLine())
			{
				CurrentLine = Bookout.nextLine();
				Pattern pattern = Pattern.compile(UserInput, Pattern.CASE_INSENSITIVE); // a pattern is created that is insensitive
				Matcher matcher = pattern.matcher(CurrentLine); 
				boolean matchFound = matcher.find();// matchfound will be gieven value of true if the matcher finds the User input inside currentline
				if(matchFound) { //if it's found, user is given the option to add that to the cart and later can be ordered.
					flag = true;
					System.out.println(CurrentLine+"\n");
					System.out.println("Press 1 to add this to the cart\nPress 2 to continue");
					int choice = scanner.nextInt();
					if(choice == 1)
						OrderedBooks.add(CurrentLine);
					System.out.println(OrderedBooks.get(0));
				}
			}
			if(flag == false)
				System.out.println("No Book Found");
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found! Sorry ");
		}
		catch (Exception e) {
			// to catch every other errors
			System.out.println("Something went wrong!");
		}
	}
}
