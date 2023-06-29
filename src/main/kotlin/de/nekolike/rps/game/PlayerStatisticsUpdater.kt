package de.nekolike.rps.game

object PlayerStatisticsUpdater {
    fun addWinForPlayer(player: Player, opponent: Player) {
        player.addWin()
        opponent.addLoss()
    }

    fun addDrawForPlayer(player: Player, opponent: Player) {
        player.addDraw()
        opponent.addDraw()
    }

    fun addLossForPlayer(player: Player, opponent: Player) {
        player.addLoss()
        opponent.addWin()
    }
}