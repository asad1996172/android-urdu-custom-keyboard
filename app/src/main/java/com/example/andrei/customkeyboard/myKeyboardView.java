package com.example.andrei.customkeyboard;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by Asad Mahmood on 6/25/2016.
 */
public class myKeyboardView extends KeyboardView {

    DatabaseHelper db;
    myKeyboardView mMiniKeyboard;
    private View mMiniKeyboardContainer;
    private int[] mWindowOffset;
    private boolean mDrawPending;
    PopupWindow mPopupKeyboard;
    private boolean mMiniKeyboardVisible = false;

    public myKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return super.onTouchEvent(me);
    }

//    @Override
//    protected boolean onLongPress(Keyboard.Key popupKey) {
//        int popupKeyboardId = popupKey.popupResId;
//
//
//        if (popupKeyboardId != 0) {
//
//            mPopupKeyboard = new PopupWindow();
//            mPopupKeyboard.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.cream_white)));
//            mPopupKeyboard.setOutsideTouchable(true);
//            mPopupKeyboard.setFocusable(false);
//
//            mPopupKeyboard.setTouchInterceptor(new OnTouchListener()
//            {
//
//                public boolean onTouch(View v, MotionEvent event)
//                {
//
//                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE)
//                    {
//                        mPopupKeyboard.dismiss();
//                        return true;
//                    }
//
//                    return false;
//                }
//            });
//
//
//            if (mMiniKeyboardContainer == null) {
//                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
//                        Context.LAYOUT_INFLATER_SERVICE);
//                mMiniKeyboardContainer = inflater.inflate(R.layout.popup_layout, null);
//                mMiniKeyboard = (myKeyboardView) mMiniKeyboardContainer.findViewById(R.id.keyboardView);
//
//                if (mWindowOffset == null) {
//                    mWindowOffset = new int[2];
//                    getLocationInWindow(mWindowOffset);
//                }
//
//
//                mMiniKeyboard.setOnKeyboardActionListener(new OnKeyboardActionListener() {
//                    public void onKey(int primaryCode, int[] keyCodes) {
//
//                        char code = (char) primaryCode;
//                        db.getInstance(getContext()).insertData_words(String.valueOf(code));
//                        mPopupKeyboard.dismiss();
//                        mPopupKeyboard = null;
//                        mMiniKeyboardVisible = false;
//                        getOnKeyboardActionListener().onKey(primaryCode,keyCodes);
//
//                    }
//
//                    public void onText(CharSequence text) {
//                        mPopupKeyboard.dismiss();
//                        mPopupKeyboard = null;
//                    }
//
//                    public void swipeLeft() {
//                    }
//
//                    public void swipeRight() {
//                    }
//
//                    public void swipeUp() {
//                    }
//
//                    public void swipeDown() {
//                    }
//
//                    public void onPress(int primaryCode) {
//
//                    }
//
//                    public void onRelease(int primaryCode) {
//
//                    }
//                });
//
//            }
//            else
//            {
//
//                mMiniKeyboard = (myKeyboardView) mMiniKeyboardContainer.findViewById(R.id.keyboardView);
//            }
//
//            Keyboard keyboard;
//            if (popupKey.popupCharacters != null) {
//                keyboard = new Keyboard(getContext(), R.xml.keyboard_popup_template,
//                        popupKey.popupCharacters, -1, getPaddingLeft() + getPaddingRight());
//            } else {
//                keyboard = new Keyboard(getContext(), R.xml.keyboard_popup_template);
//            }
//            mMiniKeyboard.setKeyboard(keyboard);
//            mMiniKeyboard.setPopupParent(this);
//            mMiniKeyboardContainer.measure(
//                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.AT_MOST),
//                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.AT_MOST));
//
//
//            int popupX = popupKey.x + mWindowOffset[0];
//            popupX -= mMiniKeyboard.getPaddingLeft();
//            int popupY = popupKey.y + mWindowOffset[1];
//            popupY += getPaddingTop();
//            popupY -= mMiniKeyboard.getMeasuredHeight();
//            popupY -= mMiniKeyboard.getPaddingBottom();
//
//            popupX = popupX + popupKey.width - mMiniKeyboardContainer.getMeasuredWidth();
//            popupY = popupY - mMiniKeyboardContainer.getMeasuredHeight();
//            final int x = popupX + mMiniKeyboardContainer.getPaddingRight() + mWindowOffset[0];
//            final int y = popupY + mMiniKeyboardContainer.getPaddingBottom() + mWindowOffset[1]  + 70;
//            mMiniKeyboard.setPopupOffset(x < 0 ? 0 : x, y);
//            mMiniKeyboard.setShifted(isShifted());
//
//            mPopupKeyboard.setContentView(mMiniKeyboardContainer);
//
//            mPopupKeyboard.setWidth(mMiniKeyboardContainer.getMeasuredWidth());
//            mPopupKeyboard.setHeight(mMiniKeyboardContainer.getMeasuredHeight());
//            mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, x, y);
//
////            View container = (View) mPopupKeyboard.getContentView().getParent();
////            WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
////            WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
////            p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
////            p.dimAmount = 0.3f;
////            wm.updateViewLayout(container, p);
//
//
//            invalidateAllKeys();
//
//            return true;
//        }
//
//        return false;
//    }


}
