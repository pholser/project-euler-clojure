(ns euler.prob17
  (:require [com.gfredericks.forty-two :refer [words]]))

(defn ^:private number->words [n]
  (words n))

(defn solution []
  (->> (range 1 1001)
       (map number->words)
       (mapcat seq)
       (filter #(Character/isLetter %))
       (count)))
