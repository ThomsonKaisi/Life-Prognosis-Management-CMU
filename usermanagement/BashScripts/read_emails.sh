#!/bin/bash
read_info=$(awk -F, '{print $1}' email.csv)
emails=($read_info)
echo "${emails[@]}"