package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import com.example.wavedemo.RollbackGroup.MyRollbackListener;
import com.example.wavedemo.RollbackGroup.MyScrollChangedListener;
import com.example.wavedemo.RotationView.OnRotateChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends Activity {
	private List<RotateBean> lists;
	private RotationView rotationView;
	private ArrowView arrowView;
	private RollbackGroup rollbackGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main7);
		rotationView = (RotationView) this.findViewById(R.id.rotateView);
		arrowView = (ArrowView) this.findViewById(R.id.arrowView);
		lists = new ArrayList<RotateBean>();
		lists.add(new RotateBean("+0.75", 50, "#7eb445"));
		lists.add(new RotateBean("+0.35", 100, "#819d87"));
		lists.add(new RotateBean("+0.25", 20, "#e61a5f"));
		lists.add(new RotateBean("+0.25", 190, "#000000"));
		rotationView.setData(lists);
		rotationView.setRotateListener(new OnRotateChangedListener() {

			@Override
			public void onRotate(int index) {
				arrowView.setColor(lists.get(index).getColor());
			}
		});
		rollbackGroup = (RollbackGroup) this.findViewById(R.id.rollbackGroup);

		// 滑动下面时，让上面一起滚动
		rollbackGroup.setMyScrollChangedListener(new MyScrollChangedListener() {

			@Override
			public void onScroll(int delta, int top, int perChildHeight) {
				int index = top / perChildHeight;
				int remainder = top % perChildHeight;
				if (index == 0) {
					if (remainder <= perChildHeight / 2) {
						rotationView.rotateWheel(lists.get(index).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2) * delta);
					} else {
						rotationView.rotateWheel(lists.get(
								lists.size() - index - 1).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2) * delta);
					}
				} else {
					index=lists.size()-index;
					if (remainder <= perChildHeight / 2) {
						rotationView.rotateWheel(lists.get(index).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2) * delta);
					} else {
						rotationView.rotateWheel(lists.get(
								index - 1).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2) * delta);
					}
				}
			}
		});
		// 滑动下面，让上面回滚
		rollbackGroup.setMyRollbackListener(new MyRollbackListener() {

			@Override
			public void onRollback(int degrees, int delTop, int perChildHeight) {
				int index = -delTop / perChildHeight;
				int remainder = delTop % perChildHeight;
				if (index == 0) {
					index = 0;
					if (Math.abs(remainder) < perChildHeight / 2) {
						rotationView.rotateWheel(lists.get(index).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2) * remainder);

					} else {
						rotationView.rotateWheel(lists.get(
								lists.size() - index - 1).getDegrees()
								* 1.0f
								/ 2
								/ (perChildHeight / 2.0f)
								* (perChildHeight - Math.abs(remainder)));
					}
				} else {
					index = lists.size() - index;
					if (Math.abs(remainder) < perChildHeight / 2) {
						rotationView.rotateWheel(lists.get(index).getDegrees()
								* 1.0f / 2 / (perChildHeight / 2.0f)
								* remainder);

					} else {
						rotationView.rotateWheel(lists.get(index - 1)
								.getDegrees()
								* 1.0f/2
								/ (perChildHeight / 2)
								* (perChildHeight - Math.abs(remainder)));
					}
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

}
