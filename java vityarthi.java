import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static abstract class Subject {
        String name;
        int credits;

        Subject(String name, int credits) {
            this.name = name;
            this.credits = credits;
        }

        abstract double getCreditPoint();
        abstract String getResult();
        abstract boolean isGraded();
    }

    static class GradedSubject extends Subject {
        String grade;
        double gradePoint;

        GradedSubject(String name, int credits, String grade) {
            super(name, credits);
            this.grade = grade.toUpperCase();
            this.gradePoint = getGradePoint(this.grade);
        }

        double getCreditPoint() {
            return credits * gradePoint;
        }

        String getResult() {
            return grade;
        }

        boolean isGraded() {
            return true;
        }
    }

    static class NonGradedSubject extends Subject {

        NonGradedSubject(String name, int credits) {
            super(name, credits);
        }

        double getCreditPoint() {
            return 0.0;
        }

        String getResult() {
            return "P";
        }

        boolean isGraded() {
            return false;
        }
    }

    static class Semester {
        int semesterNumber;
        ArrayList<Subject> subjects = new ArrayList<>();

        Semester(int semesterNumber) {
            this.semesterNumber = semesterNumber;
        }

        void addSubject(Subject subject) {
            subjects.add(subject);
        }

        int getTotalCredits() {
            int total = 0;

            for (Subject subject : subjects) {
                total += subject.credits;
            }

            return total;
        }

        int getGradedCredits() {
            int total = 0;

            for (Subject subject : subjects) {
                if (subject.isGraded()) {
                    total += subject.credits;
                }
            }

            return total;
        }

        int getNonGradedCredits() {
            int total = 0;

            for (Subject subject : subjects) {
                if (!subject.isGraded()) {
                    total += subject.credits;
                }
            }

            return total;
        }

        double getTotalCreditPoints() {
            double total = 0;

            for (Subject subject : subjects) {
                total += subject.getCreditPoint();
            }

            return total;
        }

        double calculateGPA() {
            int gradedCredits = getGradedCredits();

            if (gradedCredits == 0) {
                return 0.0;
            }

            return getTotalCreditPoints() / gradedCredits;
        }
    }

    static class Student {
        String name;
        String registerNumber;
        ArrayList<Semester> semesters = new ArrayList<>();

        Student(String name, String registerNumber) {
            this.name = name;
            this.registerNumber = registerNumber;
        }

        void addSemester(Semester semester) {
            semesters.add(semester);
        }

        int getTotalCredits() {
            int total = 0;

            for (Semester semester : semesters) {
                total += semester.getTotalCredits();
            }

            return total;
        }

        int getTotalGradedCredits() {
            int total = 0;

            for (Semester semester : semesters) {
                total += semester.getGradedCredits();
            }

            return total;
        }

        int getTotalNonGradedCredits() {
            int total = 0;

            for (Semester semester : semesters) {
                total += semester.getNonGradedCredits();
            }

            return total;
        }

        double getTotalCreditPoints() {
            double total = 0;

            for (Semester semester : semesters) {
                total += semester.getTotalCreditPoints();
            }

            return total;
        }

        double calculateCGPA() {
            int gradedCredits = getTotalGradedCredits();

            if (gradedCredits == 0) {
                return 0.0;
            }

            return getTotalCreditPoints() / gradedCredits;
        }
    }

    static double getGradePoint(String grade) {
        switch (grade.toUpperCase()) {
            case "S":
                return 10.0;
            case "A":
                return 9.0;
            case "B":
                return 8.0;
            case "C":
                return 7.0;
            case "D":
                return 6.0;
            case "E":
                return 5.0;
            case "F":
                return 0.0;
            case "N":
                return 0.0;
            default:
                return -1.0;
        }
    }

    static boolean isValidGrade(String grade) {
        switch (grade.toUpperCase()) {
            case "S":
            case "A":
            case "B":
            case "C":
            case "D":
            case "E":
            case "F":
            case "N":
                return true;
            default:
                return false;
        }
    }

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Please enter a number greater than 0.");
        }
    }

    static void addSemester(Student student, int number) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("           SEMESTER " + number);
        System.out.println("======================================");

        Semester semester = new Semester(number);

        int numberOfSubjects =
                readPositiveInt("Enter Number of Subjects: ");

        for (int i = 1; i <= numberOfSubjects; i++) {

            System.out.println();
            System.out.println("Subject " + i);

            System.out.print("Enter Subject Name: ");
            String subjectName = sc.nextLine();

            int credits =
                    readPositiveInt("Enter Credits: ");

            System.out.println("1. Graded Subject");
            System.out.println("2. Non-Graded / Pass-Fail Subject");

            int type;

            while (true) {
                type = readInt("Enter Subject Type: ");

                if (type == 1 || type == 2) {
                    break;
                }

                System.out.println("Enter only 1 or 2.");
            }

            if (type == 1) {

                String grade;

                while (true) {

                    System.out.print(
                            "Enter Grade (S/A/B/C/D/E/F/N): ");

                    grade = sc.nextLine()
                            .trim()
                            .toUpperCase();

                    if (isValidGrade(grade)) {
                        break;
                    }

                    System.out.println(
                            "Invalid grade. Please try again.");
                }

                GradedSubject subject =
                        new GradedSubject(
                                subjectName,
                                credits,
                                grade);

                semester.addSubject(subject);

            } else {

                NonGradedSubject subject =
                        new NonGradedSubject(
                                subjectName,
                                credits);

                semester.addSubject(subject);
            }
        }

        student.addSemester(semester);

        System.out.println();
        System.out.println("Semester added successfully.");

        System.out.printf(
                "Semester GPA = %.2f%n",
                semester.calculateGPA());
    }

    static void displayResult(Student student) {

        System.out.println();
        System.out.println();
        System.out.println("======================================");
        System.out.println("          GPA / CGPA RESULT");
        System.out.println("======================================");

        System.out.println(
                "Student Name    : " + student.name);

        System.out.println(
                "Register Number : " + student.registerNumber);

        for (Semester semester : student.semesters) {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println(
                    "Semester " + semester.semesterNumber);
            System.out.println("--------------------------------------");

            System.out.printf(
                    "%-22s %-8s %-10s %-12s%n",
                    "Subject",
                    "Credits",
                    "Grade",
                    "Credit Point");

            System.out.println(
                    "----------------------------------------------------");

            for (Subject subject : semester.subjects) {

                System.out.printf(
                        "%-22s %-8d %-10s %-12.2f%n",
                        subject.name,
                        subject.credits,
                        subject.getResult(),
                        subject.getCreditPoint());
            }

            System.out.println(
                    "----------------------------------------------------");

            System.out.println(
                    "Total Credits      : "
                            + semester.getTotalCredits());

            System.out.println(
                    "Graded Credits     : "
                            + semester.getGradedCredits());

            System.out.println(
                    "Non-Graded Credits : "
                            + semester.getNonGradedCredits());

            System.out.printf(
                    "Credit Points      : %.2f%n",
                    semester.getTotalCreditPoints());

            System.out.printf(
                    "GPA                : %.2f%n",
                    semester.calculateGPA());
        }

        double cgpa = student.calculateCGPA();

        System.out.println();
        System.out.println("======================================");
        System.out.println("             OVERALL");
        System.out.println("======================================");

        System.out.println(
                "Total Semesters          : "
                        + student.semesters.size());

        System.out.println(
                "Total Credits            : "
                        + student.getTotalCredits());

        System.out.println(
                "Total Graded Credits     : "
                        + student.getTotalGradedCredits());

        System.out.println(
                "Total Non-Graded Credits : "
                        + student.getTotalNonGradedCredits());

        System.out.printf(
                "Total Credit Points      : %.2f%n",
                student.getTotalCreditPoints());

        System.out.printf(
                "CGPA                     : %.2f%n",
                cgpa);

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       GPA AND CGPA CALCULATOR");
        System.out.println("======================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Register Number: ");
        String registerNumber = sc.nextLine();

        Student student =
                new Student(name, registerNumber);

        int numberOfSemesters =
                readPositiveInt(
                        "Enter Number of Semesters: ");

        for (int i = 1; i <= numberOfSemesters; i++) {
            addSemester(student, i);
        }

        displayResult(student);

        sc.close();
    }
}