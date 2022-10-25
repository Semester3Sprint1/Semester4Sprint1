//package com.excel;
//
//import org.apache.poi.xssf.usermodel.*;
//
//import java.io.*;
//import java.util.*;
//
//public class ExcelWriter {
//    public static void main(String[] args){
//
//       String firstName = "";
//       String lastName = "";
//       String address = "";
//       String email = "";
//       int memberID = 0;
//       String startDate = "";
//       String membership = "";
//       boolean keepRunning = true;
//
////Check for existing workbook
//        File file = new File("./members.xlsx");
//        if (file.exists()){
//            XSSFWorkbook members = null;
//            try {
//                members = new XSSFWorkbook(new FileInputStream("./members.xlsx"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            XSSFSheet sheet = members.getSheet("data");
//            XSSFRow row = sheet.getRow(1);
//        }
//        else{
//            //Blank workbook
//            XSSFWorkbook members = new XSSFWorkbook();
//            //Blank sheet
//            XSSFSheet sheet = members.createSheet("data");
//
//            //create heading
//
//            XSSFRow rowHeading = sheet.createRow(0);
//            rowHeading.createCell(0).setCellValue("First Name:");
//            rowHeading.createCell(1).setCellValue("Last Name:");
//            rowHeading.createCell(2).setCellValue("Address:");
//            rowHeading.createCell(3).setCellValue("Email: ");
//            rowHeading.createCell(4).setCellValue("Member ID: ");
//            rowHeading.createCell(5).setCellValue("Start Date: ");
//            rowHeading.createCell(6).setCellValue("Membership Type: ");
//
//        };
//
//
//
//
//     while(keepRunning){
//        Scanner scnr = new Scanner(System.in);
//
//        System.out.print("Enter First Name: ");
//        firstName = scnr.nextLine();
//        if(firstName.equals("EXIT"))
//        {
//            System.out.print("Thank you. Goodbye!!");
//            System.exit(0);
//        }
//        else {
//            System.out.print("Enter Last Name: ");
//            lastName = scnr.nextLine();
//
//            System.out.print("Enter Address: ");
//            address = scnr.nextLine();
//
//            System.out.println("Enter Email: ");
//            email = scnr.nextLine();
//
//            System.out.println("Enter Member ID: ");
//            memberID = scnr.nextInt();
//
//            System.out.println("Enter Start Date: ");
//            startDate = scnr.nextLine();
//
//            System.out.println("Enter Membership Type: ");
//            membership = scnr.nextLine();
//
//        }
//
//
//
//            //This data needs to be written (Object[])
//            Map <String, Object[]> data = new TreeMap<String, Object[]>();
//            data.put("2", new Object[] {firstName, lastName, address, email, memberID, startDate, membership});
//
//            //Iterate over data and write to sheet
//            Set<String> keyset = data.keySet();
//            int rownum = 1;
//            XSSFSheet sheet = members.getSheet("data");
//            XSSFRow row = sheet.getRow(1);
//            for(String Key : keyset)
//            {
//                XSSFRow row = sheet.createRow(rownum++);
//                Object [] objArr = data.get(Key);
//                int cellnum = 0;
//                for(Object obj : objArr)
//                {
//                    XSSFCell cell = row.createCell(cellnum++);
//                    if(obj instanceof String)
//                    {
//                        cell.setCellValue((String)obj);
//                    }
//                    else if(obj instanceof Integer)
//                    {
//                        cell.setCellValue((Integer)obj);
//                    }
//                }
//                if(!(firstName.equals("EXIT")))
//                {
//                    rownum++;
//
//                }
//
////Auto size my columns that will be filled out with user input info.
//                for (int i = 0; i < 7; i++)
//                {
//                    sheet.autoSizeColumn(i);
//                }
//            }
//            try{
//
//                //save to excel file
//                FileOutputStream out = new FileOutputStream(new File("./members.xlsx"));
//                members.write(out);
//                out.flush();
//                out.close();
//                System.out.println("Excel Written Succesfully...");
//            } catch (FileNotFoundException e) {
//
//                e.printStackTrace();
//
//            } catch (IOException e){
//
//                e.printStackTrace();
//
//            } catch (Exception e) {
//
//                System.out.println(e.getMessage());
//            }
//        }
//     }
//    }//pub static void end brace
//}//pub class end brace