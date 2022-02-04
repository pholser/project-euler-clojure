(ns euler.prob23
  (:require [euler.prob21 :refer [proper-divisors]]))

(defn ^:private perfect? [n]
  (= n (reduce + (proper-divisors n))))

(defn ^:private deficient? [n]
  (< (reduce + (proper-divisors n) n)))

(defn ^:private abundant? [n]
  (> (reduce + (proper-divisors n)) n))

(def abundant-numbers
  (filter abundant? (iterate inc 1)))

(def addends
  (take-while #(<= % 28123) abundant-numbers))

(def sums-of-abundants
  (reduce conj #{} (for [a addends
                         b addends
                         :let [sum (+ a b)]
                         :when (and (<= a b) (<= sum 28123))]
                     sum)))

(defn solution []
  (->> (range 1 28124)
       (filter (complement sums-of-abundants))
       (reduce +)))
