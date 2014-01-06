package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.AbsoluteLayout
import android.widget.FrameLayout
import android.widget.GridLayout
import android.view.Gravity


public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI(this) {
            linearLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                        weight = 1.3591409142295225
                    }
                }
            }
            relativeLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
                        addRule(RelativeLayout.CENTER_IN_PARENT)
                    }
                }
            }
            absoluteLayout {
                editText {
                    layoutParams(-2, -2, 12, 23) {
                        height = 9
                        x = 100
                        y = 200
                    }
                }
            }
            frameLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                    }
                }
            }
            gridLayout {
                editText {
                    layoutParams() {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                    }
                }
            }
        }
    }
}