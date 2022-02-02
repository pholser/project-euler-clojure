(ns euler.prob3)

(defn prime-factors
  ([n]
   (prime-factors [] n 2))
  ([factors n candidate]
   (cond
     (= n 1) factors
     (zero? (rem n candidate)) (recur (conj factors candidate) (quot n candidate) candidate)
     (> candidate (Math/sqrt n)) (conj factors n)
     :else (recur factors n (inc candidate)))))

(defn solution []
  (->> (prime-factors 600851475143N)
       (reduce max)))
