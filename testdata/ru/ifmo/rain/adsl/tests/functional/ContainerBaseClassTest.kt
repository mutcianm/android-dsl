open class _Container<out T: android.view.ViewGroup>(open val vgInstance: T,
                 open val ctx: android.app.Activity) {

    var _style: ((X: Any) -> Unit) = {}

    fun style(init: (X: Any) -> Unit) {
        this._style = init
    }

    fun alertDialog(title: String, func: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.func()
        return builder.create().show()
    }

    fun mediaRouteButton( init: android.app.MediaRouteButton.() -> Unit): android.app.MediaRouteButton {
        val v = android.app.MediaRouteButton(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun viewStub( init: android.view.ViewStub.() -> Unit): android.view.ViewStub {
        val v = android.view.ViewStub(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun surfaceView( init: android.view.SurfaceView.() -> Unit): android.view.SurfaceView {
        val v = android.view.SurfaceView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun textureView( init: android.view.TextureView.() -> Unit): android.view.TextureView {
        val v = android.view.TextureView(ctx)
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
    fun fragmentBreadCrumbs( init: _FragmentBreadCrumbs<android.app.FragmentBreadCrumbs>.() -> Unit): _FragmentBreadCrumbs<android.app.FragmentBreadCrumbs> {
        val v = _FragmentBreadCrumbs(android.app.FragmentBreadCrumbs(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun relativeLayout( init: _RelativeLayout<android.widget.RelativeLayout>.() -> Unit): _RelativeLayout<android.widget.RelativeLayout> {
        val v = _RelativeLayout(android.widget.RelativeLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun absoluteLayout( init: _AbsoluteLayout<android.widget.AbsoluteLayout>.() -> Unit): _AbsoluteLayout<android.widget.AbsoluteLayout> {
        val v = _AbsoluteLayout(android.widget.AbsoluteLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun frameLayout( init: _FrameLayout<android.widget.FrameLayout>.() -> Unit): _FrameLayout<android.widget.FrameLayout> {
        val v = _FrameLayout(android.widget.FrameLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun linearLayout( init: _LinearLayout<android.widget.LinearLayout>.() -> Unit): _LinearLayout<android.widget.LinearLayout> {
        val v = _LinearLayout(android.widget.LinearLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gridLayout( init: _GridLayout<android.widget.GridLayout>.() -> Unit): _GridLayout<android.widget.GridLayout> {
        val v = _GridLayout(android.widget.GridLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    fun gLSurfaceView( init: android.opengl.GLSurfaceView.() -> Unit): android.opengl.GLSurfaceView {
        val v = android.opengl.GLSurfaceView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun rSSurfaceView( init: android.renderscript.RSSurfaceView.() -> Unit): android.renderscript.RSSurfaceView {
        val v = android.renderscript.RSSurfaceView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun videoView( init: android.widget.VideoView.() -> Unit): android.widget.VideoView {
        val v = android.widget.VideoView(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

    fun rSTextureView( init: android.renderscript.RSTextureView.() -> Unit): android.renderscript.RSTextureView {
        val v = android.renderscript.RSTextureView(ctx)
        v.init()
        vgInstance.addView(v)
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

    //container function
    fun twoLineListItem( init: _TwoLineListItem<android.widget.TwoLineListItem>.() -> Unit): _TwoLineListItem<android.widget.TwoLineListItem> {
        val v = _TwoLineListItem(android.widget.TwoLineListItem(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun dialerFilter( init: _DialerFilter<android.widget.DialerFilter>.() -> Unit): _DialerFilter<android.widget.DialerFilter> {
        val v = _DialerFilter(android.widget.DialerFilter(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun appWidgetHostView( init: _AppWidgetHostView<android.appwidget.AppWidgetHostView>.() -> Unit): _AppWidgetHostView<android.appwidget.AppWidgetHostView> {
        val v = _AppWidgetHostView(android.appwidget.AppWidgetHostView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gestureOverlayView( init: _GestureOverlayView<android.gesture.GestureOverlayView>.() -> Unit): _GestureOverlayView<android.gesture.GestureOverlayView> {
        val v = _GestureOverlayView(android.gesture.GestureOverlayView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun calendarView( init: _CalendarView<android.widget.CalendarView>.() -> Unit): _CalendarView<android.widget.CalendarView> {
        val v = _CalendarView(android.widget.CalendarView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun horizontalScrollView( init: _HorizontalScrollView<android.widget.HorizontalScrollView>.() -> Unit): _HorizontalScrollView<android.widget.HorizontalScrollView> {
        val v = _HorizontalScrollView(android.widget.HorizontalScrollView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun scrollView( init: _ScrollView<android.widget.ScrollView>.() -> Unit): _ScrollView<android.widget.ScrollView> {
        val v = _ScrollView(android.widget.ScrollView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun datePicker( init: _DatePicker<android.widget.DatePicker>.() -> Unit): _DatePicker<android.widget.DatePicker> {
        val v = _DatePicker(android.widget.DatePicker(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun timePicker( init: _TimePicker<android.widget.TimePicker>.() -> Unit): _TimePicker<android.widget.TimePicker> {
        val v = _TimePicker(android.widget.TimePicker(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun tabHost( init: _TabHost<android.widget.TabHost>.() -> Unit): _TabHost<android.widget.TabHost> {
        val v = _TabHost(android.widget.TabHost(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun viewAnimator( init: _ViewAnimator<android.widget.ViewAnimator>.() -> Unit): _ViewAnimator<android.widget.ViewAnimator> {
        val v = _ViewAnimator(android.widget.ViewAnimator(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun mediaController( init: _MediaController<android.widget.MediaController>.() -> Unit): _MediaController<android.widget.MediaController> {
        val v = _MediaController(android.widget.MediaController(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun tableLayout( init: _TableLayout<android.widget.TableLayout>.() -> Unit): _TableLayout<android.widget.TableLayout> {
        val v = _TableLayout(android.widget.TableLayout(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun tableRow( init: _TableRow<android.widget.TableRow>.() -> Unit): _TableRow<android.widget.TableRow> {
        val v = _TableRow(android.widget.TableRow(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun numberPicker( init: _NumberPicker<android.widget.NumberPicker>.() -> Unit): _NumberPicker<android.widget.NumberPicker> {
        val v = _NumberPicker(android.widget.NumberPicker(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun tabWidget( init: _TabWidget<android.widget.TabWidget>.() -> Unit): _TabWidget<android.widget.TabWidget> {
        val v = _TabWidget(android.widget.TabWidget(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun radioGroup( init: _RadioGroup<android.widget.RadioGroup>.() -> Unit): _RadioGroup<android.widget.RadioGroup> {
        val v = _RadioGroup(android.widget.RadioGroup(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun zoomControls( init: _ZoomControls<android.widget.ZoomControls>.() -> Unit): _ZoomControls<android.widget.ZoomControls> {
        val v = _ZoomControls(android.widget.ZoomControls(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun searchView( init: _SearchView<android.widget.SearchView>.() -> Unit): _SearchView<android.widget.SearchView> {
        val v = _SearchView(android.widget.SearchView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    fun extractEditText( init: android.inputmethodservice.ExtractEditText.() -> Unit): android.inputmethodservice.ExtractEditText {
        val v = android.inputmethodservice.ExtractEditText(ctx)
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

    //container function
    fun viewSwitcher( init: _ViewSwitcher<android.widget.ViewSwitcher>.() -> Unit): _ViewSwitcher<android.widget.ViewSwitcher> {
        val v = _ViewSwitcher(android.widget.ViewSwitcher(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun viewFlipper( init: _ViewFlipper<android.widget.ViewFlipper>.() -> Unit): _ViewFlipper<android.widget.ViewFlipper> {
        val v = _ViewFlipper(android.widget.ViewFlipper(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun listView( init: _ListView<android.widget.ListView>.() -> Unit): _ListView<android.widget.ListView> {
        val v = _ListView(android.widget.ListView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gridView( init: _GridView<android.widget.GridView>.() -> Unit): _GridView<android.widget.GridView> {
        val v = _GridView(android.widget.GridView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun spinner( init: _Spinner<android.widget.Spinner>.() -> Unit): _Spinner<android.widget.Spinner> {
        val v = _Spinner(android.widget.Spinner(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun gallery( init: _Gallery<android.widget.Gallery>.() -> Unit): _Gallery<android.widget.Gallery> {
        val v = _Gallery(android.widget.Gallery(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun stackView( init: _StackView<android.widget.StackView>.() -> Unit): _StackView<android.widget.StackView> {
        val v = _StackView(android.widget.StackView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
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

    //container function
    fun textSwitcher( init: _TextSwitcher<android.widget.TextSwitcher>.() -> Unit): _TextSwitcher<android.widget.TextSwitcher> {
        val v = _TextSwitcher(android.widget.TextSwitcher(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun imageSwitcher( init: _ImageSwitcher<android.widget.ImageSwitcher>.() -> Unit): _ImageSwitcher<android.widget.ImageSwitcher> {
        val v = _ImageSwitcher(android.widget.ImageSwitcher(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

    //container function
    fun expandableListView( init: _ExpandableListView<android.widget.ExpandableListView>.() -> Unit): _ExpandableListView<android.widget.ExpandableListView> {
        val v = _ExpandableListView(android.widget.ExpandableListView(ctx), ctx)
        v.init()
        vgInstance.addView(v.vgInstance)
        _style(v)
        return v
    }

}

