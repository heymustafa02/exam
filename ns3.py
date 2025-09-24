# Assignment 10
#Implement DES algorithms using python

from pyDes import des, ECB, PAD_PKCS5
import base64

def des_encrypt(key, text):
    cipher = des(key, ECB, padmode=PAD_PKCS5)
    encrypted = cipher.encrypt(text)
    return base64.b64encode(encrypted).decode()

def des_decrypt(key, encrypted):
    cipher = des(key, ECB, padmode=PAD_PKCS5)
    decrypted = cipher.decrypt(base64.b64decode(encrypted))
    return decrypted.decode()

# Example
key = "12345678"   # DES requires 8-byte key
text = "HELLODES"

enc = des_encrypt(key, text)
dec = des_decrypt(key, enc)

print("Encrypted:", enc)
print("Decrypted:", dec)
