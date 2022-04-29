(ns playground.tldraw.basic
  (:require [playground.rum :as r]
            ["@tldraw/tldraw" :as tldraw]))

(def Tldraw (r/adapt-class tldraw/Tldraw))
