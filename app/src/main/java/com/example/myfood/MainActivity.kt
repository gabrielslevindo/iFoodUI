package com.example.myfood

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfood.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }
    private fun setupView(){

     val tabLayout = binding.addTab
     val viewPager = binding.addViewpager
     val adapter = TabViewPagerAdapter(this)
     viewPager.adapter = adapter
     viewPager.isUserInputEnabled = false

     TabLayoutMediator(tabLayout, viewPager)  { tab, position ->
         tab.text = getString(adapter.tabs[position])
     }.attach()

    }

}
class TabViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){



   val tabs = arrayOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
    val fragments = arrayOf(RestaurantFragment(), MarketplaceFragment(), MarketplaceFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}



class MarketplaceFragment: Fragment(){}