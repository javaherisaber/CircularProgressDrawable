package ir.logicbase.circularprogressdrawable

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        extendedFab.setCircularDrawableIcon()
        materialButton.setCircularDrawableIcon()
    }

    private fun MaterialButton.setCircularDrawableIcon(
            defaultIcon: Drawable = defaultIcon(),
            circularIcon: CircularProgressDrawable = circularIcon()
    ) = this.setOnClickListener {
        if (icon is CircularProgressDrawable) {
            (icon as CircularProgressDrawable).stop()
            icon = defaultIcon
        } else {
            circularIcon.start()
            icon = circularIcon
        }
    }

    private fun defaultIcon() = ContextCompat.getDrawable(this, R.drawable.ic_add_white_24dp)!!

    private fun circularIcon() = CircularProgressDrawable(this).apply { strokeWidth = 8f }
}
