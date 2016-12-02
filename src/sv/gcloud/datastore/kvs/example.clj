(ns sv.gcloud.datastore.kvs.example
  (:require [sv.gcloud.client :as g]
            [sv.gcloud.datastore.client :as c]
            [sv.gcloud.datastore.kvs :as k]))

(def client
  (c/create-client
   g/create-client
   {:projectId "*your-gcloud-project-id*"}))

(def params
  {:ds/client client
   :ds/kind "test.cache.value"})

(defn set-value []
  (k/set-value params {:a 1} {:count 42}))

(defn get-value []
  (k/get-value params {:a 1}))
