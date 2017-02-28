package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 水波纹数字
 * 
 * @author huozhenpeng
 * 
 */
public class WaveTextView2 extends View {
	private TextPaint textPaint;
	private TextPaint textPaint2;
	private int textSize = 200;
	private int textPaintWidth = 50;
	private int width;
	private int height;
	private int Delta;
	private int step;
	private Path path;
	private FontMetrics fontMetrics;
	private String text = "85";
	private int baseline;
	private int max;
	private float controlY1;// 两个控制点的纵坐标
	private float controlY2;
	private int fraction = 1;// 1或者-1

	public WaveTextView2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public WaveTextView2(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public WaveTextView2(Context context) {
		this(context, null);
	}

	public void init() {

		textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textPaint.setColor(Color.parseColor("#0e92ca"));
		textPaint.setTextSize(textSize);
		textPaint.setStrokeWidth(textPaintWidth);
		textPaint.setTextAlign(Align.CENTER);
		fontMetrics = textPaint.getFontMetrics();

		textPaint2 = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textPaint2.setColor(Color.parseColor("#efefef"));
		textPaint2.setTextSize(textSize);
		textPaint2.setStrokeWidth(textPaintWidth);
		textPaint2.setTextAlign(Align.CENTER);
		path = new Path();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY) {
			widthMeasureSpec = MeasureSpec.makeMeasureSpec(
					(int) textPaint.measureText(text), MeasureSpec.EXACTLY);
		}
		if (MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY) {
			heightMeasureSpec = MeasureSpec.makeMeasureSpec(
					(int) (fontMetrics.descent - fontMetrics.ascent),
					MeasureSpec.EXACTLY);

		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		baseline = (int) ((fontMetrics.descent + fontMetrics.ascent) / 2);
		max = (int) (Integer.parseInt(text) / 100.0f * height);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (Delta >= max) {
			Delta = max;
		}
		path.reset();
		path.moveTo(0, 0);
		path.lineTo(width, 0);
		path.lineTo(width, height - Delta);
		controlY1 = step + (height - Delta);
		controlY2 = -step + (height - Delta);
		if (controlY1 - (height - Delta) >= height * 1.0f / 4) {
			fraction = -1;
		}
		if (controlY1 - (height - Delta) <= -height * 1.0f / 4) {
			fraction = 1;
		}
		path.cubicTo(width * 3.0f / 4, controlY1, width * 1.0f / 4, controlY2,
				0, height - Delta);
		path.close();
		canvas.drawColor(Color.parseColor("#ffffff"));
		canvas.drawText(text, width / 2, height / 2 - baseline, textPaint);
		canvas.save();
		canvas.clipPath(path);
		canvas.drawText(text, width / 2, height / 2 - baseline, textPaint2);
		canvas.restore();
		super.onDraw(canvas);
	}

	public void setText(int text) {
		this.text = text + "";
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
						Delta += 1;
						step += 1 * fraction;
						postInvalidate();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
