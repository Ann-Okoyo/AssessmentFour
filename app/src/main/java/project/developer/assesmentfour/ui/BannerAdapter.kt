package project.developer.assessmentfour.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import project.developer.assesmentfour.Banner
import project.developer.assesmentfour.ViewModel.BannerDetails
import project.developer.assesmentfour.databinding.BannerdisplayBinding


class BannerAdapter(var banners: List<Banner>): RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = BannerdisplayBinding.inflate(LayoutInflater.from(parent.context))
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val mybanner = banners[position]

        holder.binding.apply {
            tvTitle.text = mybanner.title
            tvDescription.text = mybanner.description

            Picasso
                .get()
                .load(mybanner.thumbnail)
                .resize(250, 250)
                .centerCrop()
                .into(ivbanner)
        }

        holder.binding.cvProducts.setOnClickListener {
            val intent = Intent(holder.itemView.context, BannerDetails::class.java)
            intent.putExtra("BANNER_ID", mybanner.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    class BannerViewHolder(var binding: BannerdisplayBinding): RecyclerView.ViewHolder(binding.root)
}