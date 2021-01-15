package com.anningtex.testdata

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anningtex.baserecyclerviewadapterhelper.R
import com.anningtex.baserecyclerviewadapterhelper.databinding.ActivityTestDataBinding
import com.anningtex.testdata.four.FourActivity
import com.anningtex.testdata.one.OneActivity
import com.anningtex.testdata.three.ThreeActivity
import com.anningtex.testdata.two.TwoActivity

/**
 * @Author Song
 * @Desc:测试上面两个包下的内容
 */
class TestDataActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTestDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView();
    }

    private fun initView() {
        binding.btnOne.setOnClickListener(this);
        binding.btnTwo.setOnClickListener(this);
        binding.btnThree.setOnClickListener(this);
        binding.btnFour.setOnClickListener(this);
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_one -> {
                startActivity(Intent(this, OneActivity::class.java))
            }
            R.id.btn_two -> {
                startActivity(Intent(this, TwoActivity::class.java))
            }
            R.id.btn_three -> {
                startActivity(Intent(this, ThreeActivity::class.java))
            }
            R.id.btn_four -> {
                startActivity(Intent(this, FourActivity::class.java))
            }
        }
    }
}