package com.simbirsoft.myapp2

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * авторизация
 */
@RunWith(JUnitParamsRunner::class)
class AuthorizationTest {
    @get:Rule
    var activityRule: IntentsTestRule<LoginActivity>
            = IntentsTestRule(LoginActivity::class.java)


    /**
     * Проверка авторизации по не верным данным
     */
    @Test
    @Parameters(value = [
        "john@testdomain.com, notcorrectpassword", //не верный пароль
        "john@testdomain.com,", //без пароля
        ",correctpassword", //без логина
        "," //без логина и пароля
    ])
    fun checkUncorrectAuthData(login_value: String, password_value: String) {
        Espresso.onView(ViewMatchers.withId(R.id.login_name))
            .perform(typeText(login_value));
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(typeText(password_value));
        Espresso.onView(ViewMatchers.withId(R.id.sign_in_button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.sign_in_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }
    /**
     * Проверка авторизации по верным данным
     */
    @Test
    @Parameters(value = [
        "john@testdomain.com, correctpassword" //логин и пароль
    ])
    fun checkCorrectAuth(login_value: String, password_value: String) {
        Espresso.onView(ViewMatchers.withId(R.id.login_name))
            .perform(typeText(login_value));
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(typeText(password_value));
        Espresso.onView(ViewMatchers.withId(R.id.sign_in_button)).perform(ViewActions.click());
        //onView(withId(R.id.sign_in_button)).check(matches(not(isDisplayed())));
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java!!.getName()))


    }
}