package com.example.a5_lab



import android.content.Intent
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.util.function.Predicate.not
import java.util.regex.Pattern.matches



import org.junit.Assert.assertEquals
import org.junit.Before
import org.mockito.Mock

class ColorTest {

    @Test
    fun testSetColorWithValidValues() {
        val colorr = color(null, null, null)
        val result = colorr.setColor()
        assertEquals(listOf(100, 150, 200), result)
    }

    @Test
    fun testSetColorWithNullValues() {
        val colorr = color(null, null, null)
        val result = colorr.setColor()
        assertEquals(listOf(0, 0, 0), result)
    }

    @Test
    fun testSetColorWithOutOfRangeValues() {
        val color = color(null, null, null)
        val result = color.setColor()
        assertEquals(listOf(255, 0, 255), result)
    }

    @Test
    fun testSetColorWithSomeNullAndSomeValidValues() {
        val color = color(null, null, null)
        val result = color.setColor()
        assertEquals(listOf(100, 0, 255), result)
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testShowHelpDialog() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.btn_help)).perform(click())

        // Проверяем, что диалоговое окно отображается
        onView(withText("Manual for this APP")).check(matches(isDisplayed()))
        scenario.close()
    }

    @Test
    fun testFinishAffinityOnExit() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.btn_exit)).perform(click())

        scenario.close()
    }

    @Test
    fun testStartSetActivity() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.btn_input)).perform(click())

        // Проверяем, что активити вызвано
        intended(hasComponent(SetActivity::class.java.name))
        scenario.close()
    }

    @Test
    fun testToastMessageOnResume() {
        val intent = Intent()
        intent.putExtra("RED_VALUE", 255)
        intent.putExtra("GREEN_VALUE", 10)
        intent.putExtra("BLUE_VALUE", 20)

        val scenario = ActivityScenario.launch<MainActivity>(intent)

}}



@RunWith(AndroidJUnit4::class)
class SetActivityTest {

    @Mock
    private lateinit var color: Color

    @Before
    fun setUp() {
        // Инициализация необходимых объектов для тестирования
    }

    @Test
    fun testOnOkButtonClick() {

        ActivityScenario.launch(SetActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                lateinit var binding: Any
                activity.binding.redInput.setText("100")
                activity.binding.greenInput.setText("150")
                activity.binding.blueInput.setText("200")
                activity.binding.leftCheck.isChecked = true
                activity.binding.rightCheck.isChecked = false

                activity.binding.btnOk.performClick()

                val resultData: Intent? = activity.resultData
                assertEquals(100, resultData?.getIntExtra("RED_VALUE", 0))
                assertEquals(150, resultData?.getIntExtra("GREEN_VALUE", 0))
                assertEquals(200, resultData?.getIntExtra("BLUE_VALUE", 0))
                assertEquals(true, resultData?.getBooleanExtra("LEFT_CHECKED", false))
                assertEquals(false, resultData?.getBooleanExtra("RIGHT_CHECKED", false))
            }
        }
    }
}
