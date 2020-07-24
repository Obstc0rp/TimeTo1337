package de.obstc0rp.timeto1337

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import de.obstc0rp.timeto1337.helpers.getSecondsToNextMinute
import de.obstc0rp.timeto1337.helpers.timeToLeet
import java.util.*

var oneMinute: Long = 60000;

/**
 * Implementation of App Widget functionality.
 */
class TimeTo1337Widget : AppWidgetProvider() {
    private val timer = Timer();
    private lateinit var task: TimerTask;

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        applyTextToWidgets(context, appWidgetManager, appWidgetIds);
        task = object: TimerTask() {
            override fun run() {
                applyTextToWidgets(context, appWidgetManager, appWidgetIds);
            }
        };
        timer.scheduleAtFixedRate(task, getSecondsToNextMinute() * 1000, oneMinute);
    }

    override fun onEnabled(context: Context) {
    }

    override fun onDisabled(context: Context) {
        timer.cancel();
    }
}

internal fun applyTextToWidgets(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetIds: IntArray) {
    for (appWidgetId in appWidgetIds) {
        updateAppWidget(context, appWidgetManager, appWidgetId)
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = timeToLeet();
    val views = RemoteViews(context.packageName, R.layout.time_to1337_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}