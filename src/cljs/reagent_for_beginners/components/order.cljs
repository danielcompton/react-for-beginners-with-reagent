(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]))

(defn order [[id quantity]]
  [:li
    [:span quantity "order" id]
    [:span.price quantity]])

(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    (for [{:keys [id quantity]} @state/orders]
      ^{:key id} [order id quantity])]
    
   [:strong "Total:"]])