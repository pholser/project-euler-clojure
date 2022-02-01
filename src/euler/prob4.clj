(ns euler.prob4)

(defn ^:private palindrome? [s]
  (= s (apply str (reverse s))))

(defn solution []
  (->> (for [x (range 999 99 -1)
             y (range 999 x -1)]
         (* x y))
       (map str)
       (filter palindrome?)
       (map #(Integer/parseInt %))
       (apply max)))
