(ns euler.prob15)

(defn binomial
  "Calculate the binomial coefficient.
  The binomial coefficient (n k) corresponds to the number
  of lattice paths from (0, 0) to (n, k).
  See https://clojuredocs.org/clojure.core/ns"
  [n k]
  (let [a (inc n)]
    (loop [b 1 c 1]
      (if (> b k)
        c
        (recur (inc b) (* (/ (- a b) b) c))))))

(defn solution [] (binomial 40 20))
