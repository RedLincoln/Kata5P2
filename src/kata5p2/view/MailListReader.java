package kata5p2.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReader {

    
    public static List<Mail> read (String fileName) throws IOException {
        List<Mail> mailList = new ArrayList<>();
        readFromFile(fileName, mailList);
        return mailList;
    }
    
    private static void readFromFile(String fileName, List mailList) throws FileNotFoundException, IOException {
        try(FileReader file = new FileReader(fileName)){
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while( ( line = reader.readLine() ) != null ){
                checkEmail(line, mailList);
            }
        }
    }
    
    private static void checkEmail(String line, List mailList) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(line);
        if ( matcher.find() )
                mailList.add(new Mail(line));
    }


}
