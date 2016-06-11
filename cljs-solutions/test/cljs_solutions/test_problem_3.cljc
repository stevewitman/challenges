(ns cljs-solutions.test-problem_3
  [:require
    [cljs-solutions.problem_3 :as p3]
    #?(:clj  [clojure.test :refer        [deftest is are]]
       :cljs [cljs.test    :refer-macros [deftest is are]])])


(def maze-a [[0 0 0 0 0 0 0 0 0 0 0]
             [0 1 1 1 1 1 1 0 1 0 1]
             [0 1 0 0 0 0 1 1 1 0 1]
             [0 1 1 0 1 0 0 1 0 0 1]
             [0 0 1 0 1 1 1 1 1 1 1]
             [0 1 1 0 1 0 0 0 0 0 1]
             [0 0 0 0 0 0 1 0 1 1 1]
             [0 1 1 1 1 1 1 0 1 0 1]
             [0 1 0 0 1 0 0 0 1 0 0]
             [0 1 0 0 1 1 1 1 1 0 1]
             [0 1 1 0 1 0 0 0 1 1 1]])

(def maze-b [[1 1 1 1 1 1 0 1 0 1]
             [1 0 0 0 0 1 1 1 0 1]
             [1 1 0 1 0 0 1 0 0 1]
             [0 1 0 1 1 1 1 1 1 1]
             [1 1 0 1 0 0 0 0 0 1]
             [0 0 0 1 0 1 0 1 1 1]
             [1 1 1 1 1 1 0 1 0 1]
             [1 0 0 1 0 0 0 1 0 0]
             [1 0 0 1 1 0 1 1 0 1]
             [1 1 0 1 0 0 0 1 1 1]])

(def maze-c [[0 0 0 0 0 0 0 0 0 0 0 0]
             [0 1 1 1 1 1 1 0 1 0 1 0]
             [0 1 0 0 0 0 1 1 1 0 1 0]
             [0 1 1 0 1 0 0 1 0 0 1 0]
             [0 0 1 0 1 1 1 1 1 1 1 0]
             [0 1 1 0 1 0 0 0 0 0 1 0]
             [0 0 1 0 0 0 1 0 1 1 1 0]
             [0 1 1 1 1 1 1 0 1 0 1 0]
             [0 1 0 0 1 0 0 0 1 0 0 0]
             [0 0 0 0 1 1 1 1 1 0 1 0]
             [0 1 1 1 1 0 0 0 1 1 1 0]
             [0 0 0 0 0 0 0 0 0 0 0 0]])


(deftest test-nodes-for-maze
  (is (= #{[0 2] [1 0] [1 1] [2 1] [2 3]}
         (p3/nodes-for-maze [[0 0 1 0]
                             [1 1]
                             [0 1 0 1]]
                            #{1}))))


(deftest test-adjacent
  (are
    [node1  node2   result] (and (= result (p3/adjacent? maze-a #{1} node1 node2)))
     [1 1]  [2 1]   true
     [1 1]  [0 1]   false
     [0 1]  [1 1]   true     ; Because we don't care if here is a wall node.
     [9 10] [9 11]  false    ; [9 11] is a wall node because it's not in maze.
     [9 10] [10 11] false    ; [10 11] is a wall node because it's not in maze.
     [9 10] [10 10] true
     [9 10] [10 9]  false    ; Because other is diagonal to here.
     [9 10] [9 9]   false
     [9 10] [8 10]  false))



(deftest test-min-paths
  (is (= (p3/min-paths maze-a #{1} [1 4] [9 10])
         [[[1 4][1 5][1 6][2 6][2 7][3 7][4 7][4 8][4 9][4 10][5 10]
           [6 10][6 9][6 8][7 8][8 8][9 8][10 8][10 9][10 10][9 10]]]))
  (is (= (p3/min-paths maze-b #{1} [0 3] [10 8])
         []))
  (is (= (p3/min-paths maze-c #{1} [1 4] [9 10])
       [[[1 4] [1 5] [1 6] [2 6] [2 7] [3 7] [4 7] [4 8] [4 9] [4 10] [5 10]
         [6 10] [6 9] [6 8] [7 8] [8 8] [9 8] [10 8] [10 9] [10 10] [9 10]]])))
