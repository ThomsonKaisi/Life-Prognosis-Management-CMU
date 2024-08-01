#!/bin/bash
#reading the passed argument through outputstream in java
read -r input
email=$input
#using awk to assign the value of email to awk fomat and compare the email, if found return the hashed password
passwordhash=$(awk -F, -v email="$email" '$1 == email {print $2}' shadow.csv)
#checking if the passwordhash is empty
if [ -z "$passwordhash" ]; then
    passwordhash="null"
    echo "$passwordhash"
else
    echo "$passwordhash"
fi

