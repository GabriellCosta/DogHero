package br.com.doghero.dhproject.myhero.ui

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.myhero.R

internal class HeroItemDecoration(resources: Resources) : RecyclerView.ItemDecoration() {

    private val itemSizeOffset = resources.getDimensionPixelOffset(R.dimen.mediumSpace)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = itemSizeOffset
    }

}
