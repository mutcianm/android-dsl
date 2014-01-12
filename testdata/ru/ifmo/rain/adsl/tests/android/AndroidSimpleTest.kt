package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                val tv1 = textView {
                    text = "9287y4r3"
                }
                val b1 = button {
                    text = "Buttons1231"
                    setOnClickListener {
                        tv1.text = text
                    }
                }
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    checkBox {
                        text = "34563456"
                    }
                    val b2 = button {
                        text = "9auhdfg9a"
                    }
                }
            }
        }
    }


}
