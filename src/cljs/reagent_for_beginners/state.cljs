(ns reagent-for-beginners.state
  (:require [reagent.core :as r]))

(def fishes (r/atom [{:id 1
                      :name "Pacific Halibut"
                      :image "https://i.istockimg.com/file_thumbview_approve/36248396/5/stock-photo-36248396-blackened-cajun-sea-bass.jpg"
                      :price 1724
                      :status "available"
                      :desc "Everyones favorite white fish. We will cut it to the size you need and ship it."}
                     {:id 2
                      :name "Lobster"
                      :image "https://i.istockimg.com/file_thumbview_approve/32135274/5/stock-photo-32135274-cooked-lobster.jpg"
                      :price 3200
                      :status "available"
                      :desc "These tender, mouth-watering beauties are a fantastic hit at any dinner party."}
                     {:id 3
                      :name "Sea Scallops"
                      :image "https://i.istockimg.com/file_thumbview_approve/58624176/5/stock-photo-58624176-scallops-on-black-stone-plate.jpg"
                      :price 1684
                      :status "unavailable"
                      :desc "Big, sweet and tender. True dry-pack scallops from the icey waters of Alaska. About 8-10 per pound"}]))

