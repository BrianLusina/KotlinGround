package com.kotlinground.design.browserhistory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


class BrowserHistoryTest {
    @Test
    fun `Should handle visit('google') - visit('facebook') - visit('youtube') - back(1) - back(1) - forward(1) - visit('linkedin') - forward(2) - back(2) - back(7)`() {
        val browserHistory = BrowserHistory("leetcode.com")
        browserHistory.visit("google.com")
        browserHistory.visit("facebook.com")
        browserHistory.visit("youtube.com")

        // move back to facebook.com from youtube.com
        assertEquals(browserHistory.back(1), "facebook.com")

        // move back to google.com from facebook.com
        assertEquals(browserHistory.back(1), "google.com")

        // move forward to facebook.com from google.com
        assertEquals(browserHistory.forward(1), "facebook.com")

        browserHistory.visit("linkedin.com")

        // move forward by 2 steps is not possible
        assertEquals(browserHistory.forward(2), "linkedin.com")

        // move back by 2 steps to google.com
        assertEquals(browserHistory.back(2), "google.com")

        // move back by 7 steps to leetcode.com
        assertEquals(browserHistory.back(7), "leetcode.com")
    }
}
