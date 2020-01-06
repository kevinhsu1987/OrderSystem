import java.sql.*;

public class OrderClient {

    public static void main(String[] args) {
        class mysql extends JDBCmysql {
            private Connection con = null; //Database objects
            //連接object
            private Statement stat = null;
            //執行,傳入之sql為完整字串
            private ResultSet rs = null;
            //結果集
            private PreparedStatement pst = null;

            ResultSet SelectTable(String comment) {
                try {
                    con.createStatement();
                    rs = stat.executeQuery(comment);
                    System.out.println("type\t\tname\t\tcost");
                    while (rs.next()) {
                        System.out.println(rs.getString("type") + "\t" +
                                rs.getString("name") + "\t" + rs.getString("cost"));
                    }
                } catch (SQLException e) {
                    System.out.println("DropDB Exception :" + e.toString());
                } finally {
                    Close();
            }
                return rs;
            }
        }
        JDBCmysql sql = new JDBCmysql();
        sql.SelectTable();

        OrderWindow window = new OrderWindow();
    }
}
