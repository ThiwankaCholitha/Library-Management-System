package Classes;

public class IssueBook {

	String bookId;
	String clientId;
	String date;
	String returnDate;
	String BookTitle;
	
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
