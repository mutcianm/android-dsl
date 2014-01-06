open class _Container(open val vgInstance: android.view.ViewGroup,
                 open val ctx: android.app.Activity) {

    var _style: ((X: Any) -> Unit) = {}

    fun style(init: (X: Any) -> Unit) {
        this._style = init
    }

    fun alertDialog(title: String, func: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.func()
        return builder.create()!!.show()
    }

    fun videoView( init: android.widget.VideoView.() -> Unit): android.widget.VideoView {
        val v = android.widget.VideoView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun analogClock( init: android.widget.AnalogClock.() -> Unit): android.widget.AnalogClock {
        val v = android.widget.AnalogClock(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun textView( init: android.widget.TextView.() -> Unit): android.widget.TextView {
        val v = android.widget.TextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageView( init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
        val v = android.widget.ImageView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun progressBar( init: android.widget.ProgressBar.() -> Unit): android.widget.ProgressBar {
        val v = android.widget.ProgressBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun space( init: android.widget.Space.() -> Unit): android.widget.Space {
        val v = android.widget.Space(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    //container function
    fun relativeLayout( init: _RelativeLayout.() -> Unit): _RelativeLayout {
        val v = _RelativeLayout(android.widget.RelativeLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun absoluteLayout( init: _AbsoluteLayout.() -> Unit): _AbsoluteLayout {
        val v = _AbsoluteLayout(android.widget.AbsoluteLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun frameLayout( init: _FrameLayout.() -> Unit): _FrameLayout {
        val v = _FrameLayout(android.widget.FrameLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun linearLayout( init: _LinearLayout.() -> Unit): _LinearLayout {
        val v = _LinearLayout(android.widget.LinearLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gridLayout( init: _GridLayout.() -> Unit): _GridLayout {
        val v = _GridLayout(android.widget.GridLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    fun digitalClock( init: android.widget.DigitalClock.() -> Unit): android.widget.DigitalClock {
        val v = android.widget.DigitalClock(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkedTextView( init: android.widget.CheckedTextView.() -> Unit): android.widget.CheckedTextView {
        val v = android.widget.CheckedTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun chronometer( init: android.widget.Chronometer.() -> Unit): android.widget.Chronometer {
        val v = android.widget.Chronometer(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun button( init: android.widget.Button.() -> Unit): android.widget.Button {
        val v = android.widget.Button(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun button(text: jet.CharSequence?,  init: android.widget.Button.() -> Unit): android.widget.Button {
        val v = android.widget.Button(ctx)
        v.text = text
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun editText( init: android.widget.EditText.() -> Unit): android.widget.EditText {
        val v = android.widget.EditText(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageButton( init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
        val v = android.widget.ImageButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun quickContactBadge( init: android.widget.QuickContactBadge.() -> Unit): android.widget.QuickContactBadge {
        val v = android.widget.QuickContactBadge(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun twoLineListItem( init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
        val v = android.widget.TwoLineListItem(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun dialerFilter( init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
        val v = android.widget.DialerFilter(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun calendarView( init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
        val v = android.widget.CalendarView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun horizontalScrollView( init: android.widget.HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
        val v = android.widget.HorizontalScrollView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun scrollView( init: android.widget.ScrollView.() -> Unit): android.widget.ScrollView {
        val v = android.widget.ScrollView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun datePicker( init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
        val v = android.widget.DatePicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun timePicker( init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
        val v = android.widget.TimePicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tabHost( init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
        val v = android.widget.TabHost(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewAnimator( init: android.widget.ViewAnimator.() -> Unit): android.widget.ViewAnimator {
        val v = android.widget.ViewAnimator(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun mediaController( init: android.widget.MediaController.() -> Unit): android.widget.MediaController {
        val v = android.widget.MediaController(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tableLayout( init: android.widget.TableLayout.() -> Unit): android.widget.TableLayout {
        val v = android.widget.TableLayout(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tableRow( init: android.widget.TableRow.() -> Unit): android.widget.TableRow {
        val v = android.widget.TableRow(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun numberPicker( init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
        val v = android.widget.NumberPicker(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun tabWidget( init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
        val v = android.widget.TabWidget(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun radioGroup( init: android.widget.RadioGroup.() -> Unit): android.widget.RadioGroup {
        val v = android.widget.RadioGroup(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun zoomControls( init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
        val v = android.widget.ZoomControls(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun searchView( init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
        val v = android.widget.SearchView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun autoCompleteTextView( init: android.widget.AutoCompleteTextView.() -> Unit): android.widget.AutoCompleteTextView {
        val v = android.widget.AutoCompleteTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun zoomButton( init: android.widget.ZoomButton.() -> Unit): android.widget.ZoomButton {
        val v = android.widget.ZoomButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun seekBar( init: android.widget.SeekBar.() -> Unit): android.widget.SeekBar {
        val v = android.widget.SeekBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun ratingBar( init: android.widget.RatingBar.() -> Unit): android.widget.RatingBar {
        val v = android.widget.RatingBar(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewSwitcher( init: android.widget.ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
        val v = android.widget.ViewSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewFlipper( init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
        val v = android.widget.ViewFlipper(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun listView( init: android.widget.ListView.() -> Unit): android.widget.ListView {
        val v = android.widget.ListView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun gridView( init: android.widget.GridView.() -> Unit): android.widget.GridView {
        val v = android.widget.GridView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun spinner( init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
        val v = android.widget.Spinner(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun gallery( init: android.widget.Gallery.() -> Unit): android.widget.Gallery {
        val v = android.widget.Gallery(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun stackView( init: android.widget.StackView.() -> Unit): android.widget.StackView {
        val v = android.widget.StackView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox( init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox(text: jet.CharSequence?,  init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.text = text
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun checkBox(text: jet.CharSequence?, checked: Boolean,  init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
        val v = android.widget.CheckBox(ctx)
        v.text = text
        v.checked = checked
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun radioButton( init: android.widget.RadioButton.() -> Unit): android.widget.RadioButton {
        val v = android.widget.RadioButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun toggleButton( init: android.widget.ToggleButton.() -> Unit): android.widget.ToggleButton {
        val v = android.widget.ToggleButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun switch( init: android.widget.Switch.() -> Unit): android.widget.Switch {
        val v = android.widget.Switch(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun multiAutoCompleteTextView( init: android.widget.MultiAutoCompleteTextView.() -> Unit): android.widget.MultiAutoCompleteTextView {
        val v = android.widget.MultiAutoCompleteTextView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun textSwitcher( init: android.widget.TextSwitcher.() -> Unit): android.widget.TextSwitcher {
        val v = android.widget.TextSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun imageSwitcher( init: android.widget.ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
        val v = android.widget.ImageSwitcher(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun expandableListView( init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
        val v = android.widget.ExpandableListView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

}

