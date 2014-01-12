class _UI(var act: android.app.Activity) {
    fun fragmentBreadCrumbs(init: _FragmentBreadCrumbs<android.app.FragmentBreadCrumbs>.() -> Unit) {
        val layout = _FragmentBreadCrumbs<android.app.FragmentBreadCrumbs>(android.app.FragmentBreadCrumbs(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun relativeLayout(init: _RelativeLayout<android.widget.RelativeLayout>.() -> Unit) {
        val layout = _RelativeLayout<android.widget.RelativeLayout>(android.widget.RelativeLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun absoluteLayout(init: _AbsoluteLayout<android.widget.AbsoluteLayout>.() -> Unit) {
        val layout = _AbsoluteLayout<android.widget.AbsoluteLayout>(android.widget.AbsoluteLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun frameLayout(init: _FrameLayout<android.widget.FrameLayout>.() -> Unit) {
        val layout = _FrameLayout<android.widget.FrameLayout>(android.widget.FrameLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun linearLayout(init: _LinearLayout<android.widget.LinearLayout>.() -> Unit) {
        val layout = _LinearLayout<android.widget.LinearLayout>(android.widget.LinearLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun gridLayout(init: _GridLayout<android.widget.GridLayout>.() -> Unit) {
        val layout = _GridLayout<android.widget.GridLayout>(android.widget.GridLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun twoLineListItem(init: _TwoLineListItem<android.widget.TwoLineListItem>.() -> Unit) {
        val layout = _TwoLineListItem<android.widget.TwoLineListItem>(android.widget.TwoLineListItem(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun dialerFilter(init: _DialerFilter<android.widget.DialerFilter>.() -> Unit) {
        val layout = _DialerFilter<android.widget.DialerFilter>(android.widget.DialerFilter(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun appWidgetHostView(init: _AppWidgetHostView<android.appwidget.AppWidgetHostView>.() -> Unit) {
        val layout = _AppWidgetHostView<android.appwidget.AppWidgetHostView>(android.appwidget.AppWidgetHostView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun gestureOverlayView(init: _GestureOverlayView<android.gesture.GestureOverlayView>.() -> Unit) {
        val layout = _GestureOverlayView<android.gesture.GestureOverlayView>(android.gesture.GestureOverlayView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun calendarView(init: _CalendarView<android.widget.CalendarView>.() -> Unit) {
        val layout = _CalendarView<android.widget.CalendarView>(android.widget.CalendarView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun horizontalScrollView(init: _HorizontalScrollView<android.widget.HorizontalScrollView>.() -> Unit) {
        val layout = _HorizontalScrollView<android.widget.HorizontalScrollView>(android.widget.HorizontalScrollView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun scrollView(init: _ScrollView<android.widget.ScrollView>.() -> Unit) {
        val layout = _ScrollView<android.widget.ScrollView>(android.widget.ScrollView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun datePicker(init: _DatePicker<android.widget.DatePicker>.() -> Unit) {
        val layout = _DatePicker<android.widget.DatePicker>(android.widget.DatePicker(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun timePicker(init: _TimePicker<android.widget.TimePicker>.() -> Unit) {
        val layout = _TimePicker<android.widget.TimePicker>(android.widget.TimePicker(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun tabHost(init: _TabHost<android.widget.TabHost>.() -> Unit) {
        val layout = _TabHost<android.widget.TabHost>(android.widget.TabHost(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun viewAnimator(init: _ViewAnimator<android.widget.ViewAnimator>.() -> Unit) {
        val layout = _ViewAnimator<android.widget.ViewAnimator>(android.widget.ViewAnimator(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun mediaController(init: _MediaController<android.widget.MediaController>.() -> Unit) {
        val layout = _MediaController<android.widget.MediaController>(android.widget.MediaController(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun tableLayout(init: _TableLayout<android.widget.TableLayout>.() -> Unit) {
        val layout = _TableLayout<android.widget.TableLayout>(android.widget.TableLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun tableRow(init: _TableRow<android.widget.TableRow>.() -> Unit) {
        val layout = _TableRow<android.widget.TableRow>(android.widget.TableRow(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun numberPicker(init: _NumberPicker<android.widget.NumberPicker>.() -> Unit) {
        val layout = _NumberPicker<android.widget.NumberPicker>(android.widget.NumberPicker(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun tabWidget(init: _TabWidget<android.widget.TabWidget>.() -> Unit) {
        val layout = _TabWidget<android.widget.TabWidget>(android.widget.TabWidget(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun radioGroup(init: _RadioGroup<android.widget.RadioGroup>.() -> Unit) {
        val layout = _RadioGroup<android.widget.RadioGroup>(android.widget.RadioGroup(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun zoomControls(init: _ZoomControls<android.widget.ZoomControls>.() -> Unit) {
        val layout = _ZoomControls<android.widget.ZoomControls>(android.widget.ZoomControls(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun searchView(init: _SearchView<android.widget.SearchView>.() -> Unit) {
        val layout = _SearchView<android.widget.SearchView>(android.widget.SearchView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun viewSwitcher(init: _ViewSwitcher<android.widget.ViewSwitcher>.() -> Unit) {
        val layout = _ViewSwitcher<android.widget.ViewSwitcher>(android.widget.ViewSwitcher(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun viewFlipper(init: _ViewFlipper<android.widget.ViewFlipper>.() -> Unit) {
        val layout = _ViewFlipper<android.widget.ViewFlipper>(android.widget.ViewFlipper(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun listView(init: _ListView<android.widget.ListView>.() -> Unit) {
        val layout = _ListView<android.widget.ListView>(android.widget.ListView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun gridView(init: _GridView<android.widget.GridView>.() -> Unit) {
        val layout = _GridView<android.widget.GridView>(android.widget.GridView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun spinner(init: _Spinner<android.widget.Spinner>.() -> Unit) {
        val layout = _Spinner<android.widget.Spinner>(android.widget.Spinner(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun gallery(init: _Gallery<android.widget.Gallery>.() -> Unit) {
        val layout = _Gallery<android.widget.Gallery>(android.widget.Gallery(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun stackView(init: _StackView<android.widget.StackView>.() -> Unit) {
        val layout = _StackView<android.widget.StackView>(android.widget.StackView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun textSwitcher(init: _TextSwitcher<android.widget.TextSwitcher>.() -> Unit) {
        val layout = _TextSwitcher<android.widget.TextSwitcher>(android.widget.TextSwitcher(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun imageSwitcher(init: _ImageSwitcher<android.widget.ImageSwitcher>.() -> Unit) {
        val layout = _ImageSwitcher<android.widget.ImageSwitcher>(android.widget.ImageSwitcher(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

    fun expandableListView(init: _ExpandableListView<android.widget.ExpandableListView>.() -> Unit) {
        val layout = _ExpandableListView<android.widget.ExpandableListView>(android.widget.ExpandableListView(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

}

