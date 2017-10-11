(ns reagent-for-beginners.app
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent-for-beginners.components.header :as header]
            [reagent-for-beginners.components.order :as order]
            [reagent-for-beginners.components.inventory :as inventory]
            [reagent-for-beginners.components.fish :as fish]
            [reagent-for-beginners.state :as state]))

(defonce app-state (reagent/atom {:fishes (sorted-map)
                                  :orders (sorted-map)}))

(defn catch-of-the-day []
  [:div.catch-of-the-day
   [:div.menu
    [header/component "Fresh seafood"]
    [:ul.list-of-fishes
     (for [{:keys [id name price status desc image]} @state/fishes]
       ^{:key id} [fish/component id name price status image desc])]]
   [order/component]
   [inventory/component]])

(defn init []
  (reagent/render-component [catch-of-the-day]
                            (.getElementById js/document "main")))
