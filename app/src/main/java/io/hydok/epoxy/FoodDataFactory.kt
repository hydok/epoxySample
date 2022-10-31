package io.hydok.epoxy

import java.util.*

object FoodDataFactory {

    //region Random Data Generators
    private val random = Random()

    private val titles = arrayListOf("Nachos", "Fries", "Cheese Balls", "Pizza")
    private val descs = arrayListOf("good", "nice", "bad", "so so")

    private fun randomTitle() : String {
        val title = random.nextInt(4)
        return titles[title]
    }
    private fun randomDesc() : String {
        val num = random.nextInt(4)
        return descs[num]
    }

    fun getFoodItems(count:Int) : List<Food>{
        val foodItems = mutableListOf<Food>()
        repeat(count){
            val image = 0
            val title = randomTitle()
            val desc = randomDesc()
            foodItems.add(Food(image,title,desc))
        }
        return foodItems
    }

}