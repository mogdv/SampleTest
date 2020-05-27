package com.simbirsoft.myapp2


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.assertion.ViewAssertions.matches


import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry

import junitparams.JUnitParamsRunner

import org.hamcrest.Matchers.not
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



//import androidx.test.runner.AndroidJUnit4


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
@RunWith(JUnitParamsRunner::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityRule: IntentsTestRule<SecondActivity>
            = IntentsTestRule(SecondActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.simbirsoft.myfirstapp2", appContext.packageName)
    }

    @Test
    fun clickButtonToast() {

        onView(withId(R.id.toast_button)).perform(click())
       onView(withText(R.string.toast_text)).inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()))
    }


}
