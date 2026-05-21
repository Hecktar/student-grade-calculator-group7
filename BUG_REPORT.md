# Bug Report — Student Grade Calculator (Group 7)

| # | Location | Description | Test(s) that exposed it | Fix |
|---|----------|-------------|-------------------------|-----|
| 1 | `calculateFinalMark` | Semester/exam weights swapped (0.6/0.4 instead of 0.4/0.6) | `testFinalMarkCalculation_*` | Use `(semester × 0.4) + (exam × 0.6)` |
| 2 | `determineGrade` | Wrong boundaries (e.g. Distinction only `> 80`, Pass at `>= 55`) | `testGrade_*` | Align to VUT: 80+, 70+, 60+, 50+, else Fail |
| 3 | `hasExamAdmission` | Threshold was 45 instead of 40 | `testExamAdmission_*` | Require `semesterMark >= 40` |
| 4 | `calculateClassAverage` | Divided by `length + 1`; empty array mishandled | `testClassAverage_*` | Divide by `length`; empty → `0.0` |
| 5 | `calculatePassRate` | Wrong pass threshold (55) and returned ratio not % | `testPassRate_*` | Pass at `>= 50`; return percentage 0–100 |
| 6 | `findHighestMark` | Used `<` so lowest mark was kept | `testHighestMark_*` | Compare with `>` |
| 7 | `qualifiesForSupplementary` | Checked 40–44 instead of 45–49 | `testSupplementary_*` | `finalMark >= 45 && finalMark <= 49` |
| 8 | `isValidMark` | Allowed -10 to 110 | `testValidMark_*` | Only `0` to `100` inclusive |
| 9 | `generateStudentReport` | Inverted `if` showed ADMITTED when denied | `testStudentReport_*` | Use `if (hasExamAdmission(...))` for admitted block |

## TODO tests completed

| TODO test | Purpose |
|-----------|---------|
| `testExamAdmission_Between40And45` | Semester 40–44 must still be admitted |
| `testClassAverage_FiveStudents` | Class average with five marks |
| `testPassRate_NonePass` | Pass rate when no one passes |
| `testHighestMark_FirstElement` | Highest mark when it is first in the array |
| `testValidMark_WayOver100` | Invalid marks above 100 |

## Verification

```bash
mvn test
```

All tests must pass before merging to `main`.
## QA Final Verification
**Date:** 21 May 2026
**All 38 JUnit tests pass.**
**Live app tested:** semester=55, exam=65 → final=61.0, grade=Credit.
**Verified by:** Sanelisiwe Mahlangu (QA/Tester)
