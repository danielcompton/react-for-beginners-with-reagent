(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))



(defn order [id quant]
  (.log js/console id quant)
  [:li
    [:span id]
    [:span.price quant]])

(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    (for [[id quant] @state/orders]
      ^{:key id} [order id quant])
    [:li.total
     ;; (.log js/console @state/fishes)
     ;; (.log js/console @state/orders)
     
    ;; (map first @state/orders)
     [:strong "Total:" (h/format-price
                        (* ((first @state/fishes) :price)(reduce + (map second @state/orders))))]]]])


