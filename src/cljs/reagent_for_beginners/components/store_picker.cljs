(ns reagent-for-beginners.components.store-picker)

(defn component []
  [:div
   [:form.store-selector
    [:h2 "Please Enter A Store"]
    [:input {:type "text" :required true :placeholder "Store Name"}]
    [:button {:type "submit"} "Visit Store"]]])
