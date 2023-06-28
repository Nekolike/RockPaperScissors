package de.nekolike.rps.game

import de.nekolike.rps.model.Action

object Judge {
    fun determineWinnerAndAddResultsToPlayers(player: Player, opponent: Player) {
        if (playerChoosesRock(player.action)) {
            when (opponent.action) {
                Action.Rock -> playerDraws(player, opponent)
                Action.Paper -> playerLoses(player, opponent)
                Action.Scissors -> playerWins(player, opponent)
            }
        } else if (playerChoosesPaper(player.action)) {
            when (opponent.action) {
                Action.Rock -> playerWins(player, opponent)
                Action.Paper -> playerDraws(player, opponent)
                Action.Scissors -> playerLoses(player, opponent)
            }
        } else if (playerChoosesScissors(player.action)) {
            when (opponent.action) {
                Action.Rock -> playerLoses(player, opponent)
                Action.Paper -> playerWins(player, opponent)
                Action.Scissors -> playerDraws(player, opponent)
            }
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