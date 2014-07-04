package org.crazyit.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class FrameLayoutTest extends Activity
{
	private int currentColor = 0;
	// ����һ����ɫ����
	final int[] colors = new int[] { 
		
		 R.color.color1,
		 
		R.color.color2,
		R.color.color3, 
		R.color.color4, 
		R.color.color5, 
		R.color.color6
		/*
			 0xfffff00,
			 0xfffff33,
			 0xfffff66,
			 0xfffff99,
			 0xfffffcc,
			 0xfffff00
			*/
			
	};
	final int[] names = new int[] {
		R.id.view01, 
		R.id.view02, 
		R.id.view03,
		R.id.view04, 
		R.id.view05,
		R.id.view06 };
	TextView[] views = new TextView[names.length];
	Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			// ������Ϣ���Ա�����������
			if (msg.what == 0x123)
			{
				for (int i = 0; i < names.length; i++)
				{
					views[i].setBackgroundResource(colors[(i 
							+ currentColor)	% names.length]);
				//	views[i].setBackgroundColor(colors[i]);
				}
				currentColor++;
			}
			super.handleMessage(msg);
		}
	};
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		for (int i = 0; i < names.length; i++)
		{
			views[i] = (TextView) findViewById(names[i]);
		}

		// ����һ���߳������Եĸı�currentColor����ֵ
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				// ����һ������Ϣ֪ͨϵͳ�ı�6��TextView����ı���ɫ
				handler.sendEmptyMessage(0x123);
			}
		}, 0, 100);
	}
}