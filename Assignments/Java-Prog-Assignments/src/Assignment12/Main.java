package Assignment12;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();

        StreamClass streamClass = new StreamClass();

        streamClass.initializeStudentList(studentList);
        streamClass.printDepartmentNames(studentList);
        streamClass.enrolledAfter2018(studentList);
        streamClass.getMaleStudentsFromCS(studentList);
        streamClass.countMaleAndFemaleStudents(studentList);
        streamClass.getAverageStudentsAge(studentList);
        streamClass.studentWithHighestPercentage(studentList);
        streamClass.studentCountInEachDepartment(studentList);
        streamClass.averagePercentageDepartment(studentList);
        streamClass.youngestMaleDepartmentWise(studentList);
        streamClass.countMaleAndFemaleStudentsInCS(studentList);
    }
}