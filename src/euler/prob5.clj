(ns euler.prob5)

(defn ^:private divisible-by? [divisor]
  (fn [n] (= 0 (rem n divisor))))

(defn ^:private divisible-by-all? [ds]
  (->> ds
       (map divisible-by?)
       (apply every-pred)))

(defn solution []
  (->> (iterate inc 20)
       (filter (divisible-by-all? (range 21 1 -1)))
       (first)))
