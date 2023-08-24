package project.developer.assesmentfour.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import project.developer.assesmentfour.Banner
import project.developer.assesmentfour.ViewModel.BannerViewModel
import project.developer.assesmentfour.databinding.ActivityMainBinding
import project.developer.assessmentfour.ui.BannerAdapter

class MainActivity : AppCompatActivity() {
    val BannerViewModel: BannerViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    var banners: List<Banner> = emptyList()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        BannerViewModel.fetchBanner()
        BannerViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })


        BannerViewModel.bannersLiveData.observe(this, Observer { banners ->
            val adapter = BannerAdapter(banners ?: emptyList())
            binding.rvbanners.adapter = adapter
            binding.rvbanners.layoutManager = GridLayoutManager(this@MainActivity, 2)
        })
    }
}