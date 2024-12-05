// Here we're calling a macro exported by uniffi. This macro will
// write some functions and bind them to the uniffi UDL file. These
// functions will invoke the `get_circom_wtns_fn` generated below.
mopro_ffi::app!();

// --- Circom Example of setting up multiplier2 circuit ---
rust_witness::witness!(multiplier2);
// rust_witness::witness!(aadhaarverifier);
rust_witness::witness!(keccak256256test);
rust_witness::witness!(sha256512);
rust_witness::witness!(rsamain);
rust_witness::witness!(semaphore32);

mopro_ffi::set_circom_circuits! {
    ("multiplier2_final.zkey", multiplier2_witness),
    // ("circuit_final.zkey", aadhaarverifier_witness),
    ("keccak256_256_test_final.zkey", keccak256256test_witness),
    ("sha256_512_final.zkey", sha256512_witness),
    ("rsa_main_final.zkey", rsamain_witness),
    ("semaphore-32.zkey", semaphore32_witness),
}
