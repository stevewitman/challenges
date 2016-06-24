# FEWEST COINS THAT SUM TO A VALUE

### Find all bags as small as possible that contain coins whose values add up to a particular sum.

That is, given a list of distinct positive integer values (representing coin denominations) along with a desired sum, find all minimal bags of coins of the given denominations whose values add up to the desired sum. (N.B., "bag" means
that repetition of elements is possible, but order is not significant.)

Examples:

    ([], 1)            => []

	([1 2 3], 6)       => [[3 3]]

    ([2 4 6], 7)       => []

    ([11 9 7 5 1], 15) => [[5 5 5] [1 7 7] [1 5 9]]

    ([11 9 7 5 1], 25) => [[7 9 9] [7 7 11] [5 9 11]]

    ([11 9 7 5 1], 45) => [[9 9 9 9 9] [7 9 9 9 11] [7 7 9 11 11]
                           [5 9 9 11 11] [5 7 11 11 11] [1 11 11 11 11]]

