class _GridLayout(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {
    fun android.view.View.layoutParams(height: Int, width: Int, init: GridLayout.LayoutParams.() -> Unit) {
        val lp = GridLayout.LayoutParams(height,width)
        lp.init()
        (this: View).setLayoutParams(lp)
    }
}

