val _AppWidgetHostView.appWidgetId: Int
    get() = (vgInstance as android.appwidget.AppWidgetHostView).getAppWidgetId()

val _AppWidgetHostView.appWidgetInfo: android.appwidget.AppWidgetProviderInfo?
    get() = (vgInstance as android.appwidget.AppWidgetHostView).getAppWidgetInfo()

var _CalendarView.date: Long
    get() = (vgInstance as android.widget.CalendarView).getDate()
    set(value) = (vgInstance as android.widget.CalendarView).setDate(value)

var _CalendarView.dateTextAppearance: Int
    get() = (vgInstance as android.widget.CalendarView).getDateTextAppearance()
    set(value) = (vgInstance as android.widget.CalendarView).setDateTextAppearance(value)

var _CalendarView.enabled: Boolean
    get() = (vgInstance as android.widget.CalendarView).isEnabled()
    set(value) = (vgInstance as android.widget.CalendarView).setEnabled(value)

var _CalendarView.firstDayOfWeek: Int
    get() = (vgInstance as android.widget.CalendarView).getFirstDayOfWeek()
    set(value) = (vgInstance as android.widget.CalendarView).setFirstDayOfWeek(value)

var _CalendarView.focusedMonthDateColor: Int
    get() = (vgInstance as android.widget.CalendarView).getFocusedMonthDateColor()
    set(value) = (vgInstance as android.widget.CalendarView).setFocusedMonthDateColor(value)

var _CalendarView.maxDate: Long
    get() = (vgInstance as android.widget.CalendarView).getMaxDate()
    set(value) = (vgInstance as android.widget.CalendarView).setMaxDate(value)

var _CalendarView.minDate: Long
    get() = (vgInstance as android.widget.CalendarView).getMinDate()
    set(value) = (vgInstance as android.widget.CalendarView).setMinDate(value)

var _CalendarView.selectedDateVerticalBar: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.CalendarView).getSelectedDateVerticalBar()
    set(value) = (vgInstance as android.widget.CalendarView).setSelectedDateVerticalBar(value!!)

var _CalendarView.selectedWeekBackgroundColor: Int
    get() = (vgInstance as android.widget.CalendarView).getSelectedWeekBackgroundColor()
    set(value) = (vgInstance as android.widget.CalendarView).setSelectedWeekBackgroundColor(value)

var _CalendarView.showWeekNumber: Boolean
    get() = (vgInstance as android.widget.CalendarView).getShowWeekNumber()
    set(value) = (vgInstance as android.widget.CalendarView).setShowWeekNumber(value)

var _CalendarView.shownWeekCount: Int
    get() = (vgInstance as android.widget.CalendarView).getShownWeekCount()
    set(value) = (vgInstance as android.widget.CalendarView).setShownWeekCount(value)

var _CalendarView.unfocusedMonthDateColor: Int
    get() = (vgInstance as android.widget.CalendarView).getUnfocusedMonthDateColor()
    set(value) = (vgInstance as android.widget.CalendarView).setUnfocusedMonthDateColor(value)

var _CalendarView.weekDayTextAppearance: Int
    get() = (vgInstance as android.widget.CalendarView).getWeekDayTextAppearance()
    set(value) = (vgInstance as android.widget.CalendarView).setWeekDayTextAppearance(value)

var _CalendarView.weekNumberColor: Int
    get() = (vgInstance as android.widget.CalendarView).getWeekNumberColor()
    set(value) = (vgInstance as android.widget.CalendarView).setWeekNumberColor(value)

var _CalendarView.weekSeparatorLineColor: Int
    get() = (vgInstance as android.widget.CalendarView).getWeekSeparatorLineColor()
    set(value) = (vgInstance as android.widget.CalendarView).setWeekSeparatorLineColor(value)

val _DatePicker.calendarView: android.widget.CalendarView?
    get() = (vgInstance as android.widget.DatePicker).getCalendarView()

var _DatePicker.calendarViewShown: Boolean
    get() = (vgInstance as android.widget.DatePicker).getCalendarViewShown()
    set(value) = (vgInstance as android.widget.DatePicker).setCalendarViewShown(value)

val _DatePicker.dayOfMonth: Int
    get() = (vgInstance as android.widget.DatePicker).getDayOfMonth()

