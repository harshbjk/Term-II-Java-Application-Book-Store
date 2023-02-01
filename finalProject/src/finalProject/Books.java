/**
 * 
 */
package finalProject;

/**
 * @author Harsh Bijukumar(C0826775)
 *This class holds fields for acquiring book information
 *Fields: BookID, BookName,  BookAuthor, BookPrice
 *Methods: Constructors, Getter and Setters, OutPut(): Prints all info of book
 */
public class Books {
	private String BookID;
	private String BookName;
	private String BookAuthor;
	private double BookPrice;
	
	/**
	 * Non-Parametric constructor
	 */
	public Books()
	{
		/*
		 *This is the non-args constructor for the class 
		 */
		BookID = " ";
		BookName = " ";
		BookAuthor = " ";
		BookPrice = 0;
		
	} 
	
	/**
	 * Parametric constructor 
	 * @param bookID Book's id
	 * @param bookName Book's name
	 * @param bookAuthor Author of the book
	 * @param bookPrice Price of the book
	 */
	public Books(String bookID, String bookName, String bookAuthor, double bookPrice) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookAuthor = bookAuthor;
		BookPrice = bookPrice;
	}

	//Generated getters and setters
	
	
	public String getBookName() {
		return BookName;
	}
	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(double bookPrice) {
		BookPrice = bookPrice;
	}
	/**
	 * Prints all the information about the book
	 */
	public void OutPut()
	{
		System.out.printf("BookID: " + BookID + "\nBook Name: "+ BookName + "\nBook's Author: "+BookAuthor + "\nPrice of Book: "+BookPrice);
	}

}
