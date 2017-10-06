(ns reagent-for-beginners.helpers)

(defn format-price [price]
  (str "$"(/ price 100)))
