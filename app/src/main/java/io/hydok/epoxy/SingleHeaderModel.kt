package io.hydok.epoxy

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import io.hydok.epoxy.databinding.SinglefoodHeaderLayoutBinding
import io.hydok.epoxy.databinding.SinglefoodLayoutBinding

@EpoxyModelClass(layout = R.layout.singlefood_header_layout)
abstract class SingleHeaderModel: EpoxyModelWithHolder<SingleHeaderModel.HeaderHolder>() {

    @EpoxyAttribute
    var title:String? = ""

    override fun bind(holder: HeaderHolder) {
        with(holder.binding){
            content.text = title
        }
    }


    inner class HeaderHolder :EpoxyHolder() {
        lateinit var binding: SinglefoodHeaderLayoutBinding


        override fun bindView(itemView: View) {
            binding = SinglefoodHeaderLayoutBinding.bind(itemView)

        }

    }
}