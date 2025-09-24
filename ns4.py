# Assignment 11
#Implement RC4 algorithms using python

def rc4(key, text):
    S = list(range(256))
    j = 0
    key = [ord(c) for c in key]

    # Key Scheduling Algorithm (KSA)
    for i in range(256):
        j = (j + S[i] + key[i % len(key)]) % 256
        S[i], S[j] = S[j], S[i]

    # Pseudo-Random Generation Algorithm (PRGA)
    i = j = 0
    keystream = []
    for _ in text:
        i = (i + 1) % 256
        j = (j + S[i]) % 256
        S[i], S[j] = S[j], S[i]
        K = S[(S[i] + S[j]) % 256]
        keystream.append(K)

    # XOR text with keystream
    return ''.join(chr(ord(c) ^ k) for c, k in zip(text, keystream))


# Example
key = "key"
plain = "HELLO"

cipher = rc4(key, plain)
plain2 = rc4(key, cipher)   # RC4 is symmetric (same function to decrypt)

print("Encrypted (hex):", cipher.encode().hex())
print("Decrypted:", plain2)
