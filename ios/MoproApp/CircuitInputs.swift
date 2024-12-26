import Foundation

func getKeccak256Inputs() -> [String: [String]] {
  var inputs: [String: [String]] = [:]

  inputs["in"] = [
    "0", "0", "1", "0", "1", "1", "1", "0", "1", "0", "1", "0", "0", "1", "1", "0",
    "1", "1", "0", "0", "1", "1", "1", "0", "0", "0", "1", "0", "1", "1", "1", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
  ]

  return inputs
}

func getSha256Inputs() -> [String: [String]] {
  var inputs: [String: [String]] = [:]

  inputs["in"] = [
    "0",
    "0",
    "1",
    "0",
    "1",
    "1",
    "1",
    "0",
    "1",
    "0",
    "1",
    "0",
    "0",
    "1",
    "1",
    "0",
    "1",
    "1",
    "0",
    "0",
    "1",
    "1",
    "1",
    "0",
    "0",
    "0",
    "1",
    "0",
    "1",
    "1",
    "1",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "1",
    "0",
    "1",
    "1",
    "1",
    "0",
    "1",
    "0",
    "1",
    "0",
    "0",
    "1",
    "1",
    "0",
    "1",
    "1",
    "0",
    "0",
    "1",
    "1",
    "1",
    "0",
    "0",
    "0",
    "1",
    "0",
    "1",
    "1",
    "1",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
  ]

  return inputs
}

func getRSAInputs() -> [String: [String]] {
  var inputs: [String: [String]] = [:]

  inputs["signature"] = [
    "3582320600048169363",
    "7163546589759624213",
    "18262551396327275695",
    "4479772254206047016",
    "1970274621151677644",
    "6547632513799968987",
    "921117808165172908",
    "7155116889028933260",
    "16769940396381196125",
    "17141182191056257954",
    "4376997046052607007",
    "17471823348423771450",
    "16282311012391954891",
    "70286524413490741",
    "1588836847166444745",
    "15693430141227594668",
    "13832254169115286697",
    "15936550641925323613",
    "323842208142565220",
    "6558662646882345749",
    "15268061661646212265",
    "14962976685717212593",
    "15773505053543368901",
    "9586594741348111792",
    "1455720481014374292",
    "13945813312010515080",
    "6352059456732816887",
    "17556873002865047035",
    "2412591065060484384",
    "11512123092407778330",
    "8499281165724578877",
    "12768005853882726493",
  ]

  inputs["modulus"] = [
    "13792647154200341559",
    "12773492180790982043",
    "13046321649363433702",
    "10174370803876824128",
    "7282572246071034406",
    "1524365412687682781",
    "4900829043004737418",
    "6195884386932410966",
    "13554217876979843574",
    "17902692039595931737",
    "12433028734895890975",
    "15971442058448435996",
    "4591894758077129763",
    "11258250015882429548",
    "16399550288873254981",
    "8246389845141771315",
    "14040203746442788850",
    "7283856864330834987",
    "12297563098718697441",
    "13560928146585163504",
    "7380926829734048483",
    "14591299561622291080",
    "8439722381984777599",
    "17375431987296514829",
    "16727607878674407272",
    "3233954801381564296",
    "17255435698225160983",
    "15093748890170255670",
    "15810389980847260072",
    "11120056430439037392",
    "5866130971823719482",
    "13327552690270163501",
  ]

  inputs["base_message"] = [
    "18114495772705111902",
    "2254271930739856077",
    "2068851770",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
    "0",
  ]

  return inputs
}

func getSemaphoreInputs() -> [String: [String]] {
  var inputs: [String: [String]] = [:]

  inputs["secret"] = [
    "2736030358979909402780800718157159386076813972158567259200215660948447373040"
  ]

  inputs["merkleProofLength"] = ["2"]

  inputs["merkleProofIndices"] = [
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0",
  ]

  inputs["merkleProofSiblings"] = [
    "2", "3", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
  ]

  inputs["scope"] = ["32"]

  inputs["message"] = ["43"]

  return inputs
}

enum CircuitError: Error {
  case failedToLoadCircuitData
  case failedToLoadJSONData
}

