(ns reagent-for-beginners.components.fish
  (:require [reagent-for-beginners.state :as state]))

(defn add-to-order [orders order]
  (let [m {:fish-id amount}])
  (.log js/console orders)
  (.log js/console (contains? m (keyword order)))
  (swap! orders conj (keyword order) 1))

(defn component [id name price status image desc]
  [:li.menu-fish
   [:img {:src image :alt name}]
   [:h3.fish-name name
    [:span.price price]]
   [:p desc]
   [:button {:disabled (if (= status "available") false true)
             :on-click #(add-to-order state/orders id)}
    (if (= status "available") "Add To Order" "Sold Out!")]])
