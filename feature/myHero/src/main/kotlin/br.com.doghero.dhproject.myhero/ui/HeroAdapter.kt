package br.com.doghero.dhproject.myhero.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.myhero.R
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.myhero.util.ImageFetcher
import br.com.doghero.dhproject.myhero.util.bind

internal class HeroAdapter(private val heroList: List<HeroVO>) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dog_hero, parent, false)

        return HeroViewHolder(layout)
    }

    override fun getItemCount() = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val item = heroList[position]

        holder.bind(item)
    }

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageFetcher = ImageFetcher()

        private val imageView by bind<ImageView>(R.id.img_list_item_hero_photo)
        private val nameView by bind<TextView>(R.id.txt_list_item_hero_name)
        private val addressView by bind<TextView>(R.id.txt_list_item_hero_addres)
        private val priceView by bind<TextView>(R.id.txt_list_item_hero_price)

        fun bind(item: HeroVO) {

            item.apply {
                imageFetcher.loadImage(imageView, userImage)
                nameView.text = item.userName
                addressView.text = item.address
                priceView.text = item.price
            }
        }
    }
}

