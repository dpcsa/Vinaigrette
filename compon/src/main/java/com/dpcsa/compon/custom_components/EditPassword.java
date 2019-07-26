package com.dpcsa.compon.custom_components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dpcsa.compon.R;
import com.dpcsa.compon.interfaces_classes.IComponent;
import com.dpcsa.compon.interfaces_classes.IValidate;
import com.dpcsa.compon.interfaces_classes.OnChangeStatusListener;

public class EditPassword extends AppCompatEditText implements IComponent, IValidate {

    private String alias;
    protected String textError = "";
    private int minLength = -1;
    private boolean isValid;
    private int imgIdShow = 0, imgIdHide = 0;

    public EditPassword(Context context) {
        super(context);
    }

    public EditPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EditPassword(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Simple,
                0, 0);
        try {
            textError = a.getString(R.styleable.Simple_textError);
            if (textError == null) {
                textError = "";
            }
            minLength = a.getInt(R.styleable.Simple_minLength, -1);
            imgIdShow = a.getResourceId(R.styleable.Simple_idShowPassword, 0);
            imgIdHide = a.getResourceId(R.styleable.Simple_idHidePassword, 0);
        } finally {
            a.recycle();
        }
        isValid = false;
        if (imgIdShow != 0) {
            setCompoundDrawablesWithIntrinsicBounds(0, 0, imgIdShow, 0);
        }
    }


//    this.setOnTouchListener(new OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            final int DRAWABLE_LEFT = 0;
//            final int DRAWABLE_TOP = 1;
//            final int DRAWABLE_RIGHT = 2;
//            final int DRAWABLE_BOTTOM = 3;
//
//            if(event.getAction() == MotionEvent.ACTION_UP) {
//                if(event.getRawX() >= (editComment.getRight() - editComment.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
//                    // your action here
//
//                    return true;
//                }
//            }
//            return false;
//        }
//    });

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_TOP = 1;
        final int DRAWABLE_RIGHT = 2;
        final int DRAWABLE_BOTTOM = 3;

        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(event.getRawX() >= (getRight() - getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, imgIdHide, 0);
                return true;
            }
        }
        return false;
    }


    @Override
    public void setData(Object data) {

    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public void setOnChangeStatusListener(OnChangeStatusListener statusListener) {

    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
