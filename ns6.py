# Assignment:-13
# Implement cryptographic algorithms using Python (Hashing)

import hashlib

def hash_text(text):
    # Encode the text to bytes
    byte_text = text.encode()

    # Create hashes
    md5_hash = hashlib.md5(byte_text).hexdigest()
    sha1_hash = hashlib.sha1(byte_text).hexdigest()
    sha256_hash = hashlib.sha256(byte_text).hexdigest()

    # Print results
    print("Original Text:", text)
    print("MD5     :", md5_hash)
    print("SHA-1   :", sha1_hash)
    print("SHA-256 :", sha256_hash)

# Example
text = "HELLO123"
hash_text(text)
