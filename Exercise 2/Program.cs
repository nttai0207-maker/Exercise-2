using System;

public class Student
{
    private string name;
    private double score;
    private static int totalStudents = 0;

    public Student(string name, double score)
    {
        this.name = name;
        this.score = score;
        totalStudents++;
    }

    // ---------------- Instance Methods ----------------
    public string GetName()
    {
        return this.name;
    }

    public double GetScore()
    {
        return this.score;
    }

    public bool IsPassed()
    {
        return this.score >= 5.0;
    }

    public string GetClassification()
    {
        if (this.score >= 8.0) return "Excellent";
        if (this.score >= 6.5) return "Good";
        if (this.score >= 5.0) return "Average";
        return "Weak";
    }

    // ---------------- Static Methods ----------------
    public static int GetTotalStudents()
    {
        return totalStudents;
    }

    public static Student FindTopStudent(Student[] students)
    {
        if (students == null || students.Length == 0) return null;

        Student topStudent = students[0];
        foreach (var student in students)
        {
            if (student.GetScore() > topStudent.GetScore())
            {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public static double CalculateAverageScore(Student[] students)
    {
        if (students == null || students.Length == 0) return 0.0;

        double totalScore = 0;
        foreach (var student in students)
        {
            totalScore += student.GetScore();
        }
        return totalScore / students.Length;
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Create array of Student objects
        Student[] students = new Student[]
        {
            new Student("An", 8.5),
            new Student("Binh", 4.2),
            new Student("Chi", 6.8),
            new Student("Dung", 9.1),
            new Student("Giang", 5.5)
        };

        // Print total students
        Console.WriteLine($"Total students created: {Student.GetTotalStudents()}");
        Console.WriteLine(new string('-', 50));

        // Print student list, classification, and status
        Console.WriteLine("STUDENT LIST:");
        foreach (var student in students)
        {
            string status = student.IsPassed() ? "Passed" : "Failed";
            Console.WriteLine($"Name: {student.GetName(),-8} | Score: {student.GetScore(),-4} | Classification: {student.GetClassification(),-10} | Status: {status}");
        }
        Console.WriteLine(new string('-', 50));

        // Print top student
        Student topStudent = Student.FindTopStudent(students);
        if (topStudent != null)
        {
            Console.WriteLine($"Top Student: {topStudent.GetName()} with score {topStudent.GetScore()}");
        }

        // Print class average score
        double avgScore = Student.CalculateAverageScore(students);
        Console.WriteLine($"Class Average Score: {avgScore:F2}");
    }
}