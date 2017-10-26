(ns reagent-for-beginners.components.order
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))

(defn remove-from-order [id]
  [:button {:on-click #(swap! state/orders dissoc id)} " \u00D7"])

(defn order [id quant]
  (let [fish-name (-> @state/fishes id :name)]
    (if (= (get-in @state/fishes [id :status]) "available")
      [:li
       [:span quant "lbs " fish-name [remove-from-order id]]
       [:span.price (h/format-price (* quant (-> @state/fishes id :price)))]]
      [:li
       [:span (str "Sorry, " (if fish-name
                               fish-name
                               "fish")
                   " no longer available")
        [remove-from-order]]])))

(defn total []
  (h/format-price (reduce (fn [sum k]
                            (let [fish @state/fishes
                                  count (k @state/orders)]
                              (if (= (-> @state/fishes k :status) "available")
                                (+ sum (* count (-> @state/fishes k :price)))
                                sum)))
                          0 (keys @state/orders))))

(reduce (fn [sum [k order]]
          (let [fish  @state/fishes]
            (if (= (get-in @state/fishes [k :status]) "available")
              (+ sum (* order (-> @state/fishes k :price)))
              sum)))
        0
        @state/orders)


(js/console.log
  (let [fishes @state/fishes]
    (->> @state/orders
         (remove (fn [[fish-id qty]] (= (get-in fishes [fish-id :status]) "unavailable")))
         (map (fn [[fish-id qty]] (* qty (get-in fishes [fish-id :price]))))
         (reduce +))))



(defn component []
  [:div.order-wrap
   [:h2 "Your Order"]
   [:ul.order
    (for [[id quant] @state/orders]
      ^{:key id} [order id quant])
    [:li.total
     [:strong "Total:"]  (total)]]])
