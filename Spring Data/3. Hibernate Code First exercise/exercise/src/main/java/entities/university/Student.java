package entities.university;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "students")
public class Student extends Person{
    private double averageGrade;
    private String attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable(name = "students_courses",
        joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
