package com.vut.calculator;

public class GradeCalculator {

    // BUG FIX #1: Weights were swapped (should be 0.4 semester, 0.6 exam)
    public double calculateFinalMark(double semesterMark, double examMark) {
        if (!isValidMark(semesterMark) || !isValidMark(examMark)) {
            return -1;
        }
        double finalMark = (semesterMark * 0.4) + (examMark * 0.6);
        return Math.round(finalMark * 100.0) / 100.0;
    }

    // BUG FIX #2: Grade boundaries corrected per VUT policy
    public String determineGrade(double finalMark) {
        if (finalMark < 0 || finalMark > 100) return "Invalid";
        if (finalMark >= 80) return "Distinction";
        if (finalMark >= 70) return "Merit";
        if (finalMark >= 60) return "Credit";
        if (finalMark >= 50) return "Pass";
        if (finalMark >= 45) return "Supplementary";
        return "Fail";
    }

    // BUG FIX #3: Exam admission threshold changed from 45 to 40
    public boolean hasExamAdmission(double semesterMark) {
        return isValidMark(semesterMark) && semesterMark >= 40;
    }

    // BUG FIX #4: Class average – divide by length, not length+1
    public double calculateClassAverage(double[] marks) {
        if (marks == null || marks.length == 0) {
            return -1;
        }
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return Math.round((total / marks.length) * 100.0) / 100.0;
    }

    // BUG FIX #5: Pass rate – threshold 50, return ratio (not percentage)
    public double calculatePassRate(double[] finalMarks) {
        if (finalMarks == null || finalMarks.length == 0) {
            return -1;
        }
        int passCount = 0;
        for (double mark : finalMarks) {
            if (mark >= 50) {
                passCount++;
            }
        }
        return Math.round(((double) passCount / finalMarks.length) * 100.0) / 100.0;
    }

    // BUG FIX #6: Highest mark – use > instead of <
    public double findHighestMark(double[] marks) {
        if (marks == null || marks.length == 0) {
            return -1;
        }
        double highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    // BUG FIX #7: Supplementary eligibility – 45-49 inclusive (was 40-44)
    public boolean qualifiesForSupplementary(double finalMark) {
        return finalMark >= 45 && finalMark <= 49;
    }

    // BUG FIX #8: Valid mark range 0-100 (was -10 to 110)
    public boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }
}