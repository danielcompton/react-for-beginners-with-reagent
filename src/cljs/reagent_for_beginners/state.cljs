(ns reagent-for-beginners.state
  (:require [reagent.core :as r]))

(def fishes (r/atom [{:id 1
                      :desc "Everyones favorite white fish. We will cut it to the size you need and ship it."
                      :image "https://i.istockimg.com/file_thumbview_approve/36248396/5/stock-photo-36248396-blackened-cajun-sea-bass.jpg"
                      :name "Pacific Halibut"
                      :price 1724
                      :status "available"}
                     {:id 2
                      :desc "These tender, mouth-watering beauties are a fantastic hit at any dinner party."
                      :image "https://i.istockimg.com/file_thumbview_approve/32135274/5/stock-photo-32135274-cooked-lobster.jpg"
                      :name "Lobster"
                      :price 3200
                      :status "available"}
                     {:id 3
                      :desc "Big, sweet and tender. True dry-pack scallops from the icey waters of Alaska. About 8-10 per pound"
                      :image "https://i.istockimg.com/file_thumbview_approve/58624176/5/stock-photo-58624176-scallops-on-black-stone-plate.jpg"
                      :name "Sea Scallops"
                      :price 1684
                      :status "unavailable"}
                     {:id 4
                      :desc "Lean flesh with a mild, sweet flavor profile, moderately firm texture and large, moist flakes."
                      :image "https://i.istockimg.com/file_thumbview_approve/12556651/5/stock-photo-12556651-mahimahi.jpg"
                      :name "Mahi Mahi"
                      :price 1129
                      :status "available"}
                     {:id 5
                      :desc "Crack these open and enjoy them plain or with one of our cocktail sauces"
                      :image "https://i.istockimg.com/file_thumbview_approve/18294110/5/stock-photo-18294110-king-crab-legs.jpg"
                      :name "King Crab"
                      :price 4234
                      :status "available"}
                     {:id 6
                      :desc "This flaky, oily salmon is truly the king of the sea. Bake it, grill it, broil it...as good as it gets!"
                      :image "https://i.istockimg.com/file_thumbview_approve/56241842/5/stock-photo-56241842-salmon-fish.jpg"
                      :name "Atlantic Salmon"
                      :price 1453
                      :status "available"}
                     {:id 7
                      :desc "A soft plump oyster with a sweet salty flavor and a clean finish."
                      :image "https://i.istockimg.com/file_thumbview_approve/58626682/5/stock-photo-58626682-fresh-oysters-on-a-black-stone-plate-top-view.jpg"
                      :name "Oyster"
                      :price 2543
                      :status "available"}
                     {:id 8
                      :desc "The best mussels from the Pacific Northwest with a full-flavored and complex taste."
                      :image "https://i.istockimg.com/file_thumbview_approve/40450406/5/stock-photo-40450406-steamed-mussels.jpg"
                      :name "Mussels"
                      :price 425
                      :status "available"}
                     {:id 9
                      :desc "With 21-25 two bite prawns in each pound, these sweet morsels are perfect for shish-kabobs."
                      :image "https://i.istockimg.com/file_thumbview_approve/67121439/5/stock-photo-67121439-fresh-tiger-shrimp-on-ice-on-a-black-stone-table.jpg"
                      :name "Jumbo Prawns"
                      :price 2250
                      :status "available"}]))
                      
