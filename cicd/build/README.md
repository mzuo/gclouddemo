# CI-CD Build

## Redis - Using Redis Labs
GCP Demo Scripts

+ Access
  - Valentine key - gclouddemo-redis-spinnaker
```
redis-16050.c1.us-central1-2.gce.cloud.redislabs.com:16050
```

## cicd - image
* project
  + cicd-174318
* image
  gclouddemo-cicd-default-image-v1

## Ansible Control Machine

gcloud compute ssh builder@build-ansible-master-v1 --project cicd-174318 --zone us-central1-f

sudo pip install ansible
sudo pip install apache-libcloud
sudo pip install cryptography

ansible-galaxy install  AMeng.spinnaker --roles-path /home/builder/g/gclouddemo/cicd/build/roles


ansible-vault create secret_key


## Ansible - Spinnaker - Playbook

```
ansible-playbook spinnaker.yml -i inventory/hosts.yml -vvv
```


```
gcloud compute --project "cicd-174318" instances create "spinnaker-manual-v1" --zone "us-central1-f" --machine-type "n1-standard-2" --subnet "default" --maintenance-policy "MIGRATE" --service-account "519196627636-compute@developer.gserviceaccount.com" --scopes "https://www.googleapis.com/auth/devstorage.read_only","https://www.googleapis.com/auth/logging.write","https://www.googleapis.com/auth/monitoring.write","https://www.googleapis.com/auth/servicecontrol","https://www.googleapis.com/auth/service.management.readonly","https://www.googleapis.com/auth/trace.append" --image "ubuntu-1404-trusty-v20170718" --image-project "ubuntu-os-cloud" --boot-disk-size "200" --boot-disk-type "pd-standard" --boot-disk-device-name "spinnaker-manual-v
```

```
rsync -avHPe "ssh -i ~/.ssh/id_rsa_builder" dev/g/pso/gcdemo/gclouddemo/* builder@104.198.27.144:/home/builder/g/gcloud
```
