package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){

    private val fragmentlist :ArrayList<Fragment> = ArrayList()

    /*override fun getItemCount(): Int {
        return fragmentlist.size
    }*/
    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1) //새로운 값이 추가되었음을 뷰페이저에게 안내
    }
}