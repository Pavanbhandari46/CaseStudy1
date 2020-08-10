import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchColleges {
    public static void searchColleges() {
        System.out.println("Enter city");
        String searchCity = College.scanner.next();
        System.out.println("Enter course type");
        String searchCourseType = College.scanner.next();
        String[] nextLine;
        List<String[]> searchResult = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(College.filePath));
            while ((nextLine = csvReader.readNext()) != null) {
                int flag = 0;
                for (String token : nextLine) {
                    if (token.equals(searchCity) || token.equals(searchCourseType)) {
                        flag++;
                    }
                }
                if (flag == 2) {
                    searchResult.add(nextLine);
                }
            }
            csvReader.close();
            if (searchResult.isEmpty()) {
                System.out.println("No colleges found");
            } else {
                for (String[] result : searchResult) {
                    for (String token : result) {
                        System.out.print(token + "\t\t");
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
