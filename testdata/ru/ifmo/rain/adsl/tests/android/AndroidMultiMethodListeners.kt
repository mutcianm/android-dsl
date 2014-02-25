package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout
import android.view.View
import android.view.View.OnClickListener

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                listView {
                    viewGroup onScroll { a,b,c,d ->  }
                    viewGroup onScrollStateChanged { a,b -> }
                }
                searchView {
                    viewGroup onQueryTextChange { a -> true }
                    viewGroup onQueryTextSubmit { a -> true }
                }
                seekBar {
                    onProgressChanged { a,b,c -> }
                    onStartTrackingTouch { a -> }
                    onStopTrackingTouch { a -> }
                }
            }
        }
    }
}