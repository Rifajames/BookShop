package com.example.bookshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshop.R
import com.example.bookshop.models.CartItem
import kotlinx.android.synthetic.main.cart_item.view.btndelete_cart_item
import kotlinx.android.synthetic.main.cart_item.view.movie_cart_title

class CartitemAdapter(
    var listCartItem: MutableList<CartItem>,
    val clickDelete: (cartItem: CartItem) -> Unit
) : RecyclerView.Adapter<CartitemAdapter.CartitemViewHolder>() {

    class CartitemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindCartitem(cartItem: CartItem, clickDelete: (cartItem: CartItem) -> Unit){
            itemView.movie_cart_title.text = cartItem.itemName
            itemView.btndelete_cart_item.setOnClickListener {
                clickDelete.invoke(cartItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartitemViewHolder {
        return CartitemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        )
    }

    override fun getItemCount(): Int = listCartItem.size

    override fun onBindViewHolder(holder: CartitemViewHolder, position: Int) {
        holder.bindCartitem(listCartItem[position],clickDelete)
    }

    fun updateData(cartItem: CartItem){
        listCartItem.remove(cartItem)
        notifyDataSetChanged()
    }
}