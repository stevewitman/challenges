(ns cljs-solutions.problem_1)


(defn shuf
  "Returns the given collection shuffled randomly. If provided, the integer n
  must be the count of the colection. Note that Clojure has
  clojure.core/shuffle and ClojureScript has cljs.core/shuffle, both of which
  do just this. However, they both rely upon shuffling algorithms written in
  the hosting language (Java and JavaScript, respectively). So for the sake of
  education and fun, I thought I'd implement a shuffle function here in pure
  Clojure/ClojureScript.
  "

  ([coll]
   (shuf coll (count coll)))

  ([coll n]
   (if-let [[ls [r & rs]] (and (> n 0)
                               (split-at (rand-int n) coll))]
     ; Elem. r is a randomly chosen elem. pulled out of coll. Note that
     ; we always have such an element, because (rand-int n) is never n, so
     ; (second (split-at (rand-int n) coll)) is never empty.
     (-> (concat ls rs)
         (shuf (dec n))    ; Shuffle the n-1 elems. excluding r.
         (conj r))         ; Prepend r onto the n-1 now-shuffled elems.

     ; Else n is 0 and coll is empty, so we're done.
     [])))
