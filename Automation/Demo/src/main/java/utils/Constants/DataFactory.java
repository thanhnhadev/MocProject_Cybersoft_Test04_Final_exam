package utils.Constants;

import org.testng.annotations.DataProvider;
import utils.Helper.ExcelHelper;
import utils.Logs.LogUtils;


public class DataFactory {

    @DataProvider(name = "data_Login_Excel", parallel = true)
    public Object[][] dataLogin() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( ConfigData.Excel, "Login", 1, 1);
        LogUtils.info( "Login Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "data_LoginFail_Excel", parallel = true)
    public Object[][] dataLogin_Fail() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( ConfigData.Excel, "Login_Fail", 1, 1);
        LogUtils.info("Login Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "data_Register_Excel")
    public Object[][] dataJoin() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( ConfigData.Excel, "Login", 1, 3);
        LogUtils.info("Login Data from Excel: " + data);
        return data;
    }
}