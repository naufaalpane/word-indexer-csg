# word-indexer-csg
Java CLI application that processes text files and applies configurable word indexing rules

# Text File Indexing CLI Application

This project is a Java command-line application that processes one or more text files and applies configurable business rules to support indexing for a search system.

The application was developed as part of a coding assignment, with a focus on clean architecture, extensibility, and testability.

---

## Features

For each input file, the application:
- Counts the number of words that start with an uppercase letter
- Lists all words that are longer than 5 characters

---

## Design Overview

The application is intentionally structured to separate concerns:

- **CLI Layer**  
  Handles command-line arguments and output formatting

- **IO Layer**  
  Responsible for reading file contents

- **Business Validation Layer**  
  Each validation is implemented independently using a common interface, allowing new validation to be added without modifying existing logic

- **Validation Orchestrator**  
  Applies all configured validation using polymorphism

This design supports evolving business requirements and promotes maintainable, production-quality code.

---