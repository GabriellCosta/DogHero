package br.com.doghero.dhproject.myhero.ui

import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import br.com.doghero.dhproject.myhero.R

class FavoriteFlipButtonBehavior : View.OnClickListener {

    private var clicked = false

    override fun onClick(it: View) {

        val favoriteButton = it as ImageButton

        val unfilled = ContextCompat.getDrawable(
            it.context,
            R.drawable.icon_like_border_vector_gray_battleship
        )
        val filled = ContextCompat.getDrawable(
            it.context,
            R.drawable.icon_like_filled_vector_red
        )

        favoriteButton.setImageDrawable(
            if (clicked)
                unfilled
            else
                filled
        )

        clicked = !clicked
    }
}
