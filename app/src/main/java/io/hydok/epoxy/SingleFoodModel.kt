package io.hydok.epoxy

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlin.coroutines.coroutineContext

@EpoxyModelClass(layout = R.layout.singlefood_layout)
abstract class SingleFoodModel: EpoxyModelWithHolder<SingleFoodModel.FoodHolder>() {

    @EpoxyAttribute
    var clickListener: (() -> Unit)? = null

    @EpoxyAttribute
    var title:String? = ""

    @EpoxyAttribute
    var desc:String? = ""

    override fun bind(holder: FoodHolder) {
        holder.titleView.text = title
        holder.descView.text = desc
        holder.titleView.setOnClickListener{clickListener}
    }


    inner class FoodHolder :EpoxyHolder() {

        lateinit var titleView: TextView
        lateinit var descView: TextView


        override fun bindView(itemView: View) {
            titleView = itemView.findViewById(R.id.title)
            descView = itemView.findViewById(R.id.des)
        }

    }
}