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
        binding.btnLaunch.setOnClickListener(this)
        binding.tvSource.text =
            "① Source : " + " \n " + "https://github.com/CymChad/BaseRecyclerViewAdapterHelper"
        binding.tvLoadZipUrl.text =
            "② LoadZipUrl : " + " \n " + "https://github.com/CymChad/BaseRecyclerViewAdapterHelper/releases"

        binding.tvSourceTwo.text =
            "① Source : " + " \n " + "https://github.com/LidongWen"
        binding.tvLoadZipUrlTwo.text =
            "② LoadZipUrl : " + " \n " + "https://github.com/LidongWen/MultiTypeAdapter/releases"

        binding.tvLoad.text =
            "https://github.com/Songlengmou/BaseRecyclerViewAdapterHelper"
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_launch ->
                startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}