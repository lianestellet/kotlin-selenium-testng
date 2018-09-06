package tests

import PageAction.Outlook.*
import setup.TestBaseOutlook
import org.junit.Assert.assertTrue
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class OutlookSignupTest() : TestBaseOutlook() {

    @Test(priority = 0)
    fun `Enter on Outlook signup page`() {
        val emailPage = EmailPage()
        val emailPageMessage: String = emailPage.getMessage()
        assertEquals("Create account", emailPageMessage)
    }

    @Test(priority = 1)
    fun `Set e-mail and go to password page`() {
        val emailPage = EmailPage()
        emailPage.nextStep()

        val passwordPage = PasswordPage()
        val passwordPageMessage: String = passwordPage.getPageMessage()

        assertEquals("Create a password", passwordPageMessage)
    }

    @Test(priority = 2)
    fun `Set password and go to name page`() {
        val emailPage = EmailPage()
        emailPage.nextStep()

        val passwordPage = PasswordPage()
        passwordPage.nextStep()

        val namePage = NamesPage()
        val namePageMessage = namePage.getPageMessage()

        assertEquals("We need just a little more info to set up your account.", namePageMessage)
    }

    @Test(priority = 3)
    fun `Set names and go to account details page`() {
        val emailPage = EmailPage()
        emailPage.nextStep()

        val passwordPage = PasswordPage()
        passwordPage.nextStep()

        val namePage = NamesPage()
        namePage.nextStep()

        val detailsPage = DetailsPage()
        val detailsPageMessage = detailsPage.getPageMessage()

        assertEquals("Add details", detailsPageMessage)
    }

    @Test(priority = 4)
    fun `Setup details and go to captcha page`() {
        val emailPage = EmailPage()
        emailPage.nextStep()

        val passwordPage = PasswordPage()
        passwordPage.nextStep()

        val namePage = NamesPage()
        namePage.nextStep()

        val detailsPage = DetailsPage()
        detailsPage.nextStep()

        val confirmationPage = ConfirmationPage()
        val pageMessage = confirmationPage.getPageMessage()

        assertTrue(pageMessage.equals("New") || pageMessage.equals("Add security info"))
    }

    @Test(priority = 5)
    fun `Enter captcha and create account`() {
        val emailPage = EmailPage()
        emailPage.nextStep()

        val passwordPage = PasswordPage()
        passwordPage.nextStep()

        val namePage = NamesPage()
        namePage.nextStep()

        val detailsPage = DetailsPage()
        detailsPage.nextStep()

        val confirmationPage = ConfirmationPage()
        confirmationPage.manualConfirmationStep()

        val accountCreatedPage = AccountCreatedPage()
        val welcomeMessage: String = accountCreatedPage.getWelcomeMessage()

        assertEquals("Welcome to Outlook.", welcomeMessage)
    }

}