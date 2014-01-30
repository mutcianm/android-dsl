class _FragmentBreadCrumbs(vgInstance: android.app.FragmentBreadCrumbs, ctx: android.app.Activity): _Container<android.app.FragmentBreadCrumbs>(vgInstance, ctx) {

}

class _RelativeLayout(vgInstance: android.widget.RelativeLayout, ctx: android.app.Activity): _Container<android.widget.RelativeLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(w, h)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _AbsoluteLayout(vgInstance: android.widget.AbsoluteLayout, ctx: android.app.Activity): _Container<android.widget.AbsoluteLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(width: Int, height: Int, x: Int, y: Int, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(width, height, x, y)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _FrameLayout(vgInstance: android.widget.FrameLayout, ctx: android.app.Activity): _Container<android.widget.FrameLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, gravity: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _LinearLayout(vgInstance: android.widget.LinearLayout, ctx: android.app.Activity): _Container<android.widget.LinearLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, weight: Float, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(width, height, weight)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p: android.view.ViewGroup.LayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _GridLayout(vgInstance: android.widget.GridLayout, ctx: android.app.Activity): _Container<android.widget.GridLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(rowSpec: android.widget.GridLayout.Spec?, columnSpec: android.widget.GridLayout.Spec?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(params: android.view.ViewGroup.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(params!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(params: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(params!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(that: android.widget.GridLayout.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(that!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(context: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(context!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _TwoLineListItem(vgInstance: android.widget.TwoLineListItem, ctx: android.app.Activity): _Container<android.widget.TwoLineListItem>(vgInstance, ctx) {

}

class _DialerFilter(vgInstance: android.widget.DialerFilter, ctx: android.app.Activity): _Container<android.widget.DialerFilter>(vgInstance, ctx) {

}

class _AppWidgetHostView(vgInstance: android.appwidget.AppWidgetHostView, ctx: android.app.Activity): _Container<android.appwidget.AppWidgetHostView>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, gravity: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _GestureOverlayView(vgInstance: android.gesture.GestureOverlayView, ctx: android.app.Activity): _Container<android.gesture.GestureOverlayView>(vgInstance, ctx) {

}

class _CalendarView(vgInstance: android.widget.CalendarView, ctx: android.app.Activity): _Container<android.widget.CalendarView>(vgInstance, ctx) {

}

class _HorizontalScrollView(vgInstance: android.widget.HorizontalScrollView, ctx: android.app.Activity): _Container<android.widget.HorizontalScrollView>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ScrollView(vgInstance: android.widget.ScrollView, ctx: android.app.Activity): _Container<android.widget.ScrollView>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _DatePicker(vgInstance: android.widget.DatePicker, ctx: android.app.Activity): _Container<android.widget.DatePicker>(vgInstance, ctx) {

}

class _TimePicker(vgInstance: android.widget.TimePicker, ctx: android.app.Activity): _Container<android.widget.TimePicker>(vgInstance, ctx) {

}

class _TabHost(vgInstance: android.widget.TabHost, ctx: android.app.Activity): _Container<android.widget.TabHost>(vgInstance, ctx) {

}

class _ViewAnimator(vgInstance: android.widget.ViewAnimator, ctx: android.app.Activity): _Container<android.widget.ViewAnimator>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _MediaController(vgInstance: android.widget.MediaController, ctx: android.app.Activity): _Container<android.widget.MediaController>(vgInstance, ctx) {

}

class _TableLayout(vgInstance: android.widget.TableLayout, ctx: android.app.Activity): _Container<android.widget.TableLayout>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(w, h)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, initWeight: Float, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(w, h, initWeight)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p: android.view.ViewGroup.LayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _TableRow(vgInstance: android.widget.TableRow, ctx: android.app.Activity): _Container<android.widget.TableRow>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(w, h)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, initWeight: Float, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(w, h, initWeight)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(column: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(column)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p: android.view.ViewGroup.LayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _NumberPicker(vgInstance: android.widget.NumberPicker, ctx: android.app.Activity): _Container<android.widget.NumberPicker>(vgInstance, ctx) {

}

class _TabWidget(vgInstance: android.widget.TabWidget, ctx: android.app.Activity): _Container<android.widget.TabWidget>(vgInstance, ctx) {

}

class _RadioGroup(vgInstance: android.widget.RadioGroup, ctx: android.app.Activity): _Container<android.widget.RadioGroup>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(w, h)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, initWeight: Float, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(w, h, initWeight)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p: android.view.ViewGroup.LayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ZoomControls(vgInstance: android.widget.ZoomControls, ctx: android.app.Activity): _Container<android.widget.ZoomControls>(vgInstance, ctx) {

}

class _SearchView(vgInstance: android.widget.SearchView, ctx: android.app.Activity): _Container<android.widget.SearchView>(vgInstance, ctx) {

}

class _ViewSwitcher(vgInstance: android.widget.ViewSwitcher, ctx: android.app.Activity): _Container<android.widget.ViewSwitcher>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ViewFlipper(vgInstance: android.widget.ViewFlipper, ctx: android.app.Activity): _Container<android.widget.ViewFlipper>(vgInstance, ctx) {

}

class _ListView(vgInstance: android.widget.ListView, ctx: android.app.Activity): _Container<android.widget.ListView>(vgInstance, ctx) {

}

class _GridView(vgInstance: android.widget.GridView, ctx: android.app.Activity): _Container<android.widget.GridView>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _Spinner(vgInstance: android.widget.Spinner, ctx: android.app.Activity): _Container<android.widget.Spinner>(vgInstance, ctx) {

}

class _Gallery(vgInstance: android.widget.Gallery, ctx: android.app.Activity): _Container<android.widget.Gallery>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(w: Int, h: Int, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(w, h)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _StackView(vgInstance: android.widget.StackView, ctx: android.app.Activity): _Container<android.widget.StackView>(vgInstance, ctx) {

}

class _TextSwitcher(vgInstance: android.widget.TextSwitcher, ctx: android.app.Activity): _Container<android.widget.TextSwitcher>(vgInstance, ctx) {

    fun android.view.View.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(width: Int, height: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(width, height)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(source: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(source!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ImageSwitcher(vgInstance: android.widget.ImageSwitcher, ctx: android.app.Activity): _Container<android.widget.ImageSwitcher>(vgInstance, ctx) {

}

class _ExpandableListView(vgInstance: android.widget.ExpandableListView, ctx: android.app.Activity): _Container<android.widget.ExpandableListView>(vgInstance, ctx) {

}

