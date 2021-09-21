package com.kotlinground.strings.maximumtime

/**
 * Finds the maximum time from a given string input of the format hh:mm
 * @param time [String] time string of format hh:mm with some digits set as ?
 * @return [String] maximum possible time
 */
fun maximumTime(time: String): String {
    val hoursAndMinutes = time.toCharArray()

    if (hoursAndMinutes[0] == '?') {
        hoursAndMinutes[0] = if (hoursAndMinutes[1] == '?') '2' else if (hoursAndMinutes[1] > '3') '1' else '2'
    }

    if (hoursAndMinutes[1] == '?')
        hoursAndMinutes[1] = if (hoursAndMinutes[0] == '2') '3' else '9'

    if (hoursAndMinutes[3] == '?')
        hoursAndMinutes[3] = '5'

    if (hoursAndMinutes[4] == '?')
        hoursAndMinutes[4] = '9'

    return String(hoursAndMinutes)
}
