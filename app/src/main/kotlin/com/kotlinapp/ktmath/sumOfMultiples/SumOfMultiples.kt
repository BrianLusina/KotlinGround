object SumOfMultiples{

    fun sum(numbers: Set<Int> = emptySet(), limit: Int) : Int{
        if( limit <= 1){
            return 0
        }

        val range = IntRange(1, limit -1)
        val multiples = arrayListOf<Int>()

        for (num in numbers){
            range
                    .asSequence()
                    .filter { it % num == 0 && it !in multiples }
                    .forEach { multiples.add(it) }
        }

        return multiples.sum()
    }


    fun sumV2(numbers: Set<Int> = emptySet(), limit: Int) =
            (1 until limit)
                    .filter {
                        value -> numbers.any{ it.hasMultiple(value) }
                    }.sum()


    private fun Int.hasMultiple(number : Int) = (number >= this) && (number % this == 0)
}