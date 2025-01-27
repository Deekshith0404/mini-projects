package com.xworkz.reader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.jws.soap.SOAPBinding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Types.INTEGER;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        String filepath="E:\\exel\\datas.xlsx";
        String url="jdbc:mysql://localhost:3306/branch";
        String user="root";
        String pass="root";
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        FileInputStream fileInputStream=new FileInputStream(filepath);
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        try {
             connection=DriverManager.getConnection(url,user,pass);
             connection.setAutoCommit(false);
             preparedStatement=connection.prepareStatement("insert into simpledata values(?,?,?,?)");
        int rows=sheet.getLastRowNum();
        int count=0;
        for (int r=1; r<=rows;r++){
                XSSFRow row=sheet.getRow(r);
                int id= (int) row.getCell(0).getNumericCellValue();
                String name=row.getCell(1).getStringCellValue();
                String product=row.getCell(2).getStringCellValue();
                int cost= (int) row.getCell(0).getNumericCellValue();
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,product);
                preparedStatement.setInt(4,cost);
                count++;
                preparedStatement.addBatch();
            if (count%10==0){
                preparedStatement.executeBatch();
              //  connection.commit();
            }
        }
        int [] row=preparedStatement.executeBatch();
            System.out.println(row.length);
        connection.commit();
        System.out.println("insertion done");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            System.out.println(e.getMessage());        }
        finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
