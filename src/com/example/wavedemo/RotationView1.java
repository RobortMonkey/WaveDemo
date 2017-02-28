package com.example.wavedemo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class RotationView1 extends ImageView {
	private int width;
	private int height;
	private Paint paint;
	private RectF rectf;
	private int paintWidth = 100;
	private int margin;
	private double startAngle;// 记录开始角度
	private Matrix matrix;
	private double totalRotation;
	private int padding;// 设置padding或者leftpadding
	private boolean isFirst = true;
	private Bitmap imageScaled;
	private Canvas mCanvas;
	private TextPaint textpaint;
	private int textsize = 50;
	private FontMetrics fontMetrics;

	public RotationView1(Context context) {
		this(context, null);
	}

	public RotationView1(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RotationView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public void init() {
		this.setScaleType(ScaleType.MATRIX);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paint.setStrokeWidth(paintWidth);
		paint.setStyle(Style.STROKE);
		textpaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textpaint.setTextSize(textsize);
		textpaint.setTextAlign(Align.CENTER);
		if (matrix == null) {
			matrix = new Matrix();
		} else {
			matrix.reset();
		}
		setImageMatrix(matrix);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(heightMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		padding = getPaddingLeft();
		margin = padding + paintWidth / 2;
		rectf = new RectF(margin, margin, width - margin, height - margin);
		imageScaled = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		mCanvas = new Canvas();
		mCanvas.setBitmap(imageScaled);
		if (isFirst) {
			paint.setColor(Color.parseColor("#7eb445"));
			mCanvas.drawArc(rectf, 0, 90, false, paint);
			paint.setColor(Color.parseColor("#819d87"));
			mCanvas.drawArc(rectf, 90, 60, false, paint);
			paint.setColor(Color.parseColor("#e61a5f"));
			mCanvas.drawArc(rectf, 150, 210, false, paint);
		}
		isFirst = false;
		setImageBitmap(imageScaled);
		fontMetrics = textpaint.getFontMetrics();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		textpaint.setColor(Color.parseColor("#7eb445"));
		canvas.drawText("+0.25", width / 2, height / 2
				- (fontMetrics.ascent + fontMetrics.descent) / 2, textpaint);

	}

	/**
	 * get the quadrant of the wheel which contains the touch point (x,y)
	 * 
	 * @return quadrant 1,2,3 or 4
	 */
	private static int getQuadrant(double x, double y) {
		if (x >= 0) {
			return y >= 0 ? 1 : 4;
		} else {
			return y >= 0 ? 2 : 3;
		}
	}

	/**
	 * get the angle of a touch event.
	 */
	private double getAngle(double x, double y) {
		x = x - (width / 2d);
		y = height - y - (height / 2d);// （就是wheelHeight/2-y，由于变为数学中的坐标系，所以相当于取了一下反）

		switch (getQuadrant(x, y)) {
		case 1:
			return Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
		case 2:
			return 180 - Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
		case 3:
			return 180 + (-1 * Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
		case 4:
			return 360 + Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
		default:
			return 0;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startAngle = getAngle(event.getX(), event.getY());
			break;

		case MotionEvent.ACTION_MOVE:
			double currentAngle = getAngle(event.getX(), event.getY());
			rotateWheel((float) (startAngle - currentAngle));
			startAngle = currentAngle;
			break;

		case MotionEvent.ACTION_UP:
			totalRotation = totalRotation % 360;
			if (totalRotation < 0) {
				totalRotation = 360 + totalRotation;
			}
			if (0 < totalRotation && totalRotation < 90) {
				Log.e("abc", "90");
				rotateWheel((float) (45 - totalRotation));
			} else if (90 < totalRotation && totalRotation < 300) {
				Log.e("abc", "360");
				rotateWheel((float) (90 + 105 - totalRotation));
			} else if (300 < totalRotation && totalRotation < 360) {
				Log.e("abc", "150");
				rotateWheel((float) (90 + 210 + 30 - totalRotation));
			}
			break;
		}

		return true;
	}

	/**
	 * rotate the wheel by the given angle
	 * 
	 * @param degrees
	 */
	private void rotateWheel(float degrees) {
		matrix.postRotate(degrees, width / 2, height / 2);
		setImageMatrix(matrix);
		totalRotation = totalRotation + degrees;
	}


}
