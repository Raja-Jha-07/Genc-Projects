package com.example.solid;


/**
 * This class demonstrates the Single Responsibility Principle (SRP).
 * According to SRP, a class should have only one reason to change, meaning
 * it should only have one job or responsibility.
 */
public class SingleResponsibility {

    private String reportContent;

    /**
     * Sets the content of the report.
     * 
     * @param content the content to set
     */
    public void setReportContent(String content) {
        this.reportContent = content;
    }

    /**
     * Generates the report based on the content.
     * 
     * @return the generated report
     */
    public String generateReport() {
        return "Report Content: " + reportContent;
    }

    /**
     * Sends the report to the specified recipient.
     * 
     * @param recipient the recipient of the report
     */
    public void sendReport(String recipient) {
        // Logic to send the report to the recipient
        System.out.println("Sending report to: " + recipient);
    }

    public void totalReport(Number count){
        System.out.println("Toatal count number :"+count);
    }
}