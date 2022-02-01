(ns euler.prob8
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def really-big-number
  (with-open [rdr (io/reader "resources/really-big-number.txt")]
    (->> (line-seq rdr)
         (str/join))))

(def really-big-number-digits
  (->> (seq really-big-number)
       (map #(- (int %) (int \0)))))

(defn solution []
  (->> really-big-number-digits
       (partition 13 1)
       (filter (partial not-any? #{0}))
       (map (partial reduce *))
       (apply max)))