var _DatePicker.enabled: Boolean
    get() = (vgInstance as android.widget.DatePicker).isEnabled()
    set(value) = (vgInstance as android.widget.DatePicker).setEnabled(value)

var _DatePicker.maxDate: Long
    get() = (vgInstance as android.widget.DatePicker).getMaxDate()
    set(value) = (vgInstance as android.widget.DatePicker).setMaxDate(value)

var _DatePicker.minDate: Long
    get() = (vgInstance as android.widget.DatePicker).getMinDate()
    set(value) = (vgInstance as android.widget.DatePicker).setMinDate(value)

val _DatePicker.month: Int
    get() = (vgInstance as android.widget.DatePicker).getMonth()

var _DatePicker.spinnersShown: Boolean
    get() = (vgInstance as android.widget.DatePicker).getSpinnersShown()
    set(value) = (vgInstance as android.widget.DatePicker).setSpinnersShown(value)

val _DatePicker.year: Int
    get() = (vgInstance as android.widget.DatePicker).getYear()

val _DialerFilter.digits: jet.CharSequence?
    get() = (vgInstance as android.widget.DialerFilter).getDigits()

val _DialerFilter.filterText: jet.CharSequence?
    get() = (vgInstance as android.widget.DialerFilter).getFilterText()

val _DialerFilter.letters: jet.CharSequence?
    get() = (vgInstance as android.widget.DialerFilter).getLetters()

var _DialerFilter.mode: Int
    get() = (vgInstance as android.widget.DialerFilter).getMode()
    set(value) = (vgInstance as android.widget.DialerFilter).setMode(value)

val _DialerFilter.qwertyKeyboard: Boolean
    get() = (vgInstance as android.widget.DialerFilter).isQwertyKeyboard()

var _ExpandableListView.adapter: android.widget.ListAdapter?
    get() = (vgInstance as android.widget.ExpandableListView).getAdapter()
    set(value) = (vgInstance as android.widget.ExpandableListView).setAdapter(value!!)

val _ExpandableListView.expandableListAdapter: android.widget.ExpandableListAdapter?
    get() = (vgInstance as android.widget.ExpandableListView).getExpandableListAdapter()

val _ExpandableListView.selectedId: Long
    get() = (vgInstance as android.widget.ExpandableListView).getSelectedId()

val _ExpandableListView.selectedPosition: Long
    get() = (vgInstance as android.widget.ExpandableListView).getSelectedPosition()

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

var _GestureOverlayView.eventsInterceptionEnabled: Boolean
    get() = (vgInstance as android.gesture.GestureOverlayView).isEventsInterceptionEnabled()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setEventsInterceptionEnabled(value)

var _GestureOverlayView.fadeEnabled: Boolean
    get() = (vgInstance as android.gesture.GestureOverlayView).isFadeEnabled()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setFadeEnabled(value)

var _GestureOverlayView.fadeOffset: Long
    get() = (vgInstance as android.gesture.GestureOverlayView).getFadeOffset()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setFadeOffset(value)

var _GestureOverlayView.gesture: android.gesture.Gesture?
    get() = (vgInstance as android.gesture.GestureOverlayView).getGesture()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGesture(value!!)

var _GestureOverlayView.gestureColor: Int
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureColor()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureColor(value)

val _GestureOverlayView.gesturePath: android.graphics.Path?
    get() = (vgInstance as android.gesture.GestureOverlayView).getGesturePath()

var _GestureOverlayView.gestureStrokeAngleThreshold: Float
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureStrokeAngleThreshold()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureStrokeAngleThreshold(value)

var _GestureOverlayView.gestureStrokeLengthThreshold: Float
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureStrokeLengthThreshold()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureStrokeLengthThreshold(value)

var _GestureOverlayView.gestureStrokeSquarenessTreshold: Float
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureStrokeSquarenessTreshold()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureStrokeSquarenessTreshold(value)

var _GestureOverlayView.gestureStrokeType: Int
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureStrokeType()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureStrokeType(value)

var _GestureOverlayView.gestureStrokeWidth: Float
    get() = (vgInstance as android.gesture.GestureOverlayView).getGestureStrokeWidth()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureStrokeWidth(value)

