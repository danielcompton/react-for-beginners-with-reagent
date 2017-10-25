(ns reagent-for-beginners.app
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [reagent.core :as r :refer [atom]]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [reagent-for-beginners.components.header :as header]
            [reagent-for-beginners.components.order :as order]
            [reagent-for-beginners.components.inventory :as inventory]
            [reagent-for-beginners.components.fish :as fish]
            [reagent-for-beginners.components.not-found :as not-found]
            [reagent-for-beginners.components.store-picker :as store-picker]
            [reagent-for-beginners.state :as state]))

(defonce app-state (r/atom {:current-page store-picker/component}))

(defn page []
  [:div
   [(session/get :current-page)]])

(defn catch-of-the-day []
  [:div.catch-of-the-day
   [:div.menu
    [header/component "Fresh seafood"]
    [:ul.list-of-fishes
     (map (fn [{:keys [id name price status desc image]}]
            ^{:key id} [fish/component id name price status desc image]) (vals @state/fishes))
     (for [{:keys [id name price status desc image]} (vals @state/fishes)]
       ^{:key id} [fish/component id name price status desc image])]]
   [order/component]
   [inventory/component]])

;; Routes

(defroute "/" []
  (session/put! :current-page store-picker/component))

(defroute "/store" []
  (session/put! :current-page catch-of-the-day))

;; History

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     HistoryEventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn mount-components []
  (r/render-component [catch-of-the-day] (.getElementById js/document "main")))

(defn init []
  ;; (hook-browser-navigation!)
  (mount-components))
