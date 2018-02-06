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
	    String[] items = { "小贝1", "小贝2", "小贝3", "小贝4", "小贝5", "小贝6", "小贝7", "小贝8", "小贝9", "小贝10", "小贝11", "小贝12" ,"小贝13","小贝14","小贝15","小贝16","小贝17","小贝18"};  
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