var _GestureOverlayView.gestureVisible: Boolean
    get() = (vgInstance as android.gesture.GestureOverlayView).isGestureVisible()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setGestureVisible(value)

val _GestureOverlayView.gesturing: Boolean
    get() = (vgInstance as android.gesture.GestureOverlayView).isGesturing()

var _GestureOverlayView.orientation: Int
    get() = (vgInstance as android.gesture.GestureOverlayView).getOrientation()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setOrientation(value)

var _GestureOverlayView.uncertainGestureColor: Int
    get() = (vgInstance as android.gesture.GestureOverlayView).getUncertainGestureColor()
    set(value) = (vgInstance as android.gesture.GestureOverlayView).setUncertainGestureColor(value)

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

var _GridView.adapter: android.widget.ListAdapter?
    get() = (vgInstance as android.widget.GridView).getAdapter()
    set(value) = (vgInstance as android.widget.GridView).setAdapter(value!!)

var _GridView.columnWidth: Int
    get() = (vgInstance as android.widget.GridView).getColumnWidth()
    set(value) = (vgInstance as android.widget.GridView).setColumnWidth(value)

var _GridView.gravity: Int
    get() = (vgInstance as android.widget.GridView).getGravity()
    set(value) = (vgInstance as android.widget.GridView).setGravity(value)

var _GridView.horizontalSpacing: Int
    get() = (vgInstance as android.widget.GridView).getHorizontalSpacing()
    set(value) = (vgInstance as android.widget.GridView).setHorizontalSpacing(value)

var _GridView.numColumns: Int
    get() = (vgInstance as android.widget.GridView).getNumColumns()
    set(value) = (vgInstance as android.widget.GridView).setNumColumns(value)

val _GridView.requestedColumnWidth: Int
    get() = (vgInstance as android.widget.GridView).getRequestedColumnWidth()

val _GridView.requestedHorizontalSpacing: Int
    get() = (vgInstance as android.widget.GridView).getRequestedHorizontalSpacing()

var _GridView.stretchMode: Int
    get() = (vgInstance as android.widget.GridView).getStretchMode()
    set(value) = (vgInstance as android.widget.GridView).setStretchMode(value)

var _GridView.verticalSpacing: Int
    get() = (vgInstance as android.widget.GridView).getVerticalSpacing()
    set(value) = (vgInstance as android.widget.GridView).setVerticalSpacing(value)

var _HorizontalScrollView.fillViewport: Boolean
    get() = (vgInstance as android.widget.HorizontalScrollView).isFillViewport()
    set(value) = (vgInstance as android.widget.HorizontalScrollView).setFillViewport(value)

val _HorizontalScrollView.maxScrollAmount: Int
    get() = (vgInstance as android.widget.HorizontalScrollView).getMaxScrollAmount()

var _HorizontalScrollView.smoothScrollingEnabled: Boolean
    get() = (vgInstance as android.widget.HorizontalScrollView).isSmoothScrollingEnabled()
    set(value) = (vgInstance as android.widget.HorizontalScrollView).setSmoothScrollingEnabled(value)

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

var _ListView.adapter: android.widget.ListAdapter?
    get() = (vgInstance as android.widget.ListView).getAdapter()
    set(value) = (vgInstance as android.widget.ListView).setAdapter(value!!)

val _ListView.checkItemIds: LongArray?
    get() = (vgInstance as android.widget.ListView).getCheckItemIds()

var _ListView.divider: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.ListView).getDivider()
    set(value) = (vgInstance as android.widget.ListView).setDivider(value!!)

var _ListView.dividerHeight: Int
    get() = (vgInstance as android.widget.ListView).getDividerHeight()
    set(value) = (vgInstance as android.widget.ListView).setDividerHeight(value)

val _ListView.footerViewsCount: Int
    get() = (vgInstance as android.widget.ListView).getFooterViewsCount()

val _ListView.headerViewsCount: Int
    get() = (vgInstance as android.widget.ListView).getHeaderViewsCount()

var _ListView.itemsCanFocus: Boolean
    get() = (vgInstance as android.widget.ListView).getItemsCanFocus()
    set(value) = (vgInstance as android.widget.ListView).setItemsCanFocus(value)

val _ListView.maxScrollAmount: Int
    get() = (vgInstance as android.widget.ListView).getMaxScrollAmount()

