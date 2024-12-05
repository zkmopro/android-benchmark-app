// Here we're calling a macro exported by uniffi. This macro will
// write some functions and bind them to the uniffi UDL file. These
// functions will invoke the `get_circom_wtns_fn` generated below.
mopro_ffi::app!();

// --- Circom Example of setting up multiplier2 circuit ---
rust_witness::witness!(multiplier2);

mopro_ffi::set_circom_circuits! {
    ("multiplier2_final.zkey", multiplier2_witness)
}


// HALO2_TEMPLATE