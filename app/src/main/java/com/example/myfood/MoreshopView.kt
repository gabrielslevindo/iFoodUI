package com.example.myfood


import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder

import com.example.myfood.databinding.MoreShopItemBinding
import com.example.myfood.databinding.ShopItemBinding

import com.squareup.picasso.Picasso


class MoreshopView(viewGroup: ViewGroup): ATViewHolder<MoreShop, MoreShopItemBinding>(
    MoreShopItemBinding::inflate,
    viewGroup

) {

    override fun bind(item:MoreShop){



        Picasso.get()
            .load(item.shopUrl)
            .into(binding.imgShop)

           binding.txtShop.text = item.text
           binding.txtStar.text = item.rate.toString()
           binding.txtSubtitle.text = itemView.context.getString(R.string.shop_category, item.category, item.distance)
           binding.txtPrice.text = itemView.context.getString(R.string.shop_price,item.time, item.prince)
    }
}