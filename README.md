## Setup Instructions

1. Clone the repository.
   ```bash
   git clone <https://github.com/Brady-White/DataProcessing-StorageAssignment.git>
   ```

2. Compile the Java files.
   ```bash
   javac InMemoryDB.java InMemoryDBImpl.java Main.java
   ```

3. Run the `Main` class.
   ```bash
   java Main
   ```

4. Expected output:
   ```
   null
   No active transaction. Call begin_transaction() first.
   null
   6
   No active transaction to commit.
   null
   ```

## Assignment Modifications
To make this an official assignment, consider:
- Adding support for nested transactions.
- Clarifying what happens if a `put` operation updates a key that was deleted during a transaction.
- Providing unit tests to automate grading.
