package database;

/**
 * Created by mac on 2016/11/22.
 */
import java.sql.*;
import java.util.ArrayList;

public class DataBaseHelper {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/HMS?useUnicode=true&characterEncoding=UTF-8" +
            "&zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    // Connection and operation
    static Connection conn = null;
    static Statement stmt = null;

    /**
     * 从数据库取出数据操作
     * @param table
     * @param content
     * @return
     */
    public static ArrayList<String> outSelect(String table,String content){
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
                ResultSet rs = stmt.executeQuery("select " + content + " from " + table);

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
     * 依据传入SQL语句，从数据库取出数据操作
     * @param sql
     * @param content
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
     * 从数据库取出单个数据操作
     * @param table
     * @param content
     * @param condition
     * @param concrete
     * @return
     */
    public static String outSingle(String table,String content,String condition, String concrete){
        String result = null;

        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            stmt = conn.createStatement();

            try {
                ResultSet rs = stmt.executeQuery("select " + content + " from " + table + " where " + condition
                + " = '" + concrete + "'" );

                if(rs.next())
                    result = rs.getString(content);

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
        return result;
    }

    /**
     * 从数据库中取出一行操作
     * @param table
     * @param condition
     * @param concrete
     * @return
     */
    public static  ArrayList<String> outRow(String table ,String condition, String concrete){

        ArrayList<String> result = new ArrayList<String>();

        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute two queries
            stmt = conn.createStatement();
            Statement stmt_ = conn.createStatement();
            try {
                ResultSet rs = stmt.executeQuery("select * from " + table + " where " + condition
                        + " = '" + concrete + "'" );

                //查询该表中有多少列
                ResultSet temp = stmt_.executeQuery("select count(*) from information_schema.columns where table_schema='HMS' and table_name = '" + table + "'");
                int size = 0;
                if(temp.next())
                    size = temp.getInt("count(*)");

                if(rs.next()) {
                    for (int i = 1; i <= size; i++) {
                        String a = rs.getString(i);
                        result.add(a);
                    }
                }

                //Clean-up environment
                rs.close();
                temp.close();
                stmt.close();
                stmt_.close();
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
        return result;
    }

    /**
     * 向数据库放入数据操作（包括删除操作）
     * @param sql
     * @return
     */
    public static boolean in(String sql) {
        int exist = 0;
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            stmt = conn.createStatement();

            try {
                exist = stmt.executeUpdate(sql);
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
        if (exist == 0)
            return false;
        else
            return true;
    }
}
