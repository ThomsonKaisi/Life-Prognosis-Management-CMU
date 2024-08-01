read -r password
$key="sjxGofqq6jHQKAUMfDdoiA=="
#Note: This encryption does not use salt inorder to avoid complexity
encrypt=$(echo "$password" | openssl enc -aes-128-cbc -a -nosalt -pass pass:"$key")

echo "$encrypt"

