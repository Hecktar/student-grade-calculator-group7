package com.vut.calculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @Before
    public void setUp() {
        calculator = new GradeCalculator();
    }

    @Test
    public void testFinalMarkCalculation_StandardCase() {
        double finalMark = calculator.calculateFinalMark(55.0, 65.0);
        assertEquals(61.0, finalMark, 0.01);
    }

    @Test
    public void testFinalMarkCalculation_HighMarks() {
        double finalMark = calculator.calculateFinalMark(85.0, 90.0);
        assertEquals(88.0, finalMark, 0.01);
    }

    @Test
    public void testFinalMarkCalculation_LowMarks() {
        double finalMark = calculator.calculateFinalMark(30.0, 40.0);
        assertEquals(36.0, finalMark, 0.01);
    }

    @Test
    public void testGrade_Distinction() {
        assertEquals("Distinction", calculator.determineGrade(85.0));
    }

    @Test
    public void testGrade_DistinctionBoundary() {
        assertEquals("Distinction", calculator.determineGrade(80.0));
    }

    @Test
    public void testGrade_Merit() {
        assertEquals("Merit", calculator.determineGrade(75.0));
    }

    @Test
    public void testGrade_MeritLowerBoundary() {
        assertEquals("Merit", calculator.determineGrade(70.0));
    }

    @Test
    public void testGrade_Credit() {
        assertEquals("Credit", calculator.determineGrade(65.0));
    }

    @Test
    public void testGrade_CreditLowerBoundary() {
        assertEquals("Credit", calculator.determineGrade(60.0));
    }

    @Test
    public void testGrade_Pass() {
        assertEquals("Pass", calculator.determineGrade(55.0));
    }

    @Test
    public void testGrade_PassLowerBoundary() {
        assertEquals("Pass", calculator.determineGrade(50.0));
    }

    @Test
    public void testGrade_Fail() {
        assertEquals("Fail", calculator.determineGrade(49.0));
    }

    @Test
    public void testGrade_FailZero() {
        assertEquals("Fail", calculator.determineGrade(0.0));
    }

    @Test
    public void testExamAdmission_Admitted() {
        assertTrue(calculator.hasExamAdmission(70.0));
    }

    @Test
    public void testExamAdmission_BoundaryAdmitted() {
        assertTrue(calculator.hasExamAdmission(40.0));
    }

    @Test
    public void testExamAdmission_Denied() {
        assertFalse(calculator.hasExamAdmission(39.0));
    }

    @Test
    public void testExamAdmission_Between40And45() {
        assertTrue(calculator.hasExamAdmission(40.0));
        assertTrue(calculator.hasExamAdmission(42.5));
        assertTrue(calculator.hasExamAdmission(44.9));
    }

    @Test
    public void testClassAverage_Normal() {
        double[] marks = {60.0, 70.0, 80.0};
        assertEquals(70.0, calculator.calculateClassAverage(marks), 0.01);
    }

    @Test
    public void testClassAverage_SingleStudent() {
        double[] marks = {55.0};
        assertEquals(55.0, calculator.calculateClassAverage(marks), 0.01);
    }

    @Test
    public void testClassAverage_EmptyArray() {
        double[] marks = {};
        assertEquals(0.0, calculator.calculateClassAverage(marks), 0.01);
    }

    @Test
    public void testClassAverage_FiveStudents() {
        double[] marks = {50.0, 60.0, 70.0, 80.0, 90.0};
        assertEquals(70.0, calculator.calculateClassAverage(marks), 0.01);
    }

    @Test
    public void testPassRate_AllPass() {
        double[] marks = {60.0, 70.0, 80.0};
        assertEquals(100.0, calculator.calculatePassRate(marks), 0.01);
    }

    @Test
    public void testPassRate_MixedResults() {
        double[] marks = {55.0, 45.0, 70.0, 30.0, 90.0};
        assertEquals(60.0, calculator.calculatePassRate(marks), 0.01);
    }

    @Test
    public void testPassRate_NonePass() {
        double[] marks = {30.0, 40.0, 45.0, 49.0, 20.0};
        assertEquals(0.0, calculator.calculatePassRate(marks), 0.01);
    }

    @Test
    public void testHighestMark_Normal() {
        double[] marks = {45.0, 91.0, 78.0};
        assertEquals(91.0, calculator.findHighestMark(marks), 0.01);
    }

    @Test
    public void testHighestMark_AllSame() {
        double[] marks = {70.0, 70.0, 70.0};
        assertEquals(70.0, calculator.findHighestMark(marks), 0.01);
    }

    @Test
    public void testHighestMark_FirstElement() {
        double[] marks = {95.0, 45.0, 78.0};
        assertEquals(95.0, calculator.findHighestMark(marks), 0.01);
    }

    @Test
    public void testSupplementary_Eligible() {
        assertTrue(calculator.qualifiesForSupplementary(47.0));
    }

    @Test
    public void testSupplementary_LowerBoundary() {
        assertTrue(calculator.qualifiesForSupplementary(45.0));
    }

    @Test
    public void testSupplementary_UpperBoundary() {
        assertTrue(calculator.qualifiesForSupplementary(49.0));
    }

    @Test
    public void testSupplementary_TooLow() {
        assertFalse(calculator.qualifiesForSupplementary(44.0));
    }

    @Test
    public void testSupplementary_TooHigh() {
        assertFalse(calculator.qualifiesForSupplementary(50.0));
    }

    @Test
    public void testValidMark_Negative() {
        assertFalse(calculator.isValidMark(-5.0));
    }

    @Test
    public void testValidMark_Over100() {
        assertFalse(calculator.isValidMark(105.0));
    }

    @Test
    public void testValidMark_WayOver100() {
        assertFalse(calculator.isValidMark(150.0));
        assertFalse(calculator.isValidMark(200.0));
    }
}