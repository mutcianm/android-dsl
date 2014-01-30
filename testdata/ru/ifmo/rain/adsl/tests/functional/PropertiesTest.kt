var android.app.MediaRouteButton.routeTypes: Int
    get() = getRouteTypes()
    set(value) = setRouteTypes(value)

val _AppWidgetHostView.appWidgetId: Int
    get() = vgInstance.getAppWidgetId()

val _AppWidgetHostView.appWidgetInfo: android.appwidget.AppWidgetProviderInfo?
    get() = vgInstance.getAppWidgetInfo()

var _GestureOverlayView.eventsInterceptionEnabled: Boolean
    get() = vgInstance.isEventsInterceptionEnabled()
    set(value) = vgInstance.setEventsInterceptionEnabled(value)

var _GestureOverlayView.fadeEnabled: Boolean
    get() = vgInstance.isFadeEnabled()
    set(value) = vgInstance.setFadeEnabled(value)

var _GestureOverlayView.fadeOffset: Long
    get() = vgInstance.getFadeOffset()
    set(value) = vgInstance.setFadeOffset(value)

var _GestureOverlayView.gesture: android.gesture.Gesture?
    get() = vgInstance.getGesture()
    set(value) = vgInstance.setGesture(value!!)

var _GestureOverlayView.gestureColor: Int
    get() = vgInstance.getGestureColor()
    set(value) = vgInstance.setGestureColor(value)

val _GestureOverlayView.gesturePath: android.graphics.Path?
    get() = vgInstance.getGesturePath()

var _GestureOverlayView.gestureStrokeAngleThreshold: Float
    get() = vgInstance.getGestureStrokeAngleThreshold()
    set(value) = vgInstance.setGestureStrokeAngleThreshold(value)

var _GestureOverlayView.gestureStrokeLengthThreshold: Float
    get() = vgInstance.getGestureStrokeLengthThreshold()
    set(value) = vgInstance.setGestureStrokeLengthThreshold(value)

var _GestureOverlayView.gestureStrokeSquarenessTreshold: Float
    get() = vgInstance.getGestureStrokeSquarenessTreshold()
    set(value) = vgInstance.setGestureStrokeSquarenessTreshold(value)

var _GestureOverlayView.gestureStrokeType: Int
    get() = vgInstance.getGestureStrokeType()
    set(value) = vgInstance.setGestureStrokeType(value)

var _GestureOverlayView.gestureStrokeWidth: Float
    get() = vgInstance.getGestureStrokeWidth()
    set(value) = vgInstance.setGestureStrokeWidth(value)

var _GestureOverlayView.gestureVisible: Boolean
    get() = vgInstance.isGestureVisible()
    set(value) = vgInstance.setGestureVisible(value)

val _GestureOverlayView.gesturing: Boolean
    get() = vgInstance.isGesturing()

var _GestureOverlayView.orientation: Int
    get() = vgInstance.getOrientation()
    set(value) = vgInstance.setOrientation(value)

var _GestureOverlayView.uncertainGestureColor: Int
    get() = vgInstance.getUncertainGestureColor()
    set(value) = vgInstance.setUncertainGestureColor(value)

val android.inputmethodservice.ExtractEditText.focused: Boolean
    get() = isFocused()

val android.inputmethodservice.ExtractEditText.inputMethodTarget: Boolean
    get() = isInputMethodTarget()

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

val android.widget.AutoCompleteTextView.adapter: android.widget.ListAdapter?
    get() = getAdapter()

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

var _CalendarView.date: Long
    get() = vgInstance.getDate()
    set(value) = vgInstance.setDate(value)

var _CalendarView.dateTextAppearance: Int
    get() = vgInstance.getDateTextAppearance()
    set(value) = vgInstance.setDateTextAppearance(value)

var _CalendarView.enabled: Boolean
    get() = vgInstance.isEnabled()
    set(value) = vgInstance.setEnabled(value)

var _CalendarView.firstDayOfWeek: Int
    get() = vgInstance.getFirstDayOfWeek()
    set(value) = vgInstance.setFirstDayOfWeek(value)

var _CalendarView.focusedMonthDateColor: Int
    get() = vgInstance.getFocusedMonthDateColor()
    set(value) = vgInstance.setFocusedMonthDateColor(value)

var _CalendarView.maxDate: Long
    get() = vgInstance.getMaxDate()
    set(value) = vgInstance.setMaxDate(value)

var _CalendarView.minDate: Long
    get() = vgInstance.getMinDate()
    set(value) = vgInstance.setMinDate(value)

