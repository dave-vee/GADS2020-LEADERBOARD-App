package com.example.leaderboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.leaderboard.fragments.SkillIQ_leaders
import com.example.leaderboard.fragments.learning_Leaders
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var submit_btn: Button

    var learningLeaders = learning_Leaders
    var IQ_leaders = SkillIQ_leaders

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        learningLeaders = learning_Leaders
        IQ_leaders = SkillIQ_leaders

        tabLayout.setupWithViewPager(viewPager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(SkillIQ_leaders(), "SkillIQ leaders")
        viewPagerAdapter.addFragment(learning_Leaders(), "learningLeaders")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        submit_btn = findViewById(R.id.submit_btn)
        submit_btn.setOnClickListener {
            val intent = Intent(this, SubmitActivity::class.java)
            startActivity(intent)
        }


    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {

        private var fragments = ArrayList<Fragment>()
        private var Titles = ArrayList<String>()

        init {
            fragments = ArrayList()
            Titles = ArrayList()
        }

        override fun getCount() = fragments.size


        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return Titles[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            Titles.add(title)
        }

    }


}