package com.example.gramayatri.shared

data class RouteStop(

    val name: String,

    val travelTimeFromPrevious: Int
)

val routeStops = listOf(

    RouteStop("Village A", 0),

    RouteStop("Village B", 10),

    RouteStop("Village C", 15),

    RouteStop("Village D", 12),

    RouteStop("Town Bus Stand", 20)
)

enum class BusStatus {

    RUNNING,
    DELAYED,
    CANCELLED
}

var currentBusStatus =
    BusStatus.RUNNING