package Locator;

public class Locator_CMS {
    //header
    public static final String headerUser="//p[@class='text my-0']";
    //
    public static final String btnSignin="(//*[contains(text(),'Sign in')])[2]";
    public static final String btnJoin="//*[contains(text(),'Join')]";
    //page Login
    public static final String lbsigninTitle="//h2[normalize-space()='Sign In to Fiverr']";
    public static final String email="//*[contains(@id,'email')]";
    public static final String password="//*[contains(@id,'password')]";
    public static final String ic_pwsh="//*[contains(@class,'show')]";
    public static final String btnLogin="//*[contains(@type,'submit')]";
    public static final String aResgister="//*[contains(@class,'text_register')]";
    //page Register
    public static final String lbRegisterTitle="//h2[normalize-space()='REGISTER']";
    public static final String ipUser="//*[contains(@id,'name')]";
    public static final String ipPw="(//*[contains(@id,'password')])[1]";
    public static final String ic_sh_pw="(//*[contains(@class,'show')])[1]";
    public static final String ipRpw="(//*[contains(@id,'password')])[2]";
    public static final String ic_sh_rpw="(//*[contains(@class,'show')])[2]";
    public static final String ipPhone="//*[contains(@id,'phone')]";
    public static final String ipBrithday="//*[contains(@id,'birthday')]";
    public static final String opionMale ="//*[contains(text(),'Male')]";
    public static final String opionFemale ="//*[contains(text(),'Female')]";
    public static final String cbox_agreeitem="//*[contains(@id,'agree-term')]";
    public static final String aLogin="//*[contains(text(),'I am already member')]";
    public static final String btnSubmit="//*[contains(@type,'submit')]";
    //page profile
    public static final String editProfile="(//button[@class='edit'])[1]";
    public static final String lstCartItemclass= "//div[@class='gigs_card']//h1";
    public static final String btnRemoveCartItemclass1="//button[contains(normalize-space(),'DEL')]";
    public static final String btnViewdetail="(//*[contains(text(),'View detail')])";
//    page podup edit profile
    public static final String titlePodup="//h2[contains(normalize-space(),'Update User')]";
    public static final String editPhoneNumber="//*[contains(@name,'phone')]";
    public static final String editName="//*[contains(@name,'name')]";
    public static final String editEmail="//*[contains(@type,'email')]";
    public static final String editBirthday="//*[contains(@name,'birthday')]";
    public static final String opionMales="//input[@value='male']";
    public static final String opionFemales="//input[@value='female']";
    public static final String editCetificate="//input[@id='certification']";
    public static final String editSkill="//input[@id='skill']";
    public static final String btnCancel="//button[contains(normalize-space(),'Cancel')]";
    public static final String btnSave="//button[contains(normalize-space(),'Save')]";

}
