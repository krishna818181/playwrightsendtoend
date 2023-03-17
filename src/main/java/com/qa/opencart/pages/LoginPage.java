package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String emilId ="#input-email";// id
    private String password = "#input-password";//id
    private String loginBtn="//input[@value='Login']";//xpath
    private String forgotPasswordLink="(//a[normalize-space()='Forgotten Password'])[1]";//xpath
    private String logoutBtn="//a[@class='list-group-item'][normalize-space()='Logout']";//xpath
    private String loginBtnlink ="//a[normalize-space()='Login']";//xpath locator
    private String myAccount="//span[normalize-space()='My Account']";


  public LoginPage(Page page)
  {
      this.page = page;
      page.click(myAccount);
      page.click(loginBtnlink);

  }

    public String loginPageTitle()
    {
        return page.title();
    }

    public boolean getForgotPasswordLink()
    {
        return page.isVisible(forgotPasswordLink);
    }

    public boolean doLogin(String appusername, String apppassword)
    {
        page.fill(emilId,appusername);
        page.fill(password, apppassword);
        page.click(loginBtn);
        if(page.isVisible(logoutBtn))
        {
           System.out.println("user successfully logged in");
           return true;
        }
        else
        {
            System.out.println("user failed to  logged in");
            return false;
        }

    }

}
