(ns reagent-for-beginners.components.inventory
  (:require [reagent-for-beginners.components.add-fish-form :as add-fish-form]
            [reagent-for-beginners.state :as state]
            [reagent-for-beginners.sample-fishes :as sample-fishes]))

(defn load-samples []
  (swap! state/fishes conj @sample-fishes/fishes ))

(defn inventory [id name price status image desc]
  [:div.fish-edit
   [:input {:type "text"
            :name "name"
            :placeholder "Fish Name"
            :value name
            :on-change #(swap! state/fishes assoc-in [(keyword id) :name] (-> % .-target.value))}]
   [:input {:type "text"
            :name "price"
            :placeholder "Fish Price"
            :value price
            :on-change #(swap! state/fishes assoc-in [(keyword id) :price] (-> % .-target.value))}]
   [:select {:value status
             :name "status"
             :on-change #(swap! state/fishes assoc-in [(keyword id) :status] (-> % .-target.value))}
    [:option {:value "available"} "Fresh!"]
    [:option {:value "unavailable"} "Sold Out!"]]
   [:textarea {:name "desc"
               :placeholder "Fish Desc"
               :value desc
               :on-change #(swap! state/fishes assoc-in [(keyword id) :desc] (-> % .-target.value))}]
   [:input {:type "text"
            :name "image"
            :placeholder "Fish Image"
            :value image
            :on-change #(swap! state/fishes assoc-in [(keyword id) :image] (-> % .-target.value))}]])


(defn component []
  [:div
   [:h2 "Inventory"]
   (for [{:keys [id name price status desc image]} (vals @state/fishes)]
     ^{:key id} [inventory id name price status image desc])
   [add-fish-form/component]
   [:button {:on-click #(load-samples)} "Load Sample Fishes"]])
