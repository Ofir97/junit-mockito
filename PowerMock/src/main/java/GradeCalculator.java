import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {

    public List<String> getGrades(List<Integer> scores) {
        List<String> grades = new ArrayList<>();
        for (Integer score : scores) {
            grades.add(computeGrade(score));
        }
        return grades;
    }

    private String computeGrade(Integer score) {
        return score < 55 ? "Fail" : "Pass";
    }
}
