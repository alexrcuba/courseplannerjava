/* Alex Cuba */
/* ID Number: 111560392 */
package PlannerManager;
class Planner {
    int MAX_COURSES = 50;
    Course[] planner = new Course[0];
    /*Constructs an instance of the Planner with no Course objects in it.
    Postcondition:
    This Planner has been initialized to an empty list of Courses.*/
    public Planner() {
    }
    /*Determines the number of courses currently in the list.
    Preconditions:
    This Planner has been instatiated.
    Returns:
    The number of Courses in this Planner.*/
    public int size() {
        return planner.length;
    }
    /*Parameters:
    newCourse - the new course to add to the list
    position - the position (preference) of this course on the list
    Preconditions:
    This Course object has been instantiated and 1 ≤ position ≤ items_currently_in_list + 1. 
    The number of Course objects in this Planner is less than MAX_COURSES.
    Postconditions:
    The new Course is now listed in the correct preference on the list. 
    All Courses that were originally greater than or equal to position are moved
    back one position. (e.g. If there are 5 Courses in a Planner, positioned 1-5, 
    and you insert a Course in position 4, the new Course would be placed in
    position 4, the Course that was in position 4 will be moved to position 5, 
    and the Course that was in position 5 will be moved to position 6.)
    Throws: 
    IllegalArgumentException
    Indicates that position is not within the valid range.
    FullPlannerExpcetion
    Indicates that there is no more room in the Planner to record an additional Course.
    Note 1:
    position refers to the position in the Planner and not the position in the array.
    Note 2:
    Inserting an item in position (items_currently_in_list + 1) is effectively 
    the same as adding the item to the end of the list.*/
    public void addCourse(Course newCourse, int position) throws FullPlannerException {
        if (position < 1 || position > planner.length + 1) {
            throw new IllegalArgumentException("Position is not in the planner.");
        } else if (planner.length >= MAX_COURSES) {
            throw new FullPlannerException("Planner is full.");
        } Course[] adding = new Course[planner.length + 1];
        if (position == 1 && adding.length > 1){
            for(int counter = 0; counter < planner.length; counter++)
               adding[counter+1] = planner[counter];
            adding[0] = newCourse;
            planner = adding;
        } else {
            if (adding.length > 1) {
                for (int counter = 0; counter < planner.length; counter++) {
                    adding[counter] = planner[counter];
                }
            }
            if (planner.length > 1 && position != adding.length) {
                for (int counter = position; counter <= adding.length; counter++) {
                    adding[counter - 1] = planner[counter - 2];
                }
            }
            adding[position - 1] = newCourse;
            planner = adding;
        }
    }
    /*Works just like public void addCourse(Course newCourse, int position), 
    except adds to the end of the list.
    Note:
    This method can be written in one line using the addCourse() and size() 
    methods above.*/
    public void addCourse(Course newCourse) throws FullPlannerException {
        addCourse(newCourse, size() + 1);
    }
    /*Parameters:
    position - the position in the Planner where the Course will be removed from.
    Preconditions:
    This Planner has been instantiated and 1 ≤ position ≤ items_currently_in_list.
    Postconditions:
    The Course at the desired position has been removed. All Courses that were 
    originally greater than or equal to position are moved backward one position. 
    (e.g. If there are 5 Courses in a Planner, positioned 1-5, and you remove the 
    Course in position 4, the item that was in position 5 will be moved to position 4.)
    Throws:
    IllegalArgumentException 
    Indicates that position is not within the valid range.
    Note:
    position refers to the position in the Planner and not the position in the array.*/
    public void removeCourse(int position) throws IllegalArgumentException {
        if (position < 1 || position > planner.length) {
            throw new IllegalArgumentException("Position is not in the planner.");
        } else {
            Course[] subbing = new Course[planner.length - 1];
            if (position == planner.length) {
                for (int counter = 0; counter < subbing.length; counter++) {
                    subbing[counter] = planner[counter];
                }
            } else {
                for (int counter = 0; counter < position; counter++) {
                    subbing[counter] = planner[counter];
                }
                if (position == 1) {
                    for (int counter = planner.length; counter > position; counter--) {
                        subbing[counter - 2] = planner[counter - 1];
                    }
                } else {
                    for (int counter = position; counter < planner.length; counter++) {
                        subbing[counter - 1] = planner[counter];
                    }
                }
            }
            planner = subbing;
        }
    }
    /* Parameters:
    position - position of the Course to retrieve.
    Preconditions:
    The Planner object has been instantiated and 1 ≤ position ≤ items_currenyly_in_list. 
    Returns:
    The Course at the specified position in this Planner object.
    Throws:
    IllegalArgumentException 
    Indicates that position is not within the valid range.
    Note:
    position refers to the position in the Planner and not the position in the array. */
    public Course getCourse(int position) throws IllegalArgumentException {
        if (position < 1 || position > planner.length) {
            throw new IllegalArgumentException("Position is not in the planner.");
        } else {
            return planner[position - 1];
        }
    }
    /*Prints all Courses that are within the specified department.
    Parameters:
    planner - the list of courses to search in 
    department - the 3 letter department code for a Course
    Preconditions:
    This Planner object has been instantiated.
    Postconditions:
    Displays a neatly formatted table of each course filtered from the Planner. 
    Keep the preference numbers the same. */
    public static void filter(Planner planner, String department) {
        System.out.printf("%-15s%-25s%-15s%-15s%-15s%-15s", "Position", "Course "
                + "Name", "Department", "Class Code", "Section", "Instructor");
        System.out.println("\n" + "*********************************************"
                + "***********************************************************");
        for (int counter = 1; counter < planner.planner.length + 1; counter++) {
            if (planner.planner[counter - 1].getDepartment().equalsIgnoreCase(department)) {
                System.out.printf("%-15d%-25s%-15s%-15d%s%-14d%-15s", counter,
                  planner.planner[counter - 1].getCourseName(),
                  planner.planner[counter - 1].getDepartment(),
                  planner.planner[counter - 1].getClassCode(), "0",
                  planner.planner[counter - 1].getSection(),
                  planner.planner[counter - 1].getInstructor());
                System.out.println();
            }
        }
        System.out.println();
    }
    /*Checks whether a certain Course is already in the list.
   Parameters:
   course - the Course we are looking for
   Preconditions: 
   This Planner and Course has both been instantiated.
   Returns: 
   True if the Planner contains this Course, false otherwise.*/
    public boolean exists(Course course) {
        int position = 0;
        for (int counter = 0; counter < planner.length; counter++) {
            position++;
            if ((planner[counter].getCourseName().equalsIgnoreCase(course.getCourseName()))
                  && (planner[counter].getDepartment()).equalsIgnoreCase(course.getDepartment())
                  && planner[counter].getClassCode() == course.getClassCode()
                  && planner[counter].getSection() == course.getSection()
                  && (planner[counter].getInstructor()).equalsIgnoreCase(course.getInstructor())){
                System.out.println(course.getDepartment() + " " + 
                  course.getClassCode() + ".0" + course.getSection() + 
                  " is found in the planner at position " + position + "." );
                return true;
            }
        }
        System.out.println("Course is not found in the planner.");
        return false;
    }
    /*Creates a copy of this Planner. Subsequent changes to the copy will not affect the original and vice versa.
    Preconditions:
    This Planner object has been instantiated. 
    Returns:
    A copy (backup) of this Planner object.*/
    public Object clone() throws CloneNotSupportedException {
        Planner cloned = new Planner();
        cloned.planner = new Course[this.planner.length];
        for (int counter = 0; counter < planner.length; counter++) {
            cloned.planner[counter] = (Course) planner[counter].clone();
        }
        return cloned;
    }
    /*Prints a neatly formatted table of each item in the list with its position
    number as shown in the sample output.
    Preconditions:
    This Planner has been instantiated. 
    Postconditions:
    Displats a neatly formatted table of each course from the Planner.*/
    public void printAllCourses() {
        toString();
    }
    @Override
    /*Gets the String representation of this Planner object, which is a neatly 
    formatted table of each Course in the Planner on its own line with its 
    position number as shown in the sample output.
    Returns:
    The String representation of this Planner object.*/
    public String toString() {
        System.out.printf("%-15s%-25s%-15s%-15s%-15s%-15s", "Position", "Course "
          + "Name", "Department", "Class Code", "Section", "Instructor");
        System.out.println("\n" + "*********************************************"
          + "***********************************************************");
        for (int counter = 1; counter < planner.length + 1; counter++) {
            System.out.printf("%-15d%-25s%-15s%-15d%s%-14d%-15s", counter,
              planner[counter - 1].getCourseName(), planner[counter - 1].getDepartment(),
              planner[counter - 1].getClassCode(), "0", planner[counter - 1].getSection(),
              planner[counter - 1].getInstructor());
            System.out.println();
        }
        System.out.println();
        return "\n";
    }
}
