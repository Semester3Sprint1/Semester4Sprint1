package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This program read date values from XLSX file in Java using Apache POI.
 *
 * @author WINDOWS 8
 *
 */
public class ExcelReader {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {

        readFromExcel("src/main/java/com/excel/members.xlsx");
    }

    public static void readFromExcel(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("data");
        XSSFRow row = myExcelSheet.getRow(1);

        if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String firstName = row.getCell(0).getStringCellValue();
            System.out.println("First Name :" + firstName);
        }

        if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String lastName = row.getCell(1).getStringCellValue();
            System.out.println("Last Name :" + lastName);
        }
        if (row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String address = row.getCell(2).getStringCellValue();
            System.out.println("Address :" + address);
        }
        if (row.getCell(3).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String email = row.getCell(3).getStringCellValue();
            System.out.println("Email :" + email);
        }

        if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            int memberID = (int) row.getCell(4).getNumericCellValue();
            System.out.println("MemberID : " + memberID);
        }

        if (row.getCell(5).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String startDate = row.getCell(5).getStringCellValue();
            System.out.println("Start Date :" + startDate);
        }
        if (row.getCell(6).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            String membershipType = row.getCell(6).getStringCellValue();
            System.out.println("Membership Type :" + membershipType);
        }

        myExcelBook.close();

    }

}