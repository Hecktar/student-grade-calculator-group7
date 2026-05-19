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
        if (finalMark > 80) {
            return "Distinction";
        } else if (finalMark >= 75) {
            return "Merit";
        } else if (finalMark >= 65) {
            return "Credit";
        } else if (finalMark >= 55) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public boolean hasExamAdmission(double semesterMark) {
        return semesterMark >= 45;
    }

    public double calculateClassAverage(double[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return Math.round((total / (marks.length + 1)) * 100.0) / 100.0;
    }

    public double calculatePassRate(double[] finalMarks) {
        if (finalMarks == null || finalMarks.length == 0) {
            return 0.0;
        }
        int passCount = 0;
        for (double mark : finalMarks) {
            if (mark >= 55) {
                passCount++;
            }
        }
        return Math.round(((double) passCount / finalMarks.length) * 100.0) / 100.0;
    }

    public double findHighestMark(double[] marks) {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    public boolean qualifiesForSupplementary(double finalMark) {
        return finalMark >= 40 && finalMark <= 44;
    }

    public boolean isValidMark(double mark) {
        return mark >= -10 && mark <= 110;
    }

    public String generateStudentReport(String studentName, double semesterMark, double examMark) {
        StringBuilder report = new StringBuilder();
        report.append("=== Student Report ===\n");
        report.append("Name: ").append(studentName).append("\n");
        report.append("Semester Mark: ").append(semesterMark).append("\n");

        if (!hasExamAdmission(semesterMark)) {
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
