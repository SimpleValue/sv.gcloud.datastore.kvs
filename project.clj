(defproject sv/gcloud.datastore.kvs "0.1.0-SNAPSHOT"
  :description "A key value store for edn values that uses Google
                Datastore."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.replikativ/hasch "0.3.1"]
                 [sv/gcloud.datastore "0.1.0"]
                 [sv/gcloud.client "0.1.3"]])
