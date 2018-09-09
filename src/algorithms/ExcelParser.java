/*
 * Copyright (c) 2018. Garvit Kothari
 */

package algorithms;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelParser {
    public static String data[][];

    public String[][] getData() {

        return data;
    }
    public  void displayData() {
        for (int i=0;i<data.length;i++) {
            for (int j=0;j<data[i].length;j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void  parser(File file) {
        try {
            Workbook workbook = WorkbookFactory.create(file);
            // int noofsheets=workbook.getNumberOfSheets();
            Sheet sheet = workbook.getSheetAt(0);
            int r = sheet.getPhysicalNumberOfRows();
            int c = 6;
            DataFormatter dataFormatter = new DataFormatter();
            data = new String[r][c];
            r=0;
            for (Row row : sheet) {
                c=0;
                for (Cell cell : row) {
                   data[r][c] = dataFormatter.formatCellValue(cell);
                   c++;
                }
                r++;
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
