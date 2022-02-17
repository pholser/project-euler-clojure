(ns euler.prob28)

(defn diagonal-sums [side]
  (cond (< side 0) ##NaN
        (even? side) ##NaN
        :else (loop [n side acc 0]
                (if (= 1 n)
                  (inc acc)
                  (let [sq (* n n) diff (dec n)]
                    (recur
                      (- n 2)
                      (+ acc
                         sq
                         (- sq diff)
                         (- sq (* 2 diff))
                         (- sq (* 3 diff)))))))))

(defn solution []
  (diagonal-sums 1001))