val _ListView.opaque: Boolean
    get() = (vgInstance as android.widget.ListView).isOpaque()

var _ListView.overscrollFooter: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.ListView).getOverscrollFooter()
    set(value) = (vgInstance as android.widget.ListView).setOverscrollFooter(value!!)

var _ListView.overscrollHeader: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.ListView).getOverscrollHeader()
    set(value) = (vgInstance as android.widget.ListView).setOverscrollHeader(value!!)

val _MediaController.showing: Boolean
    get() = (vgInstance as android.widget.MediaController).isShowing()

val _NumberPicker.accessibilityNodeProvider: android.view.accessibility.AccessibilityNodeProvider?
    get() = (vgInstance as android.widget.NumberPicker).getAccessibilityNodeProvider()

var _NumberPicker.displayedValues: Array<jet.String>?
    get() = (vgInstance as android.widget.NumberPicker).getDisplayedValues()
    set(value) = (vgInstance as android.widget.NumberPicker).setDisplayedValues(value!!)

var _NumberPicker.maxValue: Int
    get() = (vgInstance as android.widget.NumberPicker).getMaxValue()
    set(value) = (vgInstance as android.widget.NumberPicker).setMaxValue(value)

var _NumberPicker.minValue: Int
    get() = (vgInstance as android.widget.NumberPicker).getMinValue()
    set(value) = (vgInstance as android.widget.NumberPicker).setMinValue(value)

val _NumberPicker.solidColor: Int
    get() = (vgInstance as android.widget.NumberPicker).getSolidColor()

var _NumberPicker.value: Int
    get() = (vgInstance as android.widget.NumberPicker).getValue()
    set(value) = (vgInstance as android.widget.NumberPicker).setValue(value)

var _NumberPicker.wrapSelectorWheel: Boolean
    get() = (vgInstance as android.widget.NumberPicker).getWrapSelectorWheel()
    set(value) = (vgInstance as android.widget.NumberPicker).setWrapSelectorWheel(value)

val _RadioGroup.checkedRadioButtonId: Int
    get() = (vgInstance as android.widget.RadioGroup).getCheckedRadioButtonId()

val _RelativeLayout.baseline: Int
    get() = (vgInstance as android.widget.RelativeLayout).getBaseline()

var _RelativeLayout.gravity: Int
    get() = (vgInstance as android.widget.RelativeLayout).getGravity()
    set(value) = (vgInstance as android.widget.RelativeLayout).setGravity(value)

var _ScrollView.fillViewport: Boolean
    get() = (vgInstance as android.widget.ScrollView).isFillViewport()
    set(value) = (vgInstance as android.widget.ScrollView).setFillViewport(value)

val _ScrollView.maxScrollAmount: Int
    get() = (vgInstance as android.widget.ScrollView).getMaxScrollAmount()

var _ScrollView.smoothScrollingEnabled: Boolean
    get() = (vgInstance as android.widget.ScrollView).isSmoothScrollingEnabled()
    set(value) = (vgInstance as android.widget.ScrollView).setSmoothScrollingEnabled(value)

val _SearchView.iconfiedByDefault: Boolean
    get() = (vgInstance as android.widget.SearchView).isIconfiedByDefault()

var _SearchView.iconified: Boolean
    get() = (vgInstance as android.widget.SearchView).isIconified()
    set(value) = (vgInstance as android.widget.SearchView).setIconified(value)

var _SearchView.imeOptions: Int
    get() = (vgInstance as android.widget.SearchView).getImeOptions()
    set(value) = (vgInstance as android.widget.SearchView).setImeOptions(value)

var _SearchView.inputType: Int
    get() = (vgInstance as android.widget.SearchView).getInputType()
    set(value) = (vgInstance as android.widget.SearchView).setInputType(value)

var _SearchView.maxWidth: Int
    get() = (vgInstance as android.widget.SearchView).getMaxWidth()
    set(value) = (vgInstance as android.widget.SearchView).setMaxWidth(value)

val _SearchView.query: jet.CharSequence?
    get() = (vgInstance as android.widget.SearchView).getQuery()

var _SearchView.queryHint: jet.CharSequence?
    get() = (vgInstance as android.widget.SearchView).getQueryHint()
    set(value) = (vgInstance as android.widget.SearchView).setQueryHint(value!!)

