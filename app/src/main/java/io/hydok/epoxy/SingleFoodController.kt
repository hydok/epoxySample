package io.hydok.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel


class SingleFoodController(private val foodClick:(String) -> Unit) : AsyncEpoxyController() {

    private var foodItems: List<Food> = FoodDataFactory.getFoodItems(4)
    private var foodItems2: List<Food> = FoodDataFactory.getFoodItems(11)
    private var foodItems3: List<Food> = FoodDataFactory.getFoodItems(10)

    override fun buildModels() {
        var i: Long = 0



        singleHeader {
            id(i)
            title("Header1")
        }
        foodItems.forEach {
            singleFood {
                id(i++)
                titleStr(it.title)
                descStr(it.description)
                clickListener(foodClick)
            }
        }


        singleHeader {
            id(i)
            title("Header2")
        }
        val models = foodItems2.map {
            SingleFoodModel_()
                .id(i++)
                .titleStr(it.title)
                .descStr(it.description)
                .clickListener(foodClick)
        }
        carousel {
            id("carousel")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }



        singleHeader {
            id(i)
            title("Header3")
        }
        foodItems3.forEach {
            singleFood {
                id(i++)
                titleStr(it.title)
                descStr(it.description)
                clickListener(foodClick)
            }
        }

    }

}