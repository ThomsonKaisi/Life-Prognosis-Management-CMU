#!/bin/bash

read -r input

uuid=$input

id=$(awk -F, -v uuid="$uuid" '$1 == uuid {print $1}' uuid.csv)

if [ -z "$id" ]; then
    id="null"
    echo "$id"
else
    echo "$id"
fi
