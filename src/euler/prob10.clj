(ns euler.prob10
  (:require [euler.prob7 :refer [prime?]]))

(defn ^:private primes []
  (lazy-seq (cons 2 (->> (iterate #(+ 2 %) 3)
                         (filter prime?)))))

(defn solution []
  (->> (primes)
       (take-while #(< % 2000000))
       (reduce +)))
