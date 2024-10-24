package com.example.enexusteam.nexusdeviceroot;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexusteam.nexusdeviceroot.*;
import com.nexusteam.nexusdeviceroot.NexusDeviceRoot;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private LinearLayout linear1;
	private Button checkDeviceRoot;
	private Button setRootDevice;
	private Button checkDeviceSystemForRoot;
	private Button checkDeviceForRootable;
	private Button remountSystemRW;
	private TextView textview1;
	
	private NexusDeviceRoot NexusRooter;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		checkDeviceRoot = findViewById(R.id.checkDeviceRoot);
		setRootDevice = findViewById(R.id.setRootDevice);
		checkDeviceSystemForRoot = findViewById(R.id.checkDeviceSystemForRoot);
		checkDeviceForRootable = findViewById(R.id.checkDeviceForRootable);
		remountSystemRW = findViewById(R.id.remountSystemRW);
		textview1 = findViewById(R.id.textview1);
		
		checkDeviceRoot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NexusRooter.checkDeviceRoot()) {
					SketchwareUtil.showMessage(getApplicationContext(), "Device is rooted!");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Device is not rooted.");
				}
			}
		});
		
		setRootDevice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NexusRooter.setRootDevice()) {
					SketchwareUtil.showMessage(getApplicationContext(), "Root access granted!");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Failed to gain root access.");
				}
			}
		});
		
		checkDeviceSystemForRoot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NexusRooter.checkDeviceSystemForRoot()) {
					SketchwareUtil.showMessage(getApplicationContext(), "Root binaries found!");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No root binaries found.");
				}
			}
		});
		
		checkDeviceForRootable.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NexusRooter.checkDeviceForRootable()) {
					SketchwareUtil.showMessage(getApplicationContext(), "Device is rootable.");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Device is not rootable.");
				}
			}
		});
		
		remountSystemRW.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NexusRooter.remountSystemRW()) {
					SketchwareUtil.showMessage(getApplicationContext(), "System remounted as read/write.");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Failed to remount system.");
				}
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}