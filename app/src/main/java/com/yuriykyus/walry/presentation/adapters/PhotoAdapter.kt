package com.yuriykyus.walry.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuriykyus.walry.R
import com.yuriykyus.walry.databinding.PhotoItemBinding
import com.yuriykyus.walry.domain.models.PhotoUrl

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private val photoUrlList = ArrayList<PhotoUrl>()

    fun addPhotoUrlList(data: List<PhotoUrl>) {
        photoUrlList.clear()
        photoUrlList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photoUrlList[position])
    }

    override fun getItemCount(): Int {
        return photoUrlList.size
    }

    class PhotoHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PhotoItemBinding.bind(item)

        fun bind(url: PhotoUrl) = with(binding) {
            Glide.with(binding.cvPhoto)
                .asBitmap()
                .centerCrop()
                .load(url.photoUrl)
                .into(ivPhoto)
        }
    }

}