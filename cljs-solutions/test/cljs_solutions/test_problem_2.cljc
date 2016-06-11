(ns cljs-solutions.test-problem_2
  [:require
    [cljs-solutions.problem_2 :as p2]
    #?(:clj  [clojure.test :refer        [deftest is are]]
       :cljs [cljs.test    :refer-macros [deftest is are]])])


(deftest test-subseqs-by-count
  ; Function subseqs-by-count is private, but the var #'p2/subseqs-by-count
  ; can be looked up and dereferenced.
  (are [xs          result] (= result (@#'p2/subseqs-by-count #{(seq xs)}))
        []          nil
        ""          nil
        [:a]        [#{[:a]}]
        [:a :b]     [#{[:a :b]} #{[:a][:b]}]
        "abc"       [#{(seq "abc")}
                     #{(seq "ab") (seq "bc")}
                     #{(seq "a") (seq "b") (seq "c")}]))


(deftest test-common-subseqs
  (are [strs                     result] (= (map (comp set (partial map seq))
                                                 result)
                                            (apply p2/common-subseqs strs))
        [""]                     []
        ["" ""]                  []
        ["a" ""]                 []
        ["ab" "cd"]              []
        ["ab"]                   [["ab"] ["a" "b"]]
        ["a" "ab"]               [["a"]]
        ["ab" "abc" "bcd"]       [["b"]]
        ["abc" "bcd" "cde"]      [["c"]]
        ["abcd" "abc" "abcde"]   [["abc"]["ab" "bc"]["a" "b" "c"]]))


(deftest test-maximal-common
  (is (= (p2/maximal-common-subseqs "abcde" "eabcd" "deabc" "bcab" "abc")
         #{[\b \c] [\a \b]}))
  (is (= (set (p2/maximal-common-substrings
                "abcde" "eabcd" "deabc" "bcab" "abc"))
         #{"bc" "ab"}))
  (is (= (set (p2/maximal-common-substrings-ignoring-case
                "AbcDe" "Eabcd" "deaBc" "bcab" "abc"))
         #{"BC" "AB"})))
