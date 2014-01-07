class _FragmentBreadCrumbs(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _RelativeLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RelativeLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.RelativeLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _AbsoluteLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, p3: Int, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0, p1, p2, p3)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.AbsoluteLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _FrameLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _LinearLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.LinearLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.LinearLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _GridLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.Spec?, p1: android.widget.GridLayout.Spec?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams()
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.LayoutParams?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.GridLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.GridLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _TwoLineListItem(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _DialerFilter(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _WebView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _AppWidgetHostView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Int, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.FrameLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.FrameLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _GestureOverlayView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _CalendarView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _HorizontalScrollView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _ScrollView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _DatePicker(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _TimePicker(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _TabHost(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _ViewAnimator(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _MediaController(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _TableLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams()
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableLayout.LayoutParams.() -> Unit) {
        val lp = android.widget.TableLayout.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _TableRow(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams()
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.TableRow.LayoutParams.() -> Unit) {
        val lp = android.widget.TableRow.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _NumberPicker(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _TabWidget(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _RadioGroup(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, p2: Float, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0, p1, p2)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: android.widget.RadioGroup.LayoutParams.() -> Unit) {
        val lp = android.widget.RadioGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _ZoomControls(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _SearchView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _ViewSwitcher(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _ViewFlipper(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _ListView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _GridView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _Spinner(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _Gallery(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.widget.Gallery.LayoutParams.() -> Unit) {
        val lp = android.widget.Gallery.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _StackView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _TextSwitcher(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!, p1!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: Int, p1: Int, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: android.view.ViewGroup.LayoutParams.() -> Unit) {
        val lp = android.view.ViewGroup.LayoutParams(p0!!)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

class _ImageSwitcher(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

class _ExpandableListView(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

}

