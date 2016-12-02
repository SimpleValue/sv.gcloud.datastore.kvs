(ns sv.gcloud.datastore.kvs
  (:require [clojure.edn :as edn]
            [hasch.core :as h]
            [sv.gcloud.datastore.client :as c]))

(defn entity-key [kind key]
  {:ds/kind kind
   :ds/name (str (h/uuid key))})

(defn lookup [params key]
  (c/lookup-entity
   (:ds/client params)
   (entity-key (:ds/kind params) key)))
  
(defn get-value [params key]
  (when-let [result (lookup params key)]
    (let [read-edn (:read-edn params edn/read-string)]
      (read-edn (:value result)))))

(defn set-value [params key value]
  (c/transact-entity
   (:ds/client params)
   (entity-key (:ds/kind params) key)
   (fn [entity]
     (let [pr-edn (:pr-edn params pr-str)]
       (assoc
        entity
        :key (pr-edn key)
        :value (pr-edn value)))))
  true)
