# Assignment 8
#Implement Ceaser Cipher using python

def caesar_encrypt(text, shift):
    result = ''
    for char in text:
        if char.isalpha():
            base = ord('A') if char.isupper() else ord('a')
            result += chr((ord(char) - base + shift) % 26 + base)
        else:
            result += char
    return result

def caesar_decrypt(text, shift):
    return caesar_encrypt(text, -shift)

# Example
plain = "How are you"
shift = 3
cipher = caesar_encrypt(plain, shift)

print("Original :", plain)
print("Encrypted:", cipher)
print("Decrypted:", caesar_decrypt(cipher, shift))
