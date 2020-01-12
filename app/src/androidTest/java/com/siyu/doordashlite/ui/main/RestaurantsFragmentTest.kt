package com.siyu.doordashlite.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Assert.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.siyu.doordashlite.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RestaurantsFragmentTest {

    @Rule @JvmField
    var activityTestRule = ActivityTestRule(RestaurantsActivity::class.java)

    private var mainActivity: RestaurantsActivity? = null
    private var recyclerView: RecyclerView? = null

    @Before
    fun setUp() {
        mainActivity = activityTestRule.activity
    }

    @Test
    fun test_isFragmentLoaded() {
        assertNotNull(mainActivity)

        val fragment = RestaurantsFragment.newInstance()

        mainActivity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment).commit()

        InstrumentationRegistry.getInstrumentation().waitForIdleSync()

        recyclerView = fragment.view?.findViewById(R.id.recycler_view_restaurants)
        //check fragment is launched and valid
        assertNotNull(recyclerView)
    }

    @Test
    fun test_isFragmentFocusable_onAppLaunch() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_restaurants))
            .check(ViewAssertions.matches(ViewMatchers.isFocusable()))
    }

    @After
    fun tearDown() {
        mainActivity = null
    }
}