open class _Container(open val vgInstance: android.view.ViewGroup,
                 open val ctx: android.app.Activity) {

    var _style: ((X: Any) -> Unit) = {}

    fun style(init: (X: Any) -> Unit) {
        this._style = init
    }

    fun alertDialog(title: String, func: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.func()
        return builder.create()!!.show()
    }

    fun button( init: android.widget.Button.() -> Unit): android.widget.Button {
        val v = android.widget.Button(ctx)
        v.init()
        vgInstance.addView(v)
        _style(v)
        return v
    }

}

