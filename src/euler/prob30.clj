(ns euler.prob30
  (:require [clojure.math.numeric-tower :as num]))

(defn ^:private char->digit [ch]
  (- (int ch) (int \0)))

(defn ^:private upper-bound-for-power [e]
  (let [upper-digit-count
        (int (Math/floor (+ 1 (* e (Math/log10 9)) (Math/log10 e))))]
    (* upper-digit-count (num/expt 9 e))))

(defn ^:private sum-of-digit-powers [n e]
  (->> n
       (str)
       (map char->digit)
       (map #(num/expt % e))
       (reduce +)))

(defn solution []
  (->> (range 2 (upper-bound-for-power 5))
       (map (fn [n] [n (sum-of-digit-powers n 5)]))
       (filter #(= (first %) (second %)))
       (map first)
       (reduce +)))
