# Low Level System Design - Parking lot


## Problem Statement
[Check here](Problem-Statement.md)

## Video explanation:
https://youtu.be/7IX84K9g23U

## Running the project

1. **Using File Mode:**  
   Step 1 : Take the Run menu  
   Step 2 : Select Edit Configurations  
   Step 3 : Fill the Program arguments field. Tip: Use $FilePrompt$ 
2. **Interactive Mode:** : Do not use Arguments while running in Configurations.

---
### Further Enhancements:

* Dependency injection: Currently dependencies are injected manually. We can use some
  dependency injection framework like spring.
* Exit command: Exit command is currently coupled with interactive mode only which makes
  it non-reusable.
* Parking strategy: Parking strategy is currently associated with `ParkingLotService`.
  Instead of that, it makes more sense to associate it with `ParkingLot`.
* Mode: Mode checking is currently done in main function directly. There could be a
  factory for that.