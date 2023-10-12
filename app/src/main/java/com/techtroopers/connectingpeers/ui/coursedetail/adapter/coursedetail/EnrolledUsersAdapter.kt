package com.techtroopers.connectingpeers.ui.coursedetail.adapter.coursedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import com.techtroopers.connectingpeers.databinding.ItemEnrolledUsersBinding

class EnrolledUsersAdapter(
    private val data: List<EnrolledUsers>,
    private val clickListener: OnItemClickListener,
) : RecyclerView.Adapter<EnrolledUsersAdapter.EnrolledUsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrolledUsersViewHolder {
        val binding = ItemEnrolledUsersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return EnrolledUsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EnrolledUsersViewHolder, position: Int) {
        val currentItem = data[position]
        holder.onBind(currentItem)
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int = data.size

    interface OnItemClickListener {
        fun onItemClick(item: EnrolledUsers)
    }

    class EnrolledUsersViewHolder(
        private val binding: ItemEnrolledUsersBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(currentItem: EnrolledUsers) = with(binding) {
            tvUserName.text = currentItem.userName
        }
    }
}


