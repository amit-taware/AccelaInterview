package reports;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReports {


    private static final String jsonPath = "/target/cucumber.json";
    private static final String reportDirectory = "/target/cucumber-html-reports";
    private static final String userDirectory = System.getProperty("user.dir");


    public static void main(String[] args) throws Exception {
        GenerateReport();
    }

    private static void GenerateReport() throws Exception {
        File reportOutputDirectory = new File(userDirectory + reportDirectory);
        List<String> jsonReportFiles = new ArrayList<String>();
        String buildNumber = "1";
        String projectName = "Accela Interview";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        // Additional meta data presented on main page
        configuration.addClassifications("Platform", "Mac");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");
        jsonReportFiles.add(userDirectory + jsonPath);
        ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, configuration);
        reportBuilder.generateReports();
    }
}
