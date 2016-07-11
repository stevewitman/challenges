#!/usr/bin/env python3
#
#     This is a program that determines whether the parentheses, brackets, and
#     braces in a string are balanced -- i.e., "valid" -- or not.
#
#     Examples of valid strings:
#
#         []
#         ()
#         ()[]
#         a(b[c]d)e
#
#     Examples of invalid strings:
#
#         [
#         )
#         [(])
#

import unittest


def is_balanced(expression):

    mates = {'(': ')', '[': ']', '{': '}'}  # Map openers to corresp. closers.
    closers = mates.values()                # Set of searched-for strings.
    targets = []                            # Stack of closers. The last one
                                            #   is currently searched for.
    for x in expression:

        if targets and x == targets[-1]:    # Found crnt. searched-for closer.
            targets.pop()                   # Don't continue to look for it.

        elif x in closers:
            return False                    # It's a different closer. Invalid!

        else:
            mate = mates.get(x)             # Else, it's an ordinary char. or
            if mate:                        #   an opener. If opener, push its
                targets.append(mate)        #   corresponding closer, mate.

    return not targets                      # Valid iff no unfound closers.


#   Run the unit tests from the command line like this:
#
#       > python3 -m unittest problem_5_tyler
#       .
#       ----------------------------------------------------------------------
#       Ran 1 test in 0.000s
#
#       OK
#
class TestIsBalanced(unittest.TestCase):

    def test_is_balanced(self):
        self.assertTrue(is_balanced(''))
        self.assertTrue(is_balanced('[]'))
        self.assertTrue(is_balanced('()'))
        self.assertTrue(is_balanced('()[]'))
        self.assertTrue(is_balanced('a(b[c]d)e'))
        self.assertFalse(is_balanced('['))
        self.assertFalse(is_balanced(')'))
        self.assertFalse(is_balanced('[(])'))


#   Run this script from the command line as follows:
#
#   > python3 problem_5_tyler.py '0[abc](xy)' '[abc(]xy)'
#   True
#   False
#
if __name__ == '__main__':
    from sys import argv
    for a in argv[1:]:
        print(is_balanced(a))

