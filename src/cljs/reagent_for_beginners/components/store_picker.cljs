(ns reagent-for-beginners.components.store-picker
  (:require [reagent.core :as r]
            [reagent-for-beginners.helpers :as h]
            [secretary.core :refer [dispatch!]]))

(defn go-to-store [event store-id]
  (.preventDefault event)
  (dispatch! "/store"))

(defn component []
  (let [store-id (r/atom (h/get-fun-name))]
    [:div
     [:form.store-selector {:on-submit #(go-to-store %1 @store-id)}
      [:h2 "Please Enter A Store"]
      [:input {:type "text" :required true :default-value @store-id}]
      [:button {:type "submit"} "Visit Store"]]]))
