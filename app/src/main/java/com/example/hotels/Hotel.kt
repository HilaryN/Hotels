package com.example.hotels

class Hotel {
    lateinit var hotelCode: String
    var hotelInfo: HotelInfo? = null
    var ratePlans: List<RatePlan>? = null

    fun numRatePlans(): Int =
        ratePlans?.size ?: 0

    // For now, assume 1 room per rate plan
//    fun numRooms(): Int {
//        var num = 0
//        for (rooms in ratePlans) {
//            for (type in rooms) {
//                num++
//            }
//            num++
//        }
//    }
}