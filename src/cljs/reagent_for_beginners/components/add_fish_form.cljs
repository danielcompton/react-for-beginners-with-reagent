(ns reagent-for-beginners.components.add-fish-form
  (:require [reagent.core :as r]
            [reagent-for-beginners.state :as state]
            [clojure.string :as s :refer [trim blank?]]))

(defn create-fish [fishes fish default]
  (let [name (trim (:name @fish))
        price (trim (:price @fish))
        status (trim (:status @fish))
        image (trim (:image @fish))
        desc (trim (:desc @fish))]
     (reset! fish default)
    (when-not (or (blank? name)
                  (blank? price)
                  (blank? status)
                  (blank? desc)
                  (blank? image))
      (swap! fishes conj {:id (.getTime (js/Date.))
                          :name name
                          :price price
                          :status status
                          :desc desc
                          :image image}))))

(defn component []
  (let [default {:name "" :price 0 :status "available" :desc "" :image ""}
        fish (r/atom default)]
    (fn []
      [:form.fish-edit
       [:input {:type "text"
                :placeholder "Fish Name"
                :value (:name @fish)
                :on-change #(swap! fish assoc :name (-> % .-target .-value))}]
       [:input {:type "text"
                :placeholder "Fish Price"
                :value (:price @fish)
                :on-change #(swap! fish assoc :price (-> % .-target .-value))}]
       [:select {:value (:status @fish)
                 :on-change #(swap! fish assoc :status (-> % .-target .-value))}
        [:option {:value "available"} "Fresh!"]
        [:option {:value "unavailable"} "Sold Out!"]]
       [:textarea {:placeholder "Fish Desc"
                   :on-change #(swap! fish assoc :desc (-> % .-target .-value))
                   :value (:desc @fish)}]
       [:input {:type "text"
                :placeholder "Fish Image"
                :value (:image @fish)
                :on-change #(swap! fish assoc :image (-> % .-target .-value))}]
       [:button {:type "button"
                 :on-click #(create-fish state/fishes fish default)} "+ Add Item"]])))
