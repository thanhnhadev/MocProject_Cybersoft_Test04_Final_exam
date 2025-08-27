package Locators;

public class RegisterLocator {
    public static final String lbRegisterTitle="//h2[normalize-space()='REGISTER']";
    public static final String unseenPassBtn = "//input[@placeholder='Your Password']/../button";
    public static final String unseenConfirmPassBtn ="//input[@placeholder='Repeat your password']/../button";
    public static final String ipUser="//*[contains(@id,'name')]";
    public static final String ipMail="input[id='email']";
    public static final String ipPw="//input[@placeholder='Your Password']";
    public static final String ipRpw="//input[@placeholder='Repeat your password']";
    public static final String ipPhone="//*[contains(@id,'phone')]";
    public static final String ipBrithday="input[id=birthday]";
    public static final String opionMale ="//*[contains(text(),'Male')]";
    public static final String opionFemale ="//*[contains(text(),'Female')]";
    public static final String cbox_agreeitem="//*[contains(@id,'agree-term')]";
    public static final String aLogin="//*[contains(text(),'I am already member')]";
    public static final String btnSubmit="//button[normalize-space()='Submit']";

    //notification
    public static final String usernameEmptyNotification ="//span[text()=' Name không được bỏ trống ']";
    public static final String emailEmptyNotification ="//span[text()='  Email không được bỏ trống ']";
    public static final String passwordEmptyNotification ="//span[text()='  Password không được bỏ trống ']";
    public static final String passwordConfirmEmptyNotification ="//span[text()='  PasswordConfirm không được bỏ trống ']";
    public static final String phoneEmptyNotification ="//span[text()=' Phone không được bỏ trống ']";
    public static final String birthdayEmptyNotification ="//span[text()='Birthday không được bỏ trống']";

}
