package com.simbirsoft.myapp2

import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.intent.rule.IntentsTestRule

import androidx.test.espresso.matcher.ViewMatchers.*


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Тест главного окна
 */
@RunWith(AndroidJUnit4::class)
class MainWindowTest  {

    @get:Rule
    var activityRule: IntentsTestRule<MainActivity>
            = IntentsTestRule(MainActivity::class.java)


    /**
     *  проверяем что видны элементы View
     */
    @Test
    fun checkElementsisVisible(){

        onView(withId(R.id.toolbarTextView))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.imageToolbarSearch))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.bt_create_data))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
    }

    /**
     * Проверка скорллинга
     */
    @Test
    fun checkScrollRecyclerView(){

        try {
            Thread.sleep(4000);
        } catch ( e : InterruptedException) {
            e.printStackTrace();
        }

        onView(withId(R.id.recycler_data))
                .perform(scrollToPosition(12))
                .perform(scrollToPosition(1))
                .perform(scrollToPosition(3))
                .perform(scrollToPosition(22));

    }


}
