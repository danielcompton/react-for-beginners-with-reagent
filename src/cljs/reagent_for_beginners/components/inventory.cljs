(ns reagent-for-beginners.components.inventory
  (:require [reagent-for-beginners.components.add-fish-form :as add-fish-form]))

(defn component []
  [:div
   [:h2 "Inventory"]
   [add-fish-form/component]])
