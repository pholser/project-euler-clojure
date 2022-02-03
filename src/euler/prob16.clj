(ns euler.prob16
  (:require [clojure.math.numeric-tower :as num]))

(defn solution []
  (->> (num/expt 2 1000)
       (str)
       (map #(- (int %) (int \0)))
       (reduce +)))
