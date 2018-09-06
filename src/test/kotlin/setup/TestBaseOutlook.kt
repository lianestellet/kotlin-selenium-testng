package setup

import utils.*
import org.testng.annotations.*

abstract class TestBaseOutlook {

    @BeforeTest
    fun setup() {
        SeleniumEngine.defaultChromeSetup()
    }


    @BeforeMethod
    fun accessOutlookSignupUrl() {
        Redirect.accessUrl("url.outlook.signup")
    }

    @AfterMethod
    fun delay(){
        Wait.seconds(4)
    }

    @AfterSuite
    fun driverClose() {
        SeleniumEngine.closeDriver()
    }

}