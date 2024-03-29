package util;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportUtils {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static DateFormat dateFormatFile = new SimpleDateFormat("dd-M-yyyy");
    private static Date date = new Date();

    public static void report(){
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setReportDirectory("target/report/");
        reportBuilder.setReportFileName(dateFormatFile.format(date));
        reportBuilder.setReportTitle("Projeto Mobile Automation");
        reportBuilder.setReportColor(Color.CYAN);
        reportBuilder.enableVoiceControl();
        reportBuilder.setAdditionalInfo("Environment", "My Environment");
        reportBuilder.setAdditionalInfo("Date", dateFormat.format(date));
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("target/report/cucumber.json"));
        reportBuilder.build(cucumberJsonReports);
    }
}
