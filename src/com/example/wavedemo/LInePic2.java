package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class LInePic2 extends View implements Runnable{
	private int vHeight;
	private int vWidth;
	private Paint pathPaint;//路径画笔，就是折线
	private Path path;//line路径
	private Path regionPath;//闭合区域路径
	private Paint regionPaint;//区域画笔，画渐变区域
	private Paint verticalLinePaint;//跟随手指移动的线的画笔
	private Paint circlePaint;//绘制小圆环画笔
	private Paint circlePoint;//绘制小圆点画笔
	private List<Float> originalData;
	private List<Float> newData=new ArrayList<Float>();//根据originalData构造newData
	private List<Float> XList=new ArrayList<Float>();
	private float total=800;//代表竖直最大刻度

	public LInePic2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LInePic2(Context context, AttributeSet attrs) {
		this(context,attrs,-1);
	}

	public LInePic2(Context context) {
		this(context,null);
	}
	public void setData(List<Float> list)
	{
		XList.clear();
		newData.clear();
		this.originalData=list;
		int length=list.size();
		for(int i=0;i<length;i++)
		{
			XList.add(vWidth*1.0f/(length-1)*i);
			newData.add(total-originalData.get(i));
		}
		path.moveTo(XList.get(0), newData.get(0));
		regionPath.moveTo(XList.get(0), newData.get(0));
		for(int i=1;i<length;i++)
		{
			path.lineTo(XList.get(i), newData.get(i));
			regionPath.lineTo(XList.get(i), newData.get(i));
		}
		regionPath.lineTo(0, 800);
		regionPath.close();
		initColor();
		invalidate();
	}

	@Override
	public void run() {
		
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		vHeight=h;
		vWidth=w;
	}
	private void initColor()
	{
		LinearGradient gradient = new LinearGradient(0, vHeight, 0, 0, Color.parseColor("#00ffffff"),alphaColor , TileMode.REPEAT);  
		regionPaint.setShader(gradient);  
		pathPaint.setColor(color);
		circlePaint.setColor(color);
		circlePoint.setColor(color);
	}
	private void init()
	{
		pathPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		pathPaint.setStyle(Style.STROKE);//不设置Style为STROKE，DashPathEffect不起作用
		regionPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		regionPaint.setStyle(Style.FILL);
		circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePaint.setStyle(Style.STROKE);
		circlePoint=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePoint.setStrokeWidth(10);
		verticalLinePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		verticalLinePaint.setColor(Color.BLACK);
		path=new Path();
		regionPath=new Path();
	}
	private float radius=10f;
	private float largeRadius=15f;
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawPath(path, pathPaint);
		canvas.drawPath(regionPath, regionPaint);
		if(flag)
		{
			canvas.drawLine(X, 0, X, 800, verticalLinePaint);
			canvas.drawCircle(X, Y, largeRadius, circlePaint);
		}
		for(int i=0;i<newData.size();i++)//绘制小圆点
		{
			canvas.drawPoint(XList.get(i), newData.get(i), circlePoint);
			canvas.drawCircle(XList.get(i), newData.get(i) ,radius, circlePoint);
		}
	}
	
    private float X;
    private boolean flag;//标记是否出现竖直线
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	X=event.getX();
    	getRegionY(X);
    	switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			flag=true;
			break;
		case MotionEvent.ACTION_MOVE:
			
			break;
		case MotionEvent.ACTION_UP:
			break;
		default:
			break;
		}
    	invalidate();
    	return true;
    }
    private float Y;
    private void getRegionY(float x)
    {
    	for(int i=0;i<XList.size()-1;i++)
    	{
    		if(x==XList.get(i)||x==XList.get(i+1)||(x>XList.get(i)&&x<XList.get(i+1)))
    		{
    			float X1=XList.get(i);
    			float Y1=originalData.get(i);
    			float X2=XList.get(i+1);
    			float Y2=originalData.get(i+1);
    			Y=total-(Y2-Y1)/(X2-X1)*x+(Y2*X1-Y1*X2)/(X2-X1);
    		}
    	}
    }
    private int color;
    private int alphaColor;
    public void setColor(int color,int alphaColor)
    {
    	this.color=color;
    	this.alphaColor=alphaColor;
    }

}
