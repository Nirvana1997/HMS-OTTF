package database;

/**
 * Created by mac on 2016/11/22.
 */
import java.sql.*;
import java.util.ArrayList;

public class DataBaseHelper {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/HMS";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    // Connection and operation
    static Connection conn = null;
    static Statement stmt = null;

    /**
     * 从数据库取出数据操作
     * @param sql,content
     * @return
     */
    public static ArrayList<String> out(String sql,String content){
        //store the result
        ArrayList<String> arrayList = new ArrayList<String>();

        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();

            try {
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    String string = rs.getString(content);
                    arrayList.add(string);
                }
                //Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * 向数据库放入数据操作（包括删除操作）
     * @param sql
     */
    public static void in(String sql) {

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            stmt = conn.createStatement();

            try {
                stmt.executeUpdate(sql);
                //Clean-up environment
                stmt.close();
                conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
