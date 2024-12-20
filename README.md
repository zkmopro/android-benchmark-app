# Mopro benchmark app for Android

## Download the zkeys
- keccak256: https://ci-keys.zkmopro.org/keccak256_256_test_final.zkey
- RSA: https://ci-keys.zkmopro.org/rsa_main_final.zkey
- semaphore-32: https://ci-keys.zkmopro.org/semaphore-32.zkey
- SHA256: https://ci-keys.zkmopro.org/sha256_512_final.zkey

## Put the zkeys in assets folder
- `android/app/src/main/assets`

## Open the project in Android Studio
```sh
open . -a Android\ Studio
```

## Benchmark results

| | rust-witness + ark-works (Samsung S23U) | witnesscalc + rapidsnark (Samsung S23U) |
| --- | --- | --- |
| keccak256 | 2.55s  | 0.867 s |
| SHA256 | 1.73s | 0.252 s |
| RSA | 9.53 s | 1.1 s |
| semaphore-32 | 331 ms | 188 ms |