//
//  ContentView.swift
//  MoproApp
//
import SwiftUI
import moproFFI

func serializeOutputs(_ stringArray: [String]) -> [UInt8] {
    var bytesArray: [UInt8] = []
    let length = stringArray.count
    var littleEndianLength = length.littleEndian
    let targetLength = 32
    withUnsafeBytes(of: &littleEndianLength) {
        bytesArray.append(contentsOf: $0)
    }
    for value in stringArray {
        // TODO: should handle 254-bit input
        var littleEndian = Int32(value)!.littleEndian
        var byteLength = 0
        withUnsafeBytes(of: &littleEndian) {
            bytesArray.append(contentsOf: $0)
            byteLength = byteLength + $0.count
        }
        if byteLength < targetLength {
            let paddingCount = targetLength - byteLength
            let paddingArray = [UInt8](repeating: 0, count: paddingCount)
            bytesArray.append(contentsOf: paddingArray)
        }
    }
    return bytesArray
}


struct ContentView: View {
    @State private var textViewText = ""
    @State private var isCircomProveButtonEnabled = true
    @State private var isCircomVerifyButtonEnabled = false
    @State private var isHalo2roveButtonEnabled = true
    @State private var isHalo2VerifyButtonEnabled = false
    @State private var generatedCircomProof: Data?
    @State private var circomPublicInputs: Data?
    @State private var generatedHalo2Proof: Data?
    @State private var halo2PublicInputs: Data?
    private let keccak256ZkeyPath = Bundle.main.path(forResource: "keccak256_256_test_final", ofType: "zkey")!
    private let keccak256CircuitPath = Bundle.main.path(forResource: "keccak256_256_test", ofType: "dat")!
    private let keccak256InputPath = Bundle.main.path(forResource: "keccak256", ofType: "json")!
    private let sha256ZkeyPath = Bundle.main.path(forResource: "sha256_512_final", ofType: "zkey")!
    private let sha256CircuitPath = Bundle.main.path(forResource: "sha256_512", ofType: "dat")!
    private let sha256InputPath = Bundle.main.path(forResource: "sha256", ofType: "json")!
    private let RSAZkeyPath = Bundle.main.path(forResource: "rsa_main_final", ofType: "zkey")!
    private let RSACircuitPath = Bundle.main.path(forResource: "rsa_main", ofType: "dat")!
    private let RSAInputPath = Bundle.main.path(forResource: "rsa_main", ofType: "json")!
    private let semaphoreZkeyPath = Bundle.main.path(forResource: "semaphore-32", ofType: "zkey")!
    private let semaphoreCircuitPath = Bundle.main.path(forResource: "semaphore", ofType: "dat")!
    private let semaphoreInputPath = Bundle.main.path(forResource: "semaphore-32", ofType: "json")!
    private let AadhaarZkeyPath = Bundle.main.path(forResource: "circuit_final", ofType: "zkey")!
    private let AadhaarCircuitPath = Bundle.main.path(forResource: "aadhaar_verifier", ofType: "dat")!
    private let AadhaarInputPath = Bundle.main.path(forResource: "aadhaar_verifier_input", ofType: "json")!
    private let srsPath = Bundle.main.path(forResource: "plonk_fibonacci_srs.bin", ofType: "")!
    private let vkPath = Bundle.main.path(forResource: "plonk_fibonacci_vk.bin", ofType: "")!
    private let pkPath = Bundle.main.path(forResource: "plonk_fibonacci_pk.bin", ofType: "")!
    
    var body: some View {
        VStack(spacing: 10) {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Button("Prove Circom", action: runCircomProveAction).disabled(!isCircomProveButtonEnabled).accessibilityIdentifier("proveCircom")
            Button("Verify Circom", action: runCircomVerifyAction).disabled(!isCircomVerifyButtonEnabled).accessibilityIdentifier("verifyCircom")
            Button("Prove Halo2", action: runHalo2ProveAction).disabled(!isHalo2roveButtonEnabled).accessibilityIdentifier("proveHalo2")
            Button("Verify Halo2", action: runHalo2VerifyAction).disabled(!isHalo2VerifyButtonEnabled).accessibilityIdentifier("verifyHalo2")

            ScrollView {
                Text(textViewText)
                    .padding()
                    .accessibilityIdentifier("proof_log")
            }
            .frame(height: 200)
        }
        .padding()
    }
}

