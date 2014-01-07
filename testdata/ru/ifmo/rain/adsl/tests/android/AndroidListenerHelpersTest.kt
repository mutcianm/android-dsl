package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout
import android.view.View
import android.view.View.OnClickListener

public fun android.widget.Button.OnClick(l: android.view.View.OnClickListener?) {
    setOnClickListener(l)
}


public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI(this) {
            linearLayout {
               button() {
                  onClick {
                      text = "clicked"
                  }
               }
            }
        }
    }


}
