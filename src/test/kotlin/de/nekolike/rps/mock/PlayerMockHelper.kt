package de.nekolike.rps.mock

import de.nekolike.rps.game.Player
import de.nekolike.rps.model.Action
import io.mockk.every

object PlayerMockHelper {
    fun playerUsesRock(playerMock: Player) {
        every { playerMock.action } returns Action.Rock
    }

    fun playerUsesPaper(playerMock: Player) {
        every { playerMock.action } returns Action.Paper
    }

    fun playerUsesScissors(playerMock: Player) {
        every { playerMock.action } returns Action.Scissors
    }

    fun opponentUsesRock(opponentMock: Player) {
        every { opponentMock.action } returns Action.Rock
    }

    fun opponentUsesPaper(opponentMock: Player) {
        every { opponentMock.action } returns Action.Paper
    }

    fun opponentUsesScissors(opponentMock: Player) {
        every { opponentMock.action } returns Action.Scissors
    }
}