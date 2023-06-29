package de.nekolike.rps

import de.nekolike.rps.game.Judge.determineWinnerAndAddResultsToPlayers
import de.nekolike.rps.game.Player
import de.nekolike.rps.game.PlayerStatisticsUpdater.addDrawForPlayer
import de.nekolike.rps.game.PlayerStatisticsUpdater.addLossForPlayer
import de.nekolike.rps.game.PlayerStatisticsUpdater.addWinForPlayer
import de.nekolike.rps.mock.PlayerMockHelper.opponentUsesPaper
import de.nekolike.rps.mock.PlayerMockHelper.opponentUsesRock
import de.nekolike.rps.mock.PlayerMockHelper.opponentUsesScissors
import de.nekolike.rps.mock.PlayerMockHelper.playerUsesPaper
import de.nekolike.rps.mock.PlayerMockHelper.playerUsesRock
import de.nekolike.rps.mock.PlayerMockHelper.playerUsesScissors
import de.nekolike.rps.model.Strategy
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RockPaperScissorsTest {

    lateinit var player: Player
    lateinit var opponent: Player
    val playerMock = mockk<Player>(relaxed = true)
    val opponentMock = mockk<Player>(relaxed = true)

    @BeforeEach
    fun init() {
        player = Player(Strategy.Random)
        opponent = Player(Strategy.Rock)
    }

    @Nested
    inner class AddResultToPlayer {
        @Test
        fun `add win to player`() {
            addWinForPlayer(player, opponent)

            player.wins shouldBe 1
            player.draws shouldBe 0
            player.losses shouldBe 0

            opponent.wins shouldBe 0
            opponent.draws shouldBe 0
            opponent.losses shouldBe 1
        }

        @Test
        fun `add draw to player`() {
            addDrawForPlayer(player, opponent)

            player.wins shouldBe 0
            player.draws shouldBe 1
            player.losses shouldBe 0

            opponent.wins shouldBe 0
            opponent.draws shouldBe 1
            opponent.losses shouldBe 0
        }

        @Test
        fun `add loss to player`() {
            addLossForPlayer(player, opponent)

            player.wins shouldBe 0
            player.draws shouldBe 0
            player.losses shouldBe 1

            opponent.wins shouldBe 1
            opponent.draws shouldBe 0
            opponent.losses shouldBe 0
        }
    }

    @Nested
    inner class DetermineWinner {
        @Test
        fun `rock vs rock results in draw`() {
            playerUsesRock(playerMock)
            opponentUsesRock(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addDrawForPlayer(playerMock, opponentMock) }
        }

        @Test
        fun `rock vs paper results in loss`() {
            playerUsesRock(playerMock)
            opponentUsesPaper(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addLossForPlayer(playerMock, opponentMock) }
        }

        @Test
        fun `rock vs scissors results in win`() {
            playerUsesRock(playerMock)
            opponentUsesScissors(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addWinForPlayer(playerMock, opponentMock) }
        }

        @Test
        fun `paper vs paper results in draw`() {
            playerUsesPaper(playerMock)
            opponentUsesPaper(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addDrawForPlayer(playerMock, opponentMock) }
        }

        @Test
        fun `paper vs scissors results in loss`() {
            playerUsesPaper(playerMock)
            opponentUsesScissors(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addLossForPlayer(playerMock, opponentMock) }
        }

        @Test
        fun `scissors vs scissors results in draw`() {
            playerUsesScissors(playerMock)
            opponentUsesScissors(opponentMock)

            determineWinnerAndAddResultsToPlayers(playerMock, opponentMock)

            verify { addDrawForPlayer(playerMock, opponentMock) }
        }
    }


}