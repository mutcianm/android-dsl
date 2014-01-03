open class _Container(open val vgInstance: android.view.ViewGroup,
                      open val ctx: android.app.Activity) {

    var _style: ((X: Any) -> Unit) = { }

    fun style(init: (X: Any) -> Unit) {
        this._style = init
    }

    fun alertDialog(title: String, func: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.func()
        return builder.create()!!.show()
    }
    fun videoView(init: android.widget.VideoView.() -> Unit): android.widget.VideoView {
        val v = android.widget.VideoView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun analogClock(init: android.widget.AnalogClock.() -> Unit): android.widget.AnalogClock {
        val v = android.widget.AnalogClock(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun textView(init: android.widget.TextView.() -> Unit): android.widget.TextView {
        val v = android.widget.TextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageView(init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
        val v = android.widget.ImageView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun progressBar(init: android.widget.ProgressBar.() -> Unit): android.widget.ProgressBar {
        val v = android.widget.ProgressBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun space(init: android.widget.Space.() -> Unit): android.widget.Space {
        val v = android.widget.Space(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    //container function
    fun relativeLayout(init: _RelativeLayout.() -> Unit): _RelativeLayout {
        val v = _RelativeLayout(android.widget.RelativeLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun absoluteLayout(init: _AbsoluteLayout.() -> Unit): _AbsoluteLayout {
        val v = _AbsoluteLayout(android.widget.AbsoluteLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun frameLayout(init: _FrameLayout.() -> Unit): _FrameLayout {
        val v = _FrameLayout(android.widget.FrameLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun linearLayout(init: _LinearLayout.() -> Unit): _LinearLayout {
        val v = _LinearLayout(android.widget.LinearLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gridLayout(init: _GridLayout.() -> Unit): _GridLayout {
        val v = _GridLayout(android.widget.GridLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    fun digitalClock(init: android.widget.DigitalClock.() -> Unit): android.widget.DigitalClock {
        val v = android.widget.DigitalClock(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkedTextView(init: android.widget.CheckedTextView.() -> Unit): android.widget.CheckedTextView {
        val v = android.widget.CheckedTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun chronometer(init: android.widget.Chronometer.() -> Unit): android.widget.Chronometer {
        val v = android.widget.Chronometer(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun button(init: android.widget.Button.() -> Unit): android.widget.Button {
        val v = android.widget.Button(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun button(text: jet.CharSequence?, init: android.widget.Button.() -> Unit): android.widget.Button {
        val v = android.widget.Button(ctx)
        v.text = text
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun editText(init: android.widget.EditText.() -> Unit): android.widget.EditText {
        val v = android.widget.EditText(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageButton(init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
        val v = android.widget.ImageButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit): android.widget.QuickContactBadge {
        val v = android.widget.QuickContactBadge(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
        val v = android.widget.TwoLineListItem(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun dialerFilter(init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
        val v = android.widget.DialerFilter(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun calendarView(init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
        val v = android.widget.CalendarView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun horizontalScrollView(init: android.widget.HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
        val v = android.widget.HorizontalScrollView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun scrollView(init: android.widget.ScrollView.() -> Unit): android.widget.ScrollView {
        val v = android.widget.ScrollView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun datePicker(init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
        val v = android.widget.DatePicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun timePicker(init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
        val v = android.widget.TimePicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tabHost(init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
        val v = android.widget.TabHost(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewAnimator(init: android.widget.ViewAnimator.() -> Unit): android.widget.ViewAnimator {
        val v = android.widget.ViewAnimator(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun mediaController(init: android.widget.MediaController.() -> Unit): android.widget.MediaController {
        val v = android.widget.MediaController(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tableLayout(init: android.widget.TableLayout.() -> Unit): android.widget.TableLayout {
        val v = android.widget.TableLayout(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tableRow(init: android.widget.TableRow.() -> Unit): android.widget.TableRow {
        val v = android.widget.TableRow(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun numberPicker(init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
        val v = android.widget.NumberPicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tabWidget(init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
        val v = android.widget.TabWidget(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun radioGroup(init: android.widget.RadioGroup.() -> Unit): android.widget.RadioGroup {
        val v = android.widget.RadioGroup(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun zoomControls(init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
        val v = android.widget.ZoomControls(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun searchView(init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
        val v = android.widget.SearchView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit): android.widget.AutoCompleteTextView {
        val v = android.widget.AutoCompleteTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun zoomButton(init: android.widget.ZoomButton.() -> Unit): android.widget.ZoomButton {
        val v = android.widget.ZoomButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun seekBar(init: android.widget.SeekBar.() -> Unit): android.widget.SeekBar {
        val v = android.widget.SeekBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun ratingBar(init: android.widget.RatingBar.() -> Unit): android.widget.RatingBar {
        val v = android.widget.RatingBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewSwitcher(init: android.widget.ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
        val v = android.widget.ViewSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewFlipper(init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
        val v = android.widget.ViewFlipper(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun listView(init: android.widget.ListView.() -> Unit): android.widget.ListView {
        val v = android.widget.ListView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun gridView(init: android.widget.GridView.() -> Unit): android.widget.GridView {
        val v = android.widget.GridView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun spinner(init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
        val v = android.widget.Spinner(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun gallery(init: android.widget.Gallery.() -> Unit): android.widget.Gallery {
        val v = android.widget.Gallery(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun stackView(init: android.widget.StackView.() -> Unit): android.widget.StackView {
        val v = android.widget.StackView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox(init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox(text: jet.CharSequence?, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.text = text
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox(text: jet.CharSequence?, checked: Boolean, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.text = text
        v.checked = checked
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun radioButton(init: android.widget.RadioButton.() -> Unit): android.widget.RadioButton {
        val v = android.widget.RadioButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun toggleButton(init: android.widget.ToggleButton.() -> Unit): android.widget.ToggleButton {
        val v = android.widget.ToggleButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun switch(init: android.widget.Switch.() -> Unit): android.widget.Switch {
        val v = android.widget.Switch(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit): android.widget.MultiAutoCompleteTextView {
        val v = android.widget.MultiAutoCompleteTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun textSwitcher(init: android.widget.TextSwitcher.() -> Unit): android.widget.TextSwitcher {
        val v = android.widget.TextSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageSwitcher(init: android.widget.ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
        val v = android.widget.ImageSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun expandableListView(init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
        val v = android.widget.ExpandableListView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

}

val _FrameLayout.considerGoneChildrenWhenMeasuring: Boolean
    get() = (vgInstance as android.widget.FrameLayout).getConsiderGoneChildrenWhenMeasuring()

var _FrameLayout.foreground: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.FrameLayout).getForeground()
    set(value) = (vgInstance as android.widget.FrameLayout).setForeground(value!!)

var _FrameLayout.foregroundGravity: Int
    get() = (vgInstance as android.widget.FrameLayout).getForegroundGravity()
    set(value) = (vgInstance as android.widget.FrameLayout).setForegroundGravity(value)

var _FrameLayout.measureAllChildren: Boolean
    get() = (vgInstance as android.widget.FrameLayout).getMeasureAllChildren()
    set(value) = (vgInstance as android.widget.FrameLayout).setMeasureAllChildren(value)

var _GridLayout.alignmentMode: Int
    get() = (vgInstance as android.widget.GridLayout).getAlignmentMode()
    set(value) = (vgInstance as android.widget.GridLayout).setAlignmentMode(value)

var _GridLayout.columnCount: Int
    get() = (vgInstance as android.widget.GridLayout).getColumnCount()
    set(value) = (vgInstance as android.widget.GridLayout).setColumnCount(value)

var _GridLayout.columnOrderPreserved: Boolean
    get() = (vgInstance as android.widget.GridLayout).isColumnOrderPreserved()
    set(value) = (vgInstance as android.widget.GridLayout).setColumnOrderPreserved(value)

var _GridLayout.orientation: Int
    get() = (vgInstance as android.widget.GridLayout).getOrientation()
    set(value) = (vgInstance as android.widget.GridLayout).setOrientation(value)

var _GridLayout.rowCount: Int
    get() = (vgInstance as android.widget.GridLayout).getRowCount()
    set(value) = (vgInstance as android.widget.GridLayout).setRowCount(value)

var _GridLayout.rowOrderPreserved: Boolean
    get() = (vgInstance as android.widget.GridLayout).isRowOrderPreserved()
    set(value) = (vgInstance as android.widget.GridLayout).setRowOrderPreserved(value)

var _GridLayout.useDefaultMargins: Boolean
    get() = (vgInstance as android.widget.GridLayout).getUseDefaultMargins()
    set(value) = (vgInstance as android.widget.GridLayout).setUseDefaultMargins(value)

val _LinearLayout.baseline: Int
    get() = (vgInstance as android.widget.LinearLayout).getBaseline()

var _LinearLayout.baselineAligned: Boolean
    get() = (vgInstance as android.widget.LinearLayout).isBaselineAligned()
    set(value) = (vgInstance as android.widget.LinearLayout).setBaselineAligned(value)

var _LinearLayout.baselineAlignedChildIndex: Int
    get() = (vgInstance as android.widget.LinearLayout).getBaselineAlignedChildIndex()
    set(value) = (vgInstance as android.widget.LinearLayout).setBaselineAlignedChildIndex(value)

var _LinearLayout.dividerDrawable: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.LinearLayout).getDividerDrawable()
    set(value) = (vgInstance as android.widget.LinearLayout).setDividerDrawable(value!!)

var _LinearLayout.dividerPadding: Int
    get() = (vgInstance as android.widget.LinearLayout).getDividerPadding()
    set(value) = (vgInstance as android.widget.LinearLayout).setDividerPadding(value)

var _LinearLayout.measureWithLargestChildEnabled: Boolean
    get() = (vgInstance as android.widget.LinearLayout).isMeasureWithLargestChildEnabled()
    set(value) = (vgInstance as android.widget.LinearLayout).setMeasureWithLargestChildEnabled(value)

var _LinearLayout.orientation: Int
    get() = (vgInstance as android.widget.LinearLayout).getOrientation()
    set(value) = (vgInstance as android.widget.LinearLayout).setOrientation(value)

var _LinearLayout.showDividers: Int
    get() = (vgInstance as android.widget.LinearLayout).getShowDividers()
    set(value) = (vgInstance as android.widget.LinearLayout).setShowDividers(value)

var _LinearLayout.weightSum: Float
    get() = (vgInstance as android.widget.LinearLayout).getWeightSum()
    set(value) = (vgInstance as android.widget.LinearLayout).setWeightSum(value)

val _RelativeLayout.baseline: Int
    get() = (vgInstance as android.widget.RelativeLayout).getBaseline()

var _RelativeLayout.gravity: Int
    get() = (vgInstance as android.widget.RelativeLayout).getGravity()
    set(value) = (vgInstance as android.widget.RelativeLayout).setGravity(value)

var android.widget.AbsSeekBar.keyProgressIncrement: Int
    get() = getKeyProgressIncrement()
    set(value) = setKeyProgressIncrement(value)

var android.widget.AbsSeekBar.thumb: android.graphics.drawable.Drawable?
    get() = getThumb()
    set(value) = setThumb(value!!)

var android.widget.AbsSeekBar.thumbOffset: Int
    get() = getThumbOffset()
    set(value) = setThumbOffset(value)

var android.widget.AdapterViewFlipper.autoStart: Boolean
    get() = isAutoStart()
    set(value) = setAutoStart(value)

var android.widget.AdapterViewFlipper.flipInterval: Int
    get() = getFlipInterval()
    set(value) = setFlipInterval(value)

val android.widget.AdapterViewFlipper.flipping: Boolean
    get() = isFlipping()

val android.widget.Adapter.count: Int
    get() = getCount()

val android.widget.Adapter.empty: Boolean
    get() = isEmpty()

val android.widget.Adapter.viewTypeCount: Int
    get() = getViewTypeCount()

val android.widget.AlphabetIndexer.sections: Array<jet.Any>?
    get() = getSections()

var android.widget.AutoCompleteTextView.completionHint: jet.CharSequence?
    get() = getCompletionHint()
    set(value) = setCompletionHint(value!!)

var android.widget.AutoCompleteTextView.dropDownAnchor: Int
    get() = getDropDownAnchor()
    set(value) = setDropDownAnchor(value)

val android.widget.AutoCompleteTextView.dropDownBackground: android.graphics.drawable.Drawable?
    get() = getDropDownBackground()

var android.widget.AutoCompleteTextView.dropDownHeight: Int
    get() = getDropDownHeight()
    set(value) = setDropDownHeight(value)

var android.widget.AutoCompleteTextView.dropDownHorizontalOffset: Int
    get() = getDropDownHorizontalOffset()
    set(value) = setDropDownHorizontalOffset(value)

var android.widget.AutoCompleteTextView.dropDownVerticalOffset: Int
    get() = getDropDownVerticalOffset()
    set(value) = setDropDownVerticalOffset(value)

var android.widget.AutoCompleteTextView.dropDownWidth: Int
    get() = getDropDownWidth()
    set(value) = setDropDownWidth(value)

val android.widget.AutoCompleteTextView.itemClickListener: android.widget.AdapterView.OnItemClickListener?
    get() = getItemClickListener()

val android.widget.AutoCompleteTextView.itemSelectedListener: android.widget.AdapterView.OnItemSelectedListener?
    get() = getItemSelectedListener()

var android.widget.AutoCompleteTextView.listSelection: Int
    get() = getListSelection()
    set(value) = setListSelection(value)

var android.widget.AutoCompleteTextView.onItemClickListener: android.widget.AdapterView.OnItemClickListener?
    get() = getOnItemClickListener()
    set(value) = setOnItemClickListener(value!!)

var android.widget.AutoCompleteTextView.onItemSelectedListener: android.widget.AdapterView.OnItemSelectedListener?
    get() = getOnItemSelectedListener()
    set(value) = setOnItemSelectedListener(value!!)

val android.widget.AutoCompleteTextView.performingCompletion: Boolean
    get() = isPerformingCompletion()

val android.widget.AutoCompleteTextView.popupShowing: Boolean
    get() = isPopupShowing()

var android.widget.AutoCompleteTextView.threshold: Int
    get() = getThreshold()
    set(value) = setThreshold(value)

var android.widget.AutoCompleteTextView.validator: android.widget.AutoCompleteTextView.Validator?
    get() = getValidator()
    set(value) = setValidator(value!!)

val android.widget.BaseAdapter.empty: Boolean
    get() = isEmpty()

val android.widget.BaseAdapter.viewTypeCount: Int
    get() = getViewTypeCount()

val android.widget.BaseExpandableListAdapter.childTypeCount: Int
    get() = getChildTypeCount()

val android.widget.BaseExpandableListAdapter.empty: Boolean
    get() = isEmpty()

val android.widget.BaseExpandableListAdapter.groupTypeCount: Int
    get() = getGroupTypeCount()

var android.widget.CalendarView.date: Long
    get() = getDate()
    set(value) = setDate(value)

var android.widget.CalendarView.dateTextAppearance: Int
    get() = getDateTextAppearance()
    set(value) = setDateTextAppearance(value)

var android.widget.CalendarView.enabled: Boolean
    get() = isEnabled()
    set(value) = setEnabled(value)

var android.widget.CalendarView.firstDayOfWeek: Int
    get() = getFirstDayOfWeek()
    set(value) = setFirstDayOfWeek(value)

var android.widget.CalendarView.focusedMonthDateColor: Int
    get() = getFocusedMonthDateColor()
    set(value) = setFocusedMonthDateColor(value)

var android.widget.CalendarView.maxDate: Long
    get() = getMaxDate()
    set(value) = setMaxDate(value)

var android.widget.CalendarView.minDate: Long
    get() = getMinDate()
    set(value) = setMinDate(value)

var android.widget.CalendarView.selectedDateVerticalBar: android.graphics.drawable.Drawable?
    get() = getSelectedDateVerticalBar()
    set(value) = setSelectedDateVerticalBar(value!!)

var android.widget.CalendarView.selectedWeekBackgroundColor: Int
    get() = getSelectedWeekBackgroundColor()
    set(value) = setSelectedWeekBackgroundColor(value)

var android.widget.CalendarView.showWeekNumber: Boolean
    get() = getShowWeekNumber()
    set(value) = setShowWeekNumber(value)

var android.widget.CalendarView.shownWeekCount: Int
    get() = getShownWeekCount()
    set(value) = setShownWeekCount(value)

var android.widget.CalendarView.unfocusedMonthDateColor: Int
    get() = getUnfocusedMonthDateColor()
    set(value) = setUnfocusedMonthDateColor(value)

var android.widget.CalendarView.weekDayTextAppearance: Int
    get() = getWeekDayTextAppearance()
    set(value) = setWeekDayTextAppearance(value)

var android.widget.CalendarView.weekNumberColor: Int
    get() = getWeekNumberColor()
    set(value) = setWeekNumberColor(value)

var android.widget.CalendarView.weekSeparatorLineColor: Int
    get() = getWeekSeparatorLineColor()
    set(value) = setWeekSeparatorLineColor(value)

var android.widget.Checkable.checked: Boolean
    get() = isChecked()
    set(value) = setChecked(value)

var android.widget.CheckedTextView.checkMarkDrawable: android.graphics.drawable.Drawable?
    get() = getCheckMarkDrawable()
    set(value) = setCheckMarkDrawable(value!!)

var android.widget.CheckedTextView.checked: Boolean
    get() = isChecked()
    set(value) = setChecked(value)

var android.widget.Chronometer.base: Long
    get() = getBase()
    set(value) = setBase(value)

var android.widget.Chronometer.format: jet.String?
    get() = getFormat()
    set(value) = setFormat(value!!)

var android.widget.Chronometer.onChronometerTickListener: android.widget.Chronometer.OnChronometerTickListener?
    get() = getOnChronometerTickListener()
    set(value) = setOnChronometerTickListener(value!!)

var android.widget.CompoundButton.checked: Boolean
    get() = isChecked()
    set(value) = setChecked(value)

val android.widget.CursorAdapter.count: Int
    get() = getCount()

val android.widget.CursorAdapter.cursor: android.database.Cursor?
    get() = getCursor()

val android.widget.CursorAdapter.filter: android.widget.Filter?
    get() = getFilter()

var android.widget.CursorAdapter.filterQueryProvider: android.widget.FilterQueryProvider?
    get() = getFilterQueryProvider()
    set(value) = setFilterQueryProvider(value!!)

val android.widget.CursorTreeAdapter.cursor: android.database.Cursor?
    get() = getCursor()

val android.widget.CursorTreeAdapter.filter: android.widget.Filter?
    get() = getFilter()

var android.widget.CursorTreeAdapter.filterQueryProvider: android.widget.FilterQueryProvider?
    get() = getFilterQueryProvider()
    set(value) = setFilterQueryProvider(value!!)

val android.widget.CursorTreeAdapter.groupCount: Int
    get() = getGroupCount()

val android.widget.DatePicker.calendarView: android.widget.CalendarView?
    get() = getCalendarView()

var android.widget.DatePicker.calendarViewShown: Boolean
    get() = getCalendarViewShown()
    set(value) = setCalendarViewShown(value)

val android.widget.DatePicker.dayOfMonth: Int
    get() = getDayOfMonth()

var android.widget.DatePicker.enabled: Boolean
    get() = isEnabled()
    set(value) = setEnabled(value)

var android.widget.DatePicker.maxDate: Long
    get() = getMaxDate()
    set(value) = setMaxDate(value)

var android.widget.DatePicker.minDate: Long
    get() = getMinDate()
    set(value) = setMinDate(value)

val android.widget.DatePicker.month: Int
    get() = getMonth()

var android.widget.DatePicker.spinnersShown: Boolean
    get() = getSpinnersShown()
    set(value) = setSpinnersShown(value)

val android.widget.DatePicker.year: Int
    get() = getYear()

val android.widget.DialerFilter.digits: jet.CharSequence?
    get() = getDigits()

val android.widget.DialerFilter.filterText: jet.CharSequence?
    get() = getFilterText()

val android.widget.DialerFilter.letters: jet.CharSequence?
    get() = getLetters()

var android.widget.DialerFilter.mode: Int
    get() = getMode()
    set(value) = setMode(value)

val android.widget.DialerFilter.qwertyKeyboard: Boolean
    get() = isQwertyKeyboard()

val android.widget.EdgeEffect.finished: Boolean
    get() = isFinished()

val android.widget.ExpandableListAdapter.empty: Boolean
    get() = isEmpty()

val android.widget.ExpandableListAdapter.groupCount: Int
    get() = getGroupCount()

var android.widget.ExpandableListView.adapter: android.widget.ListAdapter?
    get() = getAdapter()
    set(value) = setAdapter(value!!)

val android.widget.ExpandableListView.expandableListAdapter: android.widget.ExpandableListAdapter?
    get() = getExpandableListAdapter()

val android.widget.ExpandableListView.selectedId: Long
    get() = getSelectedId()

val android.widget.ExpandableListView.selectedPosition: Long
    get() = getSelectedPosition()

val android.widget.Filterable.filter: android.widget.Filter?
    get() = getFilter()

var android.widget.GridView.adapter: android.widget.ListAdapter?
    get() = getAdapter()
    set(value) = setAdapter(value!!)

var android.widget.GridView.columnWidth: Int
    get() = getColumnWidth()
    set(value) = setColumnWidth(value)

var android.widget.GridView.gravity: Int
    get() = getGravity()
    set(value) = setGravity(value)

var android.widget.GridView.horizontalSpacing: Int
    get() = getHorizontalSpacing()
    set(value) = setHorizontalSpacing(value)

var android.widget.GridView.numColumns: Int
    get() = getNumColumns()
    set(value) = setNumColumns(value)

val android.widget.GridView.requestedColumnWidth: Int
    get() = getRequestedColumnWidth()

val android.widget.GridView.requestedHorizontalSpacing: Int
    get() = getRequestedHorizontalSpacing()

var android.widget.GridView.stretchMode: Int
    get() = getStretchMode()
    set(value) = setStretchMode(value)

var android.widget.GridView.verticalSpacing: Int
    get() = getVerticalSpacing()
    set(value) = setVerticalSpacing(value)

val android.widget.HeaderViewListAdapter.count: Int
    get() = getCount()

val android.widget.HeaderViewListAdapter.empty: Boolean
    get() = isEmpty()

val android.widget.HeaderViewListAdapter.filter: android.widget.Filter?
    get() = getFilter()

val android.widget.HeaderViewListAdapter.footersCount: Int
    get() = getFootersCount()

val android.widget.HeaderViewListAdapter.headersCount: Int
    get() = getHeadersCount()

val android.widget.HeaderViewListAdapter.viewTypeCount: Int
    get() = getViewTypeCount()

val android.widget.HeaderViewListAdapter.wrappedAdapter: android.widget.ListAdapter?
    get() = getWrappedAdapter()

val android.widget.HeterogeneousExpandableList.childTypeCount: Int
    get() = getChildTypeCount()

val android.widget.HeterogeneousExpandableList.groupTypeCount: Int
    get() = getGroupTypeCount()

var android.widget.HorizontalScrollView.fillViewport: Boolean
    get() = isFillViewport()
    set(value) = setFillViewport(value)

val android.widget.HorizontalScrollView.maxScrollAmount: Int
    get() = getMaxScrollAmount()

var android.widget.HorizontalScrollView.smoothScrollingEnabled: Boolean
    get() = isSmoothScrollingEnabled()
    set(value) = setSmoothScrollingEnabled(value)

var android.widget.ImageView.adjustViewBounds: Boolean
    get() = getAdjustViewBounds()
    set(value) = setAdjustViewBounds(value)

var android.widget.ImageView.baseline: Int
    get() = getBaseline()
    set(value) = setBaseline(value)

var android.widget.ImageView.baselineAlignBottom: Boolean
    get() = getBaselineAlignBottom()
    set(value) = setBaselineAlignBottom(value)

var android.widget.ImageView.colorFilter: android.graphics.ColorFilter?
    get() = getColorFilter()
    set(value) = setColorFilter(value!!)

var android.widget.ImageView.cropToPadding: Boolean
    get() = getCropToPadding()
    set(value) = setCropToPadding(value)

val android.widget.ImageView.drawable: android.graphics.drawable.Drawable?
    get() = getDrawable()

var android.widget.ImageView.imageAlpha: Int
    get() = getImageAlpha()
    set(value) = setImageAlpha(value)

var android.widget.ImageView.imageMatrix: android.graphics.Matrix?
    get() = getImageMatrix()
    set(value) = setImageMatrix(value!!)

var android.widget.ImageView.maxHeight: Int
    get() = getMaxHeight()
    set(value) = setMaxHeight(value)

var android.widget.ImageView.maxWidth: Int
    get() = getMaxWidth()
    set(value) = setMaxWidth(value)

var android.widget.ImageView.scaleType: android.widget.ImageView.ScaleType?
    get() = getScaleType()
    set(value) = setScaleType(value!!)

var android.widget.ListPopupWindow.anchorView: android.view.View?
    get() = getAnchorView()
    set(value) = setAnchorView(value!!)

var android.widget.ListPopupWindow.animationStyle: Int
    get() = getAnimationStyle()
    set(value) = setAnimationStyle(value)

val android.widget.ListPopupWindow.background: android.graphics.drawable.Drawable?
    get() = getBackground()

var android.widget.ListPopupWindow.height: Int
    get() = getHeight()
    set(value) = setHeight(value)

var android.widget.ListPopupWindow.horizontalOffset: Int
    get() = getHorizontalOffset()
    set(value) = setHorizontalOffset(value)

var android.widget.ListPopupWindow.inputMethodMode: Int
    get() = getInputMethodMode()
    set(value) = setInputMethodMode(value)

val android.widget.ListPopupWindow.inputMethodNotNeeded: Boolean
    get() = isInputMethodNotNeeded()

val android.widget.ListPopupWindow.listView: android.widget.ListView?
    get() = getListView()

var android.widget.ListPopupWindow.modal: Boolean
    get() = isModal()
    set(value) = setModal(value)

var android.widget.ListPopupWindow.promptPosition: Int
    get() = getPromptPosition()
    set(value) = setPromptPosition(value)

val android.widget.ListPopupWindow.selectedItem: jet.Any?
    get() = getSelectedItem()

val android.widget.ListPopupWindow.selectedItemId: Long
    get() = getSelectedItemId()

val android.widget.ListPopupWindow.selectedItemPosition: Int
    get() = getSelectedItemPosition()

val android.widget.ListPopupWindow.selectedView: android.view.View?
    get() = getSelectedView()

val android.widget.ListPopupWindow.showing: Boolean
    get() = isShowing()

var android.widget.ListPopupWindow.softInputMode: Int
    get() = getSoftInputMode()
    set(value) = setSoftInputMode(value)

var android.widget.ListPopupWindow.verticalOffset: Int
    get() = getVerticalOffset()
    set(value) = setVerticalOffset(value)

var android.widget.ListPopupWindow.width: Int
    get() = getWidth()
    set(value) = setWidth(value)

var android.widget.ListView.adapter: android.widget.ListAdapter?
    get() = getAdapter()
    set(value) = setAdapter(value!!)

val android.widget.ListView.checkItemIds: LongArray?
    get() = getCheckItemIds()

var android.widget.ListView.divider: android.graphics.drawable.Drawable?
    get() = getDivider()
    set(value) = setDivider(value!!)

var android.widget.ListView.dividerHeight: Int
    get() = getDividerHeight()
    set(value) = setDividerHeight(value)

val android.widget.ListView.footerViewsCount: Int
    get() = getFooterViewsCount()

val android.widget.ListView.headerViewsCount: Int
    get() = getHeaderViewsCount()

var android.widget.ListView.itemsCanFocus: Boolean
    get() = getItemsCanFocus()
    set(value) = setItemsCanFocus(value)

val android.widget.ListView.maxScrollAmount: Int
    get() = getMaxScrollAmount()

val android.widget.ListView.opaque: Boolean
    get() = isOpaque()

var android.widget.ListView.overscrollFooter: android.graphics.drawable.Drawable?
    get() = getOverscrollFooter()
    set(value) = setOverscrollFooter(value!!)

var android.widget.ListView.overscrollHeader: android.graphics.drawable.Drawable?
    get() = getOverscrollHeader()
    set(value) = setOverscrollHeader(value!!)

val android.widget.MediaController.MediaPlayerControl.bufferPercentage: Int
    get() = getBufferPercentage()

val android.widget.MediaController.MediaPlayerControl.currentPosition: Int
    get() = getCurrentPosition()

val android.widget.MediaController.MediaPlayerControl.duration: Int
    get() = getDuration()

val android.widget.MediaController.MediaPlayerControl.playing: Boolean
    get() = isPlaying()

val android.widget.MediaController.showing: Boolean
    get() = isShowing()

val android.widget.NumberPicker.accessibilityNodeProvider: android.view.accessibility.AccessibilityNodeProvider?
    get() = getAccessibilityNodeProvider()

var android.widget.NumberPicker.displayedValues: Array<jet.String>?
    get() = getDisplayedValues()
    set(value) = setDisplayedValues(value!!)

var android.widget.NumberPicker.maxValue: Int
    get() = getMaxValue()
    set(value) = setMaxValue(value)

var android.widget.NumberPicker.minValue: Int
    get() = getMinValue()
    set(value) = setMinValue(value)

val android.widget.NumberPicker.solidColor: Int
    get() = getSolidColor()

var android.widget.NumberPicker.value: Int
    get() = getValue()
    set(value) = setValue(value)

var android.widget.NumberPicker.wrapSelectorWheel: Boolean
    get() = getWrapSelectorWheel()
    set(value) = setWrapSelectorWheel(value)

val android.widget.OverScroller.currVelocity: Float
    get() = getCurrVelocity()

val android.widget.OverScroller.currX: Int
    get() = getCurrX()

val android.widget.OverScroller.currY: Int
    get() = getCurrY()

val android.widget.OverScroller.finalX: Int
    get() = getFinalX()

val android.widget.OverScroller.finalY: Int
    get() = getFinalY()

val android.widget.OverScroller.finished: Boolean
    get() = isFinished()

val android.widget.OverScroller.overScrolled: Boolean
    get() = isOverScrolled()

val android.widget.OverScroller.startX: Int
    get() = getStartX()

val android.widget.OverScroller.startY: Int
    get() = getStartY()

val android.widget.PopupMenu.menu: android.view.Menu?
    get() = getMenu()

val android.widget.PopupMenu.menuInflater: android.view.MenuInflater?
    get() = getMenuInflater()

val android.widget.PopupWindow.aboveAnchor: Boolean
    get() = isAboveAnchor()

var android.widget.PopupWindow.animationStyle: Int
    get() = getAnimationStyle()
    set(value) = setAnimationStyle(value)

val android.widget.PopupWindow.background: android.graphics.drawable.Drawable?
    get() = getBackground()

var android.widget.PopupWindow.clippingEnabled: Boolean
    get() = isClippingEnabled()
    set(value) = setClippingEnabled(value)

var android.widget.PopupWindow.contentView: android.view.View?
    get() = getContentView()
    set(value) = setContentView(value!!)

var android.widget.PopupWindow.focusable: Boolean
    get() = isFocusable()
    set(value) = setFocusable(value)

var android.widget.PopupWindow.height: Int
    get() = getHeight()
    set(value) = setHeight(value)

var android.widget.PopupWindow.inputMethodMode: Int
    get() = getInputMethodMode()
    set(value) = setInputMethodMode(value)

var android.widget.PopupWindow.outsideTouchable: Boolean
    get() = isOutsideTouchable()
    set(value) = setOutsideTouchable(value)

val android.widget.PopupWindow.showing: Boolean
    get() = isShowing()

var android.widget.PopupWindow.softInputMode: Int
    get() = getSoftInputMode()
    set(value) = setSoftInputMode(value)

var android.widget.PopupWindow.splitTouchEnabled: Boolean
    get() = isSplitTouchEnabled()
    set(value) = setSplitTouchEnabled(value)

var android.widget.PopupWindow.touchable: Boolean
    get() = isTouchable()
    set(value) = setTouchable(value)

var android.widget.PopupWindow.width: Int
    get() = getWidth()
    set(value) = setWidth(value)

var android.widget.ProgressBar.indeterminate: Boolean
    get() = isIndeterminate()
    set(value) = setIndeterminate(value)

var android.widget.ProgressBar.indeterminateDrawable: android.graphics.drawable.Drawable?
    get() = getIndeterminateDrawable()
    set(value) = setIndeterminateDrawable(value!!)

var android.widget.ProgressBar.interpolator: android.view.animation.Interpolator?
    get() = getInterpolator()
    set(value) = setInterpolator(value!!)

var android.widget.ProgressBar.max: Int
    get() = getMax()
    set(value) = setMax(value)

var android.widget.ProgressBar.progress: Int
    get() = getProgress()
    set(value) = setProgress(value)

var android.widget.ProgressBar.progressDrawable: android.graphics.drawable.Drawable?
    get() = getProgressDrawable()
    set(value) = setProgressDrawable(value!!)

var android.widget.ProgressBar.secondaryProgress: Int
    get() = getSecondaryProgress()
    set(value) = setSecondaryProgress(value)

val android.widget.RadioGroup.checkedRadioButtonId: Int
    get() = getCheckedRadioButtonId()

val android.widget.RatingBar.indicator: Boolean
    get() = isIndicator()

var android.widget.RatingBar.numStars: Int
    get() = getNumStars()
    set(value) = setNumStars(value)

var android.widget.RatingBar.onRatingBarChangeListener: android.widget.RatingBar.OnRatingBarChangeListener?
    get() = getOnRatingBarChangeListener()
    set(value) = setOnRatingBarChangeListener(value!!)

var android.widget.RatingBar.rating: Float
    get() = getRating()
    set(value) = setRating(value)

var android.widget.RatingBar.stepSize: Float
    get() = getStepSize()
    set(value) = setStepSize(value)

val android.widget.RelativeLayout.LayoutParams.rules: IntArray?
    get() = getRules()

val android.widget.RemoteViewsService.RemoteViewsFactory.count: Int
    get() = getCount()

val android.widget.RemoteViewsService.RemoteViewsFactory.loadingView: android.widget.RemoteViews?
    get() = getLoadingView()

val android.widget.RemoteViewsService.RemoteViewsFactory.viewTypeCount: Int
    get() = getViewTypeCount()

val android.widget.RemoteViews.layoutId: Int
    get() = getLayoutId()

var android.widget.ScrollView.fillViewport: Boolean
    get() = isFillViewport()
    set(value) = setFillViewport(value)

val android.widget.ScrollView.maxScrollAmount: Int
    get() = getMaxScrollAmount()

var android.widget.ScrollView.smoothScrollingEnabled: Boolean
    get() = isSmoothScrollingEnabled()
    set(value) = setSmoothScrollingEnabled(value)

val android.widget.Scroller.currVelocity: Float
    get() = getCurrVelocity()

val android.widget.Scroller.currX: Int
    get() = getCurrX()

val android.widget.Scroller.currY: Int
    get() = getCurrY()

val android.widget.Scroller.duration: Int
    get() = getDuration()

var android.widget.Scroller.finalX: Int
    get() = getFinalX()
    set(value) = setFinalX(value)

var android.widget.Scroller.finalY: Int
    get() = getFinalY()
    set(value) = setFinalY(value)

val android.widget.Scroller.finished: Boolean
    get() = isFinished()

val android.widget.Scroller.startX: Int
    get() = getStartX()

val android.widget.Scroller.startY: Int
    get() = getStartY()

val android.widget.SearchView.iconfiedByDefault: Boolean
    get() = isIconfiedByDefault()

var android.widget.SearchView.iconified: Boolean
    get() = isIconified()
    set(value) = setIconified(value)

var android.widget.SearchView.imeOptions: Int
    get() = getImeOptions()
    set(value) = setImeOptions(value)

var android.widget.SearchView.inputType: Int
    get() = getInputType()
    set(value) = setInputType(value)

var android.widget.SearchView.maxWidth: Int
    get() = getMaxWidth()
    set(value) = setMaxWidth(value)

val android.widget.SearchView.query: jet.CharSequence?
    get() = getQuery()

var android.widget.SearchView.queryHint: jet.CharSequence?
    get() = getQueryHint()
    set(value) = setQueryHint(value!!)

var android.widget.SearchView.queryRefinementEnabled: Boolean
    get() = isQueryRefinementEnabled()
    set(value) = setQueryRefinementEnabled(value)

var android.widget.SearchView.submitButtonEnabled: Boolean
    get() = isSubmitButtonEnabled()
    set(value) = setSubmitButtonEnabled(value)

var android.widget.SearchView.suggestionsAdapter: android.widget.CursorAdapter?
    get() = getSuggestionsAdapter()
    set(value) = setSuggestionsAdapter(value!!)

val android.widget.SectionIndexer.sections: Array<jet.Any>?
    get() = getSections()

val android.widget.SimpleAdapter.count: Int
    get() = getCount()

val android.widget.SimpleAdapter.filter: android.widget.Filter?
    get() = getFilter()

var android.widget.SimpleAdapter.viewBinder: android.widget.SimpleAdapter.ViewBinder?
    get() = getViewBinder()
    set(value) = setViewBinder(value!!)

var android.widget.SimpleCursorAdapter.cursorToStringConverter: android.widget.SimpleCursorAdapter.CursorToStringConverter?
    get() = getCursorToStringConverter()
    set(value) = setCursorToStringConverter(value!!)

var android.widget.SimpleCursorAdapter.stringConversionColumn: Int
    get() = getStringConversionColumn()
    set(value) = setStringConversionColumn(value)

var android.widget.SimpleCursorAdapter.viewBinder: android.widget.SimpleCursorAdapter.ViewBinder?
    get() = getViewBinder()
    set(value) = setViewBinder(value!!)

var android.widget.SimpleCursorTreeAdapter.viewBinder: android.widget.SimpleCursorTreeAdapter.ViewBinder?
    get() = getViewBinder()
    set(value) = setViewBinder(value!!)

val android.widget.SimpleExpandableListAdapter.groupCount: Int
    get() = getGroupCount()

val android.widget.Spinner.baseline: Int
    get() = getBaseline()

var android.widget.Spinner.dropDownHorizontalOffset: Int
    get() = getDropDownHorizontalOffset()
    set(value) = setDropDownHorizontalOffset(value)

var android.widget.Spinner.dropDownVerticalOffset: Int
    get() = getDropDownVerticalOffset()
    set(value) = setDropDownVerticalOffset(value)

var android.widget.Spinner.dropDownWidth: Int
    get() = getDropDownWidth()
    set(value) = setDropDownWidth(value)

var android.widget.Spinner.gravity: Int
    get() = getGravity()
    set(value) = setGravity(value)

val android.widget.Spinner.popupBackground: android.graphics.drawable.Drawable?
    get() = getPopupBackground()

var android.widget.Spinner.prompt: jet.CharSequence?
    get() = getPrompt()
    set(value) = setPrompt(value!!)

val android.widget.Switch.compoundPaddingRight: Int
    get() = getCompoundPaddingRight()

var android.widget.Switch.switchMinWidth: Int
    get() = getSwitchMinWidth()
    set(value) = setSwitchMinWidth(value)

var android.widget.Switch.switchPadding: Int
    get() = getSwitchPadding()
    set(value) = setSwitchPadding(value)

var android.widget.Switch.textOff: jet.CharSequence?
    get() = getTextOff()
    set(value) = setTextOff(value!!)

var android.widget.Switch.textOn: jet.CharSequence?
    get() = getTextOn()
    set(value) = setTextOn(value!!)

var android.widget.Switch.thumbDrawable: android.graphics.drawable.Drawable?
    get() = getThumbDrawable()
    set(value) = setThumbDrawable(value!!)

var android.widget.Switch.thumbTextPadding: Int
    get() = getThumbTextPadding()
    set(value) = setThumbTextPadding(value)

var android.widget.Switch.trackDrawable: android.graphics.drawable.Drawable?
    get() = getTrackDrawable()
    set(value) = setTrackDrawable(value!!)

val android.widget.TabHost.TabSpec.tag: jet.String?
    get() = getTag()

var android.widget.TabHost.currentTab: Int
    get() = getCurrentTab()
    set(value) = setCurrentTab(value)

val android.widget.TabHost.currentTabTag: jet.String?
    get() = getCurrentTabTag()

val android.widget.TabHost.currentTabView: android.view.View?
    get() = getCurrentTabView()

val android.widget.TabHost.currentView: android.view.View?
    get() = getCurrentView()

val android.widget.TabHost.tabContentView: android.widget.FrameLayout?
    get() = getTabContentView()

val android.widget.TabHost.tabWidget: android.widget.TabWidget?
    get() = getTabWidget()

var android.widget.TabWidget.stripEnabled: Boolean
    get() = isStripEnabled()
    set(value) = setStripEnabled(value)

val android.widget.TabWidget.tabCount: Int
    get() = getTabCount()

var android.widget.TableLayout.shrinkAllColumns: Boolean
    get() = isShrinkAllColumns()
    set(value) = setShrinkAllColumns(value)

var android.widget.TableLayout.stretchAllColumns: Boolean
    get() = isStretchAllColumns()
    set(value) = setStretchAllColumns(value)

val android.widget.TableRow.virtualChildCount: Int
    get() = getVirtualChildCount()

var android.widget.TextView.autoLinkMask: Int
    get() = getAutoLinkMask()
    set(value) = setAutoLinkMask(value)

val android.widget.TextView.baseline: Int
    get() = getBaseline()

var android.widget.TextView.compoundDrawablePadding: Int
    get() = getCompoundDrawablePadding()
    set(value) = setCompoundDrawablePadding(value)

val android.widget.TextView.compoundDrawables: Array<android.graphics.drawable.Drawable>?
    get() = getCompoundDrawables()

val android.widget.TextView.compoundPaddingBottom: Int
    get() = getCompoundPaddingBottom()

val android.widget.TextView.compoundPaddingLeft: Int
    get() = getCompoundPaddingLeft()

val android.widget.TextView.compoundPaddingRight: Int
    get() = getCompoundPaddingRight()

val android.widget.TextView.compoundPaddingTop: Int
    get() = getCompoundPaddingTop()

val android.widget.TextView.currentHintTextColor: Int
    get() = getCurrentHintTextColor()

val android.widget.TextView.currentTextColor: Int
    get() = getCurrentTextColor()

var android.widget.TextView.cursorVisible: Boolean
    get() = isCursorVisible()
    set(value) = setCursorVisible(value)

var android.widget.TextView.customSelectionActionModeCallback: android.view.ActionMode.Callback?
    get() = getCustomSelectionActionModeCallback()
    set(value) = setCustomSelectionActionModeCallback(value!!)

val android.widget.TextView.editableText: android.text.Editable?
    get() = getEditableText()

var android.widget.TextView.ellipsize: android.text.TextUtils.TruncateAt?
    get() = getEllipsize()
    set(value) = setEllipsize(value!!)

var android.widget.TextView.error: jet.CharSequence?
    get() = getError()
    set(value) = setError(value!!)

val android.widget.TextView.extendedPaddingBottom: Int
    get() = getExtendedPaddingBottom()

val android.widget.TextView.extendedPaddingTop: Int
    get() = getExtendedPaddingTop()

var android.widget.TextView.filters: Array<android.text.InputFilter>?
    get() = getFilters()
    set(value) = setFilters(value!!)

var android.widget.TextView.freezesText: Boolean
    get() = getFreezesText()
    set(value) = setFreezesText(value)

var android.widget.TextView.gravity: Int
    get() = getGravity()
    set(value) = setGravity(value)

var android.widget.TextView.highlightColor: Int
    get() = getHighlightColor()
    set(value) = setHighlightColor(value)

var android.widget.TextView.hint: jet.CharSequence?
    get() = getHint()
    set(value) = setHint(value!!)

val android.widget.TextView.hintTextColors: android.content.res.ColorStateList?
    get() = getHintTextColors()

val android.widget.TextView.imeActionId: Int
    get() = getImeActionId()

val android.widget.TextView.imeActionLabel: jet.CharSequence?
    get() = getImeActionLabel()

var android.widget.TextView.imeOptions: Int
    get() = getImeOptions()
    set(value) = setImeOptions(value)

var android.widget.TextView.includeFontPadding: Boolean
    get() = getIncludeFontPadding()
    set(value) = setIncludeFontPadding(value)

val android.widget.TextView.inputMethodTarget: Boolean
    get() = isInputMethodTarget()

var android.widget.TextView.inputType: Int
    get() = getInputType()
    set(value) = setInputType(value)

var android.widget.TextView.keyListener: android.text.method.KeyListener?
    get() = getKeyListener()
    set(value) = setKeyListener(value!!)

val android.widget.TextView.layout: android.text.Layout?
    get() = getLayout()

val android.widget.TextView.lineCount: Int
    get() = getLineCount()

val android.widget.TextView.lineHeight: Int
    get() = getLineHeight()

val android.widget.TextView.lineSpacingExtra: Float
    get() = getLineSpacingExtra()

val android.widget.TextView.lineSpacingMultiplier: Float
    get() = getLineSpacingMultiplier()

val android.widget.TextView.linkTextColors: android.content.res.ColorStateList?
    get() = getLinkTextColors()

var android.widget.TextView.linksClickable: Boolean
    get() = getLinksClickable()
    set(value) = setLinksClickable(value)

var android.widget.TextView.marqueeRepeatLimit: Int
    get() = getMarqueeRepeatLimit()
    set(value) = setMarqueeRepeatLimit(value)

var android.widget.TextView.maxEms: Int
    get() = getMaxEms()
    set(value) = setMaxEms(value)

var android.widget.TextView.maxHeight: Int
    get() = getMaxHeight()
    set(value) = setMaxHeight(value)

var android.widget.TextView.maxLines: Int
    get() = getMaxLines()
    set(value) = setMaxLines(value)

var android.widget.TextView.maxWidth: Int
    get() = getMaxWidth()
    set(value) = setMaxWidth(value)

var android.widget.TextView.minEms: Int
    get() = getMinEms()
    set(value) = setMinEms(value)

var android.widget.TextView.minHeight: Int
    get() = getMinHeight()
    set(value) = setMinHeight(value)

var android.widget.TextView.minLines: Int
    get() = getMinLines()
    set(value) = setMinLines(value)

var android.widget.TextView.minWidth: Int
    get() = getMinWidth()
    set(value) = setMinWidth(value)

var android.widget.TextView.movementMethod: android.text.method.MovementMethod?
    get() = getMovementMethod()
    set(value) = setMovementMethod(value!!)

val android.widget.TextView.paint: android.text.TextPaint?
    get() = getPaint()

var android.widget.TextView.paintFlags: Int
    get() = getPaintFlags()
    set(value) = setPaintFlags(value)

var android.widget.TextView.privateImeOptions: jet.String?
    get() = getPrivateImeOptions()
    set(value) = setPrivateImeOptions(value!!)

val android.widget.TextView.selectionEnd: Int
    get() = getSelectionEnd()

val android.widget.TextView.selectionStart: Int
    get() = getSelectionStart()

val android.widget.TextView.shadowColor: Int
    get() = getShadowColor()

val android.widget.TextView.shadowDx: Float
    get() = getShadowDx()

val android.widget.TextView.shadowDy: Float
    get() = getShadowDy()

val android.widget.TextView.shadowRadius: Float
    get() = getShadowRadius()

val android.widget.TextView.suggestionsEnabled: Boolean
    get() = isSuggestionsEnabled()

var android.widget.TextView.text: jet.CharSequence?
    get() = getText()
    set(value) = setText(value!!)

val android.widget.TextView.textColors: android.content.res.ColorStateList?
    get() = getTextColors()

var android.widget.TextView.textScaleX: Float
    get() = getTextScaleX()
    set(value) = setTextScaleX(value)

val android.widget.TextView.textSelectable: Boolean
    get() = isTextSelectable()

var android.widget.TextView.textSize: Float
    get() = getTextSize()
    set(value) = setTextSize(value)

val android.widget.TextView.totalPaddingBottom: Int
    get() = getTotalPaddingBottom()

val android.widget.TextView.totalPaddingLeft: Int
    get() = getTotalPaddingLeft()

val android.widget.TextView.totalPaddingRight: Int
    get() = getTotalPaddingRight()

val android.widget.TextView.totalPaddingTop: Int
    get() = getTotalPaddingTop()

var android.widget.TextView.transformationMethod: android.text.method.TransformationMethod?
    get() = getTransformationMethod()
    set(value) = setTransformationMethod(value!!)

var android.widget.TextView.typeface: android.graphics.Typeface?
    get() = getTypeface()
    set(value) = setTypeface(value!!)

val android.widget.TextView.urls: Array<android.text.style.URLSpan>?
    get() = getUrls()

val android.widget.TimePicker.baseline: Int
    get() = getBaseline()

var android.widget.TimePicker.currentHour: jet.Int?
    get() = getCurrentHour()
    set(value) = setCurrentHour(value!!)

var android.widget.TimePicker.currentMinute: jet.Int?
    get() = getCurrentMinute()
    set(value) = setCurrentMinute(value!!)

var android.widget.TimePicker.enabled: Boolean
    get() = isEnabled()
    set(value) = setEnabled(value)

var android.widget.Toast.duration: Int
    get() = getDuration()
    set(value) = setDuration(value)

val android.widget.Toast.gravity: Int
    get() = getGravity()

val android.widget.Toast.horizontalMargin: Float
    get() = getHorizontalMargin()

val android.widget.Toast.verticalMargin: Float
    get() = getVerticalMargin()

var android.widget.Toast.view: android.view.View?
    get() = getView()
    set(value) = setView(value!!)

val android.widget.Toast.xOffset: Int
    get() = getXOffset()

val android.widget.Toast.yOffset: Int
    get() = getYOffset()

var android.widget.ToggleButton.textOff: jet.CharSequence?
    get() = getTextOff()
    set(value) = setTextOff(value!!)

var android.widget.ToggleButton.textOn: jet.CharSequence?
    get() = getTextOn()
    set(value) = setTextOn(value!!)

val android.widget.TwoLineListItem.text1: android.widget.TextView?
    get() = getText1()

val android.widget.TwoLineListItem.text2: android.widget.TextView?
    get() = getText2()

val android.widget.VideoView.bufferPercentage: Int
    get() = getBufferPercentage()

val android.widget.VideoView.currentPosition: Int
    get() = getCurrentPosition()

val android.widget.VideoView.duration: Int
    get() = getDuration()

val android.widget.VideoView.playing: Boolean
    get() = isPlaying()

val android.widget.ViewAnimator.baseline: Int
    get() = getBaseline()

val android.widget.ViewAnimator.currentView: android.view.View?
    get() = getCurrentView()

var android.widget.ViewAnimator.displayedChild: Int
    get() = getDisplayedChild()
    set(value) = setDisplayedChild(value)

var android.widget.ViewAnimator.inAnimation: android.view.animation.Animation?
    get() = getInAnimation()
    set(value) = setInAnimation(value!!)

var android.widget.ViewAnimator.outAnimation: android.view.animation.Animation?
    get() = getOutAnimation()
    set(value) = setOutAnimation(value!!)

var android.widget.ViewFlipper.autoStart: Boolean
    get() = isAutoStart()
    set(value) = setAutoStart(value)

val android.widget.ViewFlipper.flipping: Boolean
    get() = isFlipping()

val android.widget.ViewSwitcher.nextView: android.view.View?
    get() = getNextView()

val android.widget.WrapperListAdapter.wrappedAdapter: android.widget.ListAdapter?
    get() = getWrappedAdapter()

var android.widget.ZoomButtonsController.autoDismissed: Boolean
    get() = isAutoDismissed()
    set(value) = setAutoDismissed(value)

val android.widget.ZoomButtonsController.container: android.view.ViewGroup?
    get() = getContainer()

var android.widget.ZoomButtonsController.visible: Boolean
    get() = isVisible()
    set(value) = setVisible(value)

val android.widget.ZoomButtonsController.zoomControls: android.view.View?
    get() = getZoomControls()

