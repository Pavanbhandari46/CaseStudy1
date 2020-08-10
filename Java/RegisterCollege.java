import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterCollege {
    public static void registerCollege(String collegeId, String collegeName, String courseType, String city, String fees, String pinCode) {
        String[] college = {collegeId, collegeName, courseType, city, fees, pinCode};

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(College.filePath, true));
            csvWriter.writeNext(college);
            csvWriter.flush();
            csvWriter.close();
            System.out.println("Data entered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
