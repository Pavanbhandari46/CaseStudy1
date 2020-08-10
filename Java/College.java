import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class College {
    public static String filePath = "F:\\LTI\\LBJ Coding Session\\CaseStudy1\\colleges.csv";
    public static Scanner scanner = new Scanner(System.in);

    private static String collegeId, fees, pinCode, collegeName, courseType, city;
    private static int choice;

    public static void main(String[] args) {
        System.out.println("Welcome to University Manager");
        selectChoice();

        while (choice != 4) {
            switch (choice) {
                case 1:
                    System.out.println("Enter college id");
                    collegeId = College.scanner.next();
                    boolean flag = true;
                    try {
                        CSVReader csvReader = new CSVReader(new FileReader(College.filePath));
                        String[] nextLine;
                        while ((nextLine = csvReader.readNext()) != null) {
                            for (String token : nextLine) {
                                if (token.equals(collegeId)) {
                                    flag = false;
                                }
                            }
                        }
                        csvReader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (flag) {
                        System.out.println("Enter college name");
                        collegeName = scanner.next();
                        System.out.println("Enter course type");
                        courseType = scanner.next();
                        System.out.println("Enter city");
                        city = scanner.next();
                        System.out.println("Enter fees");
                        fees = scanner.next();
                        System.out.println("Enter pin code");
                        pinCode = scanner.next();
                        RegisterCollege.registerCollege(collegeId, collegeName, courseType, city, fees, pinCode);
                        selectChoice();
                    }
                    else {
                        System.out.println("College id exists! Please change your college id");
                        choice = 1;
                    }
                    break;
                case 2:
                    SearchColleges.searchColleges();
                    selectChoice();
                    break;
                case 3:
                    RemoveCollege.removeCollege();
                    selectChoice();
                    break;
                default:
                    System.out.println("Please choose the correct option");
                    System.out.println("1. Enter new college\n2. Search colleges based on city\n3. Remove college\n4. Exit application");
                    break;
            }
        }

    }

    private static void selectChoice() {
        System.out.println("Choose any options below");
        System.out.println("1. Enter new college\n2. Search colleges based on city\n3. Remove college\n4. Exit application\n");
        choice = scanner.nextInt();
    }

}