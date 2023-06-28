package de.nekolike.rps

import de.nekolike.rps.game.Player
import de.nekolike.rps.game.PlayerStatisticsUpdater.addWinForPlayer
import de.nekolike.rps.model.Strategy
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RockPaperScissorsTest {

    lateinit var player: Player
    lateinit var opponent: Player

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
            opponent.losses shouldBe 1
        }
    }
}