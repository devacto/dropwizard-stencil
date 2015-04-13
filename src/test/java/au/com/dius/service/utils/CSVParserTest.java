package au.com.dius.service.utils;

import au.com.dius.service.core.People;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.Test;

import java.io.FileNotFoundException;

public class CSVParserTest {

    @Test
    public void testParseCSVToPeople() throws Exception {
        CSVParser csvParser = new CSVParser();
        final People people = new People();
        try {
            csvParser.parseCSVToPeople("incoming/20140703.csv", people);
            assertThat(people.getPerson(0).getFirstName()).isEqualTo("Victor");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
