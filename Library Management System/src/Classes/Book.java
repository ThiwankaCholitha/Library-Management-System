package Classes;

public class Book {
	String bookId;
	String bookISBN;
	String booktitle;
	String bookType;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	public Book(String bookId, String bookISBN, String booktitle, String bookType) {
		super();
		this.bookId = bookId;
		this.bookISBN = bookISBN;
		this.booktitle = booktitle;
		this.bookType = bookType;
	}
	
	

}
