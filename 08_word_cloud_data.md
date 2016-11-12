# Word Cloud Data

[[Back to Challenges]](https://github.com/stevewitman/challenges "Return to 'Challenges'")

For this challenge ([from InterviewCake.com](https://www.interviewcake.com/question/python/word-cloud)), write code that takes a long string and builds its word cloud data in a dictionary, where the keys are words and the values are the number of times the words occurred.

Think about capitalized words. For example, look at these sentences:

```
'After beating the eggs, Dana read the next step:'
'Add milk and eggs, then add flour and sugar.'
```
What do we want to do with "After", "Dana", and "add"? In this example, your final dictionary should include one "Add" or "add" with a value of 2.
Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".

You could make a reasonable argument to use regex in your solution. We won't, mainly because performance is difficult to measure and can get pretty bad.
