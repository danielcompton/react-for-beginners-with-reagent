(ns reagent-for-beginners.components.fish
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))

(defn add-to-order [orders id]
  (swap! orders update (keyword id) (fnil inc 0)))

(defn component [id name price status desc image]
  [:li.menu-fish {:key id}
   [:img {:src image :alt name}]
   [:h3.fish-name name
    [:span.price (h/format-price price)]]
   [:p desc]
   [:button {:disabled (= status "unavailable")
             :on-click #(add-to-order state/orders id)}
    (if (= status "available") "Add To Order" "Sold Out!")]])
