package com.example.gramayatri.shared

data class Stop(
    val name: String,
    val travelTimeFromPrevious: Int
)

val routeStops = listOf(

    Stop(
        name = "Village A",
        travelTimeFromPrevious = 0
    ),

    Stop(
        name = "Village B",
        travelTimeFromPrevious = 10
    ),

    Stop(
        name = "Village C",
        travelTimeFromPrevious = 15
    ),

    Stop(
        name = "Village D",
        travelTimeFromPrevious = 12
    ),

    Stop(
        name = "Town Bus Stand",
        travelTimeFromPrevious = 20
    )
)