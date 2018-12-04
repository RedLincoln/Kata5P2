package kata5p2.main;

import kata5p2.model.Histogram;
import kata5p2.view.HistogramDisplay;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JOptionPane;
import kata5p2.model.Mail;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDB;

public class Kata5P2 {
    private String fileName;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws Exception {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();
    }

    private void execute() throws Exception {
        input();
        process();
        output();
    }

    private void input() {
        fileName = JOptionPane.showInputDialog("Introduce nombre de fichero");
    }
    
    
    private void process() throws Exception {
        List<Mail> emails = MailListReaderDB.read(fileName);
        histogram = MailHistogramBuilder.build(emails);
    }

    private void output() {
        HistogramDisplay histDisplay = new HistogramDisplay(histogram);
        histDisplay.execute();
    }
    
    
    
}
