import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDemo {
    private String url = "jdbc:mysql:///35.236.156.108/order01";
    private String user = "s92006351012@gmail.com";
    private String passwd = "Kev!n1987";
    public static void main(String[] args) {
        try {

            DBSource dbsource = new SimpleDBSource();
            Connection conn = dbsource.getConnection();

            if(!conn.isClosed()) {
                System.out.println("資料庫連接已開啟…");
            }

            dbsource.closeConnection(conn);

            if(conn.isClosed()) {
                System.out.println("資料庫連接已關閉…");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}