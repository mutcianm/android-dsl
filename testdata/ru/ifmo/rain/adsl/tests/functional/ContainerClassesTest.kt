class _GridLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.Spec?, p1: android.widget.GridLayout.Spec?, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams( init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams()
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.LayoutParams?, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(p0)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.view.ViewGroup.MarginLayoutParams?, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(p0)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.widget.GridLayout.LayoutParams?, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(p0)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

    fun android.view.View.layoutParams(p0: android.content.Context?, p1: android.util.AttributeSet?, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(p0, p1)
        lp.init()
        (this: View).setLayoutParams(lp)
    }

}

