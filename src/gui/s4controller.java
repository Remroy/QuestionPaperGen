/*
 * Copyright (c) 2018. Garvit Kothari
 */

package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import algorithms.ExcelParser;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class s4controller implements Initializable {

    @FXML
    String fname;

    public void countWorksheet(String filename, String testName, int setNumber, int diffPercentage)
    {
        fname=filename;
        System.out.println("File Name:"+fname+"\n Test Name:" + testName  + "\nSet Number:" + setNumber +"\nDifficulty Percentage:"+diffPercentage);
        //Excel Print in Console for Test
       /* try
        {
            File file = new File(filename);
            Workbook wb= WorkbookFactory.create(new FileInputStream(file));
            System.out.println("Number of Sheets:" + wb.getNumberOfSheets());
        }catch (Exception e)
        {
            System.out.println(e);
        }
       System.out.println("\n" + filename);*/
        //ExcelParser excelParser = new ExcelParser();
        //excelParser.parser(new File(fname));
        //excelParser.displayData();

        //parser(new File(fname));
        //displayData();

    }
    int[] questionChooser(int diff,int marks,int noq) {
        int cost = (diff*noq)/10;
        int[] q = new int[noq];
        int min = 1;
        int max=5;
        for(int i=0;i<noq;i++) {
            int r=(int)(Math.random() * ((max - min) + 1)) + min;
            r %= cost;
            q[i]=r;
            cost -= r;
        }
        q[noq]=cost;
        return q;
    }
    public static String data[][];
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
    public  void displayData() {
        for (String[] aData : data) {
            for (int j = 0; j < aData.length; j++) {
                System.out.print(aData[j] + " ");
            }
            System.out.println();
        }
    }
    public void initialize(URL url, ResourceBundle resources) {

    }
}
