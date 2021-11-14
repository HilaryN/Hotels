package com.example.hotels


class RatePlan {
    lateinit var name: String
    lateinit var rooms: List<Room>
    private lateinit var rrr: String

    fun numRooms() = rooms.size
}

class Room {
    lateinit var type: String
    lateinit var totalCost: Cost
}

class Cost {
    var amount = 0.00
    lateinit var currency: String
}
