(ns playground.tldraw.basic
  (:require [playground.rum :as r]
            ["@tldraw/tldraw" :refer [Tldraw]]))

(def Basic (r/adapt-class tldraw/Tldraw))
