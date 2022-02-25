(ns euler.prob29
  (:require [clojure.math.numeric-tower :as math]))

(defn power-seq [max-a max-b]
  (for [a (range 2 (inc max-a))
        b (range 2 (inc max-b))]
    (math/expt a b)))

(defn solution []
  (->> (power-seq 100 100)
       (distinct)
       (count)))
