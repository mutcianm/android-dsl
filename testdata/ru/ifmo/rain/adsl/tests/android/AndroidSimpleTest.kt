package com.example.android_test

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI(this) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                var tv1 = textView()
                tv1 = textView {
                    text = "9287y4r3"
                }
                val b1 = button {
                    text = "Buttons1231"
                    setOnClickListener {
                        tv1.text = text
                    }

                    mouse {
                        onPress {

                        }
                        onRelease {

                        }
                    }

                    onMousePress {

                    }
                    onMouseRelease {

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