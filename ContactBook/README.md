# Contact Book (Java)

A simple command-line contact manager written in Java. Contacts are saved to a text file, so they are still there the next time you run the program.

## Features

- **Add** a contact (name + phone number)
- **Display** all saved contacts
- **Search** contacts by name (case-insensitive, partial matches allowed)
- **Update** an existing contact's name and number
- **Delete** a contact by name
- **Persistent storage**: contacts are saved to `contacts.txt` after every change and loaded automatically on startup

## Input Validation

- Fields cannot be empty
- Names may contain only letters and spaces
- Phone numbers must be exactly 10 digits (e.g. `9812345678`)
- Duplicate names (case-insensitive) are rejected when adding or updating
- Non-numeric menu input is handled without crashing

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Run

1. Open a terminal in this folder.
2. Compile the program:

```bash
javac ContactBook.java
```

3. Run it:

```bash
java ContactBook
```
## Usage

When the program starts, it shows this menu:

```
1. Add contact
2. Display contacts
3. Search contact
4. Delete contact
5. Update contact
6. Exit
Enter your choice:
```

Type the number of the action you want and press Enter. Choose `6` to exit.

### Example session

```
Enter your choice: 1
Enter name: Alice Smith
Enter number: 9812345678
Contact added successfully
Contacts saved successfully!!!

Enter your choice: 3
Enter the name of the person: ali
Contact found!!!
Name: Alice Smith
Number: 9812345678
```

## Data File Format

Contacts are stored in `contacts.txt` in the folder where you run the program. Each contact takes up three lines (name, number, blank line):

```
Name: Alice Smith
Number: 9812345678

Name: Bob Jones
Number: 9801234567

```

Incomplete or malformed entries in the file are skipped when loading, so a damaged file will not crash the program.

## Project Structure

```
ContactBook/
├── ContactBook.java   # Contact class + main program
├── README.md
└── contacts.txt       # Created automatically on first save
```

## Concepts Practiced

- Classes, objects, and encapsulation (private fields with getters/setters)
- `ArrayList` for storing objects
- `Scanner` for console input
- Exception handling (`InputMismatchException`, `IOException`, `FileNotFoundException`)
- File I/O with `BufferedReader` / `BufferedWriter` and try-with-resources
- Input validation with regular expressions

## Known Limitations

- Phone numbers must be exactly 10 digits, so country codes and `+` are not supported
- Names cannot contain digits, hyphens, apostrophes, or non-English letters
- Contacts are identified by name only, so two people with the same name cannot be stored
- Everything lives in a single file, and the whole data file is rewritten after every change

## Possible Improvements

- Split the code into separate classes (model, storage, UI)
- Store data as JSON, CSV, or in a database (SQLite)
- Support more phone formats and extra fields (email, address)
- Add unit tests with JUnit
- Build a GUI with JavaFX or Swing