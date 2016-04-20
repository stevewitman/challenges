(ns CodePlusChallenges.problem_2
  [:require [clojure.test :refer :all]
            [clojure.set :refer [intersection]]])


(defn- subseqs-by-count
  "Returns a lazy seq of sets of subsequences of the members of the given
  sequable. Each of the returned subsequences within its set will have the
  same count as the others there, and these containing sets are in order of
  decreasing subsequence count in the returned seq, ending with the given
  sequence.
  "
  [n-length-subseqs]
  (if (empty? (first n-length-subseqs))
    nil
    (cons n-length-subseqs
          (lazy-seq
            (subseqs-by-count (->> n-length-subseqs
                                ; There are just two (n-1)-length subseqs.
                                ; for each n-length subseq. Make them.
                                (mapcat (juxt butlast next))
                                ; Finally, remove duplicates.
                                set))))))


(defn common-subseqs
  "Returns a lazy seq of sets of subsequences common to all the given
  seqables. (Args. don't have to be strings.) Each set contains subsequences
  of the same count, and the sets are returned in decreasing order of these
  counts. None of the sets are empty.
  "
  [& strs]
  (let [min-cnt (apply min (map count strs))
        shorten (fn [seq-of-sets]
                  ; Remove extra sets from the front of arg. to make count
                  ; min-cnt. We use the fact that the count of arg. is just
                  ; the count of any sequence in its first set.
                  (-> seq-of-sets
                      first
                      first
                      count
                      (- min-cnt)
                      (drop seq-of-sets)))]
    (->> strs
         (map seq)                ; Ensure input consists of seqs, not strings.
         (map (partial conj #{})) ; Convert each inner seq to a set.
         (map subseqs-by-count)   ; Have seq of seq of sets of subsequences.
         (map shorten)            ; Only need to compare w/ shortest.
         (apply map intersection) ; Seq of sets of common seqs, by decr. count.
         (filter not-empty))))    ; Remove sets indicating no commons seqs.


(def maximal-common-subseqs (comp first common-subseqs))


(deftest test-subseqs-by-count
  (are [xs          result] (= result (subseqs-by-count #{(seq xs)}))
        []          nil
        ""          nil
        [:a]        [#{[:a]}]
        [:a :b]     [#{[:a :b]} #{[:a][:b]}]
        "abc"       [#{(seq "abc")}
                     #{(seq "ab") (seq "bc")}
                     #{(seq "a") (seq "b") (seq "c")}]))


(deftest test-common-subseqs
  (are [strs                     result] (= (map (comp set (partial map seq)) result)
                                            (apply common-subseqs strs))
        [""]                     []
        ["" ""]                  []
        ["a" ""]                 []
        ["ab" "cd"]              []
        ["ab"]                   [["ab"] ["a" "b"]]
        ["a" "ab"]               [["a"]]
        ["ab" "abc" "bcd"]       [["b"]]
        ["abc" "bcd" "cde"]      [["c"]]
        ["abcd" "abc" "abcde"]   [["abc"]["ab" "bc"]["a" "b" "c"]]))


(deftest test-maximal-common-subseqs
  (is (= (maximal-common-subseqs "abcde" "eabcd" "deabc" "bcab" "abc")
         #{[\b \c] [\a \b]})))

