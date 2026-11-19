package model;

public class Attendee {
    private String fullName;
    private String courseSection;

    public Attendee(String fullName, String courseSection) {
        this.fullName = fullName;
        this.courseSection = courseSection;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourseSection() {
        return courseSection;
    }
}