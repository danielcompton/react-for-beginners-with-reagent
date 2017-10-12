(ns reagent-for-beginners.components.inventory
  (:require [reagent-for-beginners.components.add-fish-form :as add-fish-form]))

(defn load-samples []
  (.log js/console "Load Samples"))

(defn component []
  [:div
   [:h2 "Inventory"]
   [add-fish-form/component]
   [:button {:on-click #(load-samples)} "Load Sample Fishes"]])
