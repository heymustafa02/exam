# Assignment 9
# Diffi-hellman key Exchange machanism using python def diffie_hellman():

def diffie_hellman():
    # Step 1: Publicly shared values
    P = 23  # Prime number
    G = 5   # Primitive root modulo P
    print("Publicly Shared Variables:")
    print("P (Prime):", P)
    print("G (Base) :", G)

    # Step 2: Private keys (chosen randomly)
    a = 6   # Alice's private key (secret)
    b = 15  # Bob's private key (secret)

    # Step 3: Compute public keys
    A = (G ** a) % P  # Alice's public key
    B = (G ** b) % P  # Bob's public key

    print("\nPrivate Keys:")
    print("Alice's Private Key (a):", a)
    print("Bob's Private Key (b):", b)

    print("\nPublic Keys Exchanged:")
    print("Alice Sends Public Key (A):", A)
    print("Bob Sends Public Key (B):", B)

    # Step 4: Each calculates the shared secret key
    secret_key_alice = (B ** a) % P
    secret_key_bob = (A ** b) % P

    print("\nShared Secret Key Calculated:")
    print("Alice Computes:", secret_key_alice)
    print("Bob Computes :", secret_key_bob)

    if secret_key_alice == secret_key_bob:
        print("\nKey Exchange Successful! Shared Key:", secret_key_alice)
    else:
        print("\nKey Exchange Failed.")


if __name__ == "__main__":
    diffie_hellman()
