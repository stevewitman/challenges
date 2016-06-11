(ns cljs-solutions.problem_3
  [:require [cljs-solutions.graph :refer [shortest-paths]]])


(defn nodes-for-maze
  [maze is-hall-node]
  (set (for [[row      r-idx] (map vector maze (range))
             [node-val c-idx] (map vector row (range))
             :when (is-hall-node node-val)]
         [r-idx c-idx])))


(defn adjacent?
  "A predicate returning true iff other is a \"hall\" node (according to
   function is-hall-node in vector maze) and differs from here by no more than
   1 in either the row or column direction, but not both. Thus nodes next to
   each other diagonally are NOT adjacent."
  [maze is-hall-node here other]
  (letfn [(within-1? [n1 n2]
            (every? identity (map #(<= -1 (- %1 %2) 1) n1 n2)))
          (same-row-or-col? [n1 n2]
            (->> (map not= n1 n2)
                 (filter identity)
                 (= [true])))]

    (boolean (and (within-1? here other)
                  (same-row-or-col? here other)
                  (is-hall-node (get-in maze other))))))


(defn min-paths
  [maze is-hall-node start end]
  (shortest-paths (partial adjacent? maze is-hall-node)
                  (nodes-for-maze maze is-hall-node)
                  start
                  end))

