package Controller;
import DatabaseConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

 /*   //----------------------------------------------------Add user------------------------------------------------------
    public boolean addUser(User user) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();//---Get database connection
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user (uId,password,accountType,emailAddress) values (?,?,?,?)");//---Prepare sql as a java object
            preparedStatement.setObject(1, user.getuId());//---Set values to sql object
            preparedStatement.setObject(2, user.getPassword());//---Set values to sql object
            preparedStatement.setObject(3, "student");//---Set values to sql object
            preparedStatement.setObject(4, user.getEmailAddress());//---Set values to sql object
            if (preparedStatement.executeUpdate() > 0) {//---Execute sql and returns whether it was executed or not
                return true;
            }
        } catch (SQLException e) {//--Catch if any sql exception occurred
            e.printStackTrace();
        }
        return false;//---Returns if add fails
    }

    //----------------------------------------------------Update email--------------------------------------------------
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
