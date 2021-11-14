package com.example.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotelAdapter(private val listOfHotels: HotelAvailabilities?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // (Preferable to use data binding rather than findViewById as more efficient)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.hotel_name)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.hotel_description)
        val hotelImage = itemView.findViewById<ImageView>(R.id.hotel_image)

        fun bind(rowNumber: Int) {
            if (listOfHotels != null) {
                val hotelInfo = listOfHotels.hotelAvailabilities?.get(rowNumber)?.hotelInfo
                if (hotelInfo != null) {
                    nameTextView.text = hotelInfo.name
                    descriptionTextView.text = hotelInfo.headline
                    // Image (could do some uri validation first)
                    //val image = hotelInfo.images[0].fileReference
                    //if (image != null)
                    //Picasso.get().load(image).into(holder.hotelImage)
                }
            }
        }
    }

    inner class RatePlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rateNameTextView = itemView.findViewById<TextView>(R.id.ratePlan)
        val roomTypeTextView = itemView.findViewById<TextView>(R.id.roomType)
        val costTextView = itemView.findViewById<TextView>(R.id.cost)

        fun bind(planNumber: Int) {
            if (listOfHotels != null) {
                val ratePlan = listOfHotels.hotelAvailabilities?.get(hotelNumber - 1)?.ratePlans?.get(planNumber)
                if (ratePlan != null) {
                    rateNameTextView.text = ratePlan.name
                    roomTypeTextView.text = ratePlan.rooms[0].type // assume only one room type for now
                    costTextView.text = ratePlan.rooms[0].totalCost.currency + ratePlan.rooms[0].totalCost.amount.toString()

                }
            }
        }
    }

    var hotelNumber = 0
    var prevRowNumber = 0
    var planNumber = 0


    override fun getItemCount() =
        if (listOfHotels != null)
            (listOfHotels.numHotels() + (listOfHotels.totalRatePlanRows()))
        else 0


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, rowNumber: Int) {
        if (listOfHotels == null)
            return

        // Load data into row of Recycler View
        var completedRatePlanRows = listOfHotels.numRows(hotelNumber - 1)
        when (rowNumber) {
            0, completedRatePlanRows -> {
                (holder as HotelAdapter.ViewHolder).bind(hotelNumber); hotelNumber++; planNumber = 0
            }
            else -> {
                (holder as HotelAdapter.RatePlanViewHolder).bind(planNumber); planNumber++
            }
        }

        prevRowNumber++
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        if (viewType == 1) {
            val view = layoutInflater
                .inflate(R.layout.hotel_row_view, parent, false)
            return ViewHolder(view)
        }
        val view = layoutInflater
            .inflate(R.layout.rate_plan_row_view, parent, false)
        return RatePlanViewHolder(view)
    }

    override fun getItemViewType(rowNumber: Int): Int {
        var completedRatePlanRows = 0
        if (listOfHotels != null) {
            completedRatePlanRows = listOfHotels.numRows(hotelNumber - 1)
        }
        // todo define constants for view types
        when (rowNumber) {
                0, completedRatePlanRows -> return 1
                else -> return 2
            }
        }
}