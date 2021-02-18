package com.example.codechallangeweek7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    class Change(){
        val price = 12.01
        val payment = 20.00
        var tenBillChange = 0.00
        var fiveBillChange = 0.00
        var oneBillChange = 0.00
        var quarterChange = 0.00
        var dimeChange = 0.00
        var nickeChange = 0.00
        var pennyChange = 0.00
        var remainingChange = payment - price
    }

    var sale = Change()


    fun getChange(obj:Change): Change{
        if(obj.remainingChange % 10 == 0.00 && obj.remainingChange > 0.00){
            obj.tenBillChange = obj.remainingChange / 10
            println("ten Dollar Bills: ${obj.tenBillChange}")
            obj.remainingChange -=  obj.tenBillChange
        }
        if(obj.remainingChange % 5 == 0.00 && obj.remainingChange > 0.00){
            obj.fiveBillChange = obj.remainingChange / 5
            println("five Dollar Bills: ${obj.fiveBillChange}")
            obj.remainingChange -= obj.fiveBillChange

        }
        if(obj.remainingChange % 1 == 0.00 && obj.remainingChange> 0.00){
            obj.oneBillChange = obj.remainingChange / 1
            println("one Dollar Bills: ${obj.oneBillChange}")
            obj.remainingChange -= obj.oneBillChange
        }
        if(obj.remainingChange %.25 == 0.00 && obj.remainingChange > 0.00){
            obj.quarterChange = obj.remainingChange / .25
            println("quarter coin: ${obj.quarterChange}")
            obj.remainingChange -= obj.quarterChange
        }

        if(obj.remainingChange %.10 == 0.00 && obj.remainingChange > 0.00){
            obj.dimeChange = obj.remainingChange / .10
            println(" Dime coin: ${obj.dimeChange}")
            obj.remainingChange -= obj.dimeChange
        }
        if(obj.remainingChange %.05 == 0.00 && obj.remainingChange > 0.00){
            obj.nickeChange = obj.remainingChange / .05
            println("Nickel coin: ${obj.nickeChange}")
            obj.remainingChange -= obj.nickeChange
        }
        if(obj.remainingChange % 0.01 == 0.00 && obj.remainingChange > 0.00){
            obj.pennyChange = obj.remainingChange / .01
            println("Penny coin: ${obj.pennyChange}")
            obj.remainingChange -= obj.pennyChange
        }
        return obj

    }
    var test = getChange(sale)



}