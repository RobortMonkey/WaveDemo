package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;

public class MainActivityv extends Activity {
	private LInePic linePic;
	private List<LinePicBean> lists;
	private List<LinePicBean> lists1;
	private List<String> descriptionLists;// 横轴描述符
	private List<String> verticalDesciptions;// 纵轴描述符
	private PopupWindow mPop;
	private float distance;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainv);
		distance = getResources().getDimension(R.dimen.px2dp_20);
		linePic = (LInePic) findViewById(R.id.linepic);
		lists = new ArrayList<LinePicBean>();
		lists.clear();
		lists.add(new LinePicBean(5.0f));
		lists.add(new LinePicBean(0f));
		lists.add(new LinePicBean(-5.0f));
		lists.add(new LinePicBean(6.5f));
		lists.add(new LinePicBean(4.0f));
		lists1 = new ArrayList<LinePicBean>();
		lists1.clear();
		lists1.add(new LinePicBean(2.5f));
		lists1.add(new LinePicBean(0f));
		lists1.add(new LinePicBean(-2.5f));
		lists1.add(new LinePicBean(-5.0f));
		lists1.add(new LinePicBean(7.5f));
		descriptionLists = new ArrayList<String>();
		descriptionLists.add("-5.0%");
		descriptionLists.add("-2.5%");
		descriptionLists.add("0%");
		descriptionLists.add("2.5%");
		descriptionLists.add("5.0%");
		descriptionLists.add("7.5%");
		verticalDesciptions = new ArrayList<String>();
		verticalDesciptions.add("02/05");
		verticalDesciptions.add("02/06");
		verticalDesciptions.add("02/07");
		verticalDesciptions.add("02/08");
		verticalDesciptions.add("02/09");
		linePic.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {// 想办法只让执行一次

					@Override
					public void onGlobalLayout() {
						linePic.setDescriptionList(descriptionLists);// 先设置这个再设置其他数据，里面涉及到测量字符串的长度
						linePic.setData(lists);
						linePic.setData2(lists1);
						linePic.setVetticalDesciptions(verticalDesciptions);
					}
				});

		linePic.setCallbackInterface(new CallbackInterface() {

			@Override
			public void viewMoveing(float x1, float y1, float x2, float y2,
					float vWidth,float vHeight,float surplusHeight,float topSurplusHeight) {
				if (mPop == null) {
					initPopupWindow();
				}
				float temp=0;
				//定位popupwindow的竖直位置先取y1，y2的大值
				if(y1>=y2)
				{
					temp=y2+(y1-y2)/2;
				}
				else
				{
					temp=y1+(y2-y1)/2;
				}
				//popupwindow的竖直范围必须在图表内
				float yoff=0;
				//判断有没有超出下边界
				if(vHeight-surplusHeight-temp<popupHeight/2)
				{
					yoff=-(surplusHeight+popupHeight);
				}
				else if(temp<popupHeight/2)//判断有没有超出上边界
				{
					yoff=-(vHeight-topSurplusHeight);
				}
				else//位于两个圆环的中间
				{
					yoff=-(vHeight-temp+popupHeight/2);
				}
				// 先控制左右位置,优先右边
				// 先判断右边的空间是不是够放置popup，如果够就放置在右边，如果不够就放置在左边
				if (vWidth - x1 >= distance + popupWidth) {
					if (!mPop.isShowing()) {
						mPop.showAsDropDown(linePic, (int) (x1 + distance), (int)yoff);
					} else {
						mPop.update(linePic, (int) (x1 + distance), (int)yoff, popupWidth, popupHeight);
					}
				}
				else
				{
					if (!mPop.isShowing()) {
						mPop.showAsDropDown(linePic, (int) (x1 - distance-popupWidth), (int)yoff);
					} else {
						mPop.update(linePic, (int) (x1 - distance-popupWidth), (int)yoff, popupWidth, popupHeight);
					}
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	interface CallbackInterface {
		void viewMoveing(float x1, float y1, float x2, float y2, float vWidth,float vHeight,float surplusHeight,float topSurplusHeight);
	}

	private ViewGroup menuView;
	private int popupWidth;
	private int popupHeight;

	/**
	 * 是相对于view的右下角的
	 */
	public void initPopupWindow() {
		if (mPop == null) {
			menuView = (ViewGroup) LayoutInflater.from(this).inflate(
					R.layout.popup_line, null, true);
			menuView.measure(MeasureSpec.makeMeasureSpec(
					LayoutParams.WRAP_CONTENT, MeasureSpec.AT_MOST),
					MeasureSpec.makeMeasureSpec(LayoutParams.WRAP_CONTENT,
							MeasureSpec.AT_MOST));
			popupWidth = measureLayout(menuView);
			mPop = new PopupWindow(menuView, LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT, true);
			mPop.setFocusable(false);
		}
	}

	private int measureLayout(View view) {
		if (android.os.Build.VERSION.SDK_INT >= 18) {
			view.measure(MeasureSpec.makeMeasureSpec(LayoutParams.WRAP_CONTENT,
					MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(
					LayoutParams.WRAP_CONTENT, MeasureSpec.AT_MOST));
		} else {
			view.measure(MeasureSpec.makeMeasureSpec(LayoutParams.WRAP_CONTENT,
					MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(
					LayoutParams.WRAP_CONTENT, MeasureSpec.EXACTLY));
		}
		popupHeight = view.getMeasuredHeight();// popupHeight最终用来控制popupwindow的竖直位置
		return view.getMeasuredWidth();
	}
	

}
