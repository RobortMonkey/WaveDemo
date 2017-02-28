package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class ParallaxTransformer implements ViewPager.PageTransformer {

	private ImageView iv_1_title;
	private ImageView iv_1_left;
	private ImageView iv_1_right;
	private ImageView iv_1_center;
	private ImageView iv_2_title;
	private ImageView iv_2_center;
	private ImageView iv_2_left;
	private ImageView iv_2_right;
	private ImageView iv_2_bottom;
	private ImageView iv_3_title;
	private ImageView iv_3_center;
	private ImageView iv_3_line;
	private ImageView iv_3_first;
	private ImageView iv_3_second;
	private ImageView iv_3_three;
	private int z382;
	private int z150;
	private int f308;
	private int z300;
	private int z104;
	private int z178;
	private int z280;
	private int z250;
	private int z154;
	private int z80;
	private List<ObjectAnimator> lists1 = new ArrayList<ObjectAnimator>();
	private List<ObjectAnimator> lists2 = new ArrayList<ObjectAnimator>();
	private List<ObjectAnimator> lists3 = new ArrayList<ObjectAnimator>();
	private boolean isfist = true;
	private boolean issecond;
	private boolean isthreee;

	public ParallaxTransformer(Context context) {
		z150 = (int) context.getResources().getDimension(R.dimen.px2dp_150);
		z382 = (int) context.getResources().getDimension(R.dimen.px2dp_382);
		f308 = (int) context.getResources().getDimension(R.dimen.px2dp_f308);
		z300 = (int) context.getResources().getDimension(R.dimen.px2dp_300);
		z104 = (int) context.getResources().getDimension(R.dimen.px2dp_104);
		z178 = (int) context.getResources().getDimension(R.dimen.px2dp_178);
		z280 = (int) context.getResources().getDimension(R.dimen.px2dp_280);
		z250 = (int) context.getResources().getDimension(R.dimen.px2dp_250);
		z154 = (int) context.getResources().getDimension(R.dimen.px2dp_154);
		z80 = (int) context.getResources().getDimension(R.dimen.px2dp_80);

	}

	@Override
	public void transformPage(View page, float position) {

		// 刚刚进入的时候第一个页面的position为0，第二个页面的position为1
		// 滑动到第二个页面完全显示的时候，第二个页面position为0，第一个页面的position为-1
		if (position < -1) {
			// This page is way off-screen to the left.
		} else if (position <= 1) // a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
		{
			// Modify the default slide transition to shrink the page as well
		} else {
			// This page is way off-screen to the right.
		}

		switch (page.getId()) {
		case R.id.rl_1:
			if (position == 0) {
				if (isfist) {
					isfist = false;
					issecond = true;
					iv_1_title = (ImageView) page.findViewById(R.id.iv_1_title);
					iv_1_left = (ImageView) page.findViewById(R.id.iv_1_left);
					iv_1_right = (ImageView) page.findViewById(R.id.iv_1_right);
					iv_1_center = (ImageView) page
							.findViewById(R.id.iv_1_center);
					initSecondPage();
					initFirstPage();
					lists1.add(alphaAnimation(iv_1_title, 0));
					lists1.add(leftEnter(iv_1_left, 0, z382 + z150, 1000));
					lists1.add(rightEnter(iv_1_right, 0, f308, 2000));
					lists1.add(alphaAnimation(iv_1_center, 3000));
					lists1.add(downAnimation(iv_1_center, 0, z300, 4000));
				}
			} else if (position < 0 && position >= -0.5) {// 第一个页面向右滑动,从0滑动到-1的时候，页面恢复初始
//				 position=-(position*2);//从0到1
//				 iv_1_title.setAlpha(1-position);
//				 iv_1_left.setTranslationX(evaluate(position, z382+z150, 0));
//				 iv_1_right.setTranslationX(evaluate(position, f308, 0));
//				 iv_1_center.setTranslationY(evaluate(position, z300, 0));
//				 iv_1_center.setAlpha(1-position);

			}
			break;
		case R.id.rl_2:
			if (position == 0) {
				if (issecond) {
					issecond = false;
					isfist = true;
					isthreee = true;
					initThreePage();
					iv_2_title = (ImageView) page.findViewById(R.id.iv_2_title);
					iv_2_center = (ImageView) page
							.findViewById(R.id.iv_2_center);
					iv_2_left = (ImageView) page.findViewById(R.id.iv_2_left);
					iv_2_right = (ImageView) page.findViewById(R.id.iv_2_right);
					iv_2_bottom = (ImageView) page
							.findViewById(R.id.iv_2_bottom);
					initFirstPage();
					initSecondPage();
					initThreePage();
					lists2.add(alphaAnimation(iv_2_title, 0));
					lists2.add(alphaAnimation(iv_2_center, 1000));
					lists2.add(leftEnter(iv_2_left, 0, z178 + z104, 2000));
					lists2.add(rightEnter(iv_2_right, 0, -(z104 + z280), 3000));
					lists2.add(alphaAnimation(iv_2_bottom, 4000));
					lists2.add(upAnimation(iv_2_bottom, 0, -z250, 5000));
				}
			}
			break;
		case R.id.rl_3:
			if (position == 0) {
				if (isthreee) {
					isthreee = false;
					issecond = true;
					initSecondPage();
					initThreePage();
					iv_3_title = (ImageView) page.findViewById(R.id.iv_3_title);
					iv_3_center = (ImageView) page
							.findViewById(R.id.iv_3_center);
					iv_3_line = (ImageView) page.findViewById(R.id.iv_3_line);
					iv_3_first = (ImageView) page.findViewById(R.id.iv_3_first);
					iv_3_second = (ImageView) page
							.findViewById(R.id.iv_3_second);
					iv_3_three = (ImageView) page.findViewById(R.id.iv_3_three);
					lists3.add(alphaAnimation(iv_3_title, 0));
					lists3.add(alphaAnimation(iv_3_center, 1000));
					lists3.add(alphaAnimation(iv_3_line, 2000));
					lists3.add(alphaAnimation(iv_3_first, 3000));
					lists3.add(downAnimation(iv_3_first, 0, z154, 4000));
					lists3.add(alphaAnimation(iv_3_second, 5000));
					lists3.add(downAnimation(iv_3_second, 0, z80, 6000));
					lists3.add(alphaAnimation(iv_3_three, 7000));
				}
			}
			break;

		default:
			break;
		}
	}

	// 透明度渐变
	private ObjectAnimator alphaAnimation(View view, int delay) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
		animator.setDuration(1000);
		animator.setStartDelay(delay);
		animator.start();
		return animator;
	}

	// 左边进入动画
	private ObjectAnimator leftEnter(View view, int start, int end, int delay) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX",
				start, end);
		animator.setDuration(1000);
		animator.setStartDelay(delay);
		animator.start();
		return animator;
	}

	// 右边进入动画
	private ObjectAnimator rightEnter(View view, int start, int end, int delay) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX",
				start, end);
		animator.setDuration(1000);
		animator.setStartDelay(delay);
		animator.start();
		return animator;
	}

	// 竖直移动动画
	private ObjectAnimator downAnimation(View view, int start, int end,
			int delay) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY",
				start, end);
		animator.setDuration(1000);
		animator.setStartDelay(delay);
		animator.start();
		return animator;
	}

	/**
	 * 
	 * @param fraction
	 *            变换因子
	 * @param startValue
	 *            起始值
	 * @param endValue
	 *            结束指
	 * @return
	 */
	public Float evaluate(float fraction, Number startValue, Number endValue) {
		float startFloat = startValue.floatValue();
		return startFloat + fraction * (endValue.floatValue() - startFloat);
	}

	private void initFirstPage() {
		if (iv_1_title == null)
			return;
		for (int i = 0; i < lists1.size(); i++) {
			lists1.get(i).end();
		}
		lists1.clear();
		iv_1_title.setAlpha(0f);
		iv_1_left.setTranslationX(0);
		iv_1_right.setTranslationX(0);
		iv_1_center.setTranslationY(0);
		iv_1_center.setAlpha(0f);

	}

	private void initSecondPage() {
		if (iv_2_title == null)
			return;
		for (int i = 0; i < lists2.size(); i++) {
			lists2.get(i).end();
		}
		lists2.clear();
		iv_2_title.setAlpha(0f);
		iv_2_center.setAlpha(0f);
		iv_2_left.setTranslationX(0);
		iv_2_right.setTranslationX(0);
		iv_2_bottom.setTranslationY(0);
		iv_2_bottom.setAlpha(0f);
	}

	private void initThreePage() {
		if (iv_3_title == null)
			return;
		for (int i = 0; i < lists3.size(); i++) {
			lists3.get(i).end();
		}
		lists3.clear();
		iv_3_title.setAlpha(0f);
		iv_3_center.setAlpha(0f);
		iv_3_line.setAlpha(0f);
		iv_3_first.setAlpha(0f);
		iv_3_first.setTranslationY(0f);
		iv_3_second.setAlpha(0f);
		iv_3_second.setTranslationY(0f);
		iv_3_three.setAlpha(0f);
	}

	// 竖直移动动画
	private ObjectAnimator upAnimation(View view, int start, int end, int delay) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY",
				start, end);
		animator.setDuration(1000);
		animator.setStartDelay(delay);
		animator.start();
		return animator;
	}

}
