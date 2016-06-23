(ns cljs-solutions.test-problem_4
  [:require
    [cljs-solutions.problem_4 :as p4]
    #?(:clj  [clojure.test :refer        [deftest is are]]
       :cljs [cljs.test    :refer-macros [deftest is are]])])


(deftest test-min-lists
  (are [l1          l2            should-be]

       (= should-be (@#'p4/min-lists l1 l2))

       nil         nil           nil
       []          [[1]]         [[1]]
       [[]]        [[1]]         [[1]]
       [[1]]       []            [[1]]
       [[1]]       [[]]          [[1]]
       [[1]]       [[1]]         [[1] [1]]
       [[1]]       [[1 2]]       [[1]]
       [[1 2]]     [[9]]         [[9]]
       [[1] [2]]   [[3 3] [4 4]] [[1] [2]]))


(deftest test-fewest-coins
  (are [avail-coins desired-sum should-be]

       (let [result (p4/fewest-coins avail-coins desired-sum)]
         (and (= (count result) (count should-be))
              (= (set (map sort should-be))
                 (set (map sort result)))))

       []           1           []
       [2]          1           []
       [1]          0           []
       [1]          1           [[1]]
       [11 9 7 5 1] 14          [[9 5] [7 7]]
       [11 9 7 5 1] 15          [[9 5 1] [7 7 1] [5 5 5]]
       [11 9 7 5 1] 16          [[11 5] [9 7]]
       [11 9 7 5 1] 18          [[11 7] [9 9]]
       [11 9 7 5 1] 22          [[11 11]]
       [11 9 7 5 1] 25          [[11 9 5] [11 7 7] [9 9 7]]
       [11 9 7 5 1] 100         [[11 11 11 11 11 11 11 11 11 1]
                                 [11 11 11 11 11 11 11 11 7 5]
                                 [11 11 11 11 11 11 11 9 9 5]
                                 [11 11 11 11 11 11 11 9 7 7]
                                 [11 11 11 11 11 11 9 9 9 7]
                                 [11 11 11 11 11 9 9 9 9 9]]))

