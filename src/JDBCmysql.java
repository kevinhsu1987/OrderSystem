import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCmysql {
    private Connection con = null; //Database objects
    //連接object
    private Statement stat = null;
    //執行,傳入之sql為完整字串
    private ResultSet rs = null;
    //結果集
    private PreparedStatement pst = null;
    //執行,傳入之sql為預儲之字申,需要傳入變數之位置
    //先利用?來做標示

    private String dropdbSQL = "DROP TABLE User ";

    private String createdbSQL = "CREATE TABLE User (" +
            "    id     INTEGER " +
            "  , name    VARCHAR(20) " +
            "  , passwd  VARCHAR(20))";

    private String insertdbSQL = "insert into User(id,name,passwd) " +
            "select ifNULL(max(id),0)+1,?,? FROM User";

    private String selectSQL = "SELECT * FROM menu";

    public JDBCmysql()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //註冊driver
            con = DriverManager.getConnection(
                    "jdbc:mysql://35.236.156.108/Order_Breakfast?useUnicode=true&characterEncoding=UTF8",
                    "root","1qazXSW@");
            //取得connection

            //jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
            //localhost是主機名,test是database名
            //useUnicode=true&characterEncoding=Big5使用的編碼

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("DriverClassNotFound :"+e.toString());
        }//有可能會產生sqlexception
        catch(SQLException x) {
            System.out.println("Exception :"+x.toString());
        }

    }
    //建立table的方式
    //可以看看Statement的使用方式
    public void createTable()
    {
        try
        {
            stat = con.createStatement();
            stat.executeUpdate(createdbSQL);
        }
        catch(SQLException e)
        {
            System.out.println("CreateDB Exception :" + e.toString());
        }
        finally
        {
            Close();
        }
    }
    //新增資料
    //可以看看PrepareStatement的使用方式
    public void insertTable( String name,String passwd)
    {
        try
        {
            pst = con.prepareStatement(insertdbSQL);

            pst.setString(1, name);
            pst.setString(2, passwd);
            pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("InsertDB Exception :" + e.toString());
        }
        finally
        {
            Close();
        }
    }
    //刪除Table,
    //跟建立table很像
    public void dropTable()
    {
        try
        {
            stat = con.createStatement();
            stat.executeUpdate(dropdbSQL);
        }
        catch(SQLException e)
        {
            System.out.println("DropDB Exception :" + e.toString());
        }
        finally
        {
            Close();
        }
    }
    //查詢資料
    //可以看看回傳結果集及取得資料方式
    public String SelectTable()
    {
        String data = "";
        try
        {
            stat = con.createStatement();
            rs = stat.executeQuery(selectSQL);
            System.out.println("type\t\tname\t\tcost");
            while(rs.next())
            {
                System.out.println(rs.getString("type")+"\t\t"+
                        rs.getString("name")+"\t\t"+rs.getString("cost"));
                data += (rs.getString("type")+","+rs.getString("name")+","+rs.getString("cost")+"/");
            }
        }
        catch(SQLException e)
        {
            System.out.println("DropDB Exception :" + e.toString());
        }
        finally
        {
            Close();
        }
        return data;
    }
    //完整使用完資料庫後,記得要關閉所有Object
    //否則在等待Timeout時,可能會有Connection poor的狀況
    private void Close()
    {
        try
        {
            if(rs!=null)
            {
                rs.close();
                rs = null;
            }
            if(stat!=null)
            {
                stat.close();
                stat = null;
            }
            if(pst!=null)
            {
                pst.close();
                pst = null;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Close Exception :" + e.toString());
        }
    }


    public static void main(String[] args)
    {
        //測看看是否正常
        JDBCmysql test = new JDBCmysql();
	  /*  test.dropTable();
	    test.createTable();
	    test.insertTable("yku", "12356");
	    test.insertTable("yku2", "7890"); */
        String data = test.SelectTable();
        System.out.println(data);
    }
}
