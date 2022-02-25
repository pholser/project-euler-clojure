(ns euler.prob31)

(defn ^:private ways-to-make-change [denoms total]
  (cond
    (zero? total) 1
    (empty? denoms) 0
    (= 1 (count denoms)) (if (zero? (rem total (first denoms))) 1 0)
    :else (let [denom (first denoms)
                denom-count (quot total denom)]
            (reduce
              +
              (map (fn [c]
                     (let [reduced-total (- total (* c denom))]
                       (ways-to-make-change (rest denoms) reduced-total)))
                   (range 0 (inc denom-count)))))))

(defn solution []
  (ways-to-make-change [200 100 50 20 10 5 2 1] 200))
