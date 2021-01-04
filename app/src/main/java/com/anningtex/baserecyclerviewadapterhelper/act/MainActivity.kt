package com.anningtex.baserecyclerviewadapterhelper.act

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anningtex.baserecyclerviewadapterhelper.R
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityMainBinding

/**
 * @author Song
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.tvLaunch.setOnClickListener(this)
        binding.tvSource.text =
            "1. Source : " + " \n " + "https://github.com/CymChad/BaseRecyclerViewAdapterHelper"
        binding.tvLoadZipUrl.text =
            "2.LoadZipUrl : " + " \n " + "https://github.com/CymChad/BaseRecyclerViewAdapterHelper/releases"
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_launch ->
                startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}