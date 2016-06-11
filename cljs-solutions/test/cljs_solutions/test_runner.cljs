(ns cljs-solutions.test-runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cljs-solutions.test-problem_2]
              [cljs-solutions.test-problem_3]
              [cljs-solutions.test-graph]))

(doo-tests 'cljs-solutions.test-problem_2
           'cljs-solutions.test-problem_3
           'cljs-solutions.test-graph)

