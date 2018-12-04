
package kata5p2.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderDB {

    
    public static List<Mail> read (String fileName) throws IOException {
        List<Mail> mailList = new ArrayList<>();
        readFromDB(fileName, mailList);
        return mailList;
    }
    
    private static void readFromDB(String fileName, List mailList) throws FileNotFoundException, IOException {
        String sql = "SELECT * FROM EMAIL";
        String url = "jdbc:sqlite:" +  fileName;
        try ( Connection conn = DriverManager.getConnection(url);
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()) {
                checkEmail(rs.getString("mail"), mailList);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void checkEmail(String line, List mailList) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(line);
        if ( matcher.find() )
                mailList.add(new Mail(line));
    }


}
