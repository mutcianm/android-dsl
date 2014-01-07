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
fun android.app.FragmentBreadCrumbs.onBreadCrumbClick(l: (android.app.FragmentManager.BackStackEntry?, Int) -> Boolean) {
    setOnBreadCrumbClickListener(l)
}
fun android.view.ViewStub.onInflate(l: (android.view.ViewStub?, android.view.View?) -> jet.Unit) {
    setOnInflateListener(l)
}
fun android.widget.TextView.onEditorAction(l: (android.widget.TextView?, Int, android.view.KeyEvent?) -> Boolean) {
    setOnEditorActionListener(l)
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
fun android.widget.NumberPicker.onValueChanged(l: (android.widget.NumberPicker?, Int, Int) -> jet.Unit) {
    setOnValueChangedListener(l)
}
fun android.widget.NumberPicker.onScroll(l: (android.widget.NumberPicker?, Int) -> jet.Unit) {
    setOnScrollListener(l)
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
fun android.widget.SearchView.onClose(l: () -> Boolean) {
    setOnCloseListener(l)
}
fun android.widget.SearchView.onQueryTextFocusChange(l: (android.view.View?, Boolean) -> jet.Unit) {
    setOnQueryTextFocusChangeListener(l)
}
fun android.widget.SearchView.onSearchClick(l: (android.view.View?) -> jet.Unit) {
    setOnSearchClickListener(l)
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
fun android.widget.CompoundButton.onCheckedChange(l: (android.widget.CompoundButton?, Boolean) -> jet.Unit) {
    setOnCheckedChangeListener(l)
}
fun android.widget.AutoCompleteTextView.onClick(l: (android.view.View?) -> jet.Unit) {
    setOnClickListener(l)
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
