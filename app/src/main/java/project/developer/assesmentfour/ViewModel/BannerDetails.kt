package project.developer.assesmentfour.ViewModel


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import project.developer.assesmentfour.Api.ApiClient
import project.developer.assesmentfour.Api.ApiInterface
import project.developer.assesmentfour.Banner
import project.developer.assesmentfour.databinding.BannerdisplayBinding


class BannerDetails: AppCompatActivity() {
    lateinit var binding: BannerdisplayBinding
    lateinit var apiInterface: ApiInterface
    var bannerId = -1
    private var banner: Banner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BannerdisplayBinding.inflate(layoutInflater)



        setContentView(binding.root)

        apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

        val bundle = intent.extras
        if (bundle != null) {
            bannerId = bundle.getInt("BANNER_ID", -1)
        }



        fetchBannerDetails()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun fetchBannerDetails() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiInterface.getProductById(bannerId)

            if (response.isSuccessful){
                banner = response.body()
                displayBannerDetails()

            }
            else{
                Toast.makeText(this@BannerDetails, "Error, cannot fetch banner details", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun displayBannerDetails() {
        banner?.let {
            binding.tvTitle.text = it.title
            binding.tvDescription.text = it.description

            Picasso
                .get()
                .load(it.thumbnail)
                .resize(250, 250)
                .centerCrop()
                .into(binding.ivbanner)

        }


    }

}