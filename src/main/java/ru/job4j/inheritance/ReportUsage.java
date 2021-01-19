package ru.job4j.inheritance;

import java.sql.SQLOutput;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        JSONReport reportSecond = new JSONReport();
        String textSecond = reportSecond.generate("Report's name", "Report's body");
        System.out.println(textSecond);
    }
}
