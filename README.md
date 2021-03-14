# Number Converter

This application is converts the given value with input type to the requested output type.

    The default port is 7101

## Controller

Currently, the application provides a GET method with the following endpoint:

    localhost:7101/convert/to/roman

Request param dto:

    {
        "number": "10",
        "inputNumberType": "DECIMAL",
        "outputNumberType": "ROMAN"
    }

Example URL:

    localhost:7101/convert/to/roman?number=10&inputNumberType=DECIMAL&outputNumberType=ROMAN

## Supported Input & Output Types:

**Input Type(s)**

    - BINARY
    - DECIMAL

**Output Type(s):**

    - ROMAN

## DOMAIN EXPLANATION

**Request Dto:**

NumberConverterRequestDto is a specified request dto which includes the following fields:

    - number: Value to be converted
    - inputNumberType: Type of the input value
    - outputNumberType: Type of the output value

**Response Dto:**

ApiResponse is specified response dto with following fields:

    - value: final value
    - httpStatus: response status
    - httpStatusCode: response status code

**RomanNumber**

This class holds the roman mapping and converts an integer to roman number.

## ENUMS

**InputNumberType**

    - BINARY
    - DECIMAL

**OutputNumberType**

    - ROMAN

## HOW IT WORKS?

This application is designed by considering a suitable Behavioral Design Pattern which is the Strategy Design Pattern.

There are separate interfaces for input and output implementations.

- Input interface holds a method representation that converts input String value to the Integer value.

- Output interface holds a method representation that converts the Integer value to the requested output type.

Enum declarations also hold bean names. With these bean names, the service layer gets specified implementation of the input type from ApplicationContext and converts the input value to the integer as the first step. Then, the requested output type's implementation is also acquired from ApplicationContext, and conversion made through this implementation.

## EXCEPTIONS

There are two application-specific exception declarations.

    - InvalidInputException
    - NumberOutOfRangeException

**InvalidInputException**

If input number is not suitable with the specified input type, then InvalidInputException threw.

**NumberOutOfRangeException**

Roman number representation has a range between 1 - 3999. If the requested value is lower or higher than this range, the application throws NumberOutOfRangeException.

**ExceptionAdvice** is implemented to handle exceptions at the application level with a specific output format.

## LOGGING

Logging is handled by Spring AOP.

With the implementation of the logging aspect, the application prints log with the values in each step before and after a method call.

Log files are located under the /logs folder.

## HOW TO EXTEND?

To implement a new input format follow the below steps:

    1 - Declare specified bean name to the BeanNameUtil class.
    2 - Declare a new type to the InputNumberType, with declared bean name.
    3 - Create a new implementation class to the converter.input.impl package that extends to IInputToIntegerConverter.

To implement a new output format follow the below steps:

    1 - Declare specified bean name to the BeanNameUtil class.
    2 - Declare a new type to the OutputNumberType, with declared bean name.
    3 - Create a new implementation class to the converter.output.impl package that extends to IIntegerToOutputConverter.
