package Classes;

public class IssueBook {

	String ISBN;
	String clientId;
	String date;
	String returnDate;
	String BookTitle;
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	int noOfCopies;
	
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getBookISBN() {
		return ISBN;
	}
	public void setBookISBN(String isbn) {
		this.ISBN =isbn ;
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
