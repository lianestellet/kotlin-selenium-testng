package utils
import java.io.FileInputStream
import java.io.IOException
import java.util.Properties


object Resources {

    private var properties: Properties? = null

    private fun loadProperties(): Unit {
        try {
            properties = Properties()
            properties?.load(FileInputStream(Constants.Config.propertyPath))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun value(properties: String): String {
        loadProperties()
        return Resources.properties?.getProperty(properties).toString()
    }
}