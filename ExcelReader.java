import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

public  void main1() throws Exception {

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/My_data?autoReconnect=true&useSSL=false", "root", "root");
        con.setAutoCommit(false);
        PreparedStatement pstm = null;
        FileInputStream input = new FileInputStream("/home/mtech/Saved/input.xls");
        System.out.println("Hello");

        POIFSFileSystem fs = new POIFSFileSystem(input);
        Workbook workbook;
        workbook = WorkbookFactory.create(fs);
       Sheet sheet1 = workbook.getSheet("Sheet1");
        Row row;
        Row row1;
       for (int i = 0; i <= sheet1.getLastRowNum(); i++) 
        {
            row = (Row) sheet1.getRow(i);
            
            
            String Cities1 = row.getCell(0).getStringCellValue();

            String sql = "INSERT INTO Cities (name)" + "VALUES(?)";
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1,Cities1);
            pstm.executeUpdate();
         
        }
       System.out.println("Hello");


        Sheet sheet2 = workbook.getSheet("Sheet2");
         for (int j = 0; j <= sheet2.getLastRowNum(); j++) {
            row1 = (Row) sheet2.getRow(j);
            String From1 = row1.getCell(0).getStringCellValue();
            String To1 = row1.getCell(1).getStringCellValue();
            String cc1 = row1.getCell(2).getStringCellValue();
            Double c1 = row1.getCell(3).getNumericCellValue();
            int Cost1= c1.intValue();
            Double s2= row1.getCell(4).getNumericCellValue();
            int Time1 = s2.intValue();
            String sql1 = "INSERT INTO Routes (source,dest,Courier_company,cost,time)" 
            + "VALUES(?,?,?,?,?)";
            pstm = (PreparedStatement) con.prepareStatement(sql1);
         
            pstm.setString(1,From1);
            pstm.setString(2, To1);
            pstm.setString(3, cc1);
            pstm.setInt(4,Cost1);
            pstm.setInt(5, Time1);
            pstm.executeUpdate();
          
        }
        con.commit();  
        pstm.close();
        con.close();
        input.close();
        System.out.println("Success import excel to mysql table");
        
    } catch (IOException e) {
    	System.out.println(e);
    }
}
}