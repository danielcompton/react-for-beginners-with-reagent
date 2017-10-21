(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))

(defn remove-from-order [id]
  [:button {:on-click #(swap! state/orders dissoc id)} " \u00D7"])

(defn order [id quant]
  (if (= (-> @state/fishes id :status) "available")
    [:li
     [:span quant "lbs "(-> @state/fishes id :name) [remove-from-order id]]
     [:span.price (h/format-price (* quant (-> @state/fishes id :price)))]]
    [:li
     [:span (str "Sorry, " (if (-> @state/fishes id :name)
                             (-> @state/fishes id :name)
                             "fish")
                 " no longer available") [remove-from-order]]]))

(defn total []
  (h/format-price (reduce (fn [prev key]
                            (let [fish @state/fishes
                                  count (key @state/orders)
                                  is-available (fish @state/fishes)]
                              (if (= (-> @state/fishes key :status) "available")
                                (+ prev (* count (-> @state/fishes key :price)))
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
