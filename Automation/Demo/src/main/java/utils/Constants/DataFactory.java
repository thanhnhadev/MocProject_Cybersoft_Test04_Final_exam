package utils.Constants;

import org.testng.annotations.DataProvider;
import utils.Helper.ExcelHelper;


public class DataFactory {

    @DataProvider(name = "data_Login_Excel", parallel = true)
    public Object[][] dataLogin() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( ConfigData.Excel, "Login", 1, 1);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "data_Register_Excel")
    public Object[][] dataJoin() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( ConfigData.Excel, "Login", 1, 2);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}