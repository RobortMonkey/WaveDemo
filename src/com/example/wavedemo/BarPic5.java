package com.example.wavedemo;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BarPic5 extends View implements Runnable {
	private Paint linePaint;// 线条画笔
	private int width;// 控件的宽高
	private int height;
	private int perWidth;// 每个柱状图的宽度
	private int space = 10;// 柱状图之间的间距
	private int num = 7;// 线的条数
	private int lineSpace;// 线条之间的间隔
	private int startX, startY, endX, endY;// 记录线条的位置
	private Paint barPaint;
	private int startPadding = 20;// 要绘制的柱状图距离边界起始结束距离
	private int endPadding = 20;
	private int lineStartX, lineEndX, lineStartY, lineEndY;// 记录柱状图位置
	private int maskStartX, maskEndX, maskStartY, maskEndY;// 记录遮罩位置
	private TextPaint textPaint;
	private Paint maskPaint;// 遮罩画笔
	private FontMetrics metrics;// 字体测量
	private FontMetrics dataMetrics;
	private int baseline;
	private TextPaint dataPaint;// 绘制数据画笔
	private int dataHeight;
	private List<BarBean> lists;
	private int maskHeight;//遮罩高度
	private OnClickListener listener;

	public BarPic5(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BarPic5(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BarPic5(Context context) {
		super(context);
		init();
	}

	public void init() {
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		linePaint.setColor(Color.parseColor("#bebebe"));
		linePaint.setStrokeWidth(2);

		barPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

		textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textPaint.setColor(Color.parseColor("#ffffff"));
		textPaint.setTextSize(50);
		textPaint.setTextAlign(Align.CENTER);
		metrics = textPaint.getFontMetrics();
		maskPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

		dataPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		dataPaint.setTextSize(40);
		dataPaint.setTextAlign(Align.CENTER);
		dataMetrics = dataPaint.getFontMetrics();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		maskHeight=(int) (7.0 / 8 * height);
		perWidth = (width - getPaddingLeft() - getPaddingRight() - 3 * space
				- startPadding - endPadding) / 4;
		if (num >= 2) {
			lineSpace = height / (num - 1);
		}
		barPaint.setStrokeWidth(perWidth);
		maskPaint.setStrokeWidth(perWidth);
		baseline = (int) ((-metrics.ascent + metrics.descent) / 2);
		dataHeight = (int) (-dataMetrics.ascent + dataMetrics.descent);
		
		lineEndY=maskHeight;
		
		if(lists!=null)
		{
			for(int i=0;i<lists.size();i++)
			{
				lists.get(i).setHeight(maskHeight-(lists.get(i).getActualHeight()*(maskHeight-dataHeight-dataHeight))/lists.get(i).getTotalHeight());
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.parseColor("#efefef"));
		if (lineSpace > 0)// 需要画线，初始为0
		{
			startX = getPaddingLeft();
			endX = width - getPaddingRight();
			startY=0;
			endY=0;
			for (int i = 0; i < num; i++) {
				canvas.drawLine(startX, startY, endX, endY, linePaint);
				startY += lineSpace;
				endY += lineSpace;
			}
		}
		
		////////////////////////////////////////////////////
		lineStartX = lineEndX = getPaddingLeft() + startPadding + perWidth / 2;
		lineStartY = height;
		maskStartX = maskEndX = lineStartX;
		maskStartY = height;
		maskEndY = maskHeight;
		if(lists.get(0).isFlag())
		{
			barPaint.setColor(Color.parseColor("#089ae9"));
		}
		else
		{
		    barPaint.setColor(Color.parseColor("#6bc1f2"));
		}
		canvas.drawLine(lineStartX, lineStartY, lineEndX,
				lineEndY >= lists.get(0).getHeight() ? lineEndY : lists.get(0).getHeight(), barPaint);
		maskPaint.setColor(Color.parseColor("#089ae9"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText(lists.get(0).getDescription(), lineStartX, lineStartY - baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#6bc1f2"));
		canvas.drawText(lists.get(0).getData(), lineStartX, (lineEndY >= lists.get(0).getHeight() ? lineEndY : lists.get(0).getHeight()) - dataHeight, dataPaint);
		lists.get(0).setLeftX(lineStartX-perWidth/2);
		lists.get(0).setRightX(lineStartX+perWidth/2);
         ///////////////////////////////////
		
		
		
		lineStartX = lineEndX = getPaddingLeft() + startPadding + perWidth / 2
				+ space + perWidth;
		lineStartY = height;
		maskStartX = maskEndX = lineStartX;
		if(lists.get(1).isFlag())
		{
			barPaint.setColor(Color.parseColor("#63ae4e"));
		}
		else
		{
		    barPaint.setColor(Color.parseColor("#97d573"));
		}
		canvas.drawLine(lineStartX, lineStartY, lineEndX,
				lineEndY >= lists.get(1).getHeight() ? lineEndY : lists.get(1).getHeight(), barPaint);
		maskPaint.setColor(Color.parseColor("#63ae4e"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText(lists.get(1).getDescription(), lineStartX, lineStartY - baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#97d573"));
		canvas.drawText(lists.get(1).getData(), lineStartX, (lineEndY >= lists.get(1).getHeight() ? lineEndY : lists.get(1).getHeight()) - dataHeight, dataPaint);
		lists.get(1).setLeftX(lineStartX-perWidth/2);
		lists.get(1).setRightX(lineStartX+perWidth/2);
        ///////////////////////////////////

		
		
		lineStartX = lineEndX = getPaddingLeft() + startPadding + perWidth / 2
				+ space + perWidth + space + perWidth;
		lineStartY = height;
		maskStartX = maskEndX = lineStartX;
		if(lists.get(2).isFlag())
		{
			barPaint.setColor(Color.parseColor("#e99b39"));
		}
		else
		{
		    barPaint.setColor(Color.parseColor("#fec57b"));
		}

		canvas.drawLine(lineStartX, lineStartY, lineEndX,
				lineEndY >= lists.get(2).getHeight() ? lineEndY : lists.get(2).getHeight(), barPaint);
		maskPaint.setColor(Color.parseColor("#e99b39"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText(lists.get(2).getDescription(), lineStartX, lineStartY - baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#fec57b"));
		canvas.drawText(lists.get(2).getData(), lineStartX, (lineEndY >= lists.get(2).getHeight() ? lineEndY : lists.get(2).getHeight()) - dataHeight, dataPaint);
		lists.get(2).setLeftX(lineStartX-perWidth/2);
		lists.get(2).setRightX(lineStartX+perWidth/2);
        ///////////////////////////////////

		
		
		lineStartX = lineEndX = getPaddingLeft() + startPadding + perWidth / 2
				+ space + perWidth + space + perWidth + space + perWidth;
		lineStartY = height;
		maskStartX = maskEndX = lineStartX;
		if(lists.get(3).isFlag())
		{
			barPaint.setColor(Color.parseColor("#e65353"));
		}
		else
		{
		    barPaint.setColor(Color.parseColor("#ff8989"));
		}

		canvas.drawLine(lineStartX, lineStartY, lineEndX,
				lineEndY >= lists.get(3).getHeight() ? lineEndY : lists.get(3).getHeight(), barPaint);
		maskPaint.setColor(Color.parseColor("#e65353"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText(lists.get(3).getDescription(), lineStartX, lineStartY - baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#ff8989"));
		canvas.drawText(lists.get(3).getData(), lineStartX, (lineEndY >= lists.get(3).getHeight() ? lineEndY : lists.get(3).getHeight()) - dataHeight, dataPaint);
		lists.get(3).setLeftX(lineStartX-perWidth/2);
		lists.get(3).setRightX(lineStartX+perWidth/2);
		super.onDraw(canvas);
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.currentThread().sleep(10);
				lineEndY-=2;
				postInvalidate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	/**
	 * 传递数据，根据数据绘制柱状图
	 * @param lists
	 */
	 public void setData(List<BarBean> lists)
	 {
		 if(lists.size()!=4)
		 {
			 throw new IllegalArgumentException("集合大小应该为4");
		 }
		 this.lists=lists;
		 init();
		 invalidate();
	 }
	 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x=(int) event.getX();
			int y=(int) event.getY();
			if(lists!=null)
			{
				for(int i=0;i<lists.size();i++)
				{
					if(lists.get(i).getLeftX()<x&&x<lists.get(i).getRightX()&&y>lists.get(i).getHeight()&&y<maskHeight)
					{
						lists.get(i).setFlag(!lists.get(i).isFlag());
						for(int j=0;j<lists.size();j++)
						{
							if(j!=i)
							{
								lists.get(j).setFlag(false);
							}
						}
						if(listener!=null)
						{
							listener.onclick(i);
						}
						invalidate();
						break;
					}
				}
			}
			break;

		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
	public void setOnClickListener(OnClickListener listener)
	{
		this.listener=listener;
	}
	
	public interface  OnClickListener
	{
		void onclick(int i);
	}

}
