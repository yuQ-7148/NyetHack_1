import kotlin.math.roundToInt

const val TAVERN_NAME = "taernyl's Folly"
var playerGold = 10
var playerSilver = 10
//val patronList = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")


fun main() {
    if(patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yes, they're seated by the stew kettle.")
    }else {
        println("The tavern master says: nay, they departed hours ago.")
    }

    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder("elixir, Shirley's Temple,4.12")
//    println(patronList[0])

    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Alex")
    patronList[0] = "Alexis"
    println(patronList)

    for(patron in patronList) {
        println("Good evening, $patron")
    }

}


private fun placeOrder(menuData: String) {
    //与旅店老板交谈
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    //下单
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $$price."
    println(message)

    //支付过程
    performPurchase(price.toDouble())

    //餐后感想
    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks  for the $name."
    }
    println(phrase)
}


fun performPurchase(price: Double) {
    //钱包金币
    displayBalance()

    //总金额
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")

    //应付金额
    println("Purchasing item for $price")

    //剩余金额
    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    //剩余金币数量计算
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver

    //钱包金币
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}


private fun toDragonSpeak(phrase: String) =
    phrase.toLowerCase().replace(Regex("[aeiou14]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "1" -> "i"
            "4" -> "a"
            else -> it.value
        }
    }