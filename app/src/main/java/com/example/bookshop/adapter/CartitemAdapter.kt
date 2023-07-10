package com.example.bookshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshop.R
import com.example.bookshop.ShoppingCartManager
import com.example.bookshop.models.CartItem
import kotlinx.android.synthetic.main.cart_item.view.movie_cart_title

class CartitemAdapter (
    private val cartItem : List<CartItem>,
) : RecyclerView.Adapter<CartitemAdapter.CartitemViewHolder>() {

    class CartitemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindCartitem(cartItem: CartItem){
            itemView.movie_cart_title.text = cartItem.itemName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartitemViewHolder {
        return CartitemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        )
    }

    override fun getItemCount(): Int = cartItem.size

    override fun onBindViewHolder(holder: CartitemViewHolder, position: Int) {
        holder.bindCartitem(cartItem[position])
    }
}