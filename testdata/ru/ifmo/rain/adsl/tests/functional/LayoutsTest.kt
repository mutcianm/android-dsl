class _FragmentBreadCrumbs<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _RelativeLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _AbsoluteLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _FrameLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _LinearLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _GridLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _TwoLineListItem<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _DialerFilter<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _AppWidgetHostView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _GestureOverlayView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _CalendarView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _HorizontalScrollView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _ScrollView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _DatePicker<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TimePicker<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TabHost<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ViewAnimator<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _MediaController<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TableLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _TableRow<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _NumberPicker<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TabWidget<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _RadioGroup<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _ZoomControls<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _SearchView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ViewSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _ViewFlipper<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ListView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _GridView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _Spinner<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _Gallery<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _StackView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TextSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

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

class _ImageSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ExpandableListView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

