package com.siyu.doordashlite.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.siyu.doordashlite.R

import org.junit.Rule
import org.junit.Test

class RecyclerViewScrollTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(RestaurantsActivity::class.java)
    private val mockResponseTimeout = 8

    @Test
    fun test_isLoadComplete() {
        networkRequest()
        activityTestRule.activity
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_restaurants))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_isViewScrollable() {
        networkRequest()
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_restaurants))
            .perform(RecyclerViewActions.scrollToPosition<RestaurantsAdapter.ViewHolder>(50))


    }
    private fun networkRequest() {
        var totalTimeout = 0
        while (totalTimeout < mockResponseTimeout) {
            Thread.sleep(1000)
            totalTimeout++
        }
    }
}