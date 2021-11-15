fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    printPlayerStatus(healthPoints, isBlessed, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    println("$name $healthStatus")
    castFireball()

    performCombat()
    performCombat("Ulrich")
    performCombat(
        isBlessed = true,
        enemyName = "Hildr"
    )

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Sorry,find nothing"
    }

}

private fun printPlayerStatus(healthPoints: Int, isBlessed: Boolean, isImmortal: Boolean) {
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            in 16..20 -> "green"
            else -> "NONE"
        }
    } else {
        "NONE"
    }
    println("(Aura: $auraColor) " + "(Blesses: ${if (isBlessed) "YES" else "NO"})")
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
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

private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")

fun performCombat() {
    println("You see nothing to fight!")
}

fun performCombat(enemyName: String) {
    println("You begin fighting $enemyName.")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("You begin fighting $enemyName. You are blessed with 2X damage!")
    } else {
        println("You begin fighting $enemyName.")
    }
}