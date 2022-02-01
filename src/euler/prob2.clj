(ns euler.prob2)

(defn ^:private fast-fibo [n]
  (loop [[f1 f2] [1 2] index n]
    (cond (= 0 index) 1
          (= 1 index) f2
          :else (recur [f2 (+ f1 f2)] (dec index)))))

(defn solution []
  (->> (range)
       (map fast-fibo)
       (take-while #(<= % 4000000))
       (filter even?)
       (apply +)))
