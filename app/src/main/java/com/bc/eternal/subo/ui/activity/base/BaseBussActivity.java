package com.bc.eternal.subo.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.bc.eternal.subo.R;

public class BaseBussActivity extends BaseActivity {

	protected Button  ib_right;
	protected  ImageButton ib_back;
	protected TextView tv_title;
	protected Intent intent;
	protected boolean isShow = false;

	protected void initTitleBar(boolean isShow)
	{
		this.isShow = isShow;
	}
	
	@Override
	protected void setCustomLayout(Bundle savedInstanceState) {
		
	}

	@Override
	protected void initView() {
		if(isShow){
			ib_back = (ImageButton) findViewById(R.id.toolbar_normal_btn_left);
			tv_title = (TextView) findViewById(R .id.toolbar_normal_tv);
			ib_right = (Button) findViewById(R.id.toolbar_normal_btn_right);
		}
	}

	@Override
	protected void bindComponentEvent() {
		if(isShow){
			ib_back.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					onBackPressed();
				}
			});		
		}
	}

	@Override
	protected void initData() {
		intent = this.getIntent();
		if(null != intent){
			String title = intent.getStringExtra("title");
			if(isShow){
				if(tv_title != null){
					tv_title.setText(title);
				}
			}
		}
	}

	@Override
	protected void doActivityResult(int requestCode, Intent intent) {
		
	}
	
	/**
	 * 重写返回键
	 */
	@Override
	public void onBackPressed() {
		//移除application中的activity
		application.removeActivity(this);
		//关闭当前activity
		this.finish();
	}
	
}
