package com.vut.calculator;

public class GradeCalculator {

    public double calculateFinalMark(double semesterMark, double examMark) {
        if (!isValidMark(semesterMark) || !isValidMark(examMark)) {
            return -1;
        }
        double finalMark = (semesterMark * 0.4) + (examMark * 0.6);
        return Math.round(finalMark * 100.0) / 100.0;
    }

    public String determineGrade(double finalMark) {
        if (finalMark < 0 || finalMark > 100) {
            return "Invalid";
        }
        if (finalMark >= 80) {
            return "Distinction";
        }
        if (finalMark >= 70) {
            return "Merit";
        }
        if (finalMark >= 60) {
            return "Credit";
        }
        if (finalMark >= 50) {
            return "Pass";
        }
        return "Fail";
    }

    public boolean hasExamAdmission(double semesterMark) {
        return isValidMark(semesterMark) && semesterMark >= 40;
    }

    public double calculateClassAverage(double[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return Math.round((total / marks.length) * 100.0) / 100.0;
    }

    public double calculatePassRate(double[] finalMarks) {
        if (finalMarks == null || finalMarks.length == 0) {
            return 0.0;
        }
        int passCount = 0;
        for (double mark : finalMarks) {
            if (mark >= 50) {
                passCount++;
            }
        }
        return Math.round(((double) passCount / finalMarks.length) * 10000.0) / 100.0;
    }

    public double findHighestMark(double[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    public boolean qualifiesForSupplementary(double finalMark) {
        return finalMark >= 45 && finalMark <= 49;
    }

    public boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }

    public String generateStudentReport(String studentName, double semesterMark, double examMark) {
        StringBuilder report = new StringBuilder();
        report.append("=== Student Report ===\n");
        report.append("Name: ").append(studentName).append("\n");
        report.append("Semester Mark: ").append(semesterMark).append("\n");

        if (hasExamAdmission(semesterMark)) {
            report.append("Exam Admission: ADMITTED\n");
            report.append("Exam Mark: ").append(examMark).append("\n");
            double finalMark = calculateFinalMark(semesterMark, examMark);
            report.append("Final Mark: ").append(finalMark).append("\n");
            report.append("Grade: ").append(determineGrade(finalMark)).append("\n");
        } else {
            report.append("Exam Admission: DENIED\n");
            report.append("Status: Student did not meet minimum semester mark requirement.\n");
        }

        report.append("======================\n");
        return report.toString();
    }
}
