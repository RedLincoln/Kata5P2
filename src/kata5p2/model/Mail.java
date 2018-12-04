package kata5p2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private final String mail;
    private String domain;
    
    public Mail(String mail) {
        this.mail = mail;
        setDomain();
    }
    
    private void setDomain(){
        Pattern pattern = Pattern.compile("@([A-Z0-9.-]+)\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);
        if ( matcher.find() )
            domain = matcher.group(1);
    }
    
    public String getDomain(){
        return domain;
    }

    @Override
    public String toString() {
        return mail;
    }
    
    
}
