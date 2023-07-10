package com.example.bookshop

import android.content.Context
import com.example.bookshop.models.CartItem
import com.google.gson.Gson

class ShoppingCartManager(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("ShoppingCart", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun addToCart(item: CartItem?){
        val cartItems = getCartItems()
        if (item != null) {
            cartItems.add(item)
        }
        saveCartItems(cartItems)
    }

    fun getCartItems(): MutableList<CartItem>{
        val json = sharedPreferences.getString("CartItems", null)
        return if(json != null){
            gson.fromJson(json, Array<CartItem>::class.java).toMutableList()
        }else{
            mutableListOf()
        }
    }

    private fun saveCartItems(items: List<CartItem>) {
        val json = gson.toJson(items)
        sharedPreferences.edit().putString("CartItems", json).apply()
    }

    fun clearCart() {
        sharedPreferences.edit().remove("CartItems").apply()
    }

    fun deleteItem(cartItem: CartItem){
        val cartItems = getCartItems()
        cartItems.remove(cartItem)
        saveCartItems(cartItems)
    }
}