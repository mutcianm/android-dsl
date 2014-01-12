class _FragmentBreadCrumbs<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _RelativeLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _AbsoluteLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, p3: Int, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0, p1, p2, p3)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _FrameLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _LinearLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _GridLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.Spec?, p1: android.widget.GridLayout.Spec?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _TwoLineListItem<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _DialerFilter<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _WebView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _AppWidgetHostView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _GestureOverlayView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _CalendarView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _HorizontalScrollView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ScrollView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
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

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _MediaController<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TableLayout<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _TableRow<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams()
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _NumberPicker<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TabWidget<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _RadioGroup<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0, p1, p2)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ZoomControls<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _SearchView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ViewSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ViewFlipper<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ListView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _GridView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _Spinner<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _Gallery<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _StackView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _TextSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        this@layoutParams.setLayoutParams(lp)
    }

}

class _ImageSwitcher<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

class _ExpandableListView<out T: android.view.ViewGroup>(vgInstance: T, ctx: android.app.Activity): _Container<T>(vgInstance, ctx) {

}

