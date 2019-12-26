import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SimpleDBSource implements DBSource {
    private Properties props;
    private String url = "jdbc:mysql://35.236.156.108/order01?";
    private String user = "s92006351012@gmail.com";
    private String passwd = "Kev!n1987";

    public SimpleDBSource() throws IOException,
            ClassNotFoundException {
        //this("jdbc.properties");
    }

    public SimpleDBSource(String configFile) throws IOException,
            ClassNotFoundException {
        props = new Properties();
        props.load(new FileInputStream(configFile));

        url = props.getProperty("onlyfun.caterpillar.url");
        user = props.getProperty("onlyfun.caterpillar.user");
        passwd = props.getProperty("onlyfun.caterpillar.password");

        Class.forName(
                props.getProperty("onlyfun.caterpillar.driver"));
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}