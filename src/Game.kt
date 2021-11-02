fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    /*if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }*/
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    /*val healthStatus = if (healthPoints == 100) {
        "is in excellent condition!"
    } else if (healthPoints in 90..99) {
        "has a few scratches."
    } else if (healthPoints in 75..89) {
        if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
    } else if (healthPoints in 15..74) {
        "look pretty hurt."
    } else {
        "is in awful condition!"
    }*/
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    //println(name + " " + healthStatus)
    println("$name $healthStatus")

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Sorry,find nothing"
    }

}