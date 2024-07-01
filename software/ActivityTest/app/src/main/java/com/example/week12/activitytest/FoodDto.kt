package com.example.week12.activitytest

import java.io.Serializable

class FoodDto(val photo: Int, val food: String, var count: Int): Serializable {
}