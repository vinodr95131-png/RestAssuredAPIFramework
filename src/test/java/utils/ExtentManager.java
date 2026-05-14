package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                            + "/reports/APIReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName(
                    "REST Assured API Report");

            sparkReporter.config().setDocumentTitle(
                    "API Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);
        }

        return extent;
    }
}