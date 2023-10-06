package tests;


import org.junit.jupiter.api.*;

public class DeleteAccountSteps extends BaseStep {


    public void deleteAccountNavBarLinkTest() {
        navigationBar.deleteAccountClick();
    }

    public void deleteAccountMessageTest() {

        Assertions.assertEquals(deleteAccountMessage.accDeleteMessageTextGet(), "ACCOUNT DELETED!");
        System.out.println(deleteAccountMessage.accDeleteMessageTextGet());
        deleteAccountMessage.accDeleteConfirm();


    }


    }
