package test;

public class LoginStep extends BaseStep {
    public void emailInputLoginFormTest(String email) {
        loginPage.emailLoginInputField(email);
    }

    public void passwdInputLoginFormTest(String password) {
        loginPage.PasswdLLoginInputField(password);
    }

    public void loginButtonTest() {
        loginPage.loginButtonSubmit();
    }

}
