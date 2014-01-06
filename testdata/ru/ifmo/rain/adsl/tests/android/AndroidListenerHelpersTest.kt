package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout

public fun android.view.View.OnClick(l: android.view.View.OnClickListener?) {
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
