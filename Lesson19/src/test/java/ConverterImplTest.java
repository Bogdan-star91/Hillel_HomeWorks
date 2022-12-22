import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ConverterImplTest {

    @Test
    void isValidJson() {

        String testJsonPath = "D:\\Hillel\\Projects\\GitHub-Java Pro\\Hillel_HomeWorks16\\Lesson19\\src\\main\\resources\\MOCK_DATA.json";

        Converter testService = new ConverterImpl();

        String testStr = testService.readToString(testJsonPath);

        Assertions.assertTrue(testService.isValidJson(testStr));

    }

    @Test
    void checkFormat() throws IOException {

        String testYamlPath = "D:\\Hillel\\Projects\\GitHub-Java Pro\\Hillel_HomeWorks16\\Lesson19\\src\\main\\resources\\example.yaml";

        String testJsonPath = "D:\\Hillel\\Projects\\GitHub-Java Pro\\Hillel_HomeWorks16\\Lesson19\\src\\main\\resources\\example.json";

        ConverterImpl testService = new ConverterImpl();

        Assertions.assertEquals("JSON", testService.checkFormat(testJsonPath));
        Assertions.assertEquals("YAML", testService.checkFormat(testYamlPath));

    }

}
