(ns euler.prob22
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn ^:private score [[position name]]
  (* position
     (reduce + (map #(- (int %) (int \@)) name))))

(defn solution []
  (let [quoted (-> (slurp "resources/22-names.txt")
                   (str/split #",")
                   (sort))]
    (->> quoted
         (map-indexed
           (fn [i name]
             [(inc i) (str/replace name "\"" "")]))
         (map score)
         (reduce +))))
