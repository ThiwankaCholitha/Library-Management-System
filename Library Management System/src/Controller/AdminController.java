package Controller;
import DatabaseConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Classes.Book;
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into client (clientId,clientName,Email,PhoneNumber,Fine,BookId) values (?,?,?,?,?,?)");
            
            preparedStatement.setObject(1, user.getUserId());//---Set values to sql object
            preparedStatement.setObject(2, user.getUserName());//---Set values to sql object
            preparedStatement.setObject(3, user.getUserEmail());//---Set values to sql object
            preparedStatement.setObject(4, user.getMobilenumber());//---Set values to sql object
            preparedStatement.setObject(5, 0);//---Set values to sql object
            preparedStatement.setObject(6,null);//---Set values to sql object
            preparedStatement.executeUpdate(); //---Execute sql and returns whether it was executed or not
          
               
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
      
    }
    
    
    
    
    //-------------------------------------------------Adding the book-------------------------------------------------------
    public static void addBook(Book book) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book (BookId,ISBN,BookTitle,BorrowedDate,ReturnedDate) values (?,?,?,?,?)");
            
            preparedStatement.setObject(1,book.getBookId() );//---Set values to sql object
            preparedStatement.setObject(2,book.getBookISBN());//---Set values to sql object
            preparedStatement.setObject(3,book.getBooktitle());//---Set values to sql object
            preparedStatement.setObject(4,null);//---Set values to sql object
            preparedStatement.setObject(5,null);//---Set values to sql object
            preparedStatement.executeUpdate(); //---Execute sql and returns whether it was executed or not
                
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
      
    }
    
    
    public ArrayList<String[]> getIntakes() {
        ArrayList<String[]> user = new ArrayList<>();//---Creates an array object (ArrayList) to store multiple objects
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("select batchId,name from batch");//---Prepare sql as a java object
            ResultSet rst = preparedStatement.executeQuery();//---Execute sql and store result
            while (rst.next()) {//---Navigate pointer to result rows until it ends
                String[] users = new String[6];//---Creates a batch object
                users[0]= rst.getString(0);//---Set table row data to batch model object
                users[1]= rst.getString(1);//---Set table row data to batch model object
                users[2]= rst.getString(2);//---Set table row data to batch model object
                users[3]= rst.getString(3);//---Set table row data to batch model object
                users[4]= rst.getString(4);//---Set table row data to batch model object
                users[5] = rst.getString(5);
                
                
                
                
                
                
                user.add(users);
                
            }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
        return user;//---Return batches array object with a length > 0 if batches exists, if not array object returns with a length = 0
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
}
