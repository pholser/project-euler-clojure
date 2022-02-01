(ns euler.prob3)

(defn ^:private prime-factors [n]
  (let [limit (Math/sqrt n)]
    (loop [remainder n
           acc []
           divisor 2]
      (cond (> divisor n)
            acc
            (<= remainder 1)
            acc
            (= 0 (rem remainder divisor))
            (recur (quot remainder divisor)
                   (conj acc divisor)
                   divisor)
            :else
            (recur remainder
                   acc
                   (if (= 2 divisor) 3 (+ 2 divisor)))))))

(defn solution []
  (->> (prime-factors 600851475143N)
       (apply max)))