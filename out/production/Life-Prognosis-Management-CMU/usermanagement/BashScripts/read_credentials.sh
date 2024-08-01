#!/bin/bash
#reading the passed argument through outputstream in java
read -sp "Enter your Password: " password
read -r input
email=$input
$key="sjxGofqq6jHQKAUMfDdoiA=="
encrypt=$(echo "$password" | openssl enc -aes-128-cbc -a -nosalt -pass pass:"$key")
#using awk to assign the value of email to awk fomat and compare the email, if found return the hashed password
passwordhash=$(awk -F, -v email="$email" '$1 == email {print $2}' shadow.csv)
if [ [encrypt == passwordhash] ]; then
    boolean_value=true
    echo "$boolean_value"
else
    boolean_value=false
    echo "$boolean_value"

