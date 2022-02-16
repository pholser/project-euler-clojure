(ns euler.prob26
  (:require [clojure.math.numeric-tower :as num]
            [euler.prob3 :refer [prime-factors]]
            [euler.prob7 :refer [prime?]]
            [euler.prob21 :refer [proper-divisors]]))

;; https://rosettacode.org/wiki/Multiplicative_order#Clojure


(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn modexp
  "b^e (mod m)"
  [b e m]
  (if (zero? e)
    (rem 1 m)
    (loop [c 1 e' 1]
      (let [c (rem (* b c) m)]
        (if (= e' e)
          c
          (recur c (inc e')))))))

(defn ord
  "Multiplicative order of a (mod n)"
  [a n]
  (cond
    (<= n 1) ##NaN
    (not= 1 (gcd a n)) ##NaN
    :else (->> (iterate inc 1)
               (filter #(= 1 (modexp a % n)))
               (first))))

(defn solution []
  (->> (range 1 1000)
       (map (fn [i] [i (ord 10 i)]))
       (remove #(Double/isNaN (second %)))
       (apply max-key second)
       (first)))
