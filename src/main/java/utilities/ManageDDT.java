package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    @DataProvider(name="data-provider-users")
    public Object[][]getDataObject(){
        return getDataFromCSV(getData("DDTFile"));

    }
    public static List<String>readCSV(String csvFile){  // Reads a CSV file composed of String data
        List<String>lines=null; // First, initialize the list of lines
        File file=new File(csvFile);
        try {
            lines= Files.readAllLines(file.toPath(), StandardCharsets.UTF_8); // Read all lines from the CSV file using UTF-8 encoding
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;  // Return the list of lines read from the CSV file
    }

    public static Object[][]getDataFromCSV(String filePath){
        List<String> csvData = readCSV(filePath);
        if (csvData.isEmpty()) return new Object[0][0]; // Handle empty files

        Object[][] data = new Object[csvData.size()][3];

        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i).split("\\s*,\\s*"); // Split and trim in one step
        }

        return data;

    }




}
