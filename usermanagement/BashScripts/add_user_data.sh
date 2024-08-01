#!/bin/bash
read -r email
read -r firstname
read -r lastname
read -r dateOfbirth
read -r isHiv
read -r diagnosisDate
read -r isOnArt
read -r artStartDate
read -r country

echo "$email,$firstname,$lastname,$dateOfbirth,$isHiv,$diagnosisDate,$isOnArt,$artStartDate,$country" >> user-data.csv