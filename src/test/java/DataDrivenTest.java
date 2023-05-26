import com.example.testproject.WordNumeric;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataDrivenTest {
    private WordNumeric numeric;

    @Before
    public void setUp() {
        numeric = new WordNumeric();
    }

    @Test
    public void testNumericText() throws IOException {
        InputStream in = new FileInputStream("src/test/resources/DDT.xls");
        HSSFWorkbook wb = new HSSFWorkbook(in);
        DataFormatter formatter = new DataFormatter();
        Sheet sheet = wb.getSheet("Лист1");
        for (Row row : sheet) {
            numeric.numericText(formatter.formatCellValue(row.getCell(0)));
            assertEquals(row.getCell(1).getStringCellValue(), numeric.getRes().replaceFirst("\n", ""));
        }
    }
}
