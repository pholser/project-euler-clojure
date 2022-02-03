(ns euler.prob13
  (:require [clojure.java.io :as io]))

(defn solution []
  (let [sum
        (with-open [rdr (io/reader "resources/13-fifty-digit-numbers.txt")]
          (->> (line-seq rdr)
               (map bigint)
               (reduce +)))]
    (subs (str sum) 0 10)))
