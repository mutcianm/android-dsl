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
    var onStart: (p0: jet.String?) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
    var onDone: (p0: jet.String?) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
    var onError: (p0: jet.String?) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.speech.tts.TextToSpeech.onUtteranceProgress(init: __TextToSpeechUtteranceProgressListener.() -> Unit) {
    val wrapper = __TextToSpeechUtteranceProgressListener()
    wrapper.init()
    val listener = object: android.speech.tts.UtteranceProgressListener() {
        override fun onStart(p0: jet.String?) {
            wrapper.onStart(p0!!)
        }
        override fun onDone(p0: jet.String?) {
            wrapper.onDone(p0!!)
        }
        override fun onError(p0: jet.String?) {
            wrapper.onError(p0!!)
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
    var onMenuItemActionExpand: (p0: android.view.MenuItem?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
    var onMenuItemActionCollapse: (p0: android.view.MenuItem?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.view.MenuItem.onActionExpand(init: __MenuItemOnActionExpandListener.() -> Unit) {
    val wrapper = __MenuItemOnActionExpandListener()
    wrapper.init()
    val listener = object: android.view.MenuItem.OnActionExpandListener {
        override fun onMenuItemActionExpand(p0: android.view.MenuItem?): Boolean {
            return wrapper.onMenuItemActionExpand(p0!!)
        }
        override fun onMenuItemActionCollapse(p0: android.view.MenuItem?): Boolean {
            return wrapper.onMenuItemActionCollapse(p0!!)
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
    var onSingleTapConfirmed: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
    var onDoubleTap: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
    var onDoubleTapEvent: (p0: android.view.MotionEvent?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.view.GestureDetector.onDoubleTap(init: __GestureDetectorOnDoubleTapListener.() -> Unit) {
    val wrapper = __GestureDetectorOnDoubleTapListener()
    wrapper.init()
    val listener = object: android.view.GestureDetector.OnDoubleTapListener {
        override fun onSingleTapConfirmed(p0: android.view.MotionEvent?): Boolean {
            return wrapper.onSingleTapConfirmed(p0!!)
        }
        override fun onDoubleTap(p0: android.view.MotionEvent?): Boolean {
            return wrapper.onDoubleTap(p0!!)
        }
        override fun onDoubleTapEvent(p0: android.view.MotionEvent?): Boolean {
            return wrapper.onDoubleTapEvent(p0!!)
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

fun android.widget.ListPopupWindow.onDismiss(l: () -> jet.Unit) {
    setOnDismissListener(l)
}

class __ZoomButtonsControllerOnZoomListener {
    var onVisibilityChanged: (p0: Boolean) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
    var onZoom: (p0: Boolean) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.ZoomButtonsController.onZoom(init: __ZoomButtonsControllerOnZoomListener.() -> Unit) {
    val wrapper = __ZoomButtonsControllerOnZoomListener()
    wrapper.init()
    val listener = object: android.widget.ZoomButtonsController.OnZoomListener {
        override fun onVisibilityChanged(p0: Boolean) {
            wrapper.onVisibilityChanged(p0)
        }
        override fun onZoom(p0: Boolean) {
            wrapper.onZoom(p0)
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
    var onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
    var onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
}

fun android.view.ViewGroup.onHierarchyChange(init: __ViewGroupOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __ViewGroupOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewRemoved(p0!!, p1!!)
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
    var onScrollStateChanged: (p0: android.widget.AbsListView?, p1: Int) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
    var onScroll: (p0: android.widget.AbsListView?, p1: Int, p2: Int, p3: Int) -> jet.Unit = { p0, p1, p2, p3 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.AbsListView.onScroll(init: __AbsListViewOnScrollListener.() -> Unit) {
    val wrapper = __AbsListViewOnScrollListener()
    wrapper.init()
    val listener = object: android.widget.AbsListView.OnScrollListener {
        override fun onScrollStateChanged(p0: android.widget.AbsListView?, p1: Int) {
            wrapper.onScrollStateChanged(p0!!, p1)
        }
        override fun onScroll(p0: android.widget.AbsListView, p1: Int, p2: Int, p3: Int) {
            wrapper.onScroll(p0!!, p1, p2, p3)
        }
    }
    setOnScrollListener(listener)
}

class __TableLayoutOnHierarchyChangeListener {
    var onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
    var onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.TableLayout.onHierarchyChange(init: __TableLayoutOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __TableLayoutOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewRemoved(p0!!, p1!!)
        }
    }
    setOnHierarchyChangeListener(listener)
}

class __TableRowOnHierarchyChangeListener {
    var onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
    var onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.TableRow.onHierarchyChange(init: __TableRowOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __TableRowOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewRemoved(p0!!, p1!!)
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
    var onChildViewAdded: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
    var onChildViewRemoved: (p0: android.view.View?, p1: android.view.View?) -> jet.Unit = { p0, p1 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.RadioGroup.onHierarchyChange(init: __RadioGroupOnHierarchyChangeListener.() -> Unit) {
    val wrapper = __RadioGroupOnHierarchyChangeListener()
    wrapper.init()
    val listener = object: android.view.ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewAdded(p0!!, p1!!)
        }
        override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) {
            wrapper.onChildViewRemoved(p0!!, p1!!)
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
    var onQueryTextSubmit: (p0: jet.String?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
    var onQueryTextChange: (p0: jet.String?) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.SearchView.onQueryText(init: __SearchViewOnQueryTextListener.() -> Unit) {
    val wrapper = __SearchViewOnQueryTextListener()
    wrapper.init()
    val listener = object: android.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: jet.String?): Boolean {
            return wrapper.onQueryTextSubmit(p0!!)
        }
        override fun onQueryTextChange(p0: jet.String?): Boolean {
            return wrapper.onQueryTextChange(p0!!)
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
    var onSuggestionSelect: (p0: Int) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
    var onSuggestionClick: (p0: Int) -> Boolean = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.SearchView.onSuggestion(init: __SearchViewOnSuggestionListener.() -> Unit) {
    val wrapper = __SearchViewOnSuggestionListener()
    wrapper.init()
    val listener = object: android.widget.SearchView.OnSuggestionListener {
        override fun onSuggestionSelect(p0: Int): Boolean {
            return wrapper.onSuggestionSelect(p0)
        }
        override fun onSuggestionClick(p0: Int): Boolean {
            return wrapper.onSuggestionClick(p0)
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

class __SeekBarOnSeekBarChangeListener {
    var onProgressChanged: (p0: android.widget.SeekBar?, p1: Int, p2: Boolean) -> jet.Unit = { p0, p1, p2 -> throw RuntimeException("Method not overriden") }
    var onStartTrackingTouch: (p0: android.widget.SeekBar?) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
    var onStopTrackingTouch: (p0: android.widget.SeekBar?) -> jet.Unit = { p0 -> throw RuntimeException("Method not overriden") }
}

fun android.widget.SeekBar.onSeekBarChange(init: __SeekBarOnSeekBarChangeListener.() -> Unit) {
    val wrapper = __SeekBarOnSeekBarChangeListener()
    wrapper.init()
    val listener = object: android.widget.SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: android.widget.SeekBar, p1: Int, p2: Boolean) {
            wrapper.onProgressChanged(p0!!, p1, p2)
        }
        override fun onStartTrackingTouch(p0: android.widget.SeekBar?) {
            wrapper.onStartTrackingTouch(p0!!)
        }
        override fun onStopTrackingTouch(p0: android.widget.SeekBar) {
            wrapper.onStopTrackingTouch(p0!!)
        }
    }
    setOnSeekBarChangeListener(listener)
}

fun android.widget.RatingBar.onRatingBarChange(l: (android.widget.RatingBar?, Float, Boolean) -> jet.Unit) {
    setOnRatingBarChangeListener(l)
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

