package de.nekolike.rps.game

object PlayerStatisticsUpdater {
    fun addWinForPlayer(player: Player, opponent: Player) {
        player.wins++
        opponent.losses++
    }

    fun addDrawForPlayer(player: Player, opponent: Player) {
        player.draws++
        opponent.draws++
    }

    fun addLossForPlayer(player: Player, opponent: Player) {
        player.losses++
        opponent.wins++
    }
}