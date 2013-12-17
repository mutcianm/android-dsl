class _UI(var act: android.app.Activity) {
    fun linearLayout(init: _LinearLayout.() -> Unit) {
        val layout = _LinearLayout(android.widget.LinearLayout(act), act)
        layout.init()
        act.setContentView(layout.vgInstance)
    }

}

