(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))

(defn order [id quant]
  [:li
    [:span quant "lbs "(-> @state/id-fishes id :name)]
    [:span.price (h/format-price (* quant (-> @state/id-fishes id :price)))]])

(defn total []
  (h/format-price (reduce (fn [prev key]
                            (let [fish @state/id-fishes
                                  count (key @state/orders)
                                  is-available (fish @state/id-fishes)]
                              (if (= (-> @state/id-fishes key :status) "available")
                                (+ prev (* count (-> @state/id-fishes key :price)))
                                prev)))
                          0 (keys @state/orders))))

(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    (for [[id quant] @state/orders]
      ^{:key id} [order id quant])
    [:li.total
     [:strong "Total:"]  (total)]]])
