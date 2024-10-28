import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/eap_lab";
            String userName = "root";
            String password = "pa$sW04d";

            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Established Connection");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}