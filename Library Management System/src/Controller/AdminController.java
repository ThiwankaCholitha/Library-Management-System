package Controller;
import DatabaseConnection.DBConnection;
import UserInterfaces.ReturnBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import Classes.Book;
import Classes.IssueBook;
import Classes.BookReturn;
import Classes.User;

public class AdminController {

    //-------------------------------------------------Check login------------------------------------------------------
    public static boolean chkLogin(String username, String password) {
  
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "select AdminId " +
                    "from Admin " +
                    "where AdminId=? && binary(AdminPassword) = binary(?)");//---Prepare sql as a java object
            preparedStatement.setObject(1,username);//---Set values to sql object
            preparedStatement.setObject(2,password);//---Set values to sql object
            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
            if (rst.next()) {//---Navigate pointer to results
                return true;
            }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
        return false;//---Return user object if login exist, if not return null
    }
    
    //----------------------------------------------------Add user------------------------------------------------------
    public static void addUser(User user) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into client (clientId,clientName,Email,PhoneNumber,ClientType) values (?,?,?,?,?)");
            
            preparedStatement.setObject(1, user.getUserId());//---Set values to sql object
            preparedStatement.setObject(2, user.getUserName());//---Set values to sql object
            preparedStatement.setObject(3, user.getUserEmail());//---Set values to sql object
            preparedStatement.setObject(4, user.getMobilenumber());//---Set values to sql object
            preparedStatement.setObject(5, user.getType());
            preparedStatement.executeUpdate(); //---Execute sql and returns whether it was executed or not
          
               
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
      
    }
    
    
    
    
    //-------------------------------------------------Adding the book-------------------------------------------------------
    public static void addBook(Book book) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book (BookId,ISBN,BookTitle,BookType,Issued,Author) values (?,?,?,?,?,?)");
            
            preparedStatement.setObject(1,book.getBookId() );//---Set values to sql object
            preparedStatement.setObject(2,book.getBookISBN());//---Set values to sql object
            preparedStatement.setObject(3,book.getBooktitle());//---Set values to sql object
            preparedStatement.setObject(4, book.getBookType());
            preparedStatement.setObject(5,0);
            preparedStatement.setObject(6,book.getAuthor());
            
            preparedStatement.executeUpdate(); //---Execute sql and returns whether it was executed or not
                
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
      
    }
    
    
    //--------------------------------------------------------Getting exsisting users in to the table --------------------------------------------------
    
    public static ArrayList<String[]> getUserList(){
    	ArrayList <String[]> users = new ArrayList<>();
    	
    	 try {
             Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
             PreparedStatement preparedStatement = connection.prepareStatement
            ("select ClientId,ClientName,Email,PhoneNumber,ClientType "+
             "from client");//---Prepare sql as a java object
             ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
             {//---Navigate pointer to result rows until it ends
                
           while (rst.next()) {
        	   String [] user = new String[5];
               user[0] = rst.getString(1);
               user[1] = rst.getString(2);
               user[2] = rst.getString(3);
               user[3] = rst.getString(4);
               user[4] = rst.getString(5);
               
               users.add(user);
            	 }
            	 
                 
                 
             }
         } catch (SQLException e) {//--Catch if any sql exception occurred
             e.printStackTrace();
         }
    	 
		return users;//---Return batches array object with a length > 0 if batches exists, if not array object returns with a length = 0
     }
    
    
    //--------------------------------------Removing a user from the database---------------------------------------
    public static void removeUser(User u1) {
    	try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("delete from client "+
            																	"Where clientId =?");
           
            preparedStatement.setObject(1,u1.getUserId());
            preparedStatement.executeUpdate();
            
            //while (rst.next()) {}
            } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
    	
    	
    }
    
    //------------------------------------Getting Exsisting books in the databse to issue books.-----------------------------
    
    public static ArrayList<String> getBookList(){
    
    	
    	ArrayList<String> issuedBooks = new ArrayList<>();
    	String bookTitle = null;
   	 try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement
           ("select BookTitle "+
            "from book "+
        	"where Issued = 0");//---Prepare sql as a java object
            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
            {//---Navigate pointer to result rows until it ends
               
          while (rst.next()) {
       	  
              bookTitle = rst.getString(1);
              issuedBooks.add(bookTitle);
            }
        }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
   	 
		return issuedBooks;//---Return batches array object with a length > 0 if batches exists, if not array object returns with a length = 0
    }

    //----------------------------Getting book id to insert into issueBook table
	public static IssueBook getBookID(Book b1) {
		
		IssueBook newbook = new IssueBook();
		
		  try {
	            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	            PreparedStatement preparedStatement = connection.prepareStatement("" +
	                    "select BookId " +
	                    "from book " +
	                    "where BookTitle=? && Issued = 0");//---Prepare sql as a java object
	            preparedStatement.setObject(1,b1.getBooktitle());//---Set values to sql object
	            
	         
	            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
	            
	            if (rst.next()) {//---Navigate pointer to results
	                newbook.setBookId(rst.getString(1));
	                System.out.println(newbook.getBookId());
	                
	            }
	        } catch (SQLException e) {//--Catch if any sql exception occurred
	            e.printStackTrace();
	        }
	        return newbook;//---Return user object if login exist, if not return null
	        
	    }
		
	//---------------------------------------------------Inserting into issue book --------------------------------------------------------------
	public static boolean insertIntoBook(IssueBook b1) throws SQLException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar cal = new GregorianCalendar();
		
		
		
	            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into issuebook (ClientId,BookId,IssuedDate,ReturnedDate) values (?,?,?,?)");
	            
	            preparedStatement.setObject(1,b1.getClientId() );//---Set values to sql object
	            preparedStatement.setObject(2,b1.getBookId());//---Set values to sql object
	            
	            //Creating a dateformat to use dates from the calendar.
	            
	    		
	    		preparedStatement.setObject(3,formatter.format(cal.getTime()));
	    		cal.add(Calendar.DAY_OF_MONTH, 14);
	    		preparedStatement.setObject(4,formatter.format(cal.getTime()));
	    		if(preparedStatement.executeUpdate()>0) { //---Execute sql and returns whether it was executed or not
	    		return true;	   
	       
	    		}
	    		else
	    			return false;
	}
	
	//--------------------------------------Updating the issued value in the book table -----------------------------------------
	public static void updateBook(IssueBook b1) {
	try {
		Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
        PreparedStatement preparedStatement = connection.prepareStatement("update book "
        		+"set Issued ='1'"
        		+"where BookId =?"
        		);
        preparedStatement.setObject(1, b1.getBookId());
        preparedStatement.executeUpdate();
		
		
		
		
	}catch(SQLException e) {//--Catch if any sql exception occurred
        e.printStackTrace();
		
	}
	}
	
	


	//----------------------------------Getting the Book title and the date difference from the issuedbook table----------------------------------
	public static BookReturn returnBookTitleAndDate(User u1) {
		
		BookReturn rb = new BookReturn();
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select BookTitle,DATEDIFF(curdate(),ib.ReturnedDate),b1.BookId "+ 
					"from book b1,issuebook ib "+ 
					"where b1.BookId = ib.BookId && IssuedDate=(select max(IssuedDate) from issuebook) && ClientId=?");
			preparedStatement.setObject(1, u1.getUserId());
			
			ResultSet rst = preparedStatement.executeQuery();
			
			
			while(rst.next()) {
				rb.setBookTitle(rst.getString(1));
				rb.setDateDifference(rst.getInt(2));
				rb.setBookId(rst.getString(3));
				
				
			}
			
		}catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
            
		}
		return rb;
	 }
	
	
	public static void updateReturnBook(BookReturn b1) {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("update book "
	        		+"set Issued ='0'"
	        		+"where BookId =?"
	        		);
	        preparedStatement.setObject(1, b1.getBookId());
	        preparedStatement.executeUpdate();
			
			
			
			
		}catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
	}
	
	public static boolean checkUser(String userId) {
		
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("select count(ClientId) " + 
	        		"from issuebook "+ 
	        		"where ClientId = ?"
	        		);
	        preparedStatement.setObject(1, userId);
	        ResultSet rst = preparedStatement.executeQuery();
	        
	        
	        if(rst.next()) {
	        	if(rst.getInt(1)==1) {
	        	return true;
	        	}
	        	
	        }
	    }catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
		
		return false;
	}
		
	
	
	
	
	
	
	
	
}












    
/*   //----------------------------------------------------Update email--------------------------------------------------
    public boolean updateEmail(User user) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("update user set emailAddress=? where uId=?");//---Prepare sql as a java object
            preparedStatement.setObject(1, user.getEmailAddress());//---Set values to sql object
            preparedStatement.setObject(2, user.getuId());//---Set values to sql object
            if (preparedStatement.executeUpdate() > 0) {//---Execute sql and returns whether it was executed or not
                return true;
            }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
        return false;//---Returns if update fails
    }*/

