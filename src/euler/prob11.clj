(ns euler.prob11
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def grid
  (with-open [rdr (io/reader "resources/11-grid.txt")]
    (->> (line-seq rdr)
         (mapv #(str/split % #"\s+"))
         (mapv (fn [row] (mapv #(Integer/parseInt %) row)))
         (doall))))

(defn value-at [coord]
  (get-in grid coord))

(def left-to-rights
  (mapcat (partial partition 4 1) grid))

(def up-and-downs
  (for [c (range 20)
        r (range 17)]
    (map #(value-at [(+ r %) c]) (range 4))))

(def left-right-diags
  (for [r (range 17)
        c (range 17)]
    (map #(value-at [(+ r %) (+ c %)]) (range 4))))

(def up-down-diags
  (for [r (range 3 20)
        c (range 17)]
    (map #(value-at [(- r %) (+ c %)]) (range 4))))

(defn solution []
  (->> (concat left-to-rights up-and-downs left-right-diags up-down-diags)
       (map (partial apply *))
       (reduce max)))
