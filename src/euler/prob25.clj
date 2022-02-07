(ns euler.prob25)

(defn solution []
  (loop [f1 (bigint 1) f2 (bigint 1) index 3]
    (let [fib (+ f1 f2)
          digit-count (count (str fib))]
      (if (>= digit-count 1000)
        index
        (recur f2 (+ f1 f2) (inc index))))))
