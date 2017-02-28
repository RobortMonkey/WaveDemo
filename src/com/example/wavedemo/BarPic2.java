package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class BarPic2 extends View {
	private Paint linePaint;// 线条画笔
	private int width;// 控件的宽高
	private int height;
	private int perWidth;// 每个柱状图的宽度
	private int space=10;// 柱状图之间的间距
	private int num=7;// 线的条数
	private int lineSpace;// 线条之间的间隔
	private int startX, startY, endX, endY;// 记录线条的位置
	private Paint barPaint;
	private int startPadding=20;//要绘制的柱状图距离边界起始结束距离
	private int endPadding=20;
	private int lineStartX,lineEndX,lineStartY,lineEndY;//记录柱状图位置
	private int maskStartX,maskEndX,maskStartY,maskEndY;//记录遮罩位置
	private TextPaint textPaint;
	private Paint maskPaint;// 遮罩画笔
	private FontMetrics metrics;//字体测量
	private FontMetrics dataMetrics;
	private int baseline;
	private TextPaint dataPaint;//绘制数据画笔
	private int dataHeight;

	public BarPic2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BarPic2(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BarPic2(Context context) {
		super(context);
		init();
	}

	public void init() {
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		linePaint.setColor(Color.parseColor("#bebebe"));
		linePaint.setStrokeWidth(2);
		
		barPaint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		
		textPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textPaint.setColor(Color.parseColor("#ffffff"));
		textPaint.setTextSize(50);
		textPaint.setTextAlign(Align.CENTER);
		metrics=textPaint.getFontMetrics();
		maskPaint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		
		dataPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		dataPaint.setTextSize(40);
		dataPaint.setTextAlign(Align.CENTER);
		dataMetrics=dataPaint.getFontMetrics();
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
		perWidth = (width - getPaddingLeft() - getPaddingRight() - 3 * space-startPadding-endPadding)/4;
		if (num >= 2) {
			lineSpace = height / (num - 1);
		}
		barPaint.setStrokeWidth(perWidth);
		maskPaint.setStrokeWidth(perWidth);
		baseline=(int) ((-metrics.ascent+metrics.descent)/2);
		dataHeight=(int) (-dataMetrics.ascent+dataMetrics.descent);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.parseColor("#efefef"));
		if (lineSpace > 0)// 需要画线，初始为0
		{
			startX=getPaddingLeft();
			endX=width-getPaddingRight();
			for (int i = 0; i < num; i++) {
				canvas.drawLine(startX, startY, endX, endY, linePaint);
				startY+=lineSpace;
				endY+=lineSpace;
			}
		}
		lineStartX=lineEndX=getPaddingLeft()+startPadding+perWidth/2;
		lineStartY=height;
		lineEndY=height/2;
		maskStartX=maskEndX=lineStartX;
		maskStartY=height;
		maskEndY=(int)(7.0/8*height);
		barPaint.setColor(Color.parseColor("#6bc1f2"));
		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, barPaint);
		maskPaint.setColor(Color.parseColor("#089ae9"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText("高流动性",lineStartX, lineStartY-baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#6bc1f2"));
		canvas.drawText("50%", lineStartX, lineEndY-dataHeight, dataPaint);
		
		
		lineStartX=lineEndX=getPaddingLeft()+startPadding+perWidth/2+space+perWidth;
		lineStartY=height;
		lineEndY=height/3;
		maskStartX=maskEndX=lineStartX;
		barPaint.setColor(Color.parseColor("#97d573"));
		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, barPaint);
		maskPaint.setColor(Color.parseColor("#63ae4e"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText("固定收益",lineStartX, lineStartY-baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#97d573"));
		canvas.drawText("60%", lineStartX, lineEndY-dataHeight, dataPaint);
		
		
		lineStartX=lineEndX=getPaddingLeft()+startPadding+perWidth/2+space+perWidth+space+perWidth;
		lineStartY=height;
		lineEndY=height/4;
		maskStartX=maskEndX=lineStartX;
		barPaint.setColor(Color.parseColor("#fec57b"));
		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, barPaint);
		maskPaint.setColor(Color.parseColor("#e99b39"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText("浮动收益",lineStartX, lineStartY-baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#fec57b"));
		canvas.drawText("70%", lineStartX, lineEndY-dataHeight, dataPaint);
		
		
		lineStartX=lineEndX=getPaddingLeft()+startPadding+perWidth/2+space+perWidth+space+perWidth+space+perWidth;
		lineStartY=height;
		lineEndY=height/5;
		maskStartX=maskEndX=lineStartX;
		barPaint.setColor(Color.parseColor("#ff8989"));
		canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, barPaint);
		maskPaint.setColor(Color.parseColor("#e65353"));
		canvas.drawLine(maskStartX, maskStartY, maskEndX, maskEndY, maskPaint);
		canvas.drawText("另类投资",lineStartX, lineStartY-baseline, textPaint);
		dataPaint.setColor(Color.parseColor("#ff8989"));
		canvas.drawText("80%", lineStartX, lineEndY-dataHeight, dataPaint);
		
		
		
		super.onDraw(canvas);
	}

}
