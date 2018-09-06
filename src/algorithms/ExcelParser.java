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
    public void  parser(File file) {
        try {
            Workbook workbook = WorkbookFactory.create(file);
            // int noofsheets=workbook.getNumberOfSheets();
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println(new DataFormatter().createFormat(cell));
                }
                System.out.println();
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
