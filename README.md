# gclouddemo
GCP Demo Scripts


# Setup .ssh keys needed for easier management


[Use instructions to build a file for sshKeys](https://cloud.google.com/compute/docs/instances/adding-removing-ssh-keys)
```commandline
copy ~/.ssh/id_rsa.pub > pub_keys_file.txt
copy ~/.ssh/id_rsa_builder2.pub >> pub_keys_file.txt
```

Append username at the beginning `[username]:ssh-rsa`
Cleanup username at the end [username]
```commandline

gcloud compute project-info add-metadata --metadata-from-file sshKeys=
```


# Ansible Generate Keys

[Ansible Crypto](http://docs.ansible.com/ansible/latest/list_of_crypto_modules.html)



# Spinnaker Authentication

[Spinnaker Authentication](https://www.spinnaker.io/setup/security/authentication/)

- 