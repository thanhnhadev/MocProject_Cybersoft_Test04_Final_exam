package utils.Constants;

import utils.Helper.PropertiesHelper;

public class ConfigData {
    public static final String Excel="src/main/java/utils/TestData/UserData.xlsx";
    public static final String Data="src/main/java/utils/Config/configs.properties";
    public static final String base_url=PropertiesHelper.getValue("url_browse");
    public static  String signinUrl = PropertiesHelper.getValue("url");
    public static String userEmailId=PropertiesHelper.getValue("email");
    public static String nameId=PropertiesHelper.getValue("name");
    public static String pw=PropertiesHelper.getValue("password");
    public static String re_pw=PropertiesHelper.getValue("re_password");
    public static String phone=PropertiesHelper.getValue("phone");
    public static String date=PropertiesHelper.getValue("brithday");
    public static String registerUrl = PropertiesHelper.getValue("url_register");
    public static String skill= PropertiesHelper.getValue("skill");
    public static String certificate= PropertiesHelper.getValue("certificate");
    public static String contentItem=PropertiesHelper.getValue("context1");
    public static String contentItem2=PropertiesHelper.getValue("context2");
    public static String profileUrl=PropertiesHelper.getValue("url_profile");
    public static String headerProfileUrl="(//*[contains(@class,'header_navbar')]/ul/li)[6]";
    public static  String regexNumber = PropertiesHelper.getValue("regexNumber");
    public static String emailRegex = PropertiesHelper.getValue("emailRegex");
    public static String phoneRegex = PropertiesHelper.getValue("phoneRegex");
    public static String expectedFormat = PropertiesHelper.getValue("expectedFormat");
    public static  String nameRegex = PropertiesHelper.getValue("nameRegex");
    public static final String detailPage_url = "https://demo5.cybersoft.edu.vn/jobDetail/10";
    public static final String demo5_url = "https://demo5.cybersoft.edu.vn";
    public static final String siginPage_url = "https://demo5.cybersoft.edu.vn/login";
}
