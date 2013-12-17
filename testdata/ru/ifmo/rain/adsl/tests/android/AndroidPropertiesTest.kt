package com.example.android_test

import android.app.Activity
import android.os.Bundle
import com.example.adsl.*
import android.widget.LinearLayout

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI(this) {
            linearLayout {
                val bl = baseline
                baselineAlignedChildIndex = 0
                dividerDrawable = null
                dividerPadding = 1
                orientation = -1
                showDividers = 0
                weightSum = 2.4
                textSwitcher {}
                calendarView {
                    date = 123456
                    focusedMonthDateColor = 255
                    showWeekNumber = true
                    weekSeparatorLineColor = 128
                }
                zoomButton {}
                viewSwitcher {}
                digitalClock {}
                multiAutoCompleteTextView {}
                checkBox {
                    checked = true
                }
                imageButton {}
                videoView {
                    val vv_currentPosition = currentPosition
                }
                horizontalScrollView {}
                numberPicker {
                    val np_displayedValues = displayedValues
                    maxValue = 3
                    value = 2134
                }
                analogClock {}
                scrollView {}
                textView {
                    compoundDrawablePadding = 23
                    customSelectionActionModeCallback = null
                    error = "error"
                    freezesText = false
                    highlightColor = 31
                    imeOptions = 0
                    linksClickable = true
                }
                tabWidget {
                    val tw_tabCount = tabCount
                }
                radioButton {}
                toggleButton {
                    textOff = "12354"
                    textOn = "qwerty"
                }
                seekBar {}
                datePicker {
                    val dp_calendarView = calendarView
                    val dp_month = month
                    val dp_year = year
                }
                radioGroup {
                    val rg_checkedRadioButtonId = checkedRadioButtonId
                }
                timePicker {
                    currentHour = 3
                }
                zoomControls {}
                imageView {
                    adjustViewBounds = false
                    baseline = 234
                    imageMatrix = android.graphics.Matrix()
                }
                searchView {
                    inputType = 3
                    maxWidth = 32
                    queryHint = "sdfsdfsf"
                }
                autoCompleteTextView {
                    completionHint = "hint"
                    dropDownAnchor = 0
                    dropDownHeight = 0
                    dropDownHorizontalOffset = 2
                    threshold = 2
                    validator = null
                }
                switch {
                    switchPadding = 23
                    textOff = "918237"
                    thumbTextPadding = 33
                }
                progressBar {
                    progress = 34
                    secondaryProgress = 9
                }
                space {}
                listView {
                    val lv_checkItemIds = checkItemIds
                    itemsCanFocus = true
                    overscrollHeader = null
                }
                gridView {
                    columnWidth = 23
                    gravity = 68
                    numColumns = 3
                }
                spinner {}
                gallery {}
                imageSwitcher {}
                checkedTextView {}
                chronometer {
                    base = 9
                    format = "%d%Y%m"

                }
                button {}
                editText {}
                ratingBar {
                    numStars = 3
                    rating = 3.4
                    stepSize = 0.7
                }
                stackView {}
                quickContactBadge {}
                twoLineListItem {}
                dialerFilter {
                    val df_digits = digits
                }
                tabHost {
                    currentTab = 2
                    val th_currentTabView = currentTabView

                }
                viewAnimator {}
                mediaController {}
                expandableListView {
                    adapter = null
                    val elv_selectedPosition = selectedPosition
                }
                viewFlipper {}
            }
        }
    }


}
