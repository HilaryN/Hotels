package com.example.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotelAdapter(private val listOfHotels: List<Hotel?>?):
    RecyclerView.Adapter<HotelAdapter.ViewHolder>() {
    // (Preferable to use data binding rather than findViewById as more efficient)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.hotel_name)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.hotel_description)
        val hotelImage = itemView.findViewById<ImageView>(R.id.hotel_image)
    }


    override fun getItemCount() =
        if (this.listOfHotels != null) this.listOfHotels.size else 0

    override fun onBindViewHolder(holder: HotelAdapter.ViewHolder, position: Int) {
        if (this.listOfHotels == null)
            return
        // Load data into row of Recycler View
        val item: Hotel? = this.listOfHotels.get(position)
        if (item != null) {
            holder.nameTextView.text = item.hotelInfo.name
            holder.descriptionTextView.text = item.hotelInfo.headline
            // Image (could do some uri validation first)
            //val image = item.hotelInfo.images[0].fileReference
             //if (image != null)
                //Picasso.get().load(image).into(holder.hotelImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.recycler_view_row, parent, false)
        return ViewHolder(view)
    }

}