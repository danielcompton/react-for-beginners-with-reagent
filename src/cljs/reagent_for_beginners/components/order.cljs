(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]))

(defn order [orders]
  (.log js/console orders)
  [:li
    [:span "order"]
    [:span.price "price"]])

(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    (.log js/console @state/orders)
    (.log js/console @state/fishes)
    [order]
    (map first @state/orders)
    (reduce + (map second @state/orders))]
   [:strong "Total:"]])


