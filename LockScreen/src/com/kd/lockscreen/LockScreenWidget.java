package com.kd.lockscreen;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class LockScreenWidget extends AppWidgetProvider{

	final String mPerfName = "com.silenceburn.MyColorNoteConf";  
	  
    @Override  
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,  
            int[] appWidgetIds) {  
        // TODO Auto-generated method stub  
        final int N = appWidgetIds.length;  
        for (int i = 0; i < N; i++) {  
            int appWidgetId = appWidgetIds[i];  
            Log.i("myLog", "this is [" + appWidgetId + "] onUpdate!");  
  
        }  
        Intent intent=new Intent(context, MyLock.class);
//        Intent intent=new Intent(context, MyLockConf.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context, 0, intent, 0);
        //RemoteViews��������һ��View�����ܹ���ʾ�����������У������ں�layout��Դ�ļ�ʵ�ֲ��֡�
        //��Ȼ������android.widget.RemoteViews������appWidget����,����Android Widgets�����лᾭ���õ�����
        //��Ҫ�ǿ��Կ���̵���(appWidget��һ������������ͳһ���е�)��
        RemoteViews myRemoteViews = new RemoteViews(context.getPackageName(), R.layout.my_lockscreen_widget);
        //myRemoteViews.setImageViewResource(R.id.imageView, R.drawable.png1);//���ò��ֿؼ������ԣ�Ҫ�ر�ע�⣩
        myRemoteViews.setOnClickPendingIntent(R.id.my_lock_img, pendingIntent);
        ComponentName myComponentName = new ComponentName(context, LockScreenWidget.class);
        //�������AppWidget����AppwidgetProvider����֪ͨ���ṩ�˸���AppWidget״̬����ȡ�Ѿ���װ��Appwidget�ṩ��Ϣ�����������״̬
        AppWidgetManager myAppWidgetManager = AppWidgetManager.getInstance(context);
        myAppWidgetManager.updateAppWidget(myComponentName, myRemoteViews);
    }  
  
    @Override  
    public void onDeleted(Context context, int[] appWidgetIds) {  
        // TODO Auto-generated method stub  
        final int N = appWidgetIds.length;  
        for (int i = 0; i < N; i++) {  
            int appWidgetId = appWidgetIds[i];  
            Log.i("myLog", "this is [" + appWidgetId + "] onDelete!");  
        }  
    } 
    @Override 
    public void onReceive(Context context, Intent intent)
    {
    	super.onReceive(context, intent);
    	Log.i("myLog", "this is [] onReceive!");  
    }


}
