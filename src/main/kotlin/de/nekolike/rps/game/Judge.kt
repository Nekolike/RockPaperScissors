package de.nekolike.rps.game

import de.nekolike.rps.model.Action

object Judge {
    private val rules = mapOf(
        Action.Rock to Action.Scissors,
        Action.Paper to Action.Rock,
        Action.Scissors to Action.Paper
    )
    fun determineWinnerAndAddResultsToPlayers(player: Player, opponent: Player) {
        when {
            player.action == opponent.action -> playerDraws(player, opponent)
            rules[player.action] == opponent.action -> playerWins(player, opponent)
            else -> playerLoses(player, opponent)
        }
    }

    private fun playerChoosesRock(action: Action) : Boolean {
        return action == Action.Rock
    }

    private fun playerChoosesScissors(action: Action) : Boolean {
        return action == Action.Scissors
    }

    private fun playerChoosesPaper(action: Action) : Boolean {
        return action == Action.Paper
    }

    private fun playerWins(player: Player, opponent: Player) {
        player.wins++
        opponent.losses++
    }

    private fun playerDraws(player: Player, opponent: Player) {
        player.draws++
        opponent.draws++
    }

    private fun playerLoses(player: Player, opponent: Player) {
        player.losses++
        opponent.wins++
    }
}

