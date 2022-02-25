(ns euler.prob27
  (:require [euler.prob7 :refer [prime?]]))

(defn quadratic [a b]
  (fn [n]
    (+ (* n n) (* a n) b)))

(defn prime-seq [q]
  (->> (range)
       (map q)
       (take-while prime?)))

(defn solution []
  (as-> (for [a (range -999 1000)
              b (range -1000 1001)]
         (let [q (quadratic a b)]
           {:a a :b b :count (count (prime-seq q))})) <>
        (apply (partial max-key :count) <>)
        (map <> [:a :b])
        (reduce * <>)))
