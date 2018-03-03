(ns inspector-repro.ui.root
  (:require
    [fulcro.client.mutations :as m]
    [fulcro.client.data-fetch :as df]
    [fulcro.client.routing :as r]
    [fulcro.client.dom :as dom]
    [inspector-repro.api.mutations :as api]
    [fulcro.client.primitives :as prim :refer [defsc]]
    ))

(defsc SecondRoute [this _]
  {:initial-state {:page :second}
   :query [:page]})

(defsc FirstRoute [this _]
  {:initial-state {:page :first}
   :query         [:page]})

;; Assertion error only happens when there is more than one route

(r/defrouter RootRouter :root-router
  (fn [this {:keys [page]}]
    [page :root])
  :first-route FirstRoute
  :second-route SecondRoute)

(defsc Root [this props]
  {:query [{:root-router (prim/get-query RootRouter)}]}
  (dom/div nil "TODO"))
