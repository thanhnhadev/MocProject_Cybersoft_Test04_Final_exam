package utils;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static void readAndFormatDate(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(colIndex);

            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();

                // Định dạng lại ngày theo yêu cầu
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = formatter.format(date);
                System.out.println("Ngày trong Excel sau khi format: " + formattedDate);
            } else {
                System.out.println("Ô không chứa dữ liệu ngày.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