var _SearchView.queryRefinementEnabled: Boolean
    get() = (vgInstance as android.widget.SearchView).isQueryRefinementEnabled()
    set(value) = (vgInstance as android.widget.SearchView).setQueryRefinementEnabled(value)

var _SearchView.submitButtonEnabled: Boolean
    get() = (vgInstance as android.widget.SearchView).isSubmitButtonEnabled()
    set(value) = (vgInstance as android.widget.SearchView).setSubmitButtonEnabled(value)

var _SearchView.suggestionsAdapter: android.widget.CursorAdapter?
    get() = (vgInstance as android.widget.SearchView).getSuggestionsAdapter()
    set(value) = (vgInstance as android.widget.SearchView).setSuggestionsAdapter(value!!)

val _Spinner.baseline: Int
    get() = (vgInstance as android.widget.Spinner).getBaseline()

var _Spinner.dropDownHorizontalOffset: Int
    get() = (vgInstance as android.widget.Spinner).getDropDownHorizontalOffset()
    set(value) = (vgInstance as android.widget.Spinner).setDropDownHorizontalOffset(value)

var _Spinner.dropDownVerticalOffset: Int
    get() = (vgInstance as android.widget.Spinner).getDropDownVerticalOffset()
    set(value) = (vgInstance as android.widget.Spinner).setDropDownVerticalOffset(value)

var _Spinner.dropDownWidth: Int
    get() = (vgInstance as android.widget.Spinner).getDropDownWidth()
    set(value) = (vgInstance as android.widget.Spinner).setDropDownWidth(value)

var _Spinner.gravity: Int
    get() = (vgInstance as android.widget.Spinner).getGravity()
    set(value) = (vgInstance as android.widget.Spinner).setGravity(value)

val _Spinner.popupBackground: android.graphics.drawable.Drawable?
    get() = (vgInstance as android.widget.Spinner).getPopupBackground()

var _Spinner.prompt: jet.CharSequence?
    get() = (vgInstance as android.widget.Spinner).getPrompt()
    set(value) = (vgInstance as android.widget.Spinner).setPrompt(value!!)

var _TabHost.currentTab: Int
    get() = (vgInstance as android.widget.TabHost).getCurrentTab()
    set(value) = (vgInstance as android.widget.TabHost).setCurrentTab(value)

val _TabHost.currentTabTag: jet.String?
    get() = (vgInstance as android.widget.TabHost).getCurrentTabTag()

val _TabHost.currentTabView: android.view.View?
    get() = (vgInstance as android.widget.TabHost).getCurrentTabView()

val _TabHost.currentView: android.view.View?
    get() = (vgInstance as android.widget.TabHost).getCurrentView()

val _TabHost.tabContentView: android.widget.FrameLayout?
    get() = (vgInstance as android.widget.TabHost).getTabContentView()

val _TabHost.tabWidget: android.widget.TabWidget?
    get() = (vgInstance as android.widget.TabHost).getTabWidget()

var _TabWidget.stripEnabled: Boolean
    get() = (vgInstance as android.widget.TabWidget).isStripEnabled()
    set(value) = (vgInstance as android.widget.TabWidget).setStripEnabled(value)

val _TabWidget.tabCount: Int
    get() = (vgInstance as android.widget.TabWidget).getTabCount()

var _TableLayout.shrinkAllColumns: Boolean
    get() = (vgInstance as android.widget.TableLayout).isShrinkAllColumns()
    set(value) = (vgInstance as android.widget.TableLayout).setShrinkAllColumns(value)

var _TableLayout.stretchAllColumns: Boolean
    get() = (vgInstance as android.widget.TableLayout).isStretchAllColumns()
    set(value) = (vgInstance as android.widget.TableLayout).setStretchAllColumns(value)

val _TableRow.virtualChildCount: Int
    get() = (vgInstance as android.widget.TableRow).getVirtualChildCount()

val _TimePicker.baseline: Int
    get() = (vgInstance as android.widget.TimePicker).getBaseline()

var _TimePicker.currentHour: jet.Int?
    get() = (vgInstance as android.widget.TimePicker).getCurrentHour()
    set(value) = (vgInstance as android.widget.TimePicker).setCurrentHour(value!!)

