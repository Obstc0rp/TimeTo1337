package de.obstc0rp.timeto1337

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.obstc0rp.timeto1337.helpers.getSecondsToNextMinute
import de.obstc0rp.timeto1337.helpers.timeToLeet
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var timer: Timer = Timer();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateLeetLabel();
        startInterval();
    }

    override fun onDestroy() {
        timer.cancel();
        super.onDestroy()
    }

    fun startInterval() {
        val timeToNextMinute = getSecondsToNextMinute();
        timer.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
                runOnUiThread(Runnable {
                    updateLeetLabel();
                });
            }
        }, timeToNextMinute,5 * 1000);
    }

    fun updateLeetLabel() {
        val periodToLeet = timeToLeet();
        leetLabel.text = periodToLeet;
    }
}