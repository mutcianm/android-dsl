fun android.app.SearchManager.onDismiss(l: () -> jet.Unit) {
    setOnDismissListener(l)
}

fun android.app.SearchManager.onCancel(l: () -> jet.Unit) {
    setOnCancelListener(l)
}

fun android.app.AlertDialog.Builder.onCancel(l: (android.content.DialogInterface?) -> jet.Unit) {
    setOnCancelListener(l)
}

fun android.app.AlertDialog.Builder.onKey(l: (android.content.DialogInterface?, Int, android.view.KeyEvent?) -> Boolean) {
    setOnKeyListener(l)
}

class __BuilderOnItemSelectedListener {
    var _onItemSelected: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit = { p0, p1, p2, p3 ->  }
    fun onItemSelected(f : (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit) { _onItemSelected = f }
    var _onNothingSelected: (p0: android.widget.AdapterView<*>?) -> jet.Unit = { p0 ->  }
    fun onNothingSelected(f : (p0: android.widget.AdapterView<*>?) -> jet.Unit) { _onNothingSelected = f }
}

fun android.app.AlertDialog.Builder.onItemSelected(init: __BuilderOnItemSelectedListener.() -> Unit) {
    val wrapper = __BuilderOnItemSelectedListener()
    wrapper.init()
    val listener = object: android.widget.AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) {
            wrapper._onItemSelected(p0!!, p1!!, p2, p3)
        }
        override fun onNothingSelected(p0: android.widget.AdapterView<*>?) {
            wrapper._onNothingSelected(p0!!)
        }
    }
    setOnItemSelectedListener(listener)
}

fun android.app.Dialog.onCancel(l: (android.content.DialogInterface?) -> jet.Unit) {
    setOnCancelListener(l)
}

fun android.app.Dialog.onDismiss(l: (android.content.DialogInterface?) -> jet.Unit) {
    setOnDismissListener(l)
}

fun android.app.Dialog.onShow(l: (android.content.DialogInterface?) -> jet.Unit) {
    setOnShowListener(l)
}

fun android.app.Dialog.onKey(l: (android.content.DialogInterface?, Int, android.view.KeyEvent?) -> Boolean) {
    setOnKeyListener(l)
}

fun android.preference.Preference.onPreferenceChange(l: (android.preference.Preference?, jet.Any?) -> Boolean) {
    setOnPreferenceChangeListener(l)
}

fun android.preference.Preference.onPreferenceClick(l: (android.preference.Preference?) -> Boolean) {
    setOnPreferenceClickListener(l)
}

fun android.os.CancellationSignal.onCancel(l: () -> jet.Unit) {
    setOnCancelListener(l)
}

fun android.graphics.SurfaceTexture.onFrameAvailable(l: (android.graphics.SurfaceTexture?) -> jet.Unit) {
    setOnFrameAvailableListener(l)
}

fun android.speech.tts.TextToSpeech.onUtteranceCompleted(l: (jet.String?) -> jet.Unit) {
    setOnUtteranceCompletedListener(l)
}

class __TextToSpeechUtteranceProgressListener {
    var _onStart: (p0: jet.String?) -> jet.Unit = { p0 ->  }
    fun onStart(f : (p0: jet.String?) -> jet.Unit) { _onStart = f }
    var _onDone: (p0: jet.String?) -> jet.Unit = { p0 ->  }
    fun onDone(f : (p0: jet.String?) -> jet.Unit) { _onDone = f }
    var _onError: (p0: jet.String?) -> jet.Unit = { p0 ->  }
    fun onError(f : (p0: jet.String?) -> jet.Unit) { _onError = f }
}

fun android.speech.tts.TextToSpeech.onUtteranceProgress(init: __TextToSpeechUtteranceProgressListener.() -> Unit) {
    val wrapper = __TextToSpeechUtteranceProgressListener()
    wrapper.init()
    val listener = object: android.speech.tts.UtteranceProgressListener() {
        override fun onStart(p0: jet.String?) {
            wrapper._onStart(p0!!)
        }
        override fun onDone(p0: jet.String?) {
            wrapper._onDone(p0!!)
        }
        override fun onError(p0: jet.String?) {
            wrapper._onError(p0!!)
        }
    }
    setOnUtteranceProgressListener(listener)
}

