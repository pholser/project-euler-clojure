(ns euler.prob19
  (:require [java-time :as t]))

(defn firsts-of-months-starting-at [d]
  (let [one-month (t/months 1)]
    (iterate #(t/plus % one-month) d)))

(defn solution []
  (->> (firsts-of-months-starting-at (t/local-date "1901-01-01"))
       (filter #(= 7 (t/as % :day-of-week)))
       (take-while #(< (t/as % :year) 2001))
       (count)))
