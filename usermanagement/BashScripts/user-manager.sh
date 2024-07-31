#!/bin/bash

USER_STORE="user-store.txt"
COUNTRY_CODES="life-expectancy.csv"

# Create account
create_account(){
  local email=$1
  local uuid=$(uuidgen)
  echo "$email,$uuid" >> $USER_STORE
  echo "Account created for $email. UUID: $uuid"
}

# Get ISO code from country name
get_iso_code(){
  local country_name=$1
  local iso_code=$(grep -i "^$country_name," $COUNTRY_CODES | cut -d',' -f2)
  echo $iso_code
}

# Complete registration
complete_registration(){
  local uuid=$1
  local email=$(grep "$uuid" $USER_STORE | cut -d',' -f1)
  if [ -z "$email" ]; then
    echo "Invalid UUID"
    exit 1
  fi
  echo "Enter First Name:"
  read firstName
  echo "Enter Last Name:"
  read lastName
  echo "Enter Date of Birth (YYYY-MM-DD):"
  read dateOfBirth
  echo "Are you HIV positive? (yes/no):"
  read hivPositive
  diagnosisDate=""
  onART=""
  artStartDate=""
  if [ "$hivPositive" == "yes" ]; then
    echo "Enter Diagnosis Date (YYYY-MM-DD):"
    read diagnosisDate
    echo "Are you on ART? (yes/no):"
    read onART
    if [ "$onART" == "yes" ]; then
      echo "Enter ART Start Date (YYYY-MM-DD):"
      read artStartDate
    fi
  fi
  echo "Enter Country Name:"
  read country
  isoCountry=$(get_iso_code "$country")
  if [ -z "$isoCountry" ]; then
    echo "Invalid country name"
    exit 1
  fi
  echo "Enter Password:"
  read -s password
  hashedPassword=$(echo -n "$password" | openssl dgst -sha256)
  echo "$email,$uuid,$firstName,$lastName,$dateOfBirth,$hivPositive,$diagnosisDate,$onART,$artStartDate,$country,$hashedPassword" >> $USER_STORE
  echo "Registration completed for $email"
}

# Validate login
validate_login(){
  local email=$1
  local password=$2
  local hashedPassword=$(echo -n "$password" | openssl dgst -sha256)
  local user=$(grep "$email" $USER_STORE | grep "$hashedPassword")
  if [ -z "$user" ]; then
    echo "Invalid credentials"
    exit 1
  fi
  echo "Login successful"
}

# Main script
case "$1" in
  create)
    create_account "$2"
    ;;
  complete)
    complete_registration "$2"
    ;;
  login)
    validate_login "$2" "$3"
    ;;
  *)
    echo "Usage: $0 {create|complete|login} [args...]"
    ;;
esac