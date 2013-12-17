package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI(this) {
            linearLayout { }
            relativeLayout { }
            absoluteLayout { }
            frameLayout { }
            gridLayout { }
        }
    }


}
