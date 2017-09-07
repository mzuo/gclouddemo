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
rsync -avHPe "ssh -i ~/.ssh/id_rsa_builder" dev/g/pso/gcdemo/gclouddemo/* builder@104.198.27.144:/home/builder/g/gclouddemo
```

```
cd /home/builder/g/gclouddemo/cicd/build/ansible
ansible-playbook spinnaker.yml -i inventory/hosts.yml -vvv
```
```
cd /home/builder/g/gclouddemo/cicd/build/ansible
ansible-playbook jenkins.yml -i inventory/hosts.yml -vvv
```
## Ansible - Spinnaker - Variables
Following variables need to be validated and configured when the spinnaker is deployed
### cicd/build/ansible/spinnaker.yml
```
spinnaker_gsuite_adminemail - an email that has admin access to GSuite domain.

```
```
spinnaker_gcp_authjson - the path of the IAM credential on the spinnaker machine. 
```
```
spinnaker_gsuite_domain - The domain of the Gsuite.
```

### cicd/build/ansible/group_vars/spinnaker/vault
To edit the vault file, use the following commands. Password is in valentine. Do not forget to add the 'vault_' variables in the vars.yml file. Refer [Ansible Vault documentation](http://docs.ansible.com/ansible/latest/playbooks_best_practices.html#best-practices-for-variables-and-vaults)   
```
ansible-vault decrypt vault
ansible-vault encrypt vault
```
```
spinnaker_auth_clientid - This id is provided by GCP OAuth2 Client generation process for web application. Refer [Authentication section](https://docs.google.com/document/d/1Moh33cPndZ7E6no-nsFa7j1JJdDMJnluPS7iYKz3GqI/edit#) for more details
```
```
spinnaker_auth_clientsecret - This secret is provided by GCP OAuth2 Client generation process for web application. Refer [Authentication section](https://docs.google.com/document/d/1Moh33cPndZ7E6no-nsFa7j1JJdDMJnluPS7iYKz3GqI/edit#) for more details
```
```
spinnaker_jks_password - Provide a password for java keystore that will be encrypted in the ansible vault file
```
```
spinnaker_ca_password - Provide a password for certificate authority that will be encrypted in the ansible vault file
```
```
spinnaker_serverkey_password - Provide a password for server key that will be encrypted in the ansible vault file
```
```
spinnaker_server_challenge - Provide a challenge for server that will be encrypted in the ansible vault file
```

## Use Intellij Remote Host

https://www.jetbrains.com/help/idea/editing-individual-files-on-remote-hosts.html


## HTTPS - jenkins

[https Jenkins](https://wiki.jenkins.io/display/JENKINS/Starting+and+Accessing+Jenkins)


## Keytool
```
builder@spinnaker-manual-v1:~$ ls -l /usr/bin/java
lrwxrwxrwx 1 root root 22 Aug  2 18:15 /usr/bin/java -> /etc/alternatives/
```

```commandline
builder@spinnaker-manual-v1:~$ ls -l /etc/alternatives/java
lrwxrwxrwx 1 root root 46 Aug  2 18:15 /etc/alternatives/java -> /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
```
```commandline
builder@spinnaker-manual-v1:~$ ls -l /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/
total 212
lrwxrwxrwx 1 root root     46 Jul 26 12:45 blacklisted.certs -> /etc/java-8-openjdk/security/blacklisted.certs
lrwxrwxrwx 1 root root     27 Jul 26 12:45 cacerts -> /etc/ssl/certs/java/cacerts
lrwxrwxrwx 1 root root     40 Jul 26 12:45 java.policy -> /etc/java-8-openjdk/security/java.policy
lrwxrwxrwx 1 root root     42 Jul 26 12:45 java.security -> /etc/java-8-openjdk/security/java.security
-rw-r--r-- 1 root root 208199 Aug 29 16:00 jssecacerts
-rw-r--r-- 1 root root    639 Jul 26 11:54 local_policy.jar
lrwxrwxrwx 1 root root     36 Jul 26 12:45 nss.cfg -> /etc/java-8-openjdk/security/nss.cfg
-rw-r--r-- 1 root root    621 Jul 26 11:54 US_export_policy.jar

```

