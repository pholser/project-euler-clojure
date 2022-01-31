(ns euler.prob1)

(defn ^:private multiple-of? [divisor]
  (fn [n] (= 0 (rem n divisor))))

(defn solution []
  (->> (range 1000)
       (filter (some-fn (multiple-of? 3) (multiple-of? 5)))
       (apply +)))
