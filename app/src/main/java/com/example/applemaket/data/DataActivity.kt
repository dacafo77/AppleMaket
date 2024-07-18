package com.example.applemaket.data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemaket.R
import com.example.applemaket.databinding.ActivityDataBinding
import java.text.NumberFormat
import java.util.Locale

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val price = intent.getIntExtra("price", 0)
        val imageUrl = intent.getIntExtra("imageUrl", 0)
        val seller = intent.getStringExtra("seller")
        val text = intent.getStringExtra("text")

        binding.dataSellerTextView.text = seller
        binding.dataTitleTextView.text = name
        binding.dataAddressTextView.text = address
        binding.dataPric.text = "${NumberFormat.getNumberInstance(Locale.KOREA).format(price)}원"
        binding.dataImageView.setImageResource(imageUrl)
        binding.dateTextView.text = text
    }
}