fun android.drm.DrmManagerClient.onInfo(l: (android.drm.DrmManagerClient?, android.drm.DrmInfoEvent?) -> jet.Unit) {
    setOnInfoListener(l)
}

fun android.drm.DrmManagerClient.onEvent(l: (android.drm.DrmManagerClient?, android.drm.DrmEvent?) -> jet.Unit) {
    setOnEventListener(l)
}

fun android.drm.DrmManagerClient.onError(l: (android.drm.DrmManagerClient?, android.drm.DrmErrorEvent?) -> jet.Unit) {
    setOnErrorListener(l)
}

fun android.media.SoundPool.onLoadComplete(l: (android.media.SoundPool?, Int, Int) -> jet.Unit) {
    setOnLoadCompleteListener(l)
}

fun android.media.MediaRecorder.onError(l: (android.media.MediaRecorder?, Int, Int) -> jet.Unit) {
    setOnErrorListener(l)
}

fun android.media.MediaRecorder.onInfo(l: (android.media.MediaRecorder?, Int, Int) -> jet.Unit) {
    setOnInfoListener(l)
}

fun android.media.MediaPlayer.onPrepared(l: (android.media.MediaPlayer?) -> jet.Unit) {
    setOnPreparedListener(l)
}

fun android.media.MediaPlayer.onCompletion(l: (android.media.MediaPlayer?) -> jet.Unit) {
    setOnCompletionListener(l)
}

fun android.media.MediaPlayer.onBufferingUpdate(l: (android.media.MediaPlayer?, Int) -> jet.Unit) {
    setOnBufferingUpdateListener(l)
}

fun android.media.MediaPlayer.onSeekComplete(l: (android.media.MediaPlayer?) -> jet.Unit) {
    setOnSeekCompleteListener(l)
}

fun android.media.MediaPlayer.onVideoSizeChanged(l: (android.media.MediaPlayer?, Int, Int) -> jet.Unit) {
    setOnVideoSizeChangedListener(l)
}

fun android.media.MediaPlayer.onTimedText(l: (android.media.MediaPlayer?, android.media.TimedText?) -> jet.Unit) {
    setOnTimedTextListener(l)
}

fun android.media.MediaPlayer.onError(l: (android.media.MediaPlayer?, Int, Int) -> Boolean) {
    setOnErrorListener(l)
}

fun android.media.MediaPlayer.onInfo(l: (android.media.MediaPlayer?, Int, Int) -> Boolean) {
    setOnInfoListener(l)
}

fun android.view.MenuItem.onMenuItemClick(l: (android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

class __MenuItemOnActionExpandListener {
    var _onMenuItemActionExpand: (p0: android.view.MenuItem?) -> Boolean = { p0 -> false }
    fun onMenuItemActionExpand(f : (p0: android.view.MenuItem?) -> Boolean) { _onMenuItemActionExpand = f }
    var _onMenuItemActionCollapse: (p0: android.view.MenuItem?) -> Boolean = { p0 -> false }
    fun onMenuItemActionCollapse(f : (p0: android.view.MenuItem?) -> Boolean) { _onMenuItemActionCollapse = f }
}

fun android.view.MenuItem.onActionExpand(init: __MenuItemOnActionExpandListener.() -> Unit) {
    val wrapper = __MenuItemOnActionExpandListener()
    wrapper.init()
    val listener = object: android.view.MenuItem.OnActionExpandListener {
        override fun onMenuItemActionExpand(p0: android.view.MenuItem?): Boolean {
            return wrapper._onMenuItemActionExpand(p0!!)
        }
        override fun onMenuItemActionCollapse(p0: android.view.MenuItem?): Boolean {
            return wrapper._onMenuItemActionCollapse(p0!!)
        }
    }
    setOnActionExpandListener(listener)
}

fun android.view.View.onFocusChange(l: (android.view.View?, Boolean) -> jet.Unit) {
    setOnFocusChangeListener(l)
}

fun android.view.View.onClick(l: (android.view.View?) -> jet.Unit) {
    setOnClickListener(l)
}

fun android.view.View.onLongClick(l: (android.view.View?) -> Boolean) {
    setOnLongClickListener(l)
}

fun android.view.View.onCreateContextMenu(l: (android.view.ContextMenu?, android.view.View?, android.view.ContextMenu.ContextMenuInfo?) -> jet.Unit) {
    setOnCreateContextMenuListener(l)
}

fun android.view.View.onKey(l: (android.view.View?, Int, android.view.KeyEvent?) -> Boolean) {
    setOnKeyListener(l)
}

fun android.view.View.onTouch(l: (android.view.View?, android.view.MotionEvent?) -> Boolean) {
    setOnTouchListener(l)
}

fun android.view.View.onGenericMotion(l: (android.view.View?, android.view.MotionEvent?) -> Boolean) {
    setOnGenericMotionListener(l)
}

fun android.view.View.onHover(l: (android.view.View?, android.view.MotionEvent?) -> Boolean) {
    setOnHoverListener(l)
}

fun android.view.View.onDrag(l: (android.view.View?, android.view.DragEvent?) -> Boolean) {
    setOnDragListener(l)
}

fun android.view.View.onSystemUiVisibilityChange(l: (Int) -> jet.Unit) {
    setOnSystemUiVisibilityChangeListener(l)
}

class __GestureDetectorOnDoubleTapListener {
    var _onSingleTapConfirmed: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> false }
    fun onSingleTapConfirmed(f : (p0: android.view.MotionEvent?) -> Boolean) { _onSingleTapConfirmed = f }
    var _onDoubleTap: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> false }
    fun onDoubleTap(f : (p0: android.view.MotionEvent?) -> Boolean) { _onDoubleTap = f }
    var _onDoubleTapEvent: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> false }
    fun onDoubleTapEvent(f : (p0: android.view.MotionEvent?) -> Boolean) { _onDoubleTapEvent = f }
}

