import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveCollege {

    public static void removeCollege() {
        System.out.println("Enter college id");
        String id = College.scanner.next();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(College.filePath));
            String[] nextLine;
            List<String[]> allColleges = new ArrayList<>();
            int rowIndexToDelete = -1;
            int rowIndex = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                allColleges.add(nextLine);
                for (String token : nextLine) {
                    if (token.equals(id)) {
                        rowIndexToDelete = rowIndex;
                    }
                }
                rowIndex++;
            }
            csvReader.close();
            if (rowIndexToDelete != -1) {
                allColleges.remove(rowIndexToDelete);
                CSVWriter csvWriter = new CSVWriter(new FileWriter(College.filePath));
                csvWriter.writeAll(allColleges);
                csvWriter.close();
                System.out.println("College removed!");
            } else if (rowIndexToDelete == -1) {
                System.out.println("College id not found");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
