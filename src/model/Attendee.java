package model;

public class Attendee {
    private String fullName;
    private String courseSection;

    public Attendee(String fullName, String courseSection) {
        // attendee validation
        // name cannot be empty
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty\n");
        }
        // course cannot be empty
        if (courseSection == null || courseSection.isBlank()) {
            throw new IllegalArgumentException("Course/section cannot be empty\n");
        }
        // names should only be format with (letters, spaces, hyphens, apostrophes, and periods)
        String namePattern = "^[\\p{L}]+([ .'-][\\p{L}]+)*\\.?$";
        if (!fullName.matches(namePattern)) {
            throw new IllegalArgumentException("Invalid name format\n");
        }
        this.fullName = fullName;
        this.courseSection = courseSection.toUpperCase();
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourseSection() {
        return courseSection;
    }
}