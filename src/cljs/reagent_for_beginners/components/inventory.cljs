(ns reagent-for-beginners.components.inventory
  (:require [reagent-for-beginners.components.add-fish-form :as add-fish-form]
            [reagent-for-beginners.state :as state]
            [reagent-for-beginners.sample-fishes :as sample-fishes]))

(defn load-samples []
  (swap! state/fishes conj @sample-fishes/fishes ))

(defn component []
  [:div
   [:h2 "Inventory"]
   [add-fish-form/component]
   [:button {:on-click #(load-samples)} "Load Sample Fishes"]])
