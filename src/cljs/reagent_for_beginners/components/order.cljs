(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]))

(defn order [orders]
  [:li
    [:span "order"]
    [:span.price "price"]])

(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    [order ]
    (map first @state/orders)
    (reduce + (map second @state/orders))]
   [:strong "Total:"]])


