# Contributing to MOCKOGE
## Package Specific Guidelines
Some packages, like `utils` have their own guidelines.
Make sure to read a package's `README.md` before contributing to it.

## Operators
Sometimes, a class may need an operator function,
but if the function is called _without_ its special operator syntax, its name doesn't make sense!
_Operator functions that only refer to existing,
and other than being an operator, function exactly the same, must be declared in the `util.Extensions` file,
to keep the source code clean and readable._