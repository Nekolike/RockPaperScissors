import de.nekolike.rps.model.Strategy
import de.nekolike.rps.game.Player

fun main(args: Array<String>) {
    val player = Player(Strategy.Random)
    val opponent = Player(Strategy.Rock)

    repeat(100) {
        player.playAgainst(opponent)
    }

    println("--------- Player Stats ---------")
    println("Player wins: ${player.wins}")
    println("Player draws: ${player.draws}")
    println("Player loses: ${player.losses}")

    println("--------- Opponent Stats ---------")
    println("Opponent wins: ${opponent.wins}")
    println("Opponent draws: ${opponent.draws}")
    println("Opponent loses: ${opponent.losses}")

}

