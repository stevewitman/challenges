(ns cljs-solutions.problem_4)


(defn- min-lists
  "Returns the concatenation of the given lists if their first members have
  the same count. Otherwise, the list containing the shortest first member is
  returned. If an argument is empty or nil, the other argument is returned.
  "
  [[l1-1st & _ :as l1] [l2-1st & _ :as l2]]
  (let [c1 (count l1-1st)
        c2 (count l2-1st)]
    (cond
      (zero? c1) l2
      (zero? c2) l1
      (< c1 c2)  l1
      (< c2 c1)  l2
      :else      (concat l1 l2))))


(defn fewest-coins
  "Returns a seq of vectors containing elements from the given sequence of
  distinct, positive integers, avail-coins, such that the sum of the elements
  in each returned vector is equal to the given desired-sum. The returned seq
  contains ALL such vectors of minimal count, thus each has the same count.
  "
  [[coin & rest-coins :as avail-coins] desired-sum]
  (if coin

    ; Test this distinct coin against desired-sum, recursing if necessary.
    (case (compare coin desired-sum)

      ; Coin is smaller than desired-sum, so conjoining it to each of the
      ; minimal solutions found by recursing with the REST of the coins and
      ; the REMAINDER will result in new minimal solutions for desired-sum.
      -1  (->> (fewest-coins avail-coins (- desired-sum coin))
               (map #(conj % coin))
               ; But we're not done, since there could be solutions that DON'T
               ; contain coin. Find them by recursing without coin but with the
               ; SAME desired-sum. Then, keep them or keep the above solutions,
               ; whichever have shorter solutions, or keep both lists of
               ; solutions. Note that min-lists only counts the first solution
               ; of each arg, so here we make use of the fact that solutions in
               ; each arg all have the same count.
               (min-lists (fewest-coins rest-coins desired-sum)))

      ; We nailed it! There can be no other solutions this short, so the list
      ; of solutions contains only [coin].
      0   [[coin]]

      ; We overshot, so we can't use coin. Try again without it but with the
      ; SAME desired-sum. We can use recur here because we just return result.
      1   (recur rest-coins desired-sum))

    ; Otherwise, we've run out of coins, so there is no solution.
    []))


