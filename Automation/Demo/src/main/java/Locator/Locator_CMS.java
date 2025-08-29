package Locator;

import org.openqa.selenium.By;

public class Locator_CMS {
    //header
    public static final String headerUser="//p[@class='text my-0']";
    public static final String Logo="//*[@class='logo active']";
    public static final String Search_Bar="(//input[@type='search'])[1]";
    public static final String btnSearch="//button[@type='submit']";
    public static final String btnSearching="(//button[normalize-space()='Search'])[1]";
    public static final String Search_Body="(//input[@type='search'])[2]";
    public static final String inputSearch="//input[@placeholder='Try \"building mobile app\"']";
    public static final String resultSearch="//span[contains(normalize-space(),'services available')]";
    public static final String getBtnSearching_Body="(//button[normalize-space()='Search'])[2]";
    public static final String Fiverr_Business= "(//*[contains(text(),'Fiverr Business')])[1]";
    public static final String Explore="//*[contains(text(),'Explore')]";
    public static final String English="//*[contains(text(),'English')]";
    public static final String UsD="//*[contains(text(),'US$ USD')]";
    public static final String Become_a_Seller="(//*[contains(text(),'Become a Seller')])[1]";
    public static final String btnSignin="(//*[contains(text(),'Sign in')])[2]";
    public static final String btnJoin="//*[contains(text(),'Join')]";
    public static final String trustBy="//section[@class='trusted-by container']";
    public static final String categoriesMenu="(//div[@class='categoriesmenu_li'])[1]";
    //Popular professional services
    public static final String currSliderPopular="//div[@class='slider-package']//div[@class='slick-slide slick-active slick-current']";
    public static final String tileSliderbar="//*[@class='subcategory-carousel']";
    public static final String btnPre="//div[@class='slider-package']//div[@class='slick-arrow slick-prev']";
    public static final String btnNext="//div[@class='slider-package']//div[@class='slick-arrow slick-next']";
    public static final String btn="//div[@class='selling-video col-12 col-md-12 col-lg-7 col-xl-7']//button[@type='button']";
    public static final String viewVideo="//*[@class='selling-proposition-wrapper']";
    public static final String footer="//h6[normalize-space()='Categories']";
    public static final String sliderActive="(//div[@class='slick-slide slick-active'])[1]";
    //nav-header
    public static final String GraphicsDesign="(//*[contains(text(),'Graphics & Design')])[1]";
    public static final String DigitalMarketing="(//*[contains(text(),'Digital Marketing')])[1]";
    public static final String WritingTranslation="(//*[contains(text(),'Writing & Translation')])[1]";
    public static final String Video_Animation="(//*[contains(text(),'Video & Animation')])[1]";
    public static final String Music_Audio="(//*[contains(text(),'Music & Audio')])[1]";
    public static final String Testing="(//*[contains(text(),'Testing')])[1]";
    //page Login
    public static final String lbsigninTitle="//h2[normalize-space()='Sign In to Fiverr']";
    public static final String email="//*[contains(@id,'email')]";
    public static final String password="//*[contains(@id,'password')]";
    public static final String btnLogin="//*[contains(@type,'submit')]";
    public static final String aResgister="//*[contains(@class,'text_register')]";
    public static final String emailError_Locator = "//span[@class='text-danger' and normalize-space()='Email không được bỏ trống !']";
    public static final String emailFormatError_Locator = "//span[@class='text-danger' and normalize-space()='Email không đúng định dạng !']";
    public static final String toastLoginSuccess = "//div[@role='alert' and contains(@class,'Toastify__toast-body')]//div[contains(text(),'Đăng nhập tài khoản thành công')]";
    //page Register
    public static final String lbRegisterTitle="//h2[normalize-space()='REGISTER']";
    public static final String ipUser="//*[contains(@id,'name')]";
    public static final String ipPw="(//*[contains(@id,'password')])[1]";
    public static final String ipRpw="(//*[contains(@id,'password')])[2]";
    public static final String ipPhone="//*[contains(@id,'phone')]";
    public static final String ipBrithday="//*[contains(@id,'birthday')]";
    public static final String opionMale ="//*[contains(text(),'Male')]";
    public static final String opionFemale ="//*[contains(text(),'Female')]";
    public static final String cbox_agreeitem="//*[contains(@id,'agree-term')]";
    public static final String aLogin="//*[contains(text(),'I am already member')]";
    public static final String btnSubmit="//button[normalize-space()='Submit']";
    //page profile
    public static final String editProfile="(//*[@class='edit'])[1]";
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

    // detail page
//    public static final String btnCountinue = "(//button[@class='submit' and contains(normalize-space(.),'Continue')])[1]";
public static final String btnCountinue ="(//button[@class='submit'])[2]";
//public static final String btnComparePackages = "(//a[normalize-space(text())='Compare Packages'])[1]";
//public static final String btnComparePackages = "(//*[normalize-space(text())='Compare Packages'])[1]";
public static final String btnComparePackages = "((//button[@Class= 'submit']//following::a[text()='Compare Packages'])[1]";



    public static final String toastHireSuccess =
            "//*[contains(@class,'Toastify') and contains(normalize-space(),'Thuê công việc thành công')]";
}

