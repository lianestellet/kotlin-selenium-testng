package setup

import utils.*
import org.testng.annotations.*

abstract class TestBaseOutlook {

    var setupReady: Boolean = false

    @BeforeMethod
    fun setup() {
        if(!setupReady) {
            SeleniumEngine.defaultChromeSetup()
            setupReady = true
        }
        accessOutlookSignupUrl()
    }

    private fun accessOutlookSignupUrl() {
        Redirect.accessUrl("url.outlook.signup")
    }

    @AfterMethod
    fun delay(){
        Wait.seconds(3)
    }

    @AfterSuite
    fun driverClose() {
        SeleniumEngine.closeDriver()
    }

}