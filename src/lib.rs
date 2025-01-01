// Here we're calling a macro exported by uniffi. This macro will
// write some functions and bind them to the uniffi UDL file. These
// functions will invoke the `get_circom_wtns_fn` generated below.
mopro_ffi::app!();
// use ark_bn254::Bn254;
// use std::collections::HashMap;
// use std::io::Read;
// use wasmer::Store;
// use num_bigint::BigInt;

// use ark_circom::{
//     WitnessCalculator, //read_zkey,
// };
// use circom_witnesscalc::{calc_witness, wtns_from_witness};

// --- Circom Example of setting up multiplier2 circuit ---
rust_witness::witness!(multiplier2);
rust_witness::witness!(aadhaarverifier);
// rust_witness::witness!(keccak256256test);
// rust_witness::witness!(sha256512);
// rust_witness::witness!(rsamain);
// rust_witness::witness!(semaphore32);

mopro_ffi::set_circom_circuits! {
    ("multiplier2_final.zkey", multiplier2_witness),
    ("circuit_final.zkey", aadhaarverifier_witness),
    // ("keccak256_256_test_final.zkey", keccak256256test_witness),
    // ("sha256_512_final.zkey", sha256512_witness),
    // ("rsa_main_final.zkey", rsamain_witness),
    // ("semaphore-32.zkey", semaphore32_witness),
}

// circom-witnesscalc
// pub fn circom_witnesscalc(inputs: String, graph_data: String) -> u64 {
//     let inputs_data = std::fs::read_to_string(inputs).expect("Failed to read input file");

//     let graph_data = std::fs::read(graph_data).expect("Failed to read graph file");

//     let start_time = std::time::Instant::now();

//     let _ = calc_witness(&inputs_data, &graph_data).unwrap();

//     let end_time = std::time::Instant::now();
//     let duration = end_time.duration_since(start_time);
//     duration.as_millis() as u64
// }

// circom-compat
// pub fn wasmer_witnesscalc(inputs: HashMap<String, Vec<String>>, wasm_path: String) -> u64 {
//     let mut store = Store::default();
//     let converted_inputs: HashMap<String, Vec<BigInt>> = inputs
//         .into_iter()
//         .map(|(key, values)| {
//             let big_ints = values
//                 .into_iter()
//                 .map(|s| BigInt::parse_bytes(s.as_bytes(), 10).unwrap())
//                 .collect();
//             (key, big_ints)
//         })
//         .collect();
//     let start_time = std::time::Instant::now();
//     let wtns = WitnessCalculator::new(wasm_path)
//         .unwrap()
//         .calculate_witness_element::<Bn254, _>(converted_inputs, false)
//         .unwrap();
//     let end_time = std::time::Instant::now();
//     let duration = end_time.duration_since(start_time);
//     duration.as_millis() as u64
// }
