(ns euler.prob12)

(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(def triangle-numbers (map triangle (iterate inc 1)))

(defn divisors [n]
  (loop [d 1 acc #{}]
    (if (> d (Math/sqrt n))
      acc
      (recur
        (inc d)
        (cond-> acc
                (zero? (rem n d))
                (conj d (quot n d)))))))

(defn solution []
  (->> triangle-numbers
       (filter #(> (count (divisors %)) 500))
       (first)))
