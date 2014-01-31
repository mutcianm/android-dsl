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
                    vgInstance.onScroll {
                        onScroll { a,b,c,d ->  }
                        onScrollStateChanged { a,b -> }
                    }
                }
                searchView {
                    vgInstance.onQueryText {
                        onQueryTextChange { a -> true }
                        onQueryTextSubmit { a -> true }
                    }
                }
                seekBar {
                    onSeekBarChange {
                        onProgressChanged { a,b,c -> }
                        onStartTrackingTouch { a -> }
                        onStopTrackingTouch { a -> }
                    }
                }
            }
        }
    }
}