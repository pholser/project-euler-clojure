(ns euler.prob9)

(defn ^:private pythagorean-triples []
  "See https://mathcs.clarku.edu/~djoyce/java/elements/bookX/propX29.html"
  (for [k (iterate inc 1)
        m (iterate inc 1)
        n (range 1 m)
        :let [a (* k (- (* m m) (* n n)))
              b (* k 2 m n)
              c (* k (+ (* m m) (* n n)))]]
    [a b c]))

(defn solution []
  (->> (pythagorean-triples)
       (filter #(= 1000 (apply + %)))
       (first)
       (apply *)))
