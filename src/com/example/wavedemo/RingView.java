package com.example.wavedemo;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 环形view
 * 
 * @author huozhenpeng
 * 
 */
public class RingView extends View implements Runnable{
	private int width;
	private int height;
	private Paint paint;// 圆环画笔
	private Paint paint1;// 三角形画笔
	private RectF rectf;
	private float paintWidth;
	private Context context;
	private List<RingBean> datas;
	private int leftPadding;// 设置padding或者leftpadding
	private int topPadding;// 设置topPadding
	private float leftMargin;// 屏幕左边距离画笔在最左边的位置
	private float topMargin;
	private RingBean ringBean;
	private Path path;// 绘制三角形
    private int tempDegrees;//线程累加
    private boolean running=true;//控制线程停止
	public RingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();
	}

	public RingView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RingView(Context context) {
		this(context, null);
	}

	private void init() {
		if (context == null)
			return;
		paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paintWidth = context.getResources().getDimension(R.dimen.px2sp_32);
		paint.setStyle(Style.STROKE);

		paint1 = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paint1.setStyle(Style.STROKE);
		path = new Path();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		leftPadding = getPaddingLeft();
		topPadding = getPaddingTop();
		leftMargin = leftPadding + paintWidth / 2;
		topMargin = topPadding + paintWidth / 2;
		rectf = new RectF(leftMargin, topMargin, width - leftMargin, height
				- topMargin);
	}

	/**
	 * 外部设置数据
	 * 
	 * @param datas
	 */
	public void setDatas(List<RingBean> datas) {
		if (datas == null)
			return;
		this.datas = datas;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (datas != null) {
			// 绘制三角形
			int sumDegrees = 0;
			for (int i = 0; i < datas.size(); i++) {
				ringBean = datas.get(i);
				paint1.setColor(Color.parseColor(ringBean.getColor()));
				paint1.setStrokeWidth(paintWidth / 2);
				canvas.save();
				path.reset();
				path.moveTo(width / 2 - paintWidth / 2, paintWidth / 2);
				path.lineTo(width / 2 + paintWidth / 2, paintWidth / 2);
				path.lineTo(width / 2, paintWidth);
				path.close();
				canvas.rotate((sumDegrees + ringBean.getAngles() / 2),
						width / 2, height / 2);
				if(ringBean.isFlag())
				{
				canvas.drawPath(path, paint1);
				}
				canvas.restore();
				sumDegrees += ringBean.getAngles();
			}
			// 绘制圆环
			sumDegrees = -90;//从90度方向开始绘制圆环(这样的话，最后的sumDegrees会是270)
			for (int i = 0; i < datas.size(); i++) {
				ringBean = datas.get(i);
				paint.setColor(Color.parseColor(ringBean.getColor()));
				paint.setStrokeWidth(paintWidth);
				canvas.drawArc(rectf, sumDegrees, ringBean.getAngles(), false,
						paint);
				sumDegrees += ringBean.getAngles();
			}
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(height, height);
	}

	@Override
	public void run() {
		while(running)
		{
			tempDegrees++;
			invalidate();
		}
	}

}
