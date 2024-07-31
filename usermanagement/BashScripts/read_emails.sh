#!/bin/bash

# Read the CSV file and extract the email column (assuming it's the first column)
emails=($(awk -F, '{print $1}' email.csv))

# Print the array of emails
echo "${emails[@]}"