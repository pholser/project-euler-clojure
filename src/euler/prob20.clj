(ns euler.prob20)

(defn factorial
  ([n] (factorial (bigint n) (bigint 1)))
  ([n acc]
   (if (zero? n)
     acc
     (recur (dec n) (* acc n)))))

(defn solution []
  (->> (factorial 100)
       (str)
       (map #(- (int %) (int \0)))
       (reduce +)))
