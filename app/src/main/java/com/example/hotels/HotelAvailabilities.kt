package com.example.hotels

class HotelAvailabilities {
    var hotelAvailabilities: List<Hotel>? = null

    fun numHotels(): Int {
        if (hotelAvailabilities != null)
            return hotelAvailabilities!!.size
        else
            return 0
    }
// Number of rows up to current hotel number
    fun numRows(currentHotelNumber: Int): Int {
        var rows = 0
        for (i in 0..currentHotelNumber) {
            rows++  // 1 row for each hotel
            rows = rows + (hotelAvailabilities?.get(i)?.numRatePlans()!!) // plus no of rate plans
        }
    return rows
    }

    fun totalRatePlanRows(): Int {
        var num = 0
        for (Hotel in hotelAvailabilities!!)
            num = num + Hotel.numRatePlans()
        return num
    }
}