struct CircuitInputs {
  let circuitBuffer: UnsafePointer<UInt8>
  let circuitSize: UInt64
  let jsonBuffer: UnsafePointer<UInt8>
  let jsonSize: UInt64
  var wtnsBuffer: UnsafeMutablePointer<UInt8>
  var wtnsSize: UnsafeMutablePointer<UInt>
  var errorMsg: UnsafeMutablePointer<UInt8>
  let errorMsgMaxSize: UInt
  var pubData: UnsafeMutablePointer<UInt8>
  var pubLen: UInt
  var proofData: UnsafeMutablePointer<UInt8>
  var proofLen: UInt

  init(
    circuitPath: String,
    jsonPath: String
  ) throws {
    guard let circuitFileHandle = FileHandle(forReadingAtPath: circuitPath) else {
      print("Failed to load circuit data")
      throw CircuitError.failedToLoadCircuitData
    }

    defer {
      circuitFileHandle.closeFile()
    }

    var circuitData: Data = Data()
    do {
      circuitData = try circuitFileHandle.readToEnd() ?? Data()
    } catch {
      print("Failed to read file data: \(error)")
    }

    let circuitBuffer = circuitData.withUnsafeBytes {
      return $0.baseAddress?.assumingMemoryBound(to: UInt8.self)
    }

    guard let jsonFileHandle = FileHandle(forReadingAtPath: jsonPath) else {
      print("Failed to load circuit data")
      throw CircuitError.failedToLoadJSONData
    }

    defer {
      jsonFileHandle.closeFile()
    }

    var jsonData: Data = Data()
    do {
      jsonData = try jsonFileHandle.readToEnd() ?? Data()
    } catch {
      print("Failed to read file data: \(error)")
    }

    let jsonBuffer = jsonData.withUnsafeBytes {
      return $0.baseAddress?.assumingMemoryBound(to: UInt8.self)
    }

      self.circuitBuffer = circuitBuffer!
      self.circuitSize = UInt64(circuitData.count)

      self.jsonBuffer = jsonBuffer!
      self.jsonSize = UInt64(jsonData.count)

    self.wtnsBuffer = UnsafeMutablePointer<UInt8>.allocate(capacity: (100 * 1024 * 1024))
    self.wtnsSize = UnsafeMutablePointer<UInt>.allocate(capacity: Int(1))
    self.wtnsSize.initialize(to: UInt(100 * 1024 * 1024))

    self.errorMsgMaxSize = UInt(256)
    self.errorMsg = UnsafeMutablePointer<UInt8>.allocate(capacity: Int(self.errorMsgMaxSize))

    self.pubLen = 4 * 1024 * 1024
    self.pubData = UnsafeMutablePointer<UInt8>.allocate(capacity: Int(self.pubLen))

    self.proofLen = 4 * 1024 * 1024
    self.proofData = UnsafeMutablePointer<UInt8>.allocate(capacity: Int(self.proofLen))

  }
}

func prepareCircuitInputs(
  circuitPath: String,
  jsonPath: String
) throws -> CircuitInputs {

  return try CircuitInputs(
    circuitPath: circuitPath,
    jsonPath: jsonPath
  )
}


func witnessCalcKeccak256(
    circuitPath: String,
    jsonPath: String,
    zkeyPath: String
) throws {
    let circuitInputs = try prepareCircuitInputs(circuitPath: circuitPath, jsonPath: jsonPath)
    
    let start = CFAbsoluteTimeGetCurrent()
    
    // Generate Proof
    let res = witnesscalc_keccak256_256_test(
        circuitInputs.circuitBuffer,
        UInt(circuitInputs.circuitSize),
        circuitInputs.jsonBuffer,
        UInt(circuitInputs.jsonSize),
        circuitInputs.wtnsBuffer,
        circuitInputs.wtnsSize,
        circuitInputs.errorMsg,
        circuitInputs.errorMsgMaxSize
    )
    print(res)
    
    let witnessData = Data(bytes: circuitInputs.wtnsBuffer, count: Int(circuitInputs.wtnsSize.pointee))
    let proofRes = try groth16ProveWithZKeyFilePath(zkeyPath: zkeyPath, witness: witnessData)
    print(proofRes)
}
