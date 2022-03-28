package com.example.standort.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standort.databinding.ItemuniLayoutBinding
import com.example.standort.model.UniItem
import retrofit2.Response

class ItemAdapter():RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    var items= emptyList<UniItem>()
    class MyViewHolder(val binding: ItemuniLayoutBinding):RecyclerView.ViewHolder(binding.root) {  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return ItemAdapter.MyViewHolder(
          ItemuniLayoutBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
       )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=items[position]
        holder.binding.apply {
            this.name.text=currentItem.name
            this.province.text=currentItem.state
            this.mail.text=currentItem.domains[0]
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListofData(tempItems: List<UniItem>){
        this.items=tempItems
        this.notifyDataSetChanged()
    }


}