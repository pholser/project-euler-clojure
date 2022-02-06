(ns euler.prob24
  (:require [clojure.math.combinatorics :as combos]
            [clojure.string :as str]))

;; Not going as far as calculating the nth permutation by hand,
;; nor using the combos library's `nth-permutation`.

(defn solution []
  (->> (combos/permutations (seq "0123456789"))
       (drop (dec 1000000))
       (first)
       (str/join "")))
