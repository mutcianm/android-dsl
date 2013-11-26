package com.example.andr;

import android.app.Activity
import android.os.Bundle
import android.widget.*
import com.example.andr.dsl.*
import android.view.View
import android.widget.LinearLayout.LayoutParams
import android.view.ViewGroup
import android.graphics.Color

public class MyActivity() : Activity() {
    /**
     * Called when the activity is first created.
     */
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        UI(this) {
            linearLayout{
                orientation = (LinearLayout.VERTICAL)
                style{ X ->
                    when(X){
                        is Button -> X.setTextColor(Color.BLUE)
                        is EditText -> X.setBackgroundColor(Color.DKGRAY)
                        else -> X
                    }
                }
                val et = editText {
                    text = "EditText"
                }
                button {
                    text = "button1"
                    setOnClickListener {
                        et.text = savedInstanceState.toString()
                    }
                }
                button{
                    text = "Butt2"
                    setOnClickListener {
                        alertDialog("exit?") {
                            setPositiveButton("OK") { a,i ->
                                ctx.finish()
                            }
                            setNegativeButton("no") { a,i ->
                                et.text = "okno"
                            }
                        }
                    }
                }
                listView {
                    for (i in (0..3)){
                        ratingBar {
                            rating = i.toFloat()
                        }
                    }
                }
                linearLayout{
                    orientation = LinearLayout.HORIZONTAL
                    val butt = button {
                        text ="Frame1"
                    }
                    checkBox {
                        orientation = LinearLayout.HORIZONTAL
                        text = "somecb"
                        setOnClickListener {
                            butt.text = isChecked().toString()
                        }
                    }
                    orientation = LinearLayout.HORIZONTAL
                }
            }
        }
    }

}