fun android.view.GestureDetector.onDoubleTap(init: __GestureDetectorOnDoubleTapListener.() -> Unit) {
    val wrapper = __GestureDetectorOnDoubleTapListener()
    wrapper.init()
    val listener = object: android.view.GestureDetector.OnDoubleTapListener {
        override fun onSingleTapConfirmed(p0: android.view.MotionEvent?): Boolean {
            return wrapper._onSingleTapConfirmed(p0!!)
        }
        override fun onDoubleTap(p0: android.view.MotionEvent?): Boolean {
            return wrapper._onDoubleTap(p0!!)
        }
        override fun onDoubleTapEvent(p0: android.view.MotionEvent?): Boolean {
            return wrapper._onDoubleTapEvent(p0!!)
        }
    }
    setOnDoubleTapListener(listener)
}

fun android.widget.PopupMenu.onMenuItemClick(l: (android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

fun android.widget.PopupMenu.onDismiss(l: (android.widget.PopupMenu?) -> jet.Unit) {
    setOnDismissListener(l)
}

fun android.widget.ListPopupWindow.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> jet.Unit) {
    setOnItemClickListener(l)
}

class __ListPopupWindowOnItemSelectedListener {
    var _onItemSelected: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit = { p0, p1, p2, p3 ->  }
    fun onItemSelected(f : (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit) { _onItemSelected = f }
    var _onNothingSelected: (p0: android.widget.AdapterView<*>?) -> jet.Unit = { p0 ->  }
    fun onNothingSelected(f : (p0: android.widget.AdapterView<*>?) -> jet.Unit) { _onNothingSelected = f }
}

fun android.widget.ListPopupWindow.onItemSelected(init: __ListPopupWindowOnItemSelectedListener.() -> Unit) {
    val wrapper = __ListPopupWindowOnItemSelectedListener()
    wrapper.init()
    val listener = object: android.widget.AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) {
            wrapper._onItemSelected(p0!!, p1!!, p2, p3)
        }
        override fun onNothingSelected(p0: android.widget.AdapterView<*>?) {
            wrapper._onNothingSelected(p0!!)
        }
    }
    setOnItemSelectedListener(listener)
}

fun android.widget.ListPopupWindow.onDismiss(l: () -> jet.Unit) {
    setOnDismissListener(l)
}

class __ZoomButtonsControllerOnZoomListener {
    var _onVisibilityChanged: (p0: Boolean) -> jet.Unit = { p0 ->  }
    fun onVisibilityChanged(f : (p0: Boolean) -> jet.Unit) { _onVisibilityChanged = f }
    var _onZoom: (p0: Boolean) -> jet.Unit = { p0 ->  }
    fun onZoom(f : (p0: Boolean) -> jet.Unit) { _onZoom = f }
}

fun android.widget.ZoomButtonsController.onZoom(init: __ZoomButtonsControllerOnZoomListener.() -> Unit) {
    val wrapper = __ZoomButtonsControllerOnZoomListener()
    wrapper.init()
    val listener = object: android.widget.ZoomButtonsController.OnZoomListener {
        override fun onVisibilityChanged(p0: Boolean) {
            wrapper._onVisibilityChanged(p0)
        }
        override fun onZoom(p0: Boolean) {
            wrapper._onZoom(p0)
        }
    }
    setOnZoomListener(listener)
}

fun android.widget.PopupWindow.onDismiss(l: () -> jet.Unit) {
    setOnDismissListener(l)
}

fun android.widget.ShareActionProvider.onShareTargetSelected(l: (android.widget.ShareActionProvider?, android.content.Intent?) -> Boolean) {
    setOnShareTargetSelectedListener(l)
}

fun android.view.ViewStub.onInflate(l: (android.view.ViewStub?, android.view.View?) -> jet.Unit) {
    setOnInflateListener(l)
}

class __ViewGroupOnHierarchyChangeListener {
    var _onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewAdded(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewAdded = f }
    var _onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewRemoved(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewRemoved = f }
}

fun android.view.ViewGroup.onHierarchyChange(init: __ViewGroupOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __ViewGroupOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewRemoved(p0!!, p1!!)
        }
    }
    setOnHierarchyChangeListener(listener)
}

fun android.widget.TextView.onEditorAction(l: (android.widget.TextView?, Int, android.view.KeyEvent?) -> Boolean) {
    setOnEditorActionListener(l)
}

fun android.app.FragmentBreadCrumbs.onBreadCrumbClick(l: (android.app.FragmentManager.BackStackEntry?, Int) -> Boolean) {
    setOnBreadCrumbClickListener(l)
}

fun android.widget.VideoView.onPrepared(l: (android.media.MediaPlayer?) -> jet.Unit) {
    setOnPreparedListener(l)
}

fun android.widget.VideoView.onCompletion(l: (android.media.MediaPlayer?) -> jet.Unit) {
    setOnCompletionListener(l)
}

fun android.widget.VideoView.onError(l: (android.media.MediaPlayer?, Int, Int) -> Boolean) {
    setOnErrorListener(l)
}

fun android.widget.Chronometer.onChronometerTick(l: (android.widget.Chronometer?) -> jet.Unit) {
    setOnChronometerTickListener(l)
}

fun android.widget.CalendarView.onDateChange(l: (android.widget.CalendarView?, Int, Int, Int) -> jet.Unit) {
    setOnDateChangeListener(l)
}

fun android.widget.TimePicker.onTimeChanged(l: (android.widget.TimePicker?, Int, Int) -> jet.Unit) {
    setOnTimeChangedListener(l)
}

fun android.widget.TabHost.onTabChanged(l: (jet.String?) -> jet.Unit) {
    setOnTabChangedListener(l)
}

class __AbsListViewOnScrollListener {
    var _onScrollStateChanged: (p0: android.widget.AbsListView?, p1: Int) -> jet.Unit = { p0, p1 ->  }
    fun onScrollStateChanged(f : (p0: android.widget.AbsListView?, p1: Int) -> jet.Unit) { _onScrollStateChanged = f }
    var _onScroll: (p0: android.widget.AbsListView?, p1: Int, p2: Int, p3: Int) -> jet.Unit = { p0, p1, p2, p3 ->  }
    fun onScroll(f : (p0: android.widget.AbsListView?, p1: Int, p2: Int, p3: Int) -> jet.Unit) { _onScroll = f }
}

fun android.widget.AbsListView.onScroll(init: __AbsListViewOnScrollListener.() -> Unit) {
    val wrapper = __AbsListViewOnScrollListener()
    wrapper.init()
    val listener = object: android.widget.AbsListView.OnScrollListener {
        override fun onScrollStateChanged(p0: android.widget.AbsListView?, p1: Int) {
            wrapper._onScrollStateChanged(p0!!, p1)
        }
        override fun onScroll(p0: android.widget.AbsListView?, p1: Int, p2: Int, p3: Int) {
            wrapper._onScroll(p0!!, p1, p2, p3)
        }
    }
    setOnScrollListener(listener)
}

