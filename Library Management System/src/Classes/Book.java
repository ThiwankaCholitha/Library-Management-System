package Classes;

public class Book {
	String bookId;
	String bookISBN;
	String booktitle;
	String bookType;
	String author;
	int noOfCopies;
	
	
	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	
	public Book(String bookISBN, String booktitle, String bookType, String author, int noOfCopies) {
		super();
		this.bookISBN = bookISBN;
		this.booktitle = booktitle;
		this.bookType = bookType;
		this.author = author;
		this.noOfCopies = noOfCopies;
	}

	public Book() {
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
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
	

	

}
