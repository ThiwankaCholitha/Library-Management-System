package Classes;

public class BookReturn {
	String ISBN;
	String bookTitle;
	int dateDifference;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setBookISBN(String isbn) {
		ISBN = isbn;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public int getDateDifference() {
		return dateDifference;
	}
	
	public void setDateDifference(int dateDifference) {
		this.dateDifference = dateDifference;
	}
	
}
