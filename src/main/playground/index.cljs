(ns playground.index
  (:require [rum.core :as rum]
            [playground.tldraw.basic :refer [Tldraw]]))

(def persist-key "playground.index")

;; Debounce it?
(defn on-persist [e]
  (let [document (.-document e)]
    ;; persit to localstorage
    (.setItem js/localStorage persist-key (js/JSON.stringify document))))

(defn on-load []
  (js/JSON.parse (.getItem js/localStorage persist-key)))

(def doc (on-load))

(rum/defc root []
  [:div (Tldraw {:document doc
                 :showMultiplayerMenu false
                 :onPersist #(println (on-persist %))})])

(defn ^:dev/after-load  start []
  ;; start is called by init and after code reloading finishes
  ;; this is controlled by the :after-load in the config
  (rum/mount (root)
             (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
