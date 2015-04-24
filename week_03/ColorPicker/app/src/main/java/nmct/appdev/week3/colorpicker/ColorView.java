package nmct.appdev.week3.colorpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ColorView extends View {

    private String color = "#FFFFFF";
    private Paint paint;
    private Rect rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect.set(0, 0, getWidth(), getHeight());
        paint.setColor(Color.parseColor(color));
        canvas.drawRect(rect, paint);
    }

    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        rect = new Rect();

        rect.top = 0;
        rect.left = 0;
        rect.right = getWidth();
        rect.bottom = getHeight();

        paint = new Paint();
        paint.setColor(Color.parseColor(color));

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(getClass().getSimpleName(), "clicked rect");
                showColorDialog();
            }
        });


    }

    public ColorView(Context context) {
        this(context, null);
    }

    public ColorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs);
    }

    public ColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void showColorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Pick a color!")
                .setItems(R.array.holo_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        selectColor(which);
                    }
                });

        builder.create().show();
    }

    private void selectColor(int which) {
        switch (which) {
            case 0:
                setColor("#33B5E5");
                break;
            case 1:
                setColor("#AA66CC");
                break;
            case 2:
                setColor("#99CC00");
                break;
            case 3:
                setColor("#FFBB33");
                break;
            case 4:
                setColor("#FF4444");
                break;
            default:
                Log.d(getClass().getSimpleName(), "color not found in selectColor");
                break;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        Log.d(getClass().getSimpleName(), "setting color " + color);
        this.color = color;
        invalidate();
    }

}
