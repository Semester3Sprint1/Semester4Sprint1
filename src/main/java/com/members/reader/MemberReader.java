package com.members.reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MemberReader {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {

        readFromExcel("src/main/java/com/members/reader/memberList.xlsx");
    }

    public static void readFromExcel(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("memberInfo");
        XSSFRow headerRow = myExcelSheet.getRow(0);

        for(int i = 1; i < myExcelSheet.getLastRowNum(); i++){
            for (int j = 0; j < 6; j++){
                XSSFRow row = myExcelSheet.getRow(i);

                if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    String data = row.getCell(j).getStringCellValue();
                    System.out.println(headerRow.getCell(j).getStringCellValue() + ": " + data);

                } else if (row.getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    int data = (int) row.getCell(j).getNumericCellValue();
                    System.out.println(headerRow.getCell(j).getStringCellValue() + ": " + data);
                }

            }
            System.out.println();
        }

        myExcelBook.close();

    }
}
