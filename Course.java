/* Alex Cuba */
/* ID Number: 111560392 */
package PlannerManager;
import java.util.InputMismatchException;
class Course implements Cloneable {
    private String courseName;
    private String department;
    private int classCode;
    private byte section;
    private String instructor;
    /*Constructor for a Course object with no set parameters.
    Postcondition:
    Course is initialized with null variables.*/
    public Course() {
        this.courseName = "null";
        this.department = "null";
        this.classCode = 0;
        this.section = 0;
        this.instructor = "null";
    }
    /*Constructor for a Course object with set parameters.
    Parameters:
    courseName - the name of the course
    department - the department that the course is a part of
    classCode - the number of the course within the department
    section - the section of the class with the entered code
    instructor - the professor teaching the class
    Postcondition: 
    Course is initialized with set varaibles.*/
    public Course(String courseName, String department, int classCode,
            byte section, String instructor) {
        this.courseName = courseName;
        this.department = department;
        this.classCode = classCode;
        this.section = section;
        this.instructor = instructor;
    }
    /*Tells the user the course name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Returns:
    The name of the course entered*/
    public String getCourseName() {
        return courseName;
    }
    /*Tells the user the department name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Returns:
    The name of the department entered*/
    public String getDepartment() {
        return department;
    }
    /*Tells the user the class code of the registered course.
    Preconditions:
    This Course has been instatiated.
    Returns:
    The code number entered*/
    public int getClassCode() {
        return classCode;
    }
    /*Tells the user the section number of the registered course.
    Preconditions:
    This Course has been instatiated.
    Returns:
    The name of the department entered*/
    public byte getSection() {
        return section;
    }
    /*Tells the user the instructor's name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Returns:
    The name of the instructor entered*/
    public String getInstructor() {
        return instructor;
    }
    /*Lets the user change the course name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Parameters:
    courseName - the name of the course*/
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /*Lets the user change the depertment name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Parameters:
    department - the name of the department*/
    public void setDepartment(String department) {
        this.department = department;
    }
    /*Lets the user change the class code of the registered course.
    Preconditions:
    This Course has been instatiated.
    Parameters:
    classCode - the code number of the course*/
    public void setClassCode(int classCode) throws InputMismatchException {
        if (classCode <= 0) {
            throw new IllegalArgumentException("Only positive numbers please!");
        } else {
            this.classCode = classCode;
        }
    }
    /*Lets the user change the section number of the registered course.
    Preconditions:
    This Course has been instatiated.
    Parameters:
    section - the section number of the course*/
    public void setSection(byte section) throws InputMismatchException {
        if (section <= 0) {
            throw new IllegalArgumentException("Only positive numbers please!");
        } else {
            this.section = section;
        }
    }
    /*Lets the user change the instructor's name of the registered course.
    Preconditions:
    This Course has been instatiated.
    Parameters:
    instructor - the name of the instructor*/
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    /*Creates a copy of this Course. Subsequent changes to the copy will not 
    affect the original and vice versa.
    Preconditions:
    This Course object has been instantiated. 
    Returns:
    A copy (backup) of this Course object.*/
    public Object clone() throws CloneNotSupportedException {
        Course cloned = (Course) super.clone();
        cloned.classCode = this.classCode;
        cloned.section = this.section;
        return cloned;
    }
    /*a return value of true indicates that obj refers to a Course object with 
    the same attributes as this Course. Otherwise, the return value is false.
    Preconditions:
    This Course object has been instantiated. 
    Parameters:
    obj - the object we are comparing to
    Returns:
    A boolean value based on whether or not it is equak.
    */
    public boolean equals(Object obj) {
        return this == obj;
    }
}