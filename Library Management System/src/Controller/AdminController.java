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

import com.mysql.cj.protocol.Resultset;

import Classes.Book;
import Classes.IssueBook;
import Classes.BookReturn;
import Classes.User;
import Classes.UserAdmin;

public class AdminController {

    //-------------------------------------------------Check login------------------------------------------------------
    public static boolean chkLogin(UserAdmin ua) {
  
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "select AdminId " +
                    "from Admin " +
                    "where AdminId=? && binary(AdminPassword) = binary(?)");//---Prepare sql as a java object
            preparedStatement.setObject(1,ua.getUserName());//---Set values to sql object
            preparedStatement.setObject(2,ua.getAdminPassword());//---Set values to sql object
            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
            if (rst.next()) {//---Navigate pointer to results
                return true;
            }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
        return false;//---Return user object if login exist, if not return null
    }
    
    
    public static UserAdmin getAdminName(UserAdmin ua) {
    	try {
    		Connection connection = DBConnection.getDBConnection().getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement("select AdminName from Admin where admin id = ?");
    		preparedStatement.setObject(1, ua.getUserId());
    		ResultSet rst = preparedStatement.executeQuery();
    		
    		if(rst.next()){
    			ua.setUserName(rst.getString(1));
    		}}
    		catch(SQLException e){
    			e.printStackTrace();
    		}
    		
    		
    	return ua;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------------------------------------------------Adding user------------------------------------------------------
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book (ISBN,BookTitle,Author,BookType,NoOFCopies) values (?,?,?,?,?)");
            
           
            preparedStatement.setObject(1,book.getBookISBN());//---Set values to sql object
            preparedStatement.setObject(2,book.getBooktitle());//---Set values to sql object
            preparedStatement.setObject(3, book.getAuthor());
            preparedStatement.setObject(4,book.getBookType());
            preparedStatement.setObject(5,book.getNoOfCopies());
            
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
            "from book ");//---Prepare sql as a java object
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

    //***-------------------------------------------------Getting ISBN to insert into issueBook table-------------------------------------------------------------***//
	public static IssueBook getBookISBN(Book b1) {
		
		IssueBook newbook = new IssueBook();
		
		  try {
	            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	            PreparedStatement preparedStatement = connection.prepareStatement("" +
	                    "select ISBN,NoOFCopies " +
	                    "from book " +
	                    "where BookTitle=?");//---Prepare sql as a java object
	            preparedStatement.setObject(1,b1.getBooktitle());//---Set values to sql object
	            
	            
	         
	            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
	            
	            if (rst.next()) {//---Navigate pointer to results
	                newbook.setBookISBN(rst.getString(1));
	                newbook.setNoOfCopies(rst.getInt(2));
	                System.out.println(newbook.getBookISBN());
	                System.out.println(newbook.getNoOfCopies());
	                
	            }
	        } catch (SQLException e) {//--Catch if any sql exception occurred
	            e.printStackTrace();
	        }
	        return newbook;//---Return user object if login exist, if not return null
	        
	    }
		
	//***----------------------------------------------------------insert into issueBook table--------------------------------------------------------------------***//
	public static boolean insertIntoBook(IssueBook b1) throws SQLException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar cal = new GregorianCalendar();
		
		
		
	            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into issuebook (ClientId,ISBN,IssuedDate,ReturnedDate,Issued) values (?,?,?,?,?)");
	            
	            preparedStatement.setObject(1,b1.getClientId() );//---Set values to sql object
	            preparedStatement.setObject(2,b1.getBookISBN());//---Set values to sql object
	            
	            //Creating a dateformat to use dates from the calendar.
	            
	    		
	    		preparedStatement.setObject(3,formatter.format(cal.getTime()));
	    		cal.add(Calendar.DAY_OF_MONTH, 14);
	    		preparedStatement.setObject(4,formatter.format(cal.getTime()));
	    		preparedStatement.setObject(5, 1);
	    		
	    		if(preparedStatement.executeUpdate()>0) { //---Execute sql and returns whether it was executed or not
	    		return true;	   
	       
	    		}
	    		else
	    			return false;
	}
	
	//***----------------------------------------------------------Updating the number of copies--------------------------------------------------------------------***//
	public static void updateBook(IssueBook b1) {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("update book "
	        		+"set NoOFCopies = NoOFCopies -1 "
	        		+"where ISBN =?"
	        		);
	        preparedStatement.setObject(1, b1.getBookISBN());
	        preparedStatement.executeUpdate();
			
			
			
			
		}catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
}
	
	


	//***----------------------------------------------------------Getting date difference when returning the book--------------------------------------------------------------------***//
	public static BookReturn returnBookTitleAndDate(User u1) {
		
		BookReturn rb = new BookReturn();
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select BookTitle,DATEDIFF(curdate(),ib.ReturnedDate),b1.ISBN "+ 
					"from book b1,issuebook ib "+ 
					"where b1.ISBN = ib.ISBN && IssuedDate=(select max(IssuedDate) from issuebook) && ClientId=?");
			preparedStatement.setObject(1, u1.getUserId());
			
			ResultSet rst = preparedStatement.executeQuery();
			
			
			if(rst.next()) {
				rb.setBookTitle(rst.getString(1));
				rb.setDateDifference(rst.getInt(2));
				rb.setBookISBN(rst.getString(3));
				
				
			}
			
		}catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
            
		}
		return rb;
	 }
	
	//***----------------------------------------------------------Updating the number of copies--------------------------------------------------------------------***//
	public static void updateReturnBook(BookReturn b1) {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("update book "
	        		+"set NoOFCopies = NoOFCopies+1 "
	        		+"where ISBN =?"
	        		);
	        preparedStatement.setObject(1, b1.getISBN());
	        preparedStatement.executeUpdate();
			
			
			
			
		}catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
	}
	
	//***----------------------------------------------------------Updating the issued status in issued book--------------------------------------------------------------------***//
		public static void updateIssuedStatus(User u1) {
			try {
				Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
		        PreparedStatement preparedStatement = connection.prepareStatement("update issuebook "
		        		+"set Issued = 0 "
		        		+"where ClientId =?"
		        		);
		        preparedStatement.setObject(1, u1.getUserId());
		        preparedStatement.executeUpdate();
				
				
				
				
			}catch(SQLException e) {//--Catch if any sql exception occurred
		        e.printStackTrace();
				
			}
			
			
		}	
	
	//***----------------------------------------------------------Check the registration number is avilable--------------------------------------------------------------------***//
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
	
	
	public static User getUserDetails(User u1) {
		 
		User detaileduser =  new User();
		try {
	            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	            PreparedStatement preparedStatement = connection.prepareStatement("" +
	                    "select ClientName,Email,PhoneNumber " +
	                    "from client " +
	                    "where ClientId=?");//---Prepare sql as a java object
	            preparedStatement.setObject(1,u1.getUserId());//---Set values to sql object
	            
	            
	         
	            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
	            
	            if (rst.next()) {//---Navigate pointer to results
	            	
	            	detaileduser.setUserName(rst.getString(1));
	            	detaileduser.setUserEmail(rst.getString(2));
	            	detaileduser.setMobilenumber(rst.getString(3));
	                
	            }
	        } catch (SQLException e) {//--Catch if any sql exception occurred
	            e.printStackTrace();
	        }
		return detaileduser;
		
	}
	
	
	public static void updateUserDetails(User u1) {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("update client "
	        		+"set ClientName = ?, Email = ?, PhoneNumber = ? "
	        		+"where ClientId=?;"
	        		);
	        preparedStatement.setObject(1, u1.getUserName());
	        preparedStatement.setObject(2, u1.getUserEmail());
	        preparedStatement.setObject(3, u1.getMobilenumber());
	        preparedStatement.setObject(4, u1.getUserId());
	        preparedStatement.executeUpdate();
			
			
			
			
		}catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
	}
	
