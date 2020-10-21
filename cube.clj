(ns fp.cube)

(def precision 0.1)

;; return (x*x*x)
(defn cube
  [x]
  (* (* x x) x))

;; return (Math.abs(x - y^3))
(defn abs
  [y x]
  (Math/abs ^{:tag double} (- x (cube y)))
)

(defn good-enough?
  [y x]
  (< (abs y x) precision))

;; return (((x / y^2) + 2y) / 3)
(defn improve
  [y x]
  (/
    (+
      (/
        x (* y y ))
    (* y 2))
  3)
)

(defn heron-cube
  [y x]
  (if (good-enough? y x)
    y
    (heron-cube (improve y x) x)))