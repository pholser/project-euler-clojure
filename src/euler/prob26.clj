(ns euler.prob26
  (:require [clojure.math.numeric-tower :as num]
            [euler.prob3 :refer [prime-factors]]
            [euler.prob7 :refer [prime?]]
            [euler.prob21 :refer [proper-divisors]]))

;; https://rosettacode.org/wiki/Multiplicative_order#Clojure


(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(def NaN (Math/log -1))

(def primes
  (concat '(2 3 5)
          (filter prime? (iterate #(+ 2 %) 7))))

(defn prime-factors-with-exponents [n]
  (->> (prime-factors n)
       (partition-by identity)
       (map (fn [group] [(first group) (count group)]))))

;;def multOrder_(a, p, k)
;  pk = p ** k
;  t = (p - 1) * p ** (k - 1)
;  r = 1
;  for q, e in t.prime_division
;    x = powerMod(a, t / q**e, pk)
;    while x != 1
;      r *= q
;      x = powerMod(x, q, pk)
;    end
;  end
;  r
;end

(defn modpow
  " b^e mod m (using Java which solves some cases the pure clojure method has to be modified to tackle--i.e. with large b & e and
    calculation simplications when gcd(b, m) == 1 and gcd(e, m) == 1) "
  [b e m]
  (.modPow (biginteger b) (biginteger e) (biginteger m)))


(defn ord [a m]
  (->> m
       (prime-factors-with-exponents)
       (map (partial ord' a))
       (reduce lcm)))