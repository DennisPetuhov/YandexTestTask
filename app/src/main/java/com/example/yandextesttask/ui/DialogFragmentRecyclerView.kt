package com.example.yandextesttask.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.yandextesttask.databinding.PopularDiractionLayoutBinding


class MyListAdapter(
    val onCityClick: (PopularDirection) -> Unit,
    val dialogFragment: DialogFragment,
) :
    ListAdapter<PopularDirection, MyViewHolder>(DiffUtilItemCallback) {
    private val tag = "ListAdapter"

    object DiffUtilItemCallback : DiffUtil.ItemCallback<PopularDirection>() {
        override fun areItemsTheSame(
            oldItem: PopularDirection,
            newItem: PopularDirection,
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PopularDirection,
            newItem: PopularDirection,
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            PopularDiractionLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(tag, "onBindViewHolder - $position")
        val item = getItem(position)
        Log.d(tag, "item at position $position is ${item}")
        holder.itemView.setOnClickListener {
            onCityClick(item)
//            dialogFragment.dismiss()
        }

        holder.bind(item)
    }

    fun updateAll(newList: List<PopularDirection>) {
        submitList(newList)
    }

    fun add(dummyData: PopularDirection, position: Int) {
        val newItems = ArrayList(currentList)
        newItems.add(position, dummyData)
        submitList(newItems)
    }
}

class MyViewHolder(private val binding: PopularDiractionLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PopularDirection) {
        binding.popularDirectionTextView.text = item.name
        binding.image.setImageResource(item.image)

//        binding.cta.setOnClickListener {
//            listener.delete(layoutPosition)
//        }
    }
}


class MyDecoration(
    context: Context,
    resId: Int,
) : RecyclerView.ItemDecoration() {

    private var myBorder: Drawable = ContextCompat.getDrawable(context, resId)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val dividerLeft: Int = PADDING
        val dividerRight: Int = parent.width - PADDING

        for (i in 0 until parent.childCount) {

            if (i != parent.childCount - ONE) {
                val child: View = parent.getChildAt(i)

                val params = child.layoutParams as RecyclerView.LayoutParams
                val dividerTop: Int = child.bottom + params.bottomMargin
                val dividerBottom: Int = dividerTop + myBorder.intrinsicHeight

                myBorder.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                myBorder.draw(c)
            }
        }
    }
}

const val PADDING = 32
const val ONE = 1
