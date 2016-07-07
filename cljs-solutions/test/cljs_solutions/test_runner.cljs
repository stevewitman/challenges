(ns cljs-solutions.test-runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cljs-solutions.test-graph]
              [cljs-solutions.test-problem_2]
              [cljs-solutions.test-problem_3]
              [cljs-solutions.test-problem_4]))

(doo-tests 'cljs-solutions.test-graph
           'cljs-solutions.test-problem_2
           'cljs-solutions.test-problem_3
           'cljs-solutions.test-problem_4)

