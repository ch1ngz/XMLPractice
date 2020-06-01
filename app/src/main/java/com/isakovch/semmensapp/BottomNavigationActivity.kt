package com.isakovch.semmensapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.isakovch.semmensapp.ui.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation.nav_view
import kotlinx.android.synthetic.main.activity_bottom_navigation.navigateBack
import kotlinx.android.synthetic.main.activity_bottom_navigation.recyclerView

class BottomNavigationActivity : AppCompatActivity() {

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter().also {
            it.setItems(
                listOf(
                    "asdasd",
                    "asdasd",
                    "asdasd",
                    "asdasd"
                    )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            with(window.decorView.rootView) {
                systemUiVisibility = systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        }

        navigateBack.setOnClickListener {
            finish()
        }

        nav_view.setOnNavigationItemSelectedListener {
//            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
            return@setOnNavigationItemSelectedListener true
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = categoryAdapter
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, BottomNavigationActivity::class.java))
        }
    }
}
