#!/bin/bash
read_info=$(awk -F, '{print $1}' user-store.txt)
emails=($read_info)
echo "${emails[@]}"