package de.nekolike.rps.game

import de.nekolike.rps.game.PlayerStatisticsUpdater.addDrawForPlayer
import de.nekolike.rps.game.PlayerStatisticsUpdater.addLossForPlayer
import de.nekolike.rps.game.PlayerStatisticsUpdater.addWinForPlayer
import de.nekolike.rps.model.Action
import de.nekolike.rps.model.Outcome

object Judge {
    private val rules = mapOf(
        Action.Rock to Action.Scissors,
        Action.Paper to Action.Rock,
        Action.Scissors to Action.Paper
    )
    fun determineWinnerAndAddResultsToPlayers(player: Player, opponent: Player) {
        val outcomeForPlayer = determineOutcomeForPlayer(player.action, opponent.action)

        when (outcomeForPlayer) {
            Outcome.WIN -> addWinForPlayer(player, opponent)
            Outcome.DRAW -> addDrawForPlayer(player, opponent)
            Outcome.LOSS -> addLossForPlayer(player, opponent)
        }
    }

    private fun determineOutcomeForPlayer(playerAction: Action, opponentAction: Action) : Outcome {
        return when {
            playerAction == opponentAction -> Outcome.DRAW
            rules[playerAction] == opponentAction -> Outcome.WIN
            else -> Outcome.LOSS
        }
    }
}

