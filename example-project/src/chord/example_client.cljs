(ns chord.example-client
  (:require [chord.client :refer [ws-ch]]
            [cljs.core.async :refer [<! >! put! close!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(go
 (let [ws (<! (ws-ch "ws://localhost:3000/ws"))]
   (>! ws "Hello server from client!")
   (set! (.-innerHTML (js/document.getElementById "content"))
         (str "Message received: "
              (pr-str (<! ws))))))



