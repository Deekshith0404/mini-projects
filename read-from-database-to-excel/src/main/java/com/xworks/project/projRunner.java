package com.xworks.project;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class projRunner {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/branch";
            String username="root";
            String password="root";
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet=workbook.createSheet();

            connection= DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();
            String query="select * from country_info";
            ResultSet resultSet=statement.executeQuery(query);
            XSSFRow rw=sheet.createRow(0);
            rw.createCell(0).setCellValue("Id");
            rw.createCell(1).setCellValue("name");
            rw.createCell(2).setCellValue("capital");
            rw.createCell(3).setCellValue("population");
            rw.createCell(4).setCellValue("famous");
            short rowcount=0;

            while (resultSet.next()){
                rowcount++;
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String capital=resultSet.getString(3);
                int population=resultSet.getInt(4);
                String famous=resultSet.getString(5);


                XSSFRow row=sheet.createRow(rowcount);
                XSSFCell cell = row.createCell(0);
                    cell.setCellValue(id);
                XSSFCell cell1 = row.createCell(1);
                cell1.setCellValue(name);
                XSSFCell cell2 = row.createCell(2);
                cell2.setCellValue(capital);
                XSSFCell cell3 = row.createCell(3);
                cell3.setCellValue(population);
                XSSFCell cell4 = row.createCell(4);
                cell4.setCellValue(famous);

            }
            String path="E:\\\\exel\\\\abc.xlsx";
            FileOutputStream stream=new FileOutputStream(path);
            workbook.write(stream);
            stream.close();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (statement!=null){
                    statement.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
