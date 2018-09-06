package test.testNg

import org.testng.Assert
import org.testng.annotations.*
import utils.Redirect
import utils.SeleniumEngine
import utils.Wait

object TestNgExample {
    @BeforeTest
    fun beforeTest() {
        println("BeforeTest")
    }


    @BeforeMethod
    fun beforeMethod() {
        println("BeforeMethod")
    }

    @AfterMethod
    fun afterMethod(){
        println("AfterMethod")
    }

    @AfterSuite
    fun afterSuite() {
        println("AfterSuite")
    }

    @Test
    fun somaDoisValores(){
        val total = soma(2,3)
        println("somaDoisValores")
        Assert.assertEquals(total, 5)
    }

    fun soma(x: Int, y: Int):Int {
        return x + y
    }
}