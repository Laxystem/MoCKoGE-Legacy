# Contributing to MoCKoGE

## Project Specific Guidelines
Some projects may have their own `CONTRIBUTING.md` and `README.md`.
Make sure to read them before contributing.
Project-specific guidelines override the guidelines found in this document.

### Package Specific Guidelines
Some packages, like `core.utils` have their own guidelines.
Make sure to read a package's `README.md` before contributing to it.
Package-specific guidelines override the guidelines found in this document and project-specific guidelines.

## Operators
Sometimes, a class may need an operator function,
but if the function is called _without_ its special operator syntax, its name doesn't make sense!
_Operator functions that only refer to existing,
and other than being an operator, function exactly the same, must be declared in the `util.Extensions` file,
to keep the source code clean and readable._