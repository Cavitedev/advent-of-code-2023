package problems.day10

data class PipeNode(val pipe: Pipe, val lastNode: PipeNode?, val cost: Int)