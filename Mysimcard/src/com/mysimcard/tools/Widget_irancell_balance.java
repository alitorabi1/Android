package com.mysimcard.tools;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;





import android.widget.RemoteViews;


 
public class Widget_irancell_balance extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_irancell_balance_l);
            Intent intent = new Intent(context, Widget_balancei.class);
            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.img_irancell_balance, pending);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        
        
    }
    
    
}
