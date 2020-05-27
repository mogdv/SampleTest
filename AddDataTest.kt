package com.simbirsoft.myapp2




import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule;
import org.junit.Test;




import org.junit.runner.RunWith

/**
 * тест на добавление данных и сохранение
 */
@RunWith(AndroidJUnit4::class)
class AddDataTest {

//    Тестовые данные:
//    Название “Тестовый Название”
//    Описание “Тестовое описание”

    val test_Name = "Тестовое Название";
    val test_Description = "Тестовое описание";

    @get:Rule
    var activityRule: IntentsTestRule<MainActivity>
            = IntentsTestRule(MainActivity::class.java)

    /**
     *   Добавить данные и сохранить
     */
    @Test
    fun checkAddDataAndSave(){

        onView(withId(R.id.bt_create_data))
            .perform(click());
        onView(withId(R.id.input_name))
            .perform(replaceText(test_Name),
                closeSoftKeyboard());
        onView(withId(R.id.input_desc))
            .perform(replaceText(test_Description),
                closeSoftKeyboard());
        onView(withId(R.id.input_tags))
            .perform(replaceText(test_Description),
                closeSoftKeyboard());
        onView(withId(R.id.save))
            .perform(click());
        onView(withText("Сохранить"))
            .perform(click());

    }

    /**
     * Проверить есть ли тестовые данные
     */
    @Test
    fun checkExistTestData(){

        onView(withId(R.id.recycler_data))
            .perform(actionOnItemAtPosition(0, CustomViewAction.clickChildViewWithId(R.id.itemTextCategory)));
        onView(withId(R.id.card_Name))
            .check(matches(withText(test_Name)));
        onView(withId(R.id.card_desc))
            .check(matches(withText(test_Description)));
    }

}