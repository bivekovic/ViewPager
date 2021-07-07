package com.algebra.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity( ) {
    private val pages: ArrayList< Fragment > = ArrayList( )
    private lateinit var mPager: ViewPager

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        addPages( )

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById( R.id.pager )

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter( supportFragmentManager )
        mPager.adapter = pagerAdapter
    }

    private fun addPages( ) {
        pages.add( TextFragment( ) )
        pages.add( PlusOneFragment( ) )
        pages.add( RedFragment( ) )
    }

    private inner class ScreenSlidePagerAdapter( fm: FragmentManager ) : FragmentStatePagerAdapter( fm ) {
        override fun getCount( ): Int = pages.size

        override fun getItem( position: Int ): Fragment = pages[position]
    }
}
