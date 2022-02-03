(ns euler.prob14)

(defn next-collatz [n]
  (if (even? n)
    (/ n 2)
    (+ 1 (* 3 n))))

(defn collatz-seq [start]
  (cons start (take-while #(not= 1 %) (iterate next-collatz (next-collatz start)))))

(defn solution []
  (->> (range 1 1000000)
       (map (fn [n] [n (collatz-seq n)]))
       (reduce (partial max-key (fn [[_ v]] (count v))))
       (first)))
