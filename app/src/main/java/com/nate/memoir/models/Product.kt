package com.nate.memoir.models

class Product{
    var name:String=""
    var quantity:String=""
    var price:String=""
    var id:String=""

    // products features can add as many options as you want

    constructor(name:String,quantity:String,price:String,id:String){
        this.name=name
        this.quantity=quantity
        this.price=price
        this.id=id

    }
    constructor()
}