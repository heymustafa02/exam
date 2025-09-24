# Assignment:-12
# Implement the RSA algorithm logic using Python

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def modinv(a, m):
    m0, x0, x1 = m, 0, 1
    while a > 1:
        q = a // m
        a, m = m, a % m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1

def generate_keys():
    p, q = 61, 53   # Two prime numbers
    n = p * q
    phi = (p - 1) * (q - 1)

    e = 17  # Public exponent (should be coprime with phi)
    d = modinv(e, phi)  # Private exponent

    return (e, n), (d, n)

def rsa_encrypt(text, pub_key):
    e, n = pub_key
    return [pow(ord(c), e, n) for c in text]

def rsa_decrypt(cipher, priv_key):
    d, n = priv_key
    return ''.join([chr(pow(c, d, n)) for c in cipher])


# Example
public, private = generate_keys()
msg = "HELLO"

encrypted = rsa_encrypt(msg, public)
decrypted = rsa_decrypt(encrypted, private)

print("Encrypted:", encrypted)
print("Decrypted:", decrypted)