var _CalendarView.selectedDateVerticalBar: android.graphics.drawable.Drawable?
    get() = vgInstance.getSelectedDateVerticalBar()
    set(value) = vgInstance.setSelectedDateVerticalBar(value!!)

var _CalendarView.selectedWeekBackgroundColor: Int
    get() = vgInstance.getSelectedWeekBackgroundColor()
    set(value) = vgInstance.setSelectedWeekBackgroundColor(value)

var _CalendarView.showWeekNumber: Boolean
    get() = vgInstance.getShowWeekNumber()
    set(value) = vgInstance.setShowWeekNumber(value)

var _CalendarView.shownWeekCount: Int
    get() = vgInstance.getShownWeekCount()
    set(value) = vgInstance.setShownWeekCount(value)

var _CalendarView.unfocusedMonthDateColor: Int
    get() = vgInstance.getUnfocusedMonthDateColor()
    set(value) = vgInstance.setUnfocusedMonthDateColor(value)

var _CalendarView.weekDayTextAppearance: Int
    get() = vgInstance.getWeekDayTextAppearance()
    set(value) = vgInstance.setWeekDayTextAppearance(value)

var _CalendarView.weekNumberColor: Int
    get() = vgInstance.getWeekNumberColor()
    set(value) = vgInstance.setWeekNumberColor(value)

var _CalendarView.weekSeparatorLineColor: Int
    get() = vgInstance.getWeekSeparatorLineColor()
    set(value) = vgInstance.setWeekSeparatorLineColor(value)

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

val _DatePicker.calendarView: android.widget.CalendarView?
    get() = vgInstance.getCalendarView()

var _DatePicker.calendarViewShown: Boolean
    get() = vgInstance.getCalendarViewShown()
    set(value) = vgInstance.setCalendarViewShown(value)

val _DatePicker.dayOfMonth: Int
    get() = vgInstance.getDayOfMonth()

var _DatePicker.enabled: Boolean
    get() = vgInstance.isEnabled()
    set(value) = vgInstance.setEnabled(value)

var _DatePicker.maxDate: Long
    get() = vgInstance.getMaxDate()
    set(value) = vgInstance.setMaxDate(value)

var _DatePicker.minDate: Long
    get() = vgInstance.getMinDate()
    set(value) = vgInstance.setMinDate(value)

val _DatePicker.month: Int
    get() = vgInstance.getMonth()

var _DatePicker.spinnersShown: Boolean
    get() = vgInstance.getSpinnersShown()
    set(value) = vgInstance.setSpinnersShown(value)

val _DatePicker.year: Int
    get() = vgInstance.getYear()

val _DialerFilter.digits: jet.CharSequence?
    get() = vgInstance.getDigits()

val _DialerFilter.filterText: jet.CharSequence?
    get() = vgInstance.getFilterText()

val _DialerFilter.letters: jet.CharSequence?
    get() = vgInstance.getLetters()

var _DialerFilter.mode: Int
    get() = vgInstance.getMode()
    set(value) = vgInstance.setMode(value)

val _DialerFilter.qwertyKeyboard: Boolean
    get() = vgInstance.isQwertyKeyboard()

val android.widget.EditText.text: android.text.Editable?
    get() = getText()

var _ExpandableListView.adapter: android.widget.ListAdapter?
    get() = vgInstance.getAdapter()
    set(value) = vgInstance.setAdapter(value!!)

val _ExpandableListView.expandableListAdapter: android.widget.ExpandableListAdapter?
    get() = vgInstance.getExpandableListAdapter()

val _ExpandableListView.selectedId: Long
    get() = vgInstance.getSelectedId()

val _ExpandableListView.selectedPosition: Long
    get() = vgInstance.getSelectedPosition()

val _FrameLayout.considerGoneChildrenWhenMeasuring: Boolean
    get() = vgInstance.getConsiderGoneChildrenWhenMeasuring()

var _FrameLayout.foreground: android.graphics.drawable.Drawable?
    get() = vgInstance.getForeground()
    set(value) = vgInstance.setForeground(value!!)

var _FrameLayout.foregroundGravity: Int
    get() = vgInstance.getForegroundGravity()
    set(value) = vgInstance.setForegroundGravity(value)

var _FrameLayout.measureAllChildren: Boolean
    get() = vgInstance.getMeasureAllChildren()
    set(value) = vgInstance.setMeasureAllChildren(value)

var _GridLayout.alignmentMode: Int
    get() = vgInstance.getAlignmentMode()
    set(value) = vgInstance.setAlignmentMode(value)

var _GridLayout.columnCount: Int
    get() = vgInstance.getColumnCount()
    set(value) = vgInstance.setColumnCount(value)

