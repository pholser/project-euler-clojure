(ns euler.prob18
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def triangle
  (with-open [rdr (io/reader "resources/18-triangle.txt")]
   (->> (line-seq rdr)
        (mapv #(str/split % #"\s+"))
        (mapv (fn [row] (mapv #(Integer/parseInt %) row)))
        (doall))))

(defn longest-path-sum
  ([triangle] (longest-path-sum triangle 0 0))
  ([triangle row col]
   (let [current-val (get-in triangle [row col])]
     (if (= row (- (count triangle) 1))
       current-val
       (+ current-val
          (max (longest-path-sum triangle (inc row) col)
               (longest-path-sum triangle (inc row) (inc col))))))))

(defn solution [] (longest-path-sum triangle))
