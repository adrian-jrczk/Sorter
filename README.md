# Sorter

## Table of contents
* [About](#about)
* [Features](#features)
* [Usage](#usage)
* [Installation](#installation)
* [Technologies used](#technnologies-used)
* [Screenshots](#screenshots)


## About

Sorter is a simple tool which provides easy way to sort data.
It can perform sorting on 3 different data types(numbers, words, lines) and in 3 different ways(ascending, descending and by occurrences).

## Features

- sort numbers, words and whole lines 
- get occurrences count for every element

## Usage

This program can be used directly with Command Line Interface or program arguments.

### CLI

To use Sorter with CLI you just need to specify data type and sort type and then you will be asked to enter data to sort.

Correct input form: DATA_TYPE SORT_TYPE
Available data types:
- numbers
- words
- lines
Available sort types:
- ascending
- descending
- occurrences

### Arguments

`-d, --data-type DATA_TYPE`         data type to sort
`-s, --sort-type SORT_TYPE` 		sort method
`-i, --input-file INPUTFILENAME`	name of the file with input data
`-o, --output-file OUTPUTFILENAME`	name of the file with output data (default: INPUTFILENAME)

## Installation

1. Import this repository to some folder with `git clone repourl`
2. Open this folder and install with `mvn clean install`
3. In `target` folder there will be executable jar file `sorter.jar` which you can move freely and run with `java -jar sorter.jar`

## Technologies used

- Java 17

## Screenshots

![screenshot 1](images/screenshot01.png?raw=true "Usage example 1")
![screenshot 2](images/screenshot02.png?raw=true "Usage example 2")