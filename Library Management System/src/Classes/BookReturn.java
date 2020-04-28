package Classes;

public class BookReturn {
	String BookId;
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	String bookTitle;
	int dateDifference;
	
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
