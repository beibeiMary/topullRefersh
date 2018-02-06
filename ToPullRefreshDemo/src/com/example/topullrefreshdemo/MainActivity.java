package com.example.topullrefreshdemo;

import com.example.topullrefreshdemo.RefreshableView.PullToRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	 RefreshableView refreshableView;  
	    ListView listView;  
	    ArrayAdapter<String> adapter;  
	    String[] items = { "С��1", "С��2", "С��3", "С��4", "С��5", "С��6", "С��7", "С��8", "С��9", "С��10", "С��11", "С��12" ,"С��13","С��14","С��15","С��16","С��17","С��18"};  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.activity_main);
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);  
        listView = (ListView) findViewById(R.id.list_view);  
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);  
        listView.setAdapter(adapter);  
        refreshableView.setOnRefreshListener(new PullToRefreshListener() {  
            @Override  
            public void onRefresh() {  
                try {  
                    Thread.sleep(3000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                refreshableView.finishRefreshing();  
            }  
        }, 0);  
    }  
}