class __TableLayoutOnHierarchyChangeListener {
    var _onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewAdded(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewAdded = f }
    var _onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewRemoved(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewRemoved = f }
}

fun android.widget.TableLayout.onHierarchyChange(init: __TableLayoutOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __TableLayoutOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewRemoved(p0!!, p1!!)
        }
    }
    setOnHierarchyChangeListener(listener)
}

class __TableRowOnHierarchyChangeListener {
    var _onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewAdded(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewAdded = f }
    var _onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewRemoved(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewRemoved = f }
}

fun android.widget.TableRow.onHierarchyChange(init: __TableRowOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __TableRowOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewRemoved(p0!!, p1!!)
        }
    }
    setOnHierarchyChangeListener(listener)
}

fun android.widget.NumberPicker.onValueChanged(l: (android.widget.NumberPicker?, Int, Int) -> jet.Unit) {
    setOnValueChangedListener(l)
}

fun android.widget.NumberPicker.onScroll(l: (android.widget.NumberPicker?, Int) -> jet.Unit) {
    setOnScrollListener(l)
}

class __RadioGroupOnHierarchyChangeListener {
    var _onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewAdded(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewAdded = f }
    var _onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 ->  }
    fun onChildViewRemoved(f : (p0: android.view.View?, p1: android.view.View?) -> jet.Unit) { _onChildViewRemoved = f }
}

fun android.widget.RadioGroup.onHierarchyChange(init: __RadioGroupOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __RadioGroupOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper._onChildViewRemoved(p0!!, p1!!)
        }
    }
    setOnHierarchyChangeListener(listener)
}

fun android.widget.RadioGroup.onCheckedChange(l: (android.widget.RadioGroup?, Int) -> jet.Unit) {
    setOnCheckedChangeListener(l)
}

fun android.widget.ZoomControls.onZoomInClick(l: (android.view.View?) -> jet.Unit) {
    setOnZoomInClickListener(l)
}

fun android.widget.ZoomControls.onZoomOutClick(l: (android.view.View?) -> jet.Unit) {
    setOnZoomOutClickListener(l)
}

class __SearchViewOnQueryTextListener {
    var _onQueryTextSubmit: (p0: jet.String?) -> Boolean = { p0 -> false }
    fun onQueryTextSubmit(f : (p0: jet.String?) -> Boolean) { _onQueryTextSubmit = f }
    var _onQueryTextChange: (p0: jet.String?) -> Boolean = { p0 -> false }
    fun onQueryTextChange(f : (p0: jet.String?) -> Boolean) { _onQueryTextChange = f }
}

fun android.widget.SearchView.onQueryText(init: __SearchViewOnQueryTextListener.() -> Unit) {
    val wrapper = __SearchViewOnQueryTextListener()
    wrapper.init()
    val listener = object: android.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: jet.String?): Boolean {
            return wrapper._onQueryTextSubmit(p0!!)
        }
        override fun onQueryTextChange(p0: jet.String?): Boolean {
            return wrapper._onQueryTextChange(p0!!)
        }
    }
    setOnQueryTextListener(listener)
}

fun android.widget.SearchView.onClose(l: () -> Boolean) {
    setOnCloseListener(l)
}

fun android.widget.SearchView.onQueryTextFocusChange(l: (android.view.View?, Boolean) -> jet.Unit) {
    setOnQueryTextFocusChangeListener(l)
}

class __SearchViewOnSuggestionListener {
    var _onSuggestionSelect: (p0: Int) -> Boolean = { p0 -> false }
    fun onSuggestionSelect(f : (p0: Int) -> Boolean) { _onSuggestionSelect = f }
    var _onSuggestionClick: (p0: Int) -> Boolean = { p0 -> false }
    fun onSuggestionClick(f : (p0: Int) -> Boolean) { _onSuggestionClick = f }
}

fun android.widget.SearchView.onSuggestion(init: __SearchViewOnSuggestionListener.() -> Unit) {
    val wrapper = __SearchViewOnSuggestionListener()
    wrapper.init()
    val listener = object: android.widget.SearchView.OnSuggestionListener {
        override fun onSuggestionSelect(p0: Int): Boolean {
            return wrapper._onSuggestionSelect(p0)
        }
        override fun onSuggestionClick(p0: Int): Boolean {
            return wrapper._onSuggestionClick(p0)
        }
    }
    setOnSuggestionListener(listener)
}

fun android.widget.SearchView.onSearchClick(l: (android.view.View?) -> jet.Unit) {
    setOnSearchClickListener(l)
}

fun android.widget.CompoundButton.onCheckedChange(l: (android.widget.CompoundButton?, Boolean) -> jet.Unit) {
    setOnCheckedChangeListener(l)
}

fun android.widget.AutoCompleteTextView.onClick(l: (android.view.View?) -> jet.Unit) {
    setOnClickListener(l)
}

fun android.widget.AutoCompleteTextView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> jet.Unit) {
    setOnItemClickListener(l)
}

class __AutoCompleteTextViewOnItemSelectedListener {
    var _onItemSelected: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit = { p0, p1, p2, p3 ->  }
    fun onItemSelected(f : (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> jet.Unit) { _onItemSelected = f }
    var _onNothingSelected: (p0: android.widget.AdapterView<*>?) -> jet.Unit = { p0 ->  }
    fun onNothingSelected(f : (p0: android.widget.AdapterView<*>?) -> jet.Unit) { _onNothingSelected = f }
}

fun android.widget.AutoCompleteTextView.onItemSelected(init: __AutoCompleteTextViewOnItemSelectedListener.() -> Unit) {
    val wrapper = __AutoCompleteTextViewOnItemSelectedListener()
    wrapper.init()
    val listener = object: android.widget.AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) {
            wrapper._onItemSelected(p0!!, p1!!, p2, p3)
        }
        override fun onNothingSelected(p0: android.widget.AdapterView<*>?) {
            wrapper._onNothingSelected(p0!!)
        }
    }
    setOnItemSelectedListener(listener)
}

class __SeekBarOnSeekBarChangeListener {
    var _onProgressChanged: (p0: android.widget.SeekBar?, p1: Int, p2: Boolean) -> jet.Unit = { p0, p1, p2 ->  }
    fun onProgressChanged(f : (p0: android.widget.SeekBar?, p1: Int, p2: Boolean) -> jet.Unit) { _onProgressChanged = f }
    var _onStartTrackingTouch: (p0: android.widget.SeekBar?) -> jet.Unit = { p0 ->  }
    fun onStartTrackingTouch(f : (p0: android.widget.SeekBar?) -> jet.Unit) { _onStartTrackingTouch = f }
    var _onStopTrackingTouch: (p0: android.widget.SeekBar?) -> jet.Unit = { p0 ->  }
    fun onStopTrackingTouch(f : (p0: android.widget.SeekBar?) -> jet.Unit) { _onStopTrackingTouch = f }
}

fun android.widget.SeekBar.onSeekBarChange(init: __SeekBarOnSeekBarChangeListener.() -> Unit) {
    val wrapper = __SeekBarOnSeekBarChangeListener()
    wrapper.init()
    val listener = object: android.widget.SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: android.widget.SeekBar?, p1: Int, p2: Boolean) {
            wrapper._onProgressChanged(p0!!, p1, p2)
        }
        override fun onStartTrackingTouch(p0: android.widget.SeekBar?) {
            wrapper._onStartTrackingTouch(p0!!)
        }
        override fun onStopTrackingTouch(p0: android.widget.SeekBar?) {
            wrapper._onStopTrackingTouch(p0!!)
        }
    }
    setOnSeekBarChangeListener(listener)
}

fun android.widget.RatingBar.onRatingBarChange(l: (android.widget.RatingBar?, Float, Boolean) -> jet.Unit) {
    setOnRatingBarChangeListener(l)
}

fun android.widget.Spinner.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> jet.Unit) {
    setOnItemClickListener(l)
}

fun android.widget.ExpandableListView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> jet.Unit) {
    setOnItemClickListener(l)
}

fun android.widget.ExpandableListView.onGroupCollapse(l: (Int) -> jet.Unit) {
    setOnGroupCollapseListener(l)
}

fun android.widget.ExpandableListView.onGroupExpand(l: (Int) -> jet.Unit) {
    setOnGroupExpandListener(l)
}

fun android.widget.ExpandableListView.onGroupClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Long) -> Boolean) {
    setOnGroupClickListener(l)
}

fun android.widget.ExpandableListView.onChildClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Int, Long) -> Boolean) {
    setOnChildClickListener(l)
}

