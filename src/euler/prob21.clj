(ns euler.prob21
  (:require [euler.prob12 :refer [divisors]]))

(defn ^:private proper-divisors [n]
  (->> (divisors n)
       (filter (partial not= n))))

(defn ^:private d [n]
  (->> n
       (proper-divisors)
       (reduce +)))

(defn ^:private amicable? [a b]
  (and (= b (d a))
       (= a (d b))))

(defn ^:private amicables-under [n]
  (for [a (range 1 n)
        :let [b (d a)]
        :when (and (< a b) (= a (d b)))]
    #{a b}))

(defn solution []
  (->> (amicables-under 10000)
       (mapcat conj)
       (reduce +)))
