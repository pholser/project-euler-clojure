(ns euler.prob7
  (:require [euler.prob3 :refer [prime-factors]]))

(defn ^:private prime? [n]
  (= [n] (prime-factors n)))

(defn solution []
  (->> (iterate inc 2)
       (filter prime?)
       (drop 10000)
       (first)))
