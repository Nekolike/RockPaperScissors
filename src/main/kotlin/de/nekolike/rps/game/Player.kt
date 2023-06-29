package de.nekolike.rps.game

import de.nekolike.rps.game.Judge.determineWinnerAndAddResultsToPlayers
import de.nekolike.rps.model.Action
import de.nekolike.rps.model.Strategy

class Player(val strategy: Strategy) {
    var wins = 0
        private set
    var losses = 0
        private set
    var draws = 0
        private set
    var action = chooseAction()
        private set

    fun playAgainst(opponent: Player) {
        action = chooseAction()
        determineWinnerAndAddResultsToPlayers(this, opponent)
    }

    private fun chooseAction(): Action {
        return when (strategy) {
            Strategy.Random -> chooseRandomAction()
            Strategy.Rock -> chooseRockAction()
        }
    }

    private fun chooseRandomAction() : Action {
        return Action.values().toList().shuffled().first()
    }

    private fun chooseRockAction() : Action {
        return Action.Rock
    }

    fun addWin() = wins++
    fun addLoss() = losses++
    fun addDraw() = draws++
}