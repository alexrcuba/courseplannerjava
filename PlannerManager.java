/* Alex Cuba */
/* ID Number: 111560392 */
package PlannerManager;
import java.util.Scanner;
import java.util.InputMismatchException;
public class PlannerManager {
    public static void main(String[] args) {
        /* This is the main method. It is the driver class for the program.*/
        Planner plans = new Planner();
        Planner backup = new Planner();
        Scanner input = new Scanner(System.in);
        boolean running = true;
        do {
            String key;
            System.out.print("(A) Add Course" + "\n" + "(G) Get Course" + "\n"
              + "(R) Remove Course" + "\n" + "(P) Print Courses in Planner"
              + "\n" + "(F) Filter by Department Code" + "\n" + "(L) "
              + "Look for Course" + "\n" + "(S) Size" + "\n" + "(B) Backup"
              + "\n" + "(PB) Print Courses in Backup" + "\n" + "(RB) "
              + "Revert to Backup" + "\n" + "(Q) Quit" + "\n" + "\n"
              + "Enter a selection: ");
            key = input.next();
            if (null != key) {
                switch (key) {
                    case "Q":
                    case "q":
                        running = false;
                        break;
                    case "A":
                    case "a":
                        try {
                            input.nextLine();
                            System.out.print("\n" + "Enter course name: ");
                            String name = input.nextLine();
                            System.out.print("Enter department: ");
                            String depart = input.nextLine();
                            System.out.print("Enter course code: ");
                            int code = input.nextInt();
                            System.out.print("Enter course section: ");
                            byte sec = input.nextByte();
                            System.out.print("Enter instructor: ");
                            input.nextLine();
                            String instruc = input.nextLine();
                            System.out.print("Enter position: ");
                            int position = input.nextInt();
                            Course course = new Course(name, depart, code, sec, instruc);
                            try {
                                try {
                                    plans.addCourse(course, position);
                                } catch (FullPlannerException ex) {
                                    System.out.println("The planner is full, no more "
                                      + "courses can be added.");
                                }
                                System.out.println("\n" + depart + " " + code + ".0"
                                  + sec + " succesfullly added to planner." + "\n");
                            } catch (IllegalArgumentException ex) {
                                System.out.println("\n" + "Position is not in planner."
                                  + "\n");
                            }
                        } catch (InputMismatchException ex) {
                            input.nextLine();
                            System.out.println("\n" + "Input mismatch exception. "
                              + "Please enter the correct data types." + "\n");
                        }
                        break;
                    case "G":
                    case "g":
                        try {
                            try {
                                System.out.print("\n" + "Enter position: ");
                                int position = input.nextInt();
                                Course get = plans.getCourse(position);
                                System.out.println("\n" + "Course from position "
                                  + position + " recieved:" + "\n");
                                System.out.printf("%-15s%-25s%-15s%-15s%-15s%-15s",
                                  "Position", "Course Name", "Department",
                                  "Class Code", "Section", "Instructor");
                                System.out.println("\n" + "*************************"
                                  + "*****************************************"
                                  + "**************************************");
                                System.out.printf("%-15d%-25s%-15s%-15d%s%-14d%-15s",
                                  position, get.getCourseName(), get.getDepartment(),
                                  get.getClassCode(), "0", get.getSection(),
                                  get.getInstructor());
                                System.out.println("\n");
                            } catch (IllegalArgumentException ex) {
                                System.out.println("\n" + "Position is not in planner."
                                  + "\n");
                            }
                        } catch (InputMismatchException ex) {
                            input.nextLine();
                            System.out.println("\n" + "Input mismatch exception. "
                              + "Please enter the correct data types." + "\n");
                        }
                        break;
                    case "R":
                    case "r":
                        try {
                            try {
                                try {
                                    System.out.print("\n" + "Enter position: ");
                                    int position = input.nextInt();
                                    Course removed = plans.getCourse(position);
                                    plans.removeCourse(position);
                                    System.out.println("\n" + removed.getDepartment()
                                      + " " + removed.getClassCode() + ".0"
                                      + removed.getSection() + " has been removed "
                                      + "from the planner." + "\n");
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("\n" + "Position is not in planner."
                                      + "\n");
                                }
                            } catch (InputMismatchException ex) {
                                input.nextLine();
                                System.out.println("\n" + "Input mismatch exception. "
                                  + "Please enter the correct data types." + "\n");
                            }
                        } catch (NullPointerException ex) {
                            System.out.println("\n" + "Null pointer exception. "
                              + "There is nothing in the array." + "\n");
                        }
                        break;
                    case "S":
                    case "s":
                        System.out.println("\n" + "There are " + plans.size()
                          + " course(s) in the planner." + "\n");
                        break;
                    case "P":
                    case "p":
                        try {
                            System.out.println("\n" + "Planner: ");
                            plans.printAllCourses();
                        } catch (NullPointerException ex) {
                            System.out.println("\n" + "Null pointer exception. "
                              + "There is nothing in the array." + "\n");
                        }
                        break;
                    case "B":
                    case "b":
                        try {
                            backup = (Planner) plans.clone();
                            System.out.println("\n" + "Backup successfully created."
                              + "\n");
                        } catch (CloneNotSupportedException ex) {
                            System.out.println("\n" + "Clone not supported."
                              + "\n");
                        }
                        break;
                    case "PB":
                    case "pb":
                        System.out.println("\n" + "Planner Backup: ");
                        backup.printAllCourses();
                        break;
                    case "RB":
                    case "rb":
                        plans = backup;
                        System.out.println("\n" + "Successfully reverted to backup."
                          + "\n");
                        break;
                    case "F":
                    case "f":
                        try {
                            input.nextLine();
                            System.out.print("\n" + "Enter department: ");
                            String depart = input.nextLine();
                            System.out.println("\n" + "Filtered Planner: ");
                            plans.filter(plans, depart);
                        } catch (InputMismatchException ex) {
                            input.nextLine();
                            System.out.println("\n" + "Input mismatch exception. "
                              + "Please enter the correct data types." + "\n");
                        }
                        break;
                    case "L":
                    case "l":
                        try{
                            input.nextLine();
                                System.out.print("\n" + "Enter course name: ");
                                String name = input.nextLine();
                                System.out.print("Enter department: ");
                                String depart = input.nextLine();
                                System.out.print("Enter course code: ");
                                int code = input.nextInt();
                                System.out.print("Enter course section: ");
                                byte sec = input.nextByte();
                                System.out.print("Enter instructor: ");
                                input.nextLine();
                                String instruc = input.nextLine();
                                Course course = new Course(name, depart, code, 
                                  sec, instruc);
                                System.out.println();
                                boolean exist = plans.exists(course);
                                System.out.println();
                            } catch (InputMismatchException ex) {
                                input.nextLine();
                                System.out.println("\n" + "Input mismatch exception. "
                                  + "Please enter the correct data types." + "\n");
                            }
                        break;
                    default:
                        input.nextLine();
                        System.out.println("\n" + "Input error. Please only input "
                          + "one of the phrases listed." + "\n");
                        break;
                }
            }
        } while (running == true);
        System.out.println("\n" + "Program terminating succesfully...");
    }
}