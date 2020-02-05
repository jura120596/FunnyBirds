package com.example.paintk92.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.paintk92.R;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setAntiAlias(true);
        paint.setColor(Color.argb(127,0,0,255));
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, 100, paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, this.getWidth(), 200, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText("Hello world!", 100, 100, paint);

        float rotate_center_x = 200; //центр поворота холста по оси X
        float rotate_center_y = 200; // центр поворота холста по оси Y
        float rotate_angle = 15; //угол поворота

// поворачиваем холст
        canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);


        paint.setColor(Color.BLACK);
        paint.setTextSize(40);

        canvas.drawText("Samsung IT school",0,450,paint);

// возвращаем холст на прежний угол
        canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);

        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        int xx = canvas.getWidth(), yy = canvas.getHeight();
        canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paint);
    }
}
