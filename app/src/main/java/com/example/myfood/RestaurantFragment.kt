package com.example.myfood
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.example.myfood.databinding.FragmentRestaurantBinding


class RestaurantFragment:Fragment (R.layout.fragment_restaurant){

    private var binding: FragmentRestaurantBinding? = null

    private val categoryAdapter = ATAdapter({ CategpryView(it)})
    private val bannerAdapter = ATAdapter({ BannerView(it)})
    private val shopAdapter = ATAdapter({ ShopView(it)})
    private val moreShopAdapter = ATAdapter({ MoreshopView(it)})

    private var filters = arrayOf(

        FilterItem(1,"Ordenar", closeIcon = R.drawable.baseline_keyboard_arrow_down_24),
        FilterItem(2,"Pra retirar", icon = R.drawable.baseline_directions_walk_24),
        FilterItem(3,"Entrega grátis"),
        FilterItem(4,"Vale-refeição" , closeIcon = R.drawable.baseline_keyboard_arrow_down_24),
        FilterItem(5,"Distância", closeIcon = R.drawable.baseline_keyboard_arrow_down_24),
        FilterItem(6,"Entrega Parceira"),
        FilterItem(7,"Super Restaurante"),
        FilterItem(8,"Filtros", closeIcon = R.drawable.baseline_filter_list_24),
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(

            Category (1, "https://www.ifood.com.br/static/images/categories/market.png", "Mercado", 0xFFB6D048),
            Category(2 ,"https://www.ifood.com.br/static/images/categories/restaurant.png", "Restaurante",0xFFE91D2D ),
            Category(3 ,"https://www.ifood.com.br/static/images/categories/drinks.png", "Bebidas",0xFFF6D553 ),
            Category(4 ,"https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png", "Express",0xFFFF0000 ),
            Category(5 ,"https://www.ifood.com.br/static/images/categories/drinks.png", "Salgados",0xFF8C60C5 ),

        )

        bannerAdapter.items = arrayListOf(

        Banner(1, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/itensBasicosNOV21Principal_zE1X.png"),
        Banner(2, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/MerceariaeMatinaisPrincipal_mfDO.png"),
        Banner(3, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Bebidas40offPrincipal_cljA.png"), )

        shopAdapter.items = arrayListOf(

           Shop(1, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg","Pizza Crec" ),
            Shop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png" , "Uau Esfiha") ,
            Shop(3, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png" , "Bar do Juarez"),
           Shop(4,"https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg","Bolo da Madre"),
            Shop(5,"https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png","Bar do Juarez"),
        )

        moreShopAdapter.items = arrayListOf(

             MoreShop(1 , "https://static-images.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crec", 4.4, "Pizza", 11.2, "60-70" , 26.00),
             MoreShop(2, "https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png","Fábrica de Esfiha", 4.3, "Esfiha",12.2, "60-70", 9.00 ),
             MoreShop(3,"https://static-images.ifood.com.br/image/upload/t_high/logosgde/e2f3424a-06fb-46dd-89c3-f7b039e2b1f0_BOLOD_PPIN02.jpeg","Bolo da Madre", 4.7, "Bolo", 11.0, "80-90", 30.00),
             MoreShop(4,"https://static-images.ifood.com.br/image/upload/t_high/logosgde/201901021647_8066dc64-9383-46d1-aa2d-56b9492e27ed.png","Uau Esfiha", 4.4, "Esfiha", 21.0, "60-70" , 8.00),
             MoreShop(5,"https://static-images.ifood.com.br/image/upload/t_high/logosgde/201705131248_0ca51a98-ee95-48ac-b193-48066c8f20cc.png","Bar do Juarez", 4.9, "Bar", 17.2 , "40-50", 13.00),






        )





        binding = FragmentRestaurantBinding.bind(view)

        binding?.let{

            it.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategories.adapter = categoryAdapter

            it.rvBanners.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter

            it.rvShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvShops.adapter = shopAdapter

           it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext())
            it.rvMoreShops.adapter = moreShopAdapter





            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if(newState == RecyclerView.SCROLL_STATE_IDLE){

                        notifyPositionChanged(recyclerView)


                    }
                }
            })


            addDots(it.dots, bannerAdapter.items.size, 0)



            filters.forEach{filter ->

            it.chipFilterGroup.addView(filter.toChip(requireContext()))


            }
        }
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int){

                container.removeAllViews()

        Array(size){

             val textview = TextView(context).apply {

                 text = getString(R.string.dotted)
                 textSize = 20f
                 setTextColor(

                     if(position == it) ContextCompat.getColor(context, android.R.color.black)
                     else  ContextCompat.getColor(context, android.R.color.darker_gray)

                 )
             }
            container.addView(textview)
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

   private fun notifyPositionChanged(recyclerView: RecyclerView){


        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

       val positionChanged = this.position != position

       if (positionChanged){

         addDots(binding!!.dots, bannerAdapter.items.size, position ?: 0)

       }
     this.position = position

   }
}

