


fun main() {

    mapOf("A" to )

    Day2_RCP.testData.lines()
            .map { line -> line.split(' ')}
}

sealed interface Choice {
    val losesTo: Choice
}

fun Choice.winsFrom(choice: Choice) : Boolean {
    choice
}

class Rock : Choice {
    override val losesTo: Choice
        get() = Paper


}


class Day2_RCP {
    companion object {
        var testData="""A Y
    B X
    C Z"""
    }

}