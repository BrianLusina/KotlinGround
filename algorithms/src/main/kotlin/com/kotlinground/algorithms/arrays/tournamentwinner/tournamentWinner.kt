package com.kotlinground.algorithms.arrays.tournamentwinner

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
