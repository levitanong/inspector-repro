(ns inspector-repro.client
  (:require [fulcro.client :as fc]
            [inspector-repro.ui.root :as root]))

(defonce app (atom nil))

(defn mount []
  (reset! app (fc/mount @app root/Root "app")))

(defn start []
  (mount))

(defn ^:export init []
  (reset! app (fc/new-fulcro-client))
  (start))
