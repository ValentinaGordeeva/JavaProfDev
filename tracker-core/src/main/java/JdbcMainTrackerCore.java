import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMainTrackerCore {
    public static void main(String [] arg) throws ClassNotFoundException, SQLException {
         Class.forName("org.h2.Driver");
       Connection connection = DriverManager.getConnection("jdbc:h2:mem test");

    }
}
