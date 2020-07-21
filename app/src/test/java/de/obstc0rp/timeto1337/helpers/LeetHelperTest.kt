package de.obstc0rp.timeto1337.helpers

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LeetHelperTest {
    @Test
    fun getLeet() {
        val leet = getNextLeet();
        Assert.assertEquals(leet.hour, 13)
        Assert.assertEquals(leet.minute, 37)
    }
}