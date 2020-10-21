(ns heron)

(defn limit?
  [n]
  (= 0 n))

(defn square
  [x]
  (* x x))
  
(defn avg
  [x y]
  (/ (+ x y) 2))

(defn improve
  [y x]
  (avg y (/ x y)))

(defn abs
  [x]
  (if (< x 0)
    (- x)
    x))  

(defn good-enough?
  [y x]
  (< (abs (- x (square y))) 0.00001))

(defn heron-sqrt
  [y x n]
    (if (or (limit? n) (good-enough? y x))
      y

    (heron-sqrt (improve y x) x (dec n))))