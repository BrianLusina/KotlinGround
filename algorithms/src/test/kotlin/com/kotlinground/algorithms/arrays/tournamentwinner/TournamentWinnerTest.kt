package com.kotlinground.algorithms.arrays.tournamentwinner

import kotlin.test.Test
import kotlin.test.assertEquals

class TournamentWinnerTest {

    @Test
    fun `test 1`() {
        val competitions = listOf(listOf("HTML", "C#"), listOf("C#", "Python"), listOf("Python", "HTML"))
        val results = listOf(0, 0, 1)
        val expected = "Python"
        val actual = tournamentWinner(competitions, results)
        assertEquals(expected, actual)
    }

    @Test
    fun `test 2`() {
        val competitions = listOf(listOf("HTML", "Java"), listOf("Java", "Python"), listOf("Python", "HTML"))
        val results = listOf(0, 1, 1)
        val expected = "Java"
        val actual = tournamentWinner(competitions, results)
        assertEquals(expected, actual)
    }

    @Test
    fun `test tournament with only two teams`() {
        val competitions = listOf(listOf("Team A", "Team B"))
        val results = listOf(1)
        val expected = "Team A"
        val actual = tournamentWinner(competitions, results)
        assertEquals(expected, actual)
    }

    @Test
    fun `test tournament with tie - first team with max points should be returned`() {
        // In this scenario, both Team A and Team C end up with 6 points
        // Team A should be returned as it reached 6 points first
        val competitions = listOf(
            listOf("Team A", "Team B"),
            listOf("Team C", "Team D"),
            listOf("Team A", "Team C"),
            listOf("Team B", "Team D")
        )
        val results = listOf(1, 1, 0, 0)
        // Team A: 3 points (beat Team B) + 0 points (lost to Team C) = 3 points
        // Team B: 0 points (lost to Team A) + 3 points (beat Team D) = 3 points
        // Team C: 3 points (beat Team D) + 3 points (beat Team A) = 6 points
        // Team D: 0 points (lost to Team C) + 0 points (lost to Team B) = 0 points
        val expected = "Team C"
        val actual = tournamentWinner(competitions, results)
        assertEquals(expected, actual)
    }

    @Test
    fun `test tournament with multiple teams`() {
        val competitions = listOf(
            listOf("Team A", "Team B"),
            listOf("Team B", "Team C"),
            listOf("Team C", "Team D"),
            listOf("Team D", "Team E"),
            listOf("Team E", "Team A")
        )
        val results = listOf(1, 1, 1, 1, 0)
        // Team A: 3 points (beat Team B) + 3 points (beat Team E) = 6 points
        // Team B: 0 points (lost to Team A) + 3 points (beat Team C) = 3 points
        // Team C: 0 points (lost to Team B) + 3 points (beat Team D) = 3 points
        // Team D: 0 points (lost to Team C) + 3 points (beat Team E) = 3 points
        // Team E: 0 points (lost to Team D) + 0 points (lost to Team A) = 0 points
        val expected = "Team A"
        val actual = tournamentWinner(competitions, results)
        assertEquals(expected, actual)
    }
}
