(ns euler.prob6)

(defn ^:private square [n]
  (* n n))

(defn ^:private sum-of-squares [ns]
  (->> ns
       (map square)
       (apply +)))

(defn ^:private square-of-sum [ns]
  (->> ns
       (apply +)
       (square)))

(defn solution []
  (- (square-of-sum (range 1 101)) (sum-of-squares (range 1 101))))
