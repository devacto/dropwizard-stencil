package au.com.dius.service.utils;

import au.com.dius.service.core.People;
import au.com.dius.service.core.Person;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser {
    public CSVParser() {
    }

    public void parseCSVToPeople(String inputFileName, People people) throws FileNotFoundException {
        CSVReader csvReader = null;
        int lineNumber = 0;
        Person p = new Person();

        try {
            String[] lineArray;
            csvReader = new CSVReader(new FileReader(inputFileName));

            while ((lineArray = csvReader.readNext()) != null) {
                ArrayList<String> lineArrayList = new ArrayList(Arrays.asList(lineArray));

                // First line is the heading
                if (lineNumber != 0) {
                    p = new Person(lineArrayList.get(0), lineArrayList.get(1), lineArrayList.get(2));
                    people.addPerson(p);
                }

                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