public static Book checkISBN(Book bk) {
		
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("select ISBN,BookTitle,Author,BookType,NoOFCopies " + 
	        		"from book "+ 
	        		"where ISBN = ?"
	        		);
	        preparedStatement.setObject(1,bk.getBookISBN());
	        ResultSet rst = preparedStatement.executeQuery();
	        
	        
	        if(rst.next()) {
	        	System.out.println(123);
	        	System.out.println(rst.getString(1).equals(""));
	        	
	        	if(!rst.getString(1).isEmpty()) {
	        	bk.setBooktitle(rst.getString(2));
	        	bk.setAuthor(rst.getString(3));
	        	bk.setBookType(rst.getString(4));
	        	bk.setNoOfCopies(rst.getInt(5));
	        	
	        	return bk;
	        }
	        	else {
	        		System.out.println(456);
	        		return null;}
	        	}   	
	    }catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
		
		return null;
	}



public static boolean ckISBN(Book bk) {
	
	try {
		Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
        PreparedStatement preparedStatement = connection.prepareStatement("select ISBN,BookTitle,Author,BookType,NoOFCopies " + 
        		"from book "+ 
        		"where ISBN = ?"
        		);
        preparedStatement.setObject(1,bk.getBookISBN());
        ResultSet rst = preparedStatement.executeQuery();
        
        
        if(rst.next()) {
        	
        	bk.setBooktitle(rst.getString(2));
        	bk.setAuthor(rst.getString(3));
        	bk.setBookType(rst.getString(4));
        	bk.setNoOfCopies(rst.getInt(5));
        	
        	return true;
        }}catch(SQLException e) {//--Catch if any sql exception occurred
        e.printStackTrace();
		
	}
	return false;	
	}


	public static void updatebook2(Book bk) {
		try {
			Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
	        PreparedStatement preparedStatement = connection.prepareStatement("update book "
	        		+"set BookTitle = ?, Author = ?, BookType= ?, NoOFCopies = ? "
	        		+"where ISBN =?"
	        		);
	        preparedStatement.setObject(1,bk.getBooktitle());
	        preparedStatement.setObject(2,bk.getAuthor());
	        preparedStatement.setObject(3,bk.getBookType());
	        preparedStatement.setObject(4,bk.getNoOfCopies());
	        preparedStatement.setObject(5,bk.getBookISBN());
	        
	        
	        preparedStatement.executeUpdate();
			
			
			
			
		}catch(SQLException e) {//--Catch if any sql exception occurred
	        e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
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

