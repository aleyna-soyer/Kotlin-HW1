package com.example.kotlinhw1

open class Item (var name:String, var price:Double)

class Food(name:String, price:Double, var weight:String):Item(name, price)

class Cloth(name:String, price:Double, var type:String):Item(name,price)

class ShoppingList() {
    var shoppingList = mutableListOf<Item>()
    fun addItem() {
        println("Enter the item type you want to add (1 for Food, 2 for Cloth: ")
        var added = readln().toInt()
        while (added != 1 && added != 2) {
            println("Invalid input. Please enter 1 for Food or 2 for Cloth:")
            added = readln().toInt()
        }
        when (added) {
            1 -> {
                println(" 1")

                println("Enter the item name you want to add: ")
                var name = readln()

                println("Enter the item price you want to add: ")
                var price = readln().toDouble()

                println("Enter the food weight: ")
                var weight = readln()
                shoppingList.add(Food(name, price, weight))
                println(" $name added successfully!")
            }
            2 -> {
                println("Your choice is: 2")
                println("Enter the item name you want to add: ")
                val name = readln()
                println("Enter the item price you want to add: ")
                val price = readln().toDouble()
                println("Enter the cloth type: ")
                val type = readln()
                shoppingList.add(Cloth(name, price, type))
                println(" $name added successfully!")
            }
        }
    }
    fun displayItem(){

        if (shoppingList.isEmpty()) {
            println("Shopping list is empty.")
        }
        else{
            println("Items in the shopping list:")
            for (item in shoppingList) {
                println("Name: ${item.name}, Price: ${item.price}")
                when (item) {
                    is Food -> println("Weight: ${item.weight}")
                    is Cloth -> println("Type: ${item.type}")
                }
            }
        }
    }
    fun deleteItem(){
        if (shoppingList.isEmpty()) {
            println("Shopping list is empty. No items to delete.")
        }
        else{
            println("Enter the item you want to delete: ")
            var delete = readln().toInt()
            shoppingList.removeAt(delete-1)
            println("Deleted successfully")
            displayItem()
        }
    }
}
fun main(){
    println("***Welcome to Shopping List App***")
    println("Make your choice: (1-2-3-4)")
    println("1. Add Item")
    println("2. Display Item")
    println("3. Delete Item")
    println("4. Exit")

    var shoppingList = ShoppingList()

    do {
        var choice= readln().toInt()
        println("Your choice is: $choice")

        when(choice){
            1-> shoppingList.addItem()
            2-> shoppingList.displayItem()
            3-> shoppingList.deleteItem()
        }
        println("Make your choice: (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
    }
    while (choice!=4)
}