extension ContentView {
    func runCircomProveAction() {
        textViewText += "Generating Circom proof... "
        do {
            // Prepare inputs
            //var inputs = getKeccak256Inputs()
            //var inputs = getSha256Inputs()
            //var inputs = getRSAInputs()
            //var inputs = getSemaphoreInputs()
            var inputs = getAadhaarInputs()
            
            let start = CFAbsoluteTimeGetCurrent()
            
            //try witnessCalcKeccak256(circuitPath: keccak256CircuitPath, jsonPath: keccak256InputPath, zkeyPath: keccak256ZkeyPath)
            //try witnessCalcSha256(circuitPath: sha256CircuitPath, jsonPath: sha256InputPath, zkeyPath: sha256ZkeyPath)
            //try witnessCalcRSA(circuitPath: RSACircuitPath, jsonPath: RSAInputPath, zkeyPath: RSAZkeyPath)
            //try witnessCalcSemaphore(circuitPath: semaphoreCircuitPath, jsonPath: semaphoreInputPath, zkeyPath: semaphoreZkeyPath)
            //try witnessCalcAadhaar(circuitPath: AadhaarCircuitPath, jsonPath: AadhaarInputPath, zkeyPath: AadhaarZkeyPath)
            let generateProofResult = try generateCircomProof(zkeyPath: AadhaarZkeyPath, circuitInputs: inputs)
            //assert(!generateProofResult.proof.isEmpty, "Proof should not be empty")
            //assert(Data(expectedOutput) == generateProofResult.inputs, "Circuit outputs mismatch the expected outputs")
            
            let end = CFAbsoluteTimeGetCurrent()
            let timeTaken = end - start
            
            // Store the generated proof and public inputs for later verification
            //generatedCircomProof = generateProofResult.proof
            //circomPublicInputs = generateProofResult.inputs
            
            textViewText += "\(String(format: "%.3f", timeTaken))s 1️⃣\n"
            
            isCircomVerifyButtonEnabled = true
        } catch {
            textViewText += "\nProof generation failed: \(error.localizedDescription)\n"
        }
    }
    
    func runCircomVerifyAction() {
        guard let proof = generatedCircomProof,
              let inputs = circomPublicInputs else {
            textViewText += "Proof has not been generated yet.\n"
            return
        }
        
        textViewText += "Verifying Circom proof... "
        do {
            let start = CFAbsoluteTimeGetCurrent()
            
            let isValid = try verifyCircomProof(zkeyPath: semaphoreZkeyPath, proof: proof, publicInput: inputs)
            let end = CFAbsoluteTimeGetCurrent()
            let timeTaken = end - start
            
            // Convert proof to Ethereum compatible proof
            let ethereumProof = toEthereumProof(proof: proof)
            let ethereumInputs = toEthereumInputs(inputs: inputs)
            assert(ethereumProof.a.x.count > 0, "Proof should not be empty")
            assert(ethereumInputs.count > 0, "Inputs should not be empty")
            
            print("Ethereum Proof: \(ethereumProof)\n")
            print("Ethereum Inputs: \(ethereumInputs)\n")
            
            if isValid {
                textViewText += "\(String(format: "%.3f", timeTaken))s 2️⃣\n"
            } else {
                textViewText += "\nProof verification failed.\n"
            }
            isCircomVerifyButtonEnabled = false
        } catch let error as MoproError {
            print("\nMoproError: \(error)")
        } catch {
            print("\nUnexpected error: \(error)")
        }
    }
    
    func runHalo2ProveAction() {
        textViewText += "Generating Halo2 proof... "
        do {
            // Prepare inputs
            var inputs = [String: [String]]()
            let out = 55
            inputs["out"] = [String(out)]
            
            let start = CFAbsoluteTimeGetCurrent()
            
            // Generate Proof
            let generateProofResult = try generateHalo2Proof(srsPath: srsPath, pkPath: pkPath, circuitInputs: inputs)
            assert(!generateProofResult.proof.isEmpty, "Proof should not be empty")
            assert(!generateProofResult.inputs.isEmpty, "Inputs should not be empty")

            
            let end = CFAbsoluteTimeGetCurrent()
            let timeTaken = end - start
            
            // Store the generated proof and public inputs for later verification
            generatedHalo2Proof = generateProofResult.proof
            halo2PublicInputs = generateProofResult.inputs
            
            textViewText += "\(String(format: "%.3f", timeTaken))s 1️⃣\n"
            
            isHalo2VerifyButtonEnabled = true
        } catch {
            textViewText += "\nProof generation failed: \(error.localizedDescription)\n"
        }
    }
    
    func runHalo2VerifyAction() {
        guard let proof = generatedHalo2Proof,
              let inputs = halo2PublicInputs else {
            textViewText += "Proof has not been generated yet.\n"
            return
        }
        
        textViewText += "Verifying Halo2 proof... "
        do {
            let start = CFAbsoluteTimeGetCurrent()
            
            let isValid = try verifyHalo2Proof(
              srsPath: srsPath, vkPath: vkPath, proof: proof, publicInput: inputs)
            let end = CFAbsoluteTimeGetCurrent()
            let timeTaken = end - start

            
            if isValid {
                textViewText += "\(String(format: "%.3f", timeTaken))s 2️⃣\n"
            } else {
                textViewText += "\nProof verification failed.\n"
            }
            isHalo2VerifyButtonEnabled = false
        } catch let error as MoproError {
            print("\nMoproError: \(error)")
        } catch {
            print("\nUnexpected error: \(error)")
        }
    }
}

