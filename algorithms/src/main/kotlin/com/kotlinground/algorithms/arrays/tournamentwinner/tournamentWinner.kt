package com.kotlinground.algorithms.arrays.tournamentwinner

/**
 * Determines the overall winner of a tournament based on the results of multiple competitions.
 *
 * Each competition consists of a home and away team, and the results indicate which team won each match.
 * The winning team of each competition receives 3 points. The function returns the team with the highest total points.
 *
 * @param competitions A list of pairs of team names, where each pair represents a competition (home team at index 0, away team at index 1).
 * @param results A list of integers indicating the winner of each competition (0 for away team, 1 for home team).
 * @return The name of the team with the highest total points.
 */
fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    var winner = ""
    val teams = mutableMapOf<String, Int>()
    var maxPoints = 0

    for ((idx, competition) in competitions.withIndex()) {
        val homeTeam = competition[0]
        val awayTeam = competition[1]
        val competitionWinner = results[idx]

        // Determine which team won
        val winningTeam = if (competitionWinner == 0) awayTeam else homeTeam

        // Add 3 points to the winning team
        val currentPoints = teams.getOrDefault(winningTeam, 0)
        val newPoints = currentPoints + 3
        teams[winningTeam] = newPoints

        // Update the current winner if needed
        if (newPoints > maxPoints) {
            maxPoints = newPoints
            winner = winningTeam
        }
    }

    return winner
}
