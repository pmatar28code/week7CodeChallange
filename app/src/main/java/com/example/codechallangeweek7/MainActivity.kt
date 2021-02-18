import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round
import kotlin.math.roundToInt

class Change(){
    var price = 12.01
    var payment = 0.00
    var twentyBillChange = 0.00
    var tenBillChange = 0.00
    var fiveBillChange = 0.00
    var oneBillChange = 0.00
    var quarterChange = 0.00
    var dimeChange = 0.00
    var nickeChange = 0.00
    var pennyChange = 0.00000
    var remainingChange = payment - price
}

var changeMap = mutableMapOf<String,Int>(
    "Twenty Dollar Bill" to 0,
    "Ten Dollar Bill" to 0,
    "Five Dollar Bill" to 0,
    "One Dollar Bill" to 0,
    "Quarters" to 0,
    "Dimes" to 0,
    "Nickels" to 0,
    "Pennys" to 0
)

var changeMessage =""

fun createChangeMessage(changeMap: MutableMap<String,Int>){
    var checkBool = false
    for ((k,v) in changeMap){
        if(k=="Twenty Dollar Bill"
            || k=="Ten Dollar Bill" ||
            k == "Five Dollar Bill" ||
            k== "One Dollar Bill") {
            if (v == 0) {
                checkBool = true
            }else{checkBool = false}
        }
    }
    if(checkBool == true){
        changeMessage+="Zero Bills, "}

    for((k,v) in changeMap){
        when(v){
            1 -> {changeMessage+="One $k ,"}
            2 -> {changeMessage+="Two $k ,"}
            3 -> {changeMessage+="Three $k ,"}
            4 -> {changeMessage+="Four $k ,"}
            5 -> {changeMessage+="Five $k ,"}
            6 -> {changeMessage+="Six $k ,"}
            7 -> {changeMessage+="Seven $k ,"}
            8 -> {changeMessage+="Eight $k ,"}
            9 -> {changeMessage+="Nine $k ,"}
            10 -> {changeMessage+="Ten $k ,"}
        }
    }
}

fun getChange(obj:Change): Change{

    if(obj.remainingChange  / 20 >= 1.00 && obj.remainingChange >= 0.00){
        obj.twentyBillChange = obj.remainingChange  / 20
        obj.twentyBillChange = floor(obj.twentyBillChange)
        changeMap["Twenty Dollar Bill"] = obj.twentyBillChange.toInt()
        var round = obj.twentyBillChange*20
        obj.remainingChange -=  round
    }
    if(obj.remainingChange  / 10 >= 1.00 && obj.remainingChange >= 0.00){
        obj.tenBillChange = obj.remainingChange  / 10
        obj.tenBillChange = floor(obj.tenBillChange)
        changeMap["Ten Dollar Bill"] = obj.tenBillChange.toInt()
        var round = obj.tenBillChange*10
        obj.remainingChange -= round
    }
    if(obj.remainingChange / 5 >= 1.00 && obj.remainingChange >= 0.00){
        obj.fiveBillChange = obj.remainingChange / 5
        obj.fiveBillChange = floor(obj.fiveBillChange)
        changeMap["Five Dollar Bill"] = obj.fiveBillChange.toInt()
        var round = obj.fiveBillChange*5
        println(round)
        obj.remainingChange -= round
    }
    if(obj.remainingChange / 1 >= 1.00 && obj.remainingChange>= 0.00){
        obj.oneBillChange = obj.remainingChange / 1
        obj.oneBillChange = floor(obj.oneBillChange)
        changeMap["One Dollar Bill"] = obj.oneBillChange.toInt()
        var round = obj.oneBillChange*1
        obj.remainingChange -= round
    }
    if(obj.remainingChange / 0.25 >= 1.00 && obj.remainingChange >= 0.00){
        obj.quarterChange = obj.remainingChange / 0.25
        obj.quarterChange = floor(obj.quarterChange)
        changeMap["Quarters"] = obj.quarterChange.toInt()
        var round =obj.quarterChange*0.25
        obj.remainingChange -= round
    }

    if(obj.remainingChange / 0.10 >=1.00 && obj.remainingChange >= 0.00){
        obj.dimeChange = obj.remainingChange / 0.10
        obj.dimeChange = floor(obj.dimeChange)
        changeMap["Dimes"] = obj.dimeChange.toInt()
        var round = obj.dimeChange*0.10
        obj.remainingChange -= round
        println("remaining change  = ${obj.remainingChange}remaining")
    }
    if(obj.remainingChange / 0.05 >=1.00 && obj.remainingChange >= 0.00){
        obj.nickeChange = obj.remainingChange / 0.05
        obj.nickeChange = floor(obj.nickeChange)
        changeMap["Nickels"] = obj.nickeChange.toInt()
        var round =  obj.nickeChange*0.05
        obj.remainingChange -= round
    }
    if(obj.remainingChange / 0.01 >=1.00 && obj.remainingChange >= 0.00){
        obj.pennyChange = obj.remainingChange / 0.01
        println("before rounding ${obj.pennyChange}")
        obj.pennyChange = round(obj.pennyChange)
        changeMap["Pennys"] = obj.pennyChange.toInt()
        var round = obj.pennyChange*0.01
        obj.remainingChange -= round
    }
    return obj
}

var sale = Change()
sale.payment=13.00
sale.remainingChange = sale.payment - sale.price

println(sale.remainingChange)
getChange(sale)
createChangeMessage(changeMap)
println(changeMessage)








