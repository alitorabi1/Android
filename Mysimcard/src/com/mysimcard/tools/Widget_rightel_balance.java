package com.mysimcard.tools;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;





import android.widget.RemoteViews;


 
public class Widget_rightel_balance extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_rightel_balance_i);
            Intent intent = new Intent(context, widget_balanceh.class);
            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.img_rightel_balance, pending);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        
        
    }
    
    
}