var _TimePicker.currentMinute: jet.Int?
    get() = (vgInstance as android.widget.TimePicker).getCurrentMinute()
    set(value) = (vgInstance as android.widget.TimePicker).setCurrentMinute(value!!)

var _TimePicker.enabled: Boolean
    get() = (vgInstance as android.widget.TimePicker).isEnabled()
    set(value) = (vgInstance as android.widget.TimePicker).setEnabled(value)

val _TwoLineListItem.text1: android.widget.TextView?
    get() = (vgInstance as android.widget.TwoLineListItem).getText1()

val _TwoLineListItem.text2: android.widget.TextView?
    get() = (vgInstance as android.widget.TwoLineListItem).getText2()

val _ViewAnimator.baseline: Int
    get() = (vgInstance as android.widget.ViewAnimator).getBaseline()

val _ViewAnimator.currentView: android.view.View?
    get() = (vgInstance as android.widget.ViewAnimator).getCurrentView()

var _ViewAnimator.displayedChild: Int
    get() = (vgInstance as android.widget.ViewAnimator).getDisplayedChild()
    set(value) = (vgInstance as android.widget.ViewAnimator).setDisplayedChild(value)

var _ViewAnimator.inAnimation: android.view.animation.Animation?
    get() = (vgInstance as android.widget.ViewAnimator).getInAnimation()
    set(value) = (vgInstance as android.widget.ViewAnimator).setInAnimation(value!!)

var _ViewAnimator.outAnimation: android.view.animation.Animation?
    get() = (vgInstance as android.widget.ViewAnimator).getOutAnimation()
    set(value) = (vgInstance as android.widget.ViewAnimator).setOutAnimation(value!!)

var _ViewFlipper.autoStart: Boolean
    get() = (vgInstance as android.widget.ViewFlipper).isAutoStart()
    set(value) = (vgInstance as android.widget.ViewFlipper).setAutoStart(value)

val _ViewFlipper.flipping: Boolean
    get() = (vgInstance as android.widget.ViewFlipper).isFlipping()

val _ViewSwitcher.nextView: android.view.View?
    get() = (vgInstance as android.widget.ViewSwitcher).getNextView()

val _WebView.contentHeight: Int
    get() = (vgInstance as android.webkit.WebView).getContentHeight()

val _WebView.favicon: android.graphics.Bitmap?
    get() = (vgInstance as android.webkit.WebView).getFavicon()

val _WebView.progress: Int
    get() = (vgInstance as android.webkit.WebView).getProgress()

val _WebView.scale: Float
    get() = (vgInstance as android.webkit.WebView).getScale()

val _WebView.settings: android.webkit.WebSettings?
    get() = (vgInstance as android.webkit.WebView).getSettings()

val _WebView.title: jet.String?
    get() = (vgInstance as android.webkit.WebView).getTitle()

val _WebView.url: jet.String?
    get() = (vgInstance as android.webkit.WebView).getUrl()

var android.app.MediaRouteButton.routeTypes: Int
    get() = getRouteTypes()
    set(value) = setRouteTypes(value)

val android.inputmethodservice.ExtractEditText.focused: Boolean
    get() = isFocused()

val android.inputmethodservice.ExtractEditText.inputMethodTarget: Boolean
    get() = isInputMethodTarget()

var android.inputmethodservice.KeyboardView.keyboard: android.inputmethodservice.Keyboard?
    get() = getKeyboard()
    set(value) = setKeyboard(value!!)

var android.inputmethodservice.KeyboardView.previewEnabled: Boolean
    get() = isPreviewEnabled()
    set(value) = setPreviewEnabled(value)

var android.inputmethodservice.KeyboardView.proximityCorrectionEnabled: Boolean
    get() = isProximityCorrectionEnabled()
    set(value) = setProximityCorrectionEnabled(value)

var android.opengl.GLSurfaceView.debugFlags: Int
    get() = getDebugFlags()
    set(value) = setDebugFlags(value)

var android.opengl.GLSurfaceView.preserveEGLContextOnPause: Boolean
    get() = getPreserveEGLContextOnPause()
    set(value) = setPreserveEGLContextOnPause(value)

var android.opengl.GLSurfaceView.renderMode: Int
    get() = getRenderMode()
    set(value) = setRenderMode(value)

