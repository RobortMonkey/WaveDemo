package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LInePic3 extends View implements Runnable{
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
	private float surplusHeight;//预留高度，用来显示底部刻度
	private float topsurplusHeight;//顶部预留高度，为纵轴文字高度的一半
	private float total;//代表竖直最大刻度
	//--------------------------------------------------------
	private Paint pathPaint2;//路径画笔，就是折线
	private Path path2;//line路径
	private Path regionPath2;//闭合区域路径
	private Paint regionPaint2;//区域画笔，画渐变区域
	private Paint verticalLinePaint2;//跟随手指移动的线的画笔
	private Paint circlePaint2;//绘制小圆环画笔
	private Paint circlePoint2;//绘制小圆点画笔
	private List<Float> originalData2;
	private List<Float> newData2=new ArrayList<Float>();//根据originalData构造newData
	private List<Float> XList2=new ArrayList<Float>();
	//---------------------------------------------------------
	private TextPaint verticalTextPaint;
	private Paint horiPaint;//横轴刻度线画笔

	public LInePic3(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LInePic3(Context context, AttributeSet attrs) {
		this(context,attrs,-1);
	}

	public LInePic3(Context context) {
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
			XList.add((vWidth-maxLength)*1.0f/(length-1)*i+maxLength);
			newData.add(total-originalData.get(i));
		}
		path.moveTo(XList.get(0), newData.get(0));
		regionPath.moveTo(XList.get(0), newData.get(0));
		for(int i=1;i<length;i++)
		{
			path.lineTo(XList.get(i), newData.get(i));
			regionPath.lineTo(XList.get(i), newData.get(i));
		}
		regionPath.lineTo(XList.get(length-1), total);
		regionPath.lineTo(maxLength, total);
		regionPath.close();
		invalidate();
	}
	
	public void setData2(List<Float> list)
	{
		XList2.clear();
		newData2.clear();
		this.originalData2=list;
		int length=list.size();
		for(int i=0;i<length;i++)
		{
			XList2.add((vWidth-maxLength)*1.0f/(length-1)*i+maxLength);
			newData2.add(total-originalData2.get(i));
		}
		path2.moveTo(XList2.get(0), newData2.get(0));
		regionPath2.moveTo(XList2.get(0), newData2.get(0));
		for(int i=1;i<length;i++)
		{
			path2.lineTo(XList2.get(i), newData2.get(i));
			regionPath2.lineTo(XList2.get(i), newData2.get(i));
		}
		regionPath2.lineTo(XList.get(length-1), total);
		regionPath2.lineTo(maxLength, total);
		regionPath2.close();
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
		LinearGradient gradient = new LinearGradient(0, vHeight, 0, 0, Color.parseColor("#00ffffff"),Color.parseColor("#6629bbea") , TileMode.REPEAT);  
		regionPaint.setShader(gradient);  
		LinearGradient gradient2 = new LinearGradient(0, vHeight, 0, 0, Color.parseColor("#00ffffff"),Color.parseColor("#66e44078") , TileMode.REPEAT);  
		regionPaint2.setShader(gradient2);  
	}
	private DashPathEffect effects;
	private void init()
	{
		surplusHeight=getResources().getDimension(R.dimen.px2dp_150);
		pathPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		pathPaint.setStyle(Style.STROKE);//不设置Style为STROKE，DashPathEffect不起作用
		regionPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		regionPaint.setStyle(Style.FILL);
		circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePaint.setStyle(Style.STROKE);
		circlePaint.setStrokeWidth(5);
		circlePoint=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePoint.setStrokeWidth(10);
		horiPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		effects = new DashPathEffect(new float[] { 5, 5, 5,
				5 }, 1);
		horiPaint.setPathEffect(effects);
		verticalLinePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		verticalLinePaint.setColor(Color.BLACK);
		verticalTextPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG);
		verticalTextPaint.setTextSize(getResources().getDimension(R.dimen.px2dp_15));
		verticalTextPaint.setColor(Color.parseColor("#333333"));
		
		path=new Path();
		regionPath=new Path();
		pathPaint.setColor(Color.parseColor("#29bbea"));
		circlePaint.setColor(Color.parseColor("#29bbea"));
		circlePoint.setColor(Color.parseColor("#29bbea"));
		//-----------------------------------------------------------
		pathPaint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		pathPaint2.setStyle(Style.STROKE);//不设置Style为STROKE，DashPathEffect不起作用
		regionPaint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		regionPaint2.setStyle(Style.FILL);
		circlePaint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePaint2.setStyle(Style.STROKE);
		circlePaint2.setStrokeWidth(5);
		circlePoint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		circlePoint2.setStrokeWidth(10);
		verticalLinePaint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		verticalLinePaint2.setColor(Color.BLACK);
		path2=new Path();
		regionPath2=new Path();
		pathPaint2.setColor(Color.parseColor("#e44078"));
		circlePaint2.setColor(Color.parseColor("#e44078"));
		circlePoint2.setColor(Color.parseColor("#e44078"));
	}
	
	private float radius=10f;
	private float largeRadius=15f;
	private float verticalDelta=0;
	private float offsetDistance;
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
		
		
		verticalDelta=(total-topsurplusHeight)/(descriptionLists.size()-1);
		for(int i=0;i<descriptionLists.size();i++)
		{
			//绘制横轴标识
			//绘制横轴刻度线
			if(i==0)
				horiPaint.setPathEffect(null);
			else
				horiPaint.setPathEffect(effects);
			canvas.drawLine(maxLength, total-verticalDelta*i, vWidth, total-verticalDelta*i, horiPaint);
			canvas.drawText(descriptionLists.get(i), 0, total-verticalDelta*i+offsetDistance, verticalTextPaint);
		}
		
		//绘制折线和渐变区域
		canvas.drawPath(path, pathPaint);
		canvas.drawPath(regionPath, regionPaint);
		canvas.drawPath(path2, pathPaint2);
		canvas.drawPath(regionPath2, regionPaint2);
		if(flag)
		{
			canvas.drawLine(X, topsurplusHeight, X, total, verticalLinePaint);
			canvas.drawCircle(X, YY2, largeRadius, circlePaint2);
			canvas.drawCircle(X, Y, largeRadius, circlePaint);
			
		}
		for(int i=0;i<newData.size();i++)//绘制小圆点
		{
			canvas.drawCircle(XList.get(i), newData.get(i) ,radius, circlePoint);
			canvas.drawCircle(XList2.get(i), newData2.get(i) ,radius, circlePoint2);
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
    private float YY2;
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
    	
    	for(int i=0;i<XList2.size()-1;i++)
    	{
    		if(x==XList2.get(i)||x==XList2.get(i+1)||(x>XList2.get(i)&&x<XList2.get(i+1)))
    		{
    			float X1=XList2.get(i);
    			float Y1=originalData2.get(i);
    			float X2=XList2.get(i+1);
    			float Y2=originalData2.get(i+1);
    			YY2=total-(Y2-Y1)/(X2-X1)*x+(Y2*X1-Y1*X2)/(X2-X1);
    		}
    	}
    }
    private List<String> descriptionLists=new ArrayList<String>();
    private float maxLength=0;//记录纵坐标的最大长度
    public void setDescriptionList(List<String> descriptionLists)
    {
    	this.descriptionLists=descriptionLists;
    	String maxString="";
    	for(int i=0;i<descriptionLists.size();i++)
    	{
    		if(descriptionLists.get(i).length()>maxString.length())
    		{
    			maxString=descriptionLists.get(i);
    		}
    	}
    	maxLength=verticalTextPaint.measureText(maxString);
    	topsurplusHeight=(verticalTextPaint.descent()-verticalTextPaint.ascent())/2;
    	total=vHeight-surplusHeight;
    	offsetDistance=(-verticalTextPaint.descent()-verticalTextPaint.ascent())/2;
    }

}
