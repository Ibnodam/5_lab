package com.example.a5_lab

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)


class ExampleInstrumentedTest {
    @get:Rule
    var activityRule1: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)
    @get:Rule
    var activityRule2: ActivityTestRule<TipActivity> =
        ActivityTestRule(SetActivity::class.java)
    @Test
    fun useAppContext() {



        Espresso.onView(withId(R.id.redInput)).perform(ViewActions.typeText("50"))
        Espresso.onView(withId(R.id.greenInput)).perform(ViewActions.typeText("100"))
        Espresso.onView(withId(R.id.blueInput)).perform(ViewActions.typeText("255"))
        Espresso.onView(withId(R.id.left_check)).perform(click())
        Espresso.onView(withId(R.id.btn_ok)).perform(click())

        onView(withId(R.id.left))
            .check { view, _ ->
                val backgroundColor = (view.background as ColorDrawable).color


                assert(backgroundColor == Color.rgb(50, 100, 255)) {
                    "Цвет не совпадает. Ожидался (50, 100, 255), получен ${Color.red(backgroundColor)}, ${Color.green(backgroundColor)}, ${Color.blue(backgroundColor)}"
                }
            }




        Espresso.onView(withId(R.id.redInput)).perform(ViewActions.typeText("254"))
        Espresso.onView(withId(R.id.greenInput)).perform(ViewActions.typeText("34"))
        Espresso.onView(withId(R.id.blueInput)).perform(ViewActions.typeText("67"))
        Espresso.onView(withId(R.id.right_check)).perform(click())
        Espresso.onView(withId(R.id.btn_ok)).perform(click())

        onView(withId(R.id.right))
            .check { view, _ ->
                val backgroundColor = (view.background as ColorDrawable).color


                assert(backgroundColor == Color.rgb(254, 34, 67)) {
                    "Цвет не совпадает. Ожидался (254, 34, 67), получен ${Color.red(backgroundColor)}, ${Color.green(backgroundColor)}, ${Color.blue(backgroundColor)}"
                }
            }

        Espresso.onView(withId(R.id.redInput)).perform(ViewActions.typeText("254"))
        Espresso.onView(withId(R.id.greenInput)).perform(ViewActions.typeText("34"))
        Espresso.onView(withId(R.id.blueInput)).perform(ViewActions.typeText("67"))
        Espresso.onView(withId(R.id.left_check)).perform(click())
        Espresso.onView(withId(R.id.right_check)).perform(click())
        Espresso.onView(withId(R.id.btn_ok)).perform(click())

        onView(withId(R.id.left))
            .check { view, _ ->
                val backgroundColor = (view.background as ColorDrawable).color


                assert(backgroundColor == Color.rgb(254, 34, 67)) {
                    "Цвет не совпадает. Ожидался (254, 34, 67), получен ${Color.red(backgroundColor)}, ${Color.green(backgroundColor)}, ${Color.blue(backgroundColor)}"
                }
            }

        onView(withId(R.id.right))
            .check { view, _ ->
                val backgroundColor = (view.background as ColorDrawable).color


                assert(backgroundColor == Color.rgb(254, 34, 67)) {
                    "Цвет не совпадает. Ожидался (254, 34, 67), получен ${Color.red(backgroundColor)}, ${Color.green(backgroundColor)}, ${Color.blue(backgroundColor)}"
                }
            }





    }

}
//}
//class ExampleInstrumentedTest {
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.example.a5_lab", appContext.packageName)
//    }
//}