var _GridLayout.columnOrderPreserved: Boolean
    get() = vgInstance.isColumnOrderPreserved()
    set(value) = vgInstance.setColumnOrderPreserved(value)

var _GridLayout.orientation: Int
    get() = vgInstance.getOrientation()
    set(value) = vgInstance.setOrientation(value)

var _GridLayout.rowCount: Int
    get() = vgInstance.getRowCount()
    set(value) = vgInstance.setRowCount(value)

var _GridLayout.rowOrderPreserved: Boolean
    get() = vgInstance.isRowOrderPreserved()
    set(value) = vgInstance.setRowOrderPreserved(value)

var _GridLayout.useDefaultMargins: Boolean
    get() = vgInstance.getUseDefaultMargins()
    set(value) = vgInstance.setUseDefaultMargins(value)

var _GridView.adapter: android.widget.ListAdapter?
    get() = vgInstance.getAdapter()
    set(value) = vgInstance.setAdapter(value!!)

var _GridView.columnWidth: Int
    get() = vgInstance.getColumnWidth()
    set(value) = vgInstance.setColumnWidth(value)

var _GridView.gravity: Int
    get() = vgInstance.getGravity()
    set(value) = vgInstance.setGravity(value)

var _GridView.horizontalSpacing: Int
    get() = vgInstance.getHorizontalSpacing()
    set(value) = vgInstance.setHorizontalSpacing(value)

var _GridView.numColumns: Int
    get() = vgInstance.getNumColumns()
    set(value) = vgInstance.setNumColumns(value)

val _GridView.requestedColumnWidth: Int
    get() = vgInstance.getRequestedColumnWidth()

val _GridView.requestedHorizontalSpacing: Int
    get() = vgInstance.getRequestedHorizontalSpacing()

var _GridView.stretchMode: Int
    get() = vgInstance.getStretchMode()
    set(value) = vgInstance.setStretchMode(value)

var _GridView.verticalSpacing: Int
    get() = vgInstance.getVerticalSpacing()
    set(value) = vgInstance.setVerticalSpacing(value)

var _HorizontalScrollView.fillViewport: Boolean
    get() = vgInstance.isFillViewport()
    set(value) = vgInstance.setFillViewport(value)

val _HorizontalScrollView.maxScrollAmount: Int
    get() = vgInstance.getMaxScrollAmount()

var _HorizontalScrollView.smoothScrollingEnabled: Boolean
    get() = vgInstance.isSmoothScrollingEnabled()
    set(value) = vgInstance.setSmoothScrollingEnabled(value)

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

val _LinearLayout.baseline: Int
    get() = vgInstance.getBaseline()

var _LinearLayout.baselineAligned: Boolean
    get() = vgInstance.isBaselineAligned()
    set(value) = vgInstance.setBaselineAligned(value)

var _LinearLayout.baselineAlignedChildIndex: Int
    get() = vgInstance.getBaselineAlignedChildIndex()
    set(value) = vgInstance.setBaselineAlignedChildIndex(value)

var _LinearLayout.dividerDrawable: android.graphics.drawable.Drawable?
    get() = vgInstance.getDividerDrawable()
    set(value) = vgInstance.setDividerDrawable(value!!)

var _LinearLayout.dividerPadding: Int
    get() = vgInstance.getDividerPadding()
    set(value) = vgInstance.setDividerPadding(value)

var _LinearLayout.measureWithLargestChildEnabled: Boolean
    get() = vgInstance.isMeasureWithLargestChildEnabled()
    set(value) = vgInstance.setMeasureWithLargestChildEnabled(value)

var _LinearLayout.orientation: Int
    get() = vgInstance.getOrientation()
    set(value) = vgInstance.setOrientation(value)

var _LinearLayout.showDividers: Int
    get() = vgInstance.getShowDividers()
    set(value) = vgInstance.setShowDividers(value)

var _LinearLayout.weightSum: Float
    get() = vgInstance.getWeightSum()
    set(value) = vgInstance.setWeightSum(value)

var _ListView.adapter: android.widget.ListAdapter?
    get() = vgInstance.getAdapter()
    set(value) = vgInstance.setAdapter(value!!)

val _ListView.checkItemIds: LongArray?
    get() = vgInstance.getCheckItemIds()

var _ListView.divider: android.graphics.drawable.Drawable?
    get() = vgInstance.getDivider()
    set(value) = vgInstance.setDivider(value!!)

var _ListView.dividerHeight: Int
    get() = vgInstance.getDividerHeight()
    set(value) = vgInstance.setDividerHeight(value)

val _ListView.footerViewsCount: Int
    get() = vgInstance.getFooterViewsCount()

val _ListView.headerViewsCount: Int
    get() = vgInstance.getHeaderViewsCount()

var _ListView.itemsCanFocus: Boolean
    get() = vgInstance.getItemsCanFocus()
    set(value) = vgInstance.setItemsCanFocus(value)

val _ListView.maxScrollAmount: Int
    get() = vgInstance.getMaxScrollAmount()

val _ListView.opaque: Boolean
    get() = vgInstance.isOpaque()

var _ListView.overscrollFooter: android.graphics.drawable.Drawable?
    get() = vgInstance.getOverscrollFooter()
    set(value) = vgInstance.setOverscrollFooter(value!!)

var _ListView.overscrollHeader: android.graphics.drawable.Drawable?
    get() = vgInstance.getOverscrollHeader()
    set(value) = vgInstance.setOverscrollHeader(value!!)

val _MediaController.showing: Boolean
    get() = vgInstance.isShowing()

val _NumberPicker.accessibilityNodeProvider: android.view.accessibility.AccessibilityNodeProvider?
    get() = vgInstance.getAccessibilityNodeProvider()

var _NumberPicker.displayedValues: Array<jet.String>?
    get() = vgInstance.getDisplayedValues()
    set(value) = vgInstance.setDisplayedValues(value!!)

var _NumberPicker.maxValue: Int
    get() = vgInstance.getMaxValue()
    set(value) = vgInstance.setMaxValue(value)

var _NumberPicker.minValue: Int
    get() = vgInstance.getMinValue()
    set(value) = vgInstance.setMinValue(value)

val _NumberPicker.solidColor: Int
    get() = vgInstance.getSolidColor()

var _NumberPicker.value: Int
    get() = vgInstance.getValue()
    set(value) = vgInstance.setValue(value)

var _NumberPicker.wrapSelectorWheel: Boolean
    get() = vgInstance.getWrapSelectorWheel()
    set(value) = vgInstance.setWrapSelectorWheel(value)

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

val _RadioGroup.checkedRadioButtonId: Int
    get() = vgInstance.getCheckedRadioButtonId()

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

val _RelativeLayout.baseline: Int
    get() = vgInstance.getBaseline()

var _RelativeLayout.gravity: Int
    get() = vgInstance.getGravity()
    set(value) = vgInstance.setGravity(value)

var _ScrollView.fillViewport: Boolean
    get() = vgInstance.isFillViewport()
    set(value) = vgInstance.setFillViewport(value)

val _ScrollView.maxScrollAmount: Int
    get() = vgInstance.getMaxScrollAmount()

var _ScrollView.smoothScrollingEnabled: Boolean
    get() = vgInstance.isSmoothScrollingEnabled()
    set(value) = vgInstance.setSmoothScrollingEnabled(value)

val _SearchView.iconfiedByDefault: Boolean
    get() = vgInstance.isIconfiedByDefault()

var _SearchView.iconified: Boolean
    get() = vgInstance.isIconified()
    set(value) = vgInstance.setIconified(value)

var _SearchView.imeOptions: Int
    get() = vgInstance.getImeOptions()
    set(value) = vgInstance.setImeOptions(value)

var _SearchView.inputType: Int
    get() = vgInstance.getInputType()
    set(value) = vgInstance.setInputType(value)

var _SearchView.maxWidth: Int
    get() = vgInstance.getMaxWidth()
    set(value) = vgInstance.setMaxWidth(value)

val _SearchView.query: jet.CharSequence?
    get() = vgInstance.getQuery()

var _SearchView.queryHint: jet.CharSequence?
    get() = vgInstance.getQueryHint()
    set(value) = vgInstance.setQueryHint(value!!)

var _SearchView.queryRefinementEnabled: Boolean
    get() = vgInstance.isQueryRefinementEnabled()
    set(value) = vgInstance.setQueryRefinementEnabled(value)

var _SearchView.submitButtonEnabled: Boolean
    get() = vgInstance.isSubmitButtonEnabled()
    set(value) = vgInstance.setSubmitButtonEnabled(value)

var _SearchView.suggestionsAdapter: android.widget.CursorAdapter?
    get() = vgInstance.getSuggestionsAdapter()
    set(value) = vgInstance.setSuggestionsAdapter(value!!)

val _Spinner.baseline: Int
    get() = vgInstance.getBaseline()

var _Spinner.dropDownHorizontalOffset: Int
    get() = vgInstance.getDropDownHorizontalOffset()
    set(value) = vgInstance.setDropDownHorizontalOffset(value)

var _Spinner.dropDownVerticalOffset: Int
    get() = vgInstance.getDropDownVerticalOffset()
    set(value) = vgInstance.setDropDownVerticalOffset(value)

var _Spinner.dropDownWidth: Int
    get() = vgInstance.getDropDownWidth()
    set(value) = vgInstance.setDropDownWidth(value)

var _Spinner.gravity: Int
    get() = vgInstance.getGravity()
    set(value) = vgInstance.setGravity(value)

val _Spinner.popupBackground: android.graphics.drawable.Drawable?
    get() = vgInstance.getPopupBackground()

var _Spinner.prompt: jet.CharSequence?
    get() = vgInstance.getPrompt()
    set(value) = vgInstance.setPrompt(value!!)

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

var _TabHost.currentTab: Int
    get() = vgInstance.getCurrentTab()
    set(value) = vgInstance.setCurrentTab(value)

val _TabHost.currentTabTag: jet.String?
    get() = vgInstance.getCurrentTabTag()

val _TabHost.currentTabView: android.view.View?
    get() = vgInstance.getCurrentTabView()

val _TabHost.currentView: android.view.View?
    get() = vgInstance.getCurrentView()

val _TabHost.tabContentView: android.widget.FrameLayout?
    get() = vgInstance.getTabContentView()

val _TabHost.tabWidget: android.widget.TabWidget?
    get() = vgInstance.getTabWidget()

var _TabWidget.stripEnabled: Boolean
    get() = vgInstance.isStripEnabled()
    set(value) = vgInstance.setStripEnabled(value)

val _TabWidget.tabCount: Int
    get() = vgInstance.getTabCount()

var _TableLayout.shrinkAllColumns: Boolean
    get() = vgInstance.isShrinkAllColumns()
    set(value) = vgInstance.setShrinkAllColumns(value)

var _TableLayout.stretchAllColumns: Boolean
    get() = vgInstance.isStretchAllColumns()
    set(value) = vgInstance.setStretchAllColumns(value)

val _TableRow.virtualChildCount: Int
    get() = vgInstance.getVirtualChildCount()

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

val _TimePicker._24HourView: Boolean
    get() = vgInstance.is24HourView()

val _TimePicker.baseline: Int
    get() = vgInstance.getBaseline()

var _TimePicker.currentHour: jet.Int?
    get() = vgInstance.getCurrentHour()
    set(value) = vgInstance.setCurrentHour(value!!)

var _TimePicker.currentMinute: jet.Int?
    get() = vgInstance.getCurrentMinute()
    set(value) = vgInstance.setCurrentMinute(value!!)

var _TimePicker.enabled: Boolean
    get() = vgInstance.isEnabled()
    set(value) = vgInstance.setEnabled(value)

var android.widget.ToggleButton.textOff: jet.CharSequence?
    get() = getTextOff()
    set(value) = setTextOff(value!!)

var android.widget.ToggleButton.textOn: jet.CharSequence?
    get() = getTextOn()
    set(value) = setTextOn(value!!)

val _TwoLineListItem.text1: android.widget.TextView?
    get() = vgInstance.getText1()

val _TwoLineListItem.text2: android.widget.TextView?
    get() = vgInstance.getText2()

val android.widget.VideoView.bufferPercentage: Int
    get() = getBufferPercentage()

val android.widget.VideoView.currentPosition: Int
    get() = getCurrentPosition()

val android.widget.VideoView.duration: Int
    get() = getDuration()

val android.widget.VideoView.playing: Boolean
    get() = isPlaying()

val _ViewAnimator.baseline: Int
    get() = vgInstance.getBaseline()

val _ViewAnimator.currentView: android.view.View?
    get() = vgInstance.getCurrentView()

var _ViewAnimator.displayedChild: Int
    get() = vgInstance.getDisplayedChild()
    set(value) = vgInstance.setDisplayedChild(value)

var _ViewAnimator.inAnimation: android.view.animation.Animation?
    get() = vgInstance.getInAnimation()
    set(value) = vgInstance.setInAnimation(value!!)

var _ViewAnimator.outAnimation: android.view.animation.Animation?
    get() = vgInstance.getOutAnimation()
    set(value) = vgInstance.setOutAnimation(value!!)

var _ViewFlipper.autoStart: Boolean
    get() = vgInstance.isAutoStart()
    set(value) = vgInstance.setAutoStart(value)

val _ViewFlipper.flipping: Boolean
    get() = vgInstance.isFlipping()

val _ViewSwitcher.nextView: android.view.View?
    get() = vgInstance.getNextView()

