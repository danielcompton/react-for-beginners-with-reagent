(ns reagent-for-beginners.components.fish
  (:require [reagent-for-beginners.state :as state]
            [reagent-for-beginners.helpers :as h]))

(defn add-to-order [orders order]
  (if (contains? @orders (keyword order))
    (swap! orders conj (update-in @orders [(keyword order)] inc))
    (swap! orders conj {(keyword order) 1})))

(defn component [id name price status image desc]
  [:li.menu-fish
   [:img {:src image :alt name}]
   [:h3.fish-name name
    [:span.price (h/format-price price)]]
   [:p desc]
   [:button {:disabled (if (= status "available") false true)
             :on-click #(add-to-order state/orders id)}
    (if (= status "available") "Add To Order" "Sold Out!")]])
