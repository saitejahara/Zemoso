package Assignment12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClass  {
    public void printDepartmentNames(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();

        Set<String> departments = stream
                .map((student) -> student.getEngDepartment())
                .collect(Collectors.toSet());

        System.out.println("Departments: ");
        for(String department : departments) {
            System.out.println(department);
        }
    }

    public void enrolledAfter2018(List<Student> studentList) {
        int year=2018;
        Stream<Student> stream = studentList.stream();

        List<Student> filterList = stream
                .filter((student) -> student.getYearOfEnrollment() > year)
                .collect(Collectors.toList());

        System.out.println("Students enrolled after year " + year + ": ");
        for(Student student : filterList) {
            System.out.println(student);
        }
    }

    public void getMaleStudentsFromCS(List<Student> studentList) {
        String department="Computer Science";
        Stream<Student> stream = studentList.stream();

        List<Student> maleStudents = stream
                .filter((student) -> student.getEngDepartment().equalsIgnoreCase(department))
                .filter((student) -> student.getGender().equalsIgnoreCase("male"))
                .collect(Collectors.toList());

        System.out.println("Male students of " + department + ": ");

        for (Student student : maleStudents) {
            System.out.println(student);
        }
    }

    public void countMaleAndFemaleStudents(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();
        Map<String,List<Student>> genderCount = stream.collect(Collectors.groupingBy(Student:: getGender));

        System.out.println("No. of Male students: " + genderCount.get("Male").size());
        System.out.println("No. of Female students: " + genderCount.get("Female").size());
    }

    public void getAverageStudentsAge(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();
        Map<String,List<Student>> genderCount = stream.collect(Collectors.groupingBy(Student:: getGender));

        double maleAverage = 0.0;
        double femaleAverage = 0.0;
        int maleCount = genderCount.get("Male").size();
        int femaleCount = genderCount.get("Female").size();

        for(Student student : genderCount.get("Male")) {
            maleAverage += student.getAge();
        }
        for(Student student : genderCount.get("Female")) {
            femaleAverage += student.getAge();
        }

        maleAverage /= maleCount;
        femaleAverage /= femaleCount;

        System.out.println("Average age of male students: " + maleAverage);
        System.out.println("Average age of female students: " + femaleAverage);
    }

    public void studentWithHighestPercentage(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();

        Optional<Student> student = stream.max(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if(s2.getPerTillDate() - s1.getPerTillDate() > 0) return -1;
                else if(s2.getPerTillDate() - s1.getPerTillDate() < 0) return 1;
                else return 0;
            }
        });

        if(student.isPresent()) {
            System.out.println("Student with the highest percentage is: " + student);
        }
        else {
            System.out.println("Student data unavailable");
        }
    }

    public void studentCountInEachDepartment(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();
        Map<String,List<Student>> studentCountByDepartment = stream.collect(Collectors.groupingBy(Student:: getEngDepartment));

        System.out.println("No. of students in each Dept. are: ");
        for(Map.Entry<String, List<Student>> entry : studentCountByDepartment.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size());
        }
    }

    public void averagePercentageDepartment(List<Student> studentList) {
        Stream<Student> stream = studentList.stream();
        Map<String,List<Student>> studentCountByDepartment = stream.collect(Collectors.groupingBy(Student:: getEngDepartment));

        System.out.println("Average percentage in each department is: ");
        for(Map.Entry<String, List<Student>> entry : studentCountByDepartment.entrySet()) {
            double avg = 0.0;
            List<Student> tempList = entry.getValue();
            int deptSize = tempList.size();
            for(Student student : tempList) {
                avg += student.getPerTillDate();
            }
            avg /= deptSize;
            System.out.println(entry.getKey() + " - " + avg);
        }
    }

    public void youngestMaleDepartmentWise(List<Student> studentList) {
        String department="Electronic";

        Stream<Student> stream = studentList.stream();

        Optional<Student> youngestMale = stream
                .filter((student) -> student.getEngDepartment().equalsIgnoreCase(department))
                .filter((student) -> student.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.minBy(new Comparator<Student>() {
                    public int compare(Student s1, Student s2) {
                        return s1.getAge() - s2.getAge();
                    }
                }));

        if(youngestMale.isPresent()) {
            System.out.println("The youngest male student in " + department + " is :\n"+ youngestMale);
        }
        else {
            System.out.println("Student data unavailable");
        }
    }

    public void countMaleAndFemaleStudentsInCS(List<Student> studentList) {
        String department="Computer Science";

        Stream<Student> stream = studentList.stream();

        Map<String,List<Student>> genderCountByDept = stream
                .filter((student) -> student.getEngDepartment().equalsIgnoreCase(department))
                .collect(Collectors.groupingBy(Student:: getGender));

        System.out.println("Male count in " + department + ": " +
                genderCountByDept.get("Male").size());
        System.out.println("Female count in " + department + ": " +
                genderCountByDept.get("Female").size());

    }

    public void initializeStudentList(List<Student> studentList) {
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
    }
}