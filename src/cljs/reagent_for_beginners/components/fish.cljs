(ns reagent-for-beginners.components.fish
  (:require [reagent-for-beginners.state :as state]))

(defn add-to-order [orders order default]
  (swap! orders conj {:key order}))

(defn component [name price status image desc]
  [:li.menu-fish
   [:img {:src image :alt name}]
   [:h3.fish-name name
    [:span.price price]]
   [:p desc]
   [:button {:disabled (if (= status "available") false true)
             :on-click #(add-to-order @state/orders order default)}
    (if (= status "available") "Add To Order" "Sold Out!")]])