var android.renderscript.RSSurfaceView.renderScriptGL: android.renderscript.RenderScriptGL?
    get() = getRenderScriptGL()
    set(value) = setRenderScriptGL(value!!)

var android.renderscript.RSTextureView.renderScriptGL: android.renderscript.RenderScriptGL?
    get() = getRenderScriptGL()
    set(value) = setRenderScriptGL(value!!)

val android.view.SurfaceView.holder: android.view.SurfaceHolder?
    get() = getHolder()

val android.view.TextureView.available: Boolean
    get() = isAvailable()

val android.view.TextureView.bitmap: android.graphics.Bitmap?
    get() = getBitmap()

val android.view.TextureView.layerType: Int
    get() = getLayerType()

var android.view.TextureView.opaque: Boolean
    get() = isOpaque()
    set(value) = setOpaque(value)

var android.view.TextureView.surfaceTexture: android.graphics.SurfaceTexture?
    get() = getSurfaceTexture()
    set(value) = setSurfaceTexture(value!!)

var android.view.TextureView.surfaceTextureListener: android.view.TextureView.SurfaceTextureListener?
    get() = getSurfaceTextureListener()
    set(value) = setSurfaceTextureListener(value!!)

var android.view.ViewGroup.alwaysDrawnWithCacheEnabled: Boolean
    get() = isAlwaysDrawnWithCacheEnabled()
    set(value) = setAlwaysDrawnWithCacheEnabled(value)

var android.view.ViewGroup.animationCacheEnabled: Boolean
    get() = isAnimationCacheEnabled()
    set(value) = setAnimationCacheEnabled(value)

val android.view.ViewGroup.childCount: Int
    get() = getChildCount()

var android.view.ViewGroup.descendantFocusability: Int
    get() = getDescendantFocusability()
    set(value) = setDescendantFocusability(value)

val android.view.ViewGroup.focusedChild: android.view.View?
    get() = getFocusedChild()

var android.view.ViewGroup.layoutAnimation: android.view.animation.LayoutAnimationController?
    get() = getLayoutAnimation()
    set(value) = setLayoutAnimation(value!!)

var android.view.ViewGroup.layoutAnimationListener: android.view.animation.Animation.AnimationListener?
    get() = getLayoutAnimationListener()
    set(value) = setLayoutAnimationListener(value!!)

var android.view.ViewGroup.layoutTransition: android.animation.LayoutTransition?
    get() = getLayoutTransition()
    set(value) = setLayoutTransition(value!!)

var android.view.ViewGroup.motionEventSplittingEnabled: Boolean
    get() = isMotionEventSplittingEnabled()
    set(value) = setMotionEventSplittingEnabled(value)

var android.view.ViewGroup.persistentDrawingCache: Int
    get() = getPersistentDrawingCache()
    set(value) = setPersistentDrawingCache(value)

var android.view.ViewStub.inflatedId: Int
    get() = getInflatedId()
    set(value) = setInflatedId(value)

var android.view.ViewStub.layoutInflater: android.view.LayoutInflater?
    get() = getLayoutInflater()
    set(value) = setLayoutInflater(value!!)

var android.view.ViewStub.layoutResource: Int
    get() = getLayoutResource()
    set(value) = setLayoutResource(value)

var android.widget.AbsSeekBar.keyProgressIncrement: Int
    get() = getKeyProgressIncrement()
    set(value) = setKeyProgressIncrement(value)

var android.widget.AbsSeekBar.thumb: android.graphics.drawable.Drawable?
    get() = getThumb()
    set(value) = setThumb(value!!)

var android.widget.AbsSeekBar.thumbOffset: Int
    get() = getThumbOffset()
    set(value) = setThumbOffset(value)

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

var android.widget.ToggleButton.textOff: jet.CharSequence?
    get() = getTextOff()
    set(value) = setTextOff(value!!)

var android.widget.ToggleButton.textOn: jet.CharSequence?
    get() = getTextOn()
    set(value) = setTextOn(value!!)

val android.widget.VideoView.bufferPercentage: Int
    get() = getBufferPercentage()

val android.widget.VideoView.currentPosition: Int
    get() = getCurrentPosition()

val android.widget.VideoView.duration: Int
    get() = getDuration()

val android.widget.VideoView.playing: Boolean
    get() = isPlaying